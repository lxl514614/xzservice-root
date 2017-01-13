package com.xinhuanet.hylanda.service.monitor;

import com.xinhuanet.hylanda.model.entity.wxb.WxbTask;
import com.xinhuanet.hylanda.model.vo.monitor.ListQueryVO;
import com.xinhuanet.hylanda.model.vo.monitor.TaskResponseVO;

/**
 * 下稿业务操作service,下稿相关业务统一入口
 * Created by Lee XL on 2017/1/10.
 */

public interface IUnderService {

    /**
     * 根据条件查询满足条件任务分页列表
     * @param query
     * @return
     */
    public TaskResponseVO queryTask(ListQueryVO query);

    /**
     * 保存下稿任务
     * @param task
     * @return
     */
    public Integer saveTask(WxbTask task);

    /**
     * 根据id组批量清除任务
     * @param ids
     * @return
     */
    public Integer deleteTask(String ids);

    /**
     * 根据id删除任务
     * @param id
     * @return
     */
    public Integer deleteTaskById(Long id);
}
