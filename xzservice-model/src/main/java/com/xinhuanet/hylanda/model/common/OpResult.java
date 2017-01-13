package com.xinhuanet.hylanda.model.common;

import java.io.Serializable;

/**
 * 前台提示
 * @since 2017-01-09
 * @author Lee XL
 *
 */
public class OpResult implements Serializable {
	private static final long serialVersionUID = -5217263946675824590L;
	public static final String OP_SUCCESS = "success";
	public static final String OP_FAILED = "error";
	private String status;// success 成功 error失败
	private String message;// 提示信息
	private Object dataValue;// 数据值
	
	//针对文件上传，图片文件
	private Integer width;
	private Integer height;
	private String url;

	public OpResult() {
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public OpResult(String status, String message) {
		this.status = status;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getDataValue() {
		return dataValue;
	}

	public void setDataValue(Object dataValue) {
		this.dataValue = dataValue;
	}

	public static final class OpMsg {
		public static final String SAVE_SUCCESS = "保存成功";
		public static final String SAVE_FAIL = "保存失败";
		public static final String MODIFY_SUCCESS = "修改成功";
		public static final String MODIFY_FAIL = "修改失败";
		public static final String DELETE_SUCCESS = "删除成功";
		public static final String DELETE_FAIL = "删除失败";
		public static final String OP_SUCCESS = "操作成功";
		public static final String OP_FAIL = "操作失败";
		public static final String UPLOAD_SUCCESS = "上传成功";
		public static final String UPLOAD_FAIL = "上传失败";
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
