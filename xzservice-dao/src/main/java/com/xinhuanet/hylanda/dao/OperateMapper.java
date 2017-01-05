package com.xinhuanet.hylanda.dao;

import com.xinhuanet.hylanda.model.entity.Operate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "operateMapper")
public interface OperateMapper {
    public int deleteByPrimaryKey(Long id);

    public int insert(Operate record);

    public Operate selectByPrimaryKey(Long id);

    public List<Operate> selectAll();

    public int updateByPrimaryKey(Operate record);
}