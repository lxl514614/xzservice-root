
package com.xinhuanet.hylanda.common.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class ServletUtils {
	private static final Logger log = LoggerFactory.getLogger(ServletUtils.class);
	
	private static final String NUKNOWN = "unknown";
	private static final String[] ADDR_HEADER = { "X-Forwarded-For","X-Real-IP",
			"Proxy-Client-IP", "WL-Proxy-Client-IP", "HTTP_X_FORWARDED_FOR",
			"Cdn-Src-Ip","HTTP_X_REAL_IP"};
	
	/**
	 * 设置让浏览器弹出下载对话框的Header,不同浏览器使用不同的编码方式.
	 * 
	 * @param fileName 下载后的文件名.
	 */
	public static void setFileDownloadHeader(HttpServletRequest request, HttpServletResponse response, String fileName) {
		final String CONTENT_DISPOSITION = "Content-Disposition";
		
		try {
			String agent = request.getHeader("User-Agent");
			String encodedfileName = null;
	        if (null != agent) {  
	        	agent = agent.toLowerCase();  
	            if (agent.contains("firefox") || agent.contains("chrome") || agent.contains("safari")) {  
	    			encodedfileName = "filename=\"" + new String(fileName.getBytes(), "ISO8859-1") + "\"";
	            } else if (agent.contains("msie")) {  
	            	encodedfileName = "filename=\"" + URLEncoder.encode(fileName,"UTF-8") + "\"";
	            } else if (agent.contains("opera")) {  
	            	encodedfileName = "filename*=UTF-8\"" + fileName + "\"";
	            } else {
	            	encodedfileName = "filename=\"" + URLEncoder.encode(fileName,"UTF-8") + "\"";
	            }
	        }
			
	        response.setHeader(CONTENT_DISPOSITION, "attachment; " + encodedfileName);
		} catch (UnsupportedEncodingException e) {
		}
	}
	
	/**
	 * 取得带相同前缀的Request Parameters, copy from spring WebUtils.
	 * 
	 * 返回的结果的Parameter名已去除前缀.
	 */
	@SuppressWarnings("rawtypes")
	public static Map<String, Object> getParametersStartingWith(ServletRequest request, String prefix) {
		Validate.notNull(request, "Request must not be null");
		Enumeration paramNames = request.getParameterNames();
		Map<String, Object> params = new TreeMap<String, Object>();
		if (prefix == null) {
			prefix = "";
		}
		while ((paramNames != null) && paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			if ("".equals(prefix) || paramName.startsWith(prefix)) {
				String unprefixed = paramName.substring(prefix.length());
				String[] values = request.getParameterValues(paramName);
				if ((values == null) || (values.length == 0)) {
					// Do nothing, no values found at all.
				} else if (values.length > 1) {
					params.put(unprefixed, values);
				} else {
					params.put(unprefixed, values[0]);
				}
			}
		}
		return params;
	}

	/**
	 * 组合Parameters生成Query String的Parameter部分, 并在paramter name上加上prefix.
	 * 
	 * @see #getParametersStartingWith
	 */
	public static String encodeParameterStringWithPrefix(Map<String, Object> params, String prefix) {
		if ((params == null) || (params.size() == 0)) {
			return "";
		}

		if (prefix == null) {
			prefix = "";
		}

		StringBuilder queryStringBuilder = new StringBuilder();
		Iterator<Entry<String, Object>> it = params.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, Object> entry = it.next();
			queryStringBuilder.append(prefix).append(entry.getKey()).append('=').append(entry.getValue());
			if (it.hasNext()) {
				queryStringBuilder.append('&');
			}
		}
		return queryStringBuilder.toString();
	}
	
	/**
	 * 获得真实IP地址。在使用了反向代理时，直接用HttpServletRequest.getRemoteAddr()无法获取客户真实的IP地址。
	 * 
	 * @param request
	 * @return
	 */
	public static String getRemoteAddr(ServletRequest request) {
		String addr = null;
		if (request instanceof HttpServletRequest) {
			HttpServletRequest hsr = (HttpServletRequest) request;
			for (String header : ADDR_HEADER) {
				if (StringUtils.isBlank(addr) || NUKNOWN.equalsIgnoreCase(addr)) {
					addr = hsr.getHeader(header);
					log.info(header + ".ip: " + addr);
				} else {
					break;
				}
			}
		}
		if(StringUtils.isBlank(addr) || NUKNOWN.equalsIgnoreCase(addr)){
		   try {
				addr = InetAddress.getLocalHost().getHostAddress();
				log.info("InetAddress.ip: " + addr);
		   } catch (UnknownHostException e) {
				e.printStackTrace();
		   }
		}
		if(StringUtils.isBlank(addr) || NUKNOWN.equalsIgnoreCase(addr)) {
		   addr = request.getRemoteAddr();
		   log.info("RemoteAddr.ip: " + addr);
		}
		if(StringUtils.isNotBlank(addr) && !NUKNOWN.equalsIgnoreCase(addr)) {
		   // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按','分割
		   int i = addr.indexOf(",");
		   if (i > 0) {
			   addr = addr.substring(0, i);
		   }
		}
		return addr;
	}
	
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("HTTP_X_REAL_IP");
		log.info("HTTP_X_REAL_IP: " + ip);
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
			log.info("HTTP_X_FORWARDED_FOR: " + ip);
		} 
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Forwarded-For");
			log.info("X-Forwarded-For: " + ip);
			if(null != ip && !"".equals(ip) && !"unknown".equalsIgnoreCase(ip)){
			   String[] ips = ip.split(",");
			   if(ips.length > 0){
				  ip = ips[0]; 
			   }
			}
		} 
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Real-IP");
			log.info("X-Real-IP: " + ip);
		} 
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
			log.info("Proxy-Client-IP: " + ip);
		} 
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
			log.info("WL-Proxy-Client-IP: " + ip);
		} 
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Cdn-Src-Ip");
			log.info("Cdn-Src-Ip: " + ip);
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			try {
				 ip = InetAddress.getLocalHost().getHostAddress();
				 log.info("InetAddress: " + ip);
				 if(null != ip && !"".equals(ip) && !"unknown".equalsIgnoreCase(ip)){
					int pos = ip.indexOf("/");
					if(pos > 0){
					   ip = ip.substring(pos + 1);	
					}
				 }
			} catch (UnknownHostException e) {
				 e.printStackTrace();
			}
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
			log.info("RemoteAddr: " + ip);
		}
		return ip;
	}
}
