package com.xinhuanet.hylanda.service.general.impl;

import com.xinhuanet.hylanda.dao.RoleMapper;
import com.xinhuanet.hylanda.dao.RoleOperateMapper;
import com.xinhuanet.hylanda.dao.UserRoleMapper;
import com.xinhuanet.hylanda.model.entity.Operate;
import com.xinhuanet.hylanda.model.entity.Role;
import com.xinhuanet.hylanda.model.entity.RoleOperate;
import com.xinhuanet.hylanda.model.entity.UserRole;
import com.xinhuanet.hylanda.service.general.IOperateService;
import com.xinhuanet.hylanda.service.general.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/1/5.
 */
@Service(value = "roleService")
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RoleOperateMapper roleOperateMapper;

    @Autowired
    private IOperateService operateService;

    @Override
    public List<Role> findRolesByUserId(Long userId) {

        List<Role> roleList = new ArrayList<>();

        List<UserRole> userRoleList = userRoleMapper.findUserRoleByUserId(userId);

        for (UserRole userRole : userRoleList) {
            Role role = findById(userRole.getRoleId());
            roleList.add(role);
        }

        return roleList;
    }

    @Override
    public Set<String> findPermissions(Long roleId) {

        Set<String> permissionSet = new HashSet<>();

        List<RoleOperate> roleOperateList = roleOperateMapper.findOperateByRoleId(roleId);

        for (RoleOperate ro : roleOperateList) {
            Operate operate = operateService.findPermissionsById(ro.getOpId());
            permissionSet.add(operate.getCode());
        }


        return permissionSet;
    }

    @Override
    public Role findById(Long roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }
}
