
package com.xinhuanet.hylanda.dao;

import com.xinhuanet.hylanda.model.entity.UserRole;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "userRoleMapper")
public interface UserRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserRole record);

    UserRole selectByPrimaryKey(Long id);

    List<UserRole> selectAll();

    int updateByPrimaryKey(UserRole record);

    public List<UserRole> findUserRoleByUserId(Long userId);
}