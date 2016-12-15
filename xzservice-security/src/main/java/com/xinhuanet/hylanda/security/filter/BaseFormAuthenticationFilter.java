package com.xinhuanet.hylanda.security.filter;

import com.xinhuanet.hylanda.common.exception.Exceptions;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseFormAuthenticationFilter extends FormAuthenticationFilter {
	private static final Logger log = LoggerFactory.getLogger(BaseFormAuthenticationFilter.class);
	
	/*
	 * 覆盖默认实现，打印日志便于调试，查看具体登录是什么错误。
	 *（可以扩展把错误写入数据库之类的。）
	 */
	@Override
	protected boolean onLoginFailure(AuthenticationToken token,
                                     AuthenticationException e, ServletRequest request,
                                     ServletResponse response) {
		if (log.isDebugEnabled()) {
			Class<?> clazz = e.getClass();
			if (clazz.equals(AuthenticationException.class)) {
				log.debug(Exceptions.getStackTraceAsString(e));
			}
		}
		
		return super.onLoginFailure(token, e, request, response);
	}
	
	/**
	 * 覆盖isAccessAllowed，改变shiro的验证逻辑。
	 * 避免不能多次登录的错误。
	 * @param request
	 * @param response
	 * @param mappedValue
	 * @return  
	 */
    @Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		try {
			// 先判断是否是登录操作
			if (isLoginSubmission(request, response)) {
				if (log.isTraceEnabled()) {
					log.trace("Login submission detected.  Attempting to execute login.");
				}
				return false;
			}
		} catch (Exception e) {
			log.error(Exceptions.getStackTraceAsString(e));
		}

		return super.isAccessAllowed(request, response, mappedValue);
	}
    
	/**
	 * 覆盖默认实现，用sendRedirect直接跳出框架，以免造成js框架重复加载js出错。
	 * @param token
	 * @param subject
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception  
	 */
	@Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject,
                                     ServletRequest request, ServletResponse response) throws Exception {
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		HttpServletResponse httpServletResponse = (HttpServletResponse)response;
		
//		ShiroUser shiroUser = (ShiroUser)subject.getPrincipal();
//		// 加入ipAddress
//		shiroUser.setIpAddress(ServletUtils.getRemoteAddr(request));
//
//		httpServletRequest.getSession().setAttribute(SecurityConstants.LOGIN_USER, shiroUser.getUser());

		if (!"XMLHttpRequest".equalsIgnoreCase(httpServletRequest.getHeader("X-Requested-With"))
				|| request.getParameter("ajax") == null) {// 不是ajax请求
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + this.getSuccessUrl());
		} else {
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login/timeout/success");
		}

		return false;
	}
}
