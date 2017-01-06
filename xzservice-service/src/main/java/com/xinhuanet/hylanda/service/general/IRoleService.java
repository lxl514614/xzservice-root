package com.xinhuanet.hylanda.service.general;

import com.xinhuanet.hylanda.model.entity.Role;

import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/1/5.
 */
public interface IRoleService {

    /**
     * 通过用户id获取当前用户角色信息
     * @param userId
     *
     * @return
     */
    public List<Role> findRolesByUserId(Long userId);

    /**
     * 根据角色id获取角色对应操作集合
     * @param roleId
     * @return
     */
    public Set<String> findPermissions(Long roleId);

    /**
     * 根据id获取角色信息
     * @param roleId
     * @return
     */
    public Role findById(Long roleId);
}
