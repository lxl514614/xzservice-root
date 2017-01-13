package com.xinhuanet.hylanda.service.monitor.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xinhuanet.hylanda.common.contant.StatusCodeHelper;
import com.xinhuanet.hylanda.common.helper.DateHelper;
import com.xinhuanet.hylanda.common.utils.DateFormatUtils;
import com.xinhuanet.hylanda.dao.monitor.TaskMapper;
import com.xinhuanet.hylanda.model.common.OpResult;
import com.xinhuanet.hylanda.model.common.Page;
import com.xinhuanet.hylanda.model.entity.wxb.WxbTask;
import com.xinhuanet.hylanda.model.vo.monitor.ListQueryVO;
import com.xinhuanet.hylanda.model.vo.monitor.TaskListVO;
import com.xinhuanet.hylanda.model.vo.monitor.TaskQuery;
import com.xinhuanet.hylanda.model.vo.monitor.TaskResponseVO;
import com.xinhuanet.hylanda.service.monitor.IUperService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 上稿业务操作service实现类
 * Created by Lee XL on 2017/1/10.
 */
@Service (value = "uperService")
public class UperServiceImpl implements IUperService {

    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UperServiceImpl.class);

    /**
     * 注入上稿数据操作mapper
     */
    @Autowired
    private TaskMapper taskMapper;


    @Override
    public TaskResponseVO queryTask(ListQueryVO query) {

        // 构建返回参数
        TaskResponseVO taskRes = new TaskResponseVO();
        List<WxbTask> taskList = new ArrayList<>();

        try {
            PageHelper.startPage(query.getIndex(),query.getSize());

            TaskQuery taskQuery = new TaskQuery();
            taskQuery.setTitle_keword(query.getTitleKeyword().trim());
            if (StatusCodeHelper.INSTANCE.TODAY_CODE == query.getDate()) {
                // 获得起始时间
                String sdate = DateHelper.INTANCE.dateFormat(DateHelper.INTANCE.DF_YYYY_MM_DD).format(new Date());
                sdate = sdate + " 00:00:00";
                Date started = DateHelper.INTANCE.dateFormat(DateHelper.INTANCE.DF_YYYY_MM_DD_HH_MM_SS).parse(sdate);
                // 获得结束时间
                String fdate = DateHelper.INTANCE.dateFormat(DateHelper.INTANCE.DF_YYYY_MM_DD).format(new Date());
                fdate = fdate + " 23:59:59";
                Date ended = DateHelper.INTANCE.dateFormat(DateHelper.INTANCE.DF_YYYY_MM_DD_HH_MM_SS).parse(fdate);

                taskQuery.setSart_tm(started);
                taskQuery.setEnd_tm(ended);
            }
            taskList = taskMapper.findList(taskQuery);
        }
        catch (Exception e) {
            taskRes.setResp(new OpResult(OpResult.OP_FAILED,OpResult.OpMsg.OP_FAIL));
            return taskRes;
        }

        PageInfo<WxbTask> pageInfo = new PageInfo<WxbTask>(taskList);
        // 设置返回参数
        // 设置data数据
        List<TaskListVO> datalist = new ArrayList<>();

        for (WxbTask task : taskList) {
            TaskListVO taskVO = new TaskListVO();
            taskVO.setTaskId(task.getId());
            taskVO.setTitle(task.getTitle());
            taskVO.setUrl(task.getUrl());
            taskVO.setSponsor("网信办");
            taskVO.setCr_tm(DateFormatUtils.format(task.getCreateTm(),"MM-dd HH:mm"));
            taskVO.setCompleteness("90");

            datalist.add(taskVO);

        }

        taskRes.setDatalist(datalist);
        // 设置page信息
        Page page = new Page();
        page.setPage_index(pageInfo.getPageNum());
        page.setPage_size(pageInfo.getPageSize());
        page.setTotal_page(pageInfo.getPages());
        page.setTotal_recorders(pageInfo.getTotal());

        taskRes.setPage(page);

        return taskRes;
    }

    @Override
    @Transactional
    public Integer deleteTask(String ids) {

        String[] idsArr = ids.split(",");

        Integer isSuccess = StatusCodeHelper.INSTANCE.OP_SUCCESS;

        for (String id : idsArr) {
            isSuccess = this.deleteTaskById(Long.getLong(id));
        }

        return isSuccess;
    }

    @Override
    @Transactional
    public Integer deleteTaskById(Long id) {
        return taskMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public Integer saveTask(WxbTask task) {

        Integer isSuccess = StatusCodeHelper.INSTANCE.OP_SUCCESS;

        task.setType(StatusCodeHelper.INSTANCE.TASK_UPER);
        task.setCreateTm(new Date());
//        task.setCreator_id(null);

        isSuccess = taskMapper.insert(task);

        return isSuccess;
    }
}
