package com.xinhuanet.hylanda.service.general;

import com.xinhuanet.hylanda.model.entity.User;

import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/1/5.
 */
public interface IUserService {

    public List<User> getAllUser();

    /**
     * 通过用户名获取用户信息
     * @param username
     * @author Lee XL
     * @return
     */
    public User getByUserName(String username);

    /**
     * 通过用户id获取当前用户角色
     * @param userId
     * @return
     */
    public Set<String> findRoles(Long userId);

    /**
     * 通过用户id获取当前用户所有操作
     * @param userId
     * @return
     */
    public Set<String> findPermissions(Long userId);

    /**
     * 通过用户id获取用户信息
     * @param userId
     * @return
     */
    public User findById(Long userId);
}
