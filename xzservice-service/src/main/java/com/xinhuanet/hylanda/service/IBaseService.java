package com.xinhuanet.hylanda.service;

/**

 *  create by Liujishuai on 2015年9月22日

 */
public interface IBaseService<T> {

	/**
	 * 根据主键删除
	 * @param id
	 * @return
	 */
	public int deleteByPrimaryKey(Long id);

	/**
	 * 添加记录
	 * @param record
	 * @return
	 */
	public int insert(T record);

	/**
	 * 添加查询记录
	 * @param record
	 * @return
	 */
	public int insertSelective(T record);

	/**
	 * 根据主键id查询
	 * @param id
	 * @return
	 */
	public T selectByPrimaryKey(Long id);

	/**
	 * 根据主键修改
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKeySelective(T record);

	/**
	 * 根据主键修改
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKey(T record);

}

