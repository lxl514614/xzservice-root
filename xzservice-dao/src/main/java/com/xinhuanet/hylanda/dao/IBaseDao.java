package com.xinhuanet.hylanda.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;


/**
     
 *  create by Liujishuai on 2015年9月22日

 */
public interface IBaseDao<T> {

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
     * 添加后查询
     * @param record
     * @return
     */
    public int insertSelective(T record);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    public T selectByPrimaryKey(Long id);

    /**
     * 修改后查询
     * @param record
     * @return
     */
    public int updateByPrimaryKeySelective(T record);

    /**
     * 通过主键修改
     * @param record
     * @return
     */
    public int updateByPrimaryKey(T record);
    List<T> getAllByPage(RowBounds rowBounds);
}

