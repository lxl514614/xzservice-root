package com.xinhuanet.hylanda.service.general.impl;

import com.xinhuanet.hylanda.dao.IBaseDao;
import com.xinhuanet.hylanda.dao.general.IOperateDao;
import com.xinhuanet.hylanda.model.entity.Operate;
import com.xinhuanet.hylanda.service.BaseServiceImpl;
import com.xinhuanet.hylanda.service.general.IOperateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统操作相关管理实现类
 * Created by Administrator on 2016/12/13.
 */
@Service (value = "operateService")
public class OperateServiceImpl extends BaseServiceImpl<Operate> implements IOperateService {

    @Autowired
    private IOperateDao operateDao;

    @Override
    public IBaseDao<Operate> getBaseDao() {
        return operateDao;
    }
}
