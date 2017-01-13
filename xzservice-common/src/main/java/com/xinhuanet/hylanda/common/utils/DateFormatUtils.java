package com.xinhuanet.hylanda.common.utils;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatUtils extends org.apache.commons.lang.time.DateFormatUtils {
	
	public static String format(Date date) {
		if (date == null) {
			return null;
		}
		String s = org.apache.commons.lang.time.DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");
		if (s == null) {
			return org.apache.commons.lang.time.DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return s;
	}

	public static String format(Date date, String format) {
		if (date == null) {
			return null;
		}
		return org.apache.commons.lang.time.DateFormatUtils.format(date, format);
	}

	public static final Date parseDate(String strDate, String format) {
		SimpleDateFormat df = null;
		Date date = null;
		df = new SimpleDateFormat(format);
		try {
			date = df.parse(strDate);
		} catch (ParseException e) {
		}
		return date;
	}

	public static Date formatDate(Date date, String format) {
		SimpleDateFormat inDf = new SimpleDateFormat(format);
		SimpleDateFormat outDf = new SimpleDateFormat(format);
		String reDate = "";
		try {
			reDate = inDf.format(date);
			return outDf.parse(reDate);
		} catch (Exception e) {
		}
		return date;
	}

	/**
	 * 转换时间的显示格式
	 *
	 * @param date
	 * @return
	 */
	public Integer dateFormatDiff(Date date) {
		Calendar calendar = Calendar.getInstance();
		Long nd = (long) (1000 * 24 * 60 * 60);// 一天的毫秒数
		Long diff = calendar.getTime().getTime() - date.getTime();
		Long day = diff / nd;// 计算差多少天

		return day.intValue();
	}

	/**
	 * 获取若干天后的日期
	 * @param num
	 * @return
	 */
	public static String getDate(int num) {

		Long nowTm = new Date().getTime();
		Long nd = (long) (1000 * 24 * 60 * 60);// 一天的毫秒数

		Long dateTm = nowTm + nd * num;

		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(dateTm);

		return formatter.format(calendar.getTime());
	}
	
	/**
	 * 计算若干天前的日期
	 * @param num
	 * @return
	 */
	public static String getBrforeDate(int num) {
		
		Long nowTm = new Date().getTime();
		
		Long nd = (long)(1000*24*60*60);
		
		Long dateTm = nowTm - nd * num;
		
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(dateTm);

		return formatter.format(calendar.getTime());
	}

	public static void main(String[] args) {
		String date = DateFormatUtils.getDate(30);
		System.out.println(date);
	}
	
}
