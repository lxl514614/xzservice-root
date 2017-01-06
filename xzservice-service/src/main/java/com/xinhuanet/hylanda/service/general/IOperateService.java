package com.xinhuanet.hylanda.service.general;

import com.xinhuanet.hylanda.model.entity.Operate;

import java.util.Set;

/**
 * Created by Administrator on 2017/1/5.
 */
public interface IOperateService {

    /**
     * 通过id获取操作信息
     * @return
     */
    public Operate findPermissionsById(Long id);
}
