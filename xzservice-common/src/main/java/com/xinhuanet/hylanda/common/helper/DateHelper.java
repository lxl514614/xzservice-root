package com.xinhuanet.hylanda.common.helper;

import java.text.SimpleDateFormat;

/**
 * 日期帮助类
 * 
 * @since 2015-01-16
 * @author 万里
 * 
 */
public enum DateHelper {
	/**
	 * 实例
	 */
	INTANCE;
	/**
	 * yyyy-MM-dd
	 */
	public static final String DF_YYYY_MM_DD = "yyyy-MM-dd";
	/**
	 * yyyy-MM-dd hh:mm:ss
	 */
	public static final String DF_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd hh:mm:ss";
	/**
	 * yyyy-MM-dd hh:mm
	 */
	public static final String DF_YYYY_MM_DD_HH_MM = "yyyy-MM-dd hh:mm";
	/**
	 * hh:mm:ss
	 */
	public static final String DF_HH_MM_SS = "hh:mm:ss";
	/**
	 * dd hh:mm:ss
	 */
	public static final String DF_DD_HH_MM_SS = "dd hh:mm:ss";
	/**
	 * dd hh:mm
	 */
	public static final String DF_DD_HH_MM = "dd hh:mm";
	/**
	 * MM-dd hh:mm:ss
	 */
	public static final String DF_MM_DD_HH_MM_SS = "MM-dd hh:mm:ss";
	/**
	 * MM-dd hh:mm
	 */
	public static final String DF_MM_DD_HH_MM = "MM-dd hh:mm";
	/**
	 * hh:mm
	 */
	public static final String DF_HH_MM = "hh:mm";

	/**
	 * 获取日期时间格式化模板
	 * 
	 * @param format
	 * @return
	 */
	public SimpleDateFormat dateFormat(String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter;
	}
	
	/**
	 * 获取日期时间格式化模板
	 * 
	 * @param format
	 * @return
	 */
	public SimpleDateFormat dateParse() {
		SimpleDateFormat formatter = new SimpleDateFormat();
		return formatter;
	}
}
