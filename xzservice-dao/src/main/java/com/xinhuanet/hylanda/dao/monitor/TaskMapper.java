package com.xinhuanet.hylanda.dao.monitor;

import com.xinhuanet.hylanda.model.entity.wxb.WxbTask;
import com.xinhuanet.hylanda.model.vo.monitor.TaskQuery;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 上稿业务数据逻辑处理器
 * Created by Administrator on 2017/1/10.
 */
@Component (value = "uperMapper")
public interface TaskMapper {

    /**
     * 根据条件查询任务
     * @param query
     * @return
     */
    public List<WxbTask> findList(TaskQuery query);

    /**
     * 根据id删除记录
     * @param id
     * @return
     */
    public Integer deleteByPrimaryKey(Long id);

    /**
     * 添加记录
     * @param record
     * @return
     */
    public Integer insert(WxbTask record);
}
