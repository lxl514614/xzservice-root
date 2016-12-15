package com.xinhuanet.hylanda.service.general.impl;

import com.xinhuanet.hylanda.dao.IBaseDao;
import com.xinhuanet.hylanda.dao.general.IRoleDao;
import com.xinhuanet.hylanda.model.entity.Role;
import com.xinhuanet.hylanda.service.BaseServiceImpl;
import com.xinhuanet.hylanda.service.general.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统角色相关操作实现类
 * Created by Administrator on 2016/12/13.
 */
@Service (value = "roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public IBaseDao<Role> getBaseDao() {
        return roleDao;
    }
}
