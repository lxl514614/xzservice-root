package com.xinhuanet.hylanda.service.general.impl;

import com.xinhuanet.hylanda.dao.OperateMapper;
import com.xinhuanet.hylanda.dao.RoleMapper;
import com.xinhuanet.hylanda.model.entity.Operate;
import com.xinhuanet.hylanda.service.general.IOperateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/1/5.
 */
@Service(value = "operateService")
public class OperateServiceImpl implements IOperateService {


    @Autowired
    private OperateMapper operateMapper;

    @Override
    public Operate findPermissionsById(Long id) {
        return operateMapper.selectByPrimaryKey(id);
    }
}
