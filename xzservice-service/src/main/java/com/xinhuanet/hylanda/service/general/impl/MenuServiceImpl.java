package com.xinhuanet.hylanda.service.general.impl;

import com.xinhuanet.hylanda.dao.IBaseDao;
import com.xinhuanet.hylanda.dao.general.IMenuDao;
import com.xinhuanet.hylanda.model.entity.Menu;
import com.xinhuanet.hylanda.service.BaseServiceImpl;
import com.xinhuanet.hylanda.service.general.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统菜单相关操作实现类
 * Created by Administrator on 2016/12/13.
 */
@Service (value = "menuService")
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements IMenuService {

    @Autowired
    private IMenuDao menuDao;

    @Override
    public IBaseDao<Menu> getBaseDao() {
        return menuDao;
    }
}
