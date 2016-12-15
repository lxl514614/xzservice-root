package com.xinhuanet.hylanda.controller.general;

import com.xinhuanet.hylanda.controller.base.BaseController;
import com.xinhuanet.hylanda.model.entity.Operate;
import com.xinhuanet.hylanda.service.general.IOperateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 系统操作设置controller
 * Created by Administrator on 2016/12/13.
 */
@Controller
@RequestMapping (value = "/operate")
public class OperateController extends BaseController{

    /**
     * 日志
     */
    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 注入操作业务操作service
     */
    @Autowired
    private IOperateService operateService;

    /**
     * 查看系统操作列表
     * @param model
     * @param req
     * @param res
     * @return
     */
    @RequestMapping (value = "/list", method = {RequestMethod.POST})
    public String operateList(Model model, HttpServletRequest req, HttpServletResponse res) {


        return "";
    }

    /**
     * 跳转到操作添加页面
     * @param model
     * @param req
     * @param res
     * @return
     */
    @RequestMapping (value = "/add", method = {RequestMethod.GET})
    public String toAdd(Model model, HttpServletRequest req, HttpServletResponse res) {

        return "";
    }

    /**
     * 跳转到操作修改页面
     * @param operateId
     * @param model
     * @param req
     * @param res
     * @return
     */
    @RequestMapping (value = "/edit/{operate_id}", method = {RequestMethod.GET})
    public String toEdit(@PathVariable("operate_id") Long operateId, Model model, HttpServletRequest req, HttpServletResponse res) {

        return "";
    }

    /**
     * 保存操作
     * @param operate
     * @param model
     * @param req
     * @param res
     * @return
     */
    @RequestMapping (value = "/save", method = {RequestMethod.POST})
    public String saveOperate(Operate operate, Model model, HttpServletRequest req, HttpServletResponse res) {


        return "";
    }

    /**
     * 删除选中操作(单条删除)
     * @param operateId
     * @param model
     * @param req
     * @param res
     * @return
     */
    @RequestMapping (value = "delete/{operate_id}", method = {RequestMethod.GET})
    public String deleteOperate(@PathVariable ("operate_id") Long operateId, Model model, HttpServletRequest req, HttpServletResponse res) {

        return "";
    }
}
