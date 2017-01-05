package com.xinhuanet.hylanda.security.realm;


import com.xinhuanet.hylanda.model.entity.Menu;
import com.xinhuanet.hylanda.model.entity.Role;
import com.xinhuanet.hylanda.model.entity.User;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
 */
public class ShiroUser implements Serializable {

	private static final long serialVersionUID = -1748602382963711884L;
	private Long id;
	private String loginName;
	private String ipAddress;
	private User user;
	
//	private Map<String, Role> hasDataControls = new HashMap<String, Role>();
//	private Map<String, Menu> hasModules = new HashMap<String, Menu>();
//
	public ShiroUser() {
		
	}
	
	/**  
	 * 构造函数
	 * @param id
	 * @param loginName
	 * @param email
	 * @param createTime
	 * @param status  
	 */ 
	public ShiroUser(Long id, String loginName, User user) {
		this.id = id;
		this.loginName = loginName;
		this.user = user;
	}

	/**  
	 * 返回 id 的值   
	 * @return id  
	 */
	public Long getId() {
		return id;
	}

	/**  
	 * 返回 loginName 的值   
	 * @return loginName  
	 */
	public String getLoginName() {
		return loginName;
	}
	
	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**  
	 * 返回 user 的值   
	 * @return user  
	 */
	public User getUser() {
		return user;
	}
	
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 本函数输出将作为默认的<shiro:principal/>输出.
	 */
	@Override
	public String toString() {
		return loginName;
	}

//	/**
//	 * @return the hasDataControls
//	 */
//	public Map<String, DataControl> getHasDataControls() {
//		return hasDataControls;
//	}
//
//	/**
//	 * @return the hasModules
//	 */
//	public Map<String, Module> getHasModules() {
//		return hasModules;
//	}
	
}