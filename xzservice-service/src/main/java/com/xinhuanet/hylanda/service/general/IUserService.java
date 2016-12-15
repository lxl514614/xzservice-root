package com.xinhuanet.hylanda.service.general;

import com.xinhuanet.hylanda.model.entity.User;
import com.xinhuanet.hylanda.service.IBaseService;

import java.util.List;

/**
 * Created by Administrator on 2016/12/13.
 */
public interface IUserService extends IBaseService<User> {

    /**
     * 获取所有用户信息
     * @return
     */
    public List<User> getUserList();
}
