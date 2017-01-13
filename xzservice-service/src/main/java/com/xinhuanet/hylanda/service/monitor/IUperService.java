package com.xinhuanet.hylanda.service.monitor;

import com.xinhuanet.hylanda.model.entity.wxb.WxbTask;
import com.xinhuanet.hylanda.model.vo.monitor.ListQueryVO;
import com.xinhuanet.hylanda.model.vo.monitor.TaskResponseVO;

/**
 * 上稿业务操作service,上稿相关业务统一入口
 * Created by Lee XL on 2017/1/10.
 */
public interface IUperService {

    /**
     * 根据条件查询任务列表分页信息
     * @param query
     * @return
     */
    public TaskResponseVO queryTask(ListQueryVO query);

    /**
     *
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

    /**
     * 保存上稿任务
     * @param task
     * @return
     */
    public Integer saveTask(WxbTask task);
}
