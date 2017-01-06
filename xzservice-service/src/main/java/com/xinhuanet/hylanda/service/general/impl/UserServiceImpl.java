package com.xinhuanet.hylanda.service.general.impl;

import com.xinhuanet.hylanda.dao.UserMapper;
import com.xinhuanet.hylanda.model.entity.Role;
import com.xinhuanet.hylanda.model.entity.User;
import com.xinhuanet.hylanda.service.general.IRoleService;
import com.xinhuanet.hylanda.service.general.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/1/5.
 */
@Service (value = "userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IRoleService roleService;

    @Override
    public List<User> getAllUser() {

        List<User> userList = userMapper.selectAll();

        return userList;
    }

    @Override
    public User getByUserName(String username) {

        return userMapper.getByUserName(username);
    }


    @Override
    public Set<String> findRoles(Long userId) {

        Set<String> roles = new HashSet<String>();

        List<Role> roleList = roleService.findRolesByUserId(userId);
        for (Role role : roleList) {
            roles.add(role.getCode());
        }

        return roles;
    }



    @Override
    public Set<String> findPermissions(Long userId) {
        Set<String> permissions = new HashSet<String>();

        List<Role> roleList = roleService.findRolesByUserId(userId);
        for (Role role : roleList) {

            Set<String> permissionList = roleService.findPermissions(role.getId());

            permissions.addAll(permissionList);
        }

        return permissions;
    }

    @Override
    public User findById(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}
