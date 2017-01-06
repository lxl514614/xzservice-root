package com.xinhuanet.hylanda.dao;

import com.xinhuanet.hylanda.model.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "userMapper")
public interface UserMapper {
    public int deleteByPrimaryKey(Long id);

    public int insert(User record);

    public User selectByPrimaryKey(Long id);

    public List<User> selectAll();

    public int updateByPrimaryKey(User record);

    public User getByUserName(String username);

}