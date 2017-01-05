package com.xinhuanet.hylanda.dao;

import com.xinhuanet.hylanda.model.entity.Menu;
import org.springframework.stereotype.Component;

import java.util.List;

@Component (value = "menuMapper")
public interface MenuMapper {

    public int deleteByPrimaryKey(Long id);

    public int insert(Menu record);

    public Menu selectByPrimaryKey(Long id);

    public List<Menu> selectAll();

    public int updateByPrimaryKey(Menu record);
}