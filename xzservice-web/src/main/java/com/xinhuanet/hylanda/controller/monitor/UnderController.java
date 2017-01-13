package com.xinhuanet.hylanda.controller.monitor;

import com.xinhuanet.hylanda.BaseController;
import com.xinhuanet.hylanda.common.contant.StatusCodeHelper;
import com.xinhuanet.hylanda.model.common.OpResult;
import com.xinhuanet.hylanda.model.entity.wxb.WxbTask;
import com.xinhuanet.hylanda.model.vo.monitor.ListQueryVO;
import com.xinhuanet.hylanda.model.vo.monitor.TaskResponseVO;
import com.xinhuanet.hylanda.service.monitor.IUnderService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *下稿业务逻辑控制器,下稿业务操作统一入口
 * Created Lee XL on 2017/1/9.
 */
@Controller
@RequestMapping (value = "/under")
public class UnderController extends BaseController {

    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UperController.class);

    /**
     * 注入下稿操作业务service
     */
    @Autowired
    private IUnderService underService;


    /**
     * 跳转到下稿管理页面
     */
    @RequestMapping (value = "/list",method = RequestMethod.GET)
    public String uperList(Model model, HttpServletRequest request, HttpServletResponse response) {


        return "/under/underManagement";
    }

    /**
     * 下稿分页列表
     */
    @RequestMapping (value = "/list", method = RequestMethod.POST)
    @ResponseBody
    private TaskResponseVO tasklist(@RequestBody ListQueryVO query, HttpServletRequest request, HttpServletResponse response) {

        LOGGER.info("获取任务列表开始! titme:{}", System.currentTimeMillis());

        TaskResponseVO taskRes = new TaskResponseVO();

        try {
            taskRes = underService.queryTask(query);
        }
        catch (Exception e) {

            OpResult result = new OpResult(OpResult.OP_FAILED,OpResult.OpMsg.OP_FAIL);
            taskRes.setResp(result);
        }

        LOGGER.info("获取任务列表结束! titme:{}", System.currentTimeMillis());
        return taskRes;
    }

    /**
     * 跳转到添加任务页面
     */
    @RequestMapping (value = "/add",method = RequestMethod.GET)
    public String toAdd() {


        return "/under/underCreate";
    }

    /**
     * 保存任务
     */
    @RequestMapping (value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public OpResult save(@RequestBody WxbTask task, HttpServletRequest request, HttpServletResponse response) {
        OpResult result = new OpResult(OpResult.OP_SUCCESS,OpResult.OpMsg.OP_SUCCESS);

        Integer isSuccess = StatusCodeHelper.INSTANCE.OP_SUCCESS;

        try {
            isSuccess = underService.saveTask(task);

            if ( null == isSuccess || StatusCodeHelper.INSTANCE.OP_FAIL == isSuccess) {
                result.setStatus(OpResult.OP_FAILED);
                result.setStatus(OpResult.OpMsg.DELETE_FAIL);
            }
        }
        catch (Exception e) {
            result.setStatus(OpResult.OP_FAILED);
            result.setStatus(OpResult.OpMsg.DELETE_FAIL);
            return result;
        }

        return result;
    }


    /**
     * 删除下稿任务
     */
    @RequestMapping (value = "/delete/{ids}")
    @ResponseBody
    public OpResult delete(@RequestBody String ids) {
        OpResult result = new OpResult(OpResult.OP_SUCCESS,OpResult.OpMsg.OP_SUCCESS);

        if (StringUtils.isBlank(ids)) {
            result.setStatus(OpResult.OP_FAILED);
            result.setStatus(OpResult.OpMsg.DELETE_FAIL);
            return result;
        }

        Integer isSuccess = StatusCodeHelper.INSTANCE.OP_SUCCESS;
        try {
            isSuccess = underService.deleteTask(ids);

            if ( null == isSuccess || StatusCodeHelper.INSTANCE.OP_FAIL == isSuccess) {
                result.setStatus(OpResult.OP_FAILED);
                result.setStatus(OpResult.OpMsg.DELETE_FAIL);
            }
        }
        catch (Exception e) {
            result.setStatus(OpResult.OP_FAILED);
            result.setStatus(OpResult.OpMsg.DELETE_FAIL);
            return result;
        }

        return result;
    }
}
