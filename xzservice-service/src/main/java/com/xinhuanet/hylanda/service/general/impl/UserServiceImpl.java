package com.xinhuanet.hylanda.service.general.impl;

import com.xinhuanet.hylanda.dao.IBaseDao;
import com.xinhuanet.hylanda.dao.general.IUserDao;
import com.xinhuanet.hylanda.model.entity.User;
import com.xinhuanet.hylanda.service.BaseServiceImpl;
import com.xinhuanet.hylanda.service.general.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统用户相关操作实现类
 * Created by Administrator on 2016/12/13.
 */
@Service (value = "userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public IBaseDao<User> getBaseDao() {
        return userDao;
    }


    @Override
    public List<User> getUserList() {

        List<User> userList = new ArrayList<>();

        userList = userDao.getAllUser();

        return userList;
    }
}
