package com.xinhuanet.hylanda.dao.general;

import com.xinhuanet.hylanda.dao.IBaseDao;
import com.xinhuanet.hylanda.model.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/12/13.
 */
@Service (value = "userDao")
public interface IUserDao extends IBaseDao<User>{

    /**
     * 获取所有用户信息
     * @return
     */
    public List<User> getAllUser();

}
