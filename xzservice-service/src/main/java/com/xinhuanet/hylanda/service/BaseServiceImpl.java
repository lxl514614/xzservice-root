package com.xinhuanet.hylanda.service;

import com.xinhuanet.hylanda.dao.IBaseDao;

/**
 *
 * @param <T>
 */
public abstract class BaseServiceImpl<T> implements IBaseService<T> {

	public abstract IBaseDao<T> getBaseDao();

	@Override
	public int deleteByPrimaryKey(Long id) {
		return this.getBaseDao().deleteByPrimaryKey(id);
	}

	@Override
	public int insert(T record) {
		
		return this.getBaseDao().insert(record);
	}

	@Override
	public int insertSelective(T record) {
		// TODO Auto-generated method stub
		return this.getBaseDao().insertSelective(record);
	}

	@Override
	public T selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return this.getBaseDao().selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(T record) {
		// TODO Auto-generated method stub
		return this.getBaseDao().updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(T record) {
		// TODO Auto-generated method stub
		return this.getBaseDao().updateByPrimaryKey(record);
	}
	
}

