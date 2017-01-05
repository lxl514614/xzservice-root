package com.xinhuanet.hylanda.service.general.impl;

import com.xinhuanet.hylanda.dao.UserMapper;
import com.xinhuanet.hylanda.model.entity.User;
import com.xinhuanet.hylanda.service.general.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/1/5.
 */
@Service (value = "userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUser() {

        List<User> userList = userMapper.selectAll();

        return userList;
    }
}
