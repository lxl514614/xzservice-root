package com.xinhuanet.hylanda.dao;

import com.xinhuanet.hylanda.model.entity.RoleOperate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "roleOperateMapper")
public interface RoleOperateMapper {
    public int deleteByPrimaryKey(Long id);

    public int insert(RoleOperate record);

    public RoleOperate selectByPrimaryKey(Long id);

    public List<RoleOperate> selectAll();

    public int updateByPrimaryKey(RoleOperate record);

    public List<RoleOperate> findOperateByRoleId(Long roleId);
}