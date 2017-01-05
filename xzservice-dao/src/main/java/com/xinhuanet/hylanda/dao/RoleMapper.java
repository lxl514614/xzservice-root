package com.xinhuanet.hylanda.dao;

import com.xinhuanet.hylanda.model.entity.Role;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "roleMapper")
public interface RoleMapper {

    public int deleteByPrimaryKey(Long id);

    public int insert(Role record);

    public Role selectByPrimaryKey(Long id);

    public List<Role> selectAll();

    public int updateByPrimaryKey(Role record);
}