package com.xinhuanet.hylanda.controller.general;

import com.xinhuanet.hylanda.BaseController;
import com.xinhuanet.hylanda.model.entity.Role;
import com.xinhuanet.hylanda.service.general.IRoleService;
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
 * 用户角色管理controller
 * Created by Administrator on 2016/12/13.
 */
@Controller
@RequestMapping (value = "/role")
public class RoleController extends BaseController {


    /**
     * 日志
     */
    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 注入角色业务操作service
     */
    @Autowired
    private IRoleService roleService;

    /**
     * 查看角色管理列表页
     * @param model
     * @param req
     * @param res
     * @return
     */
    @RequestMapping (value = "/list", method = {RequestMethod.GET})
    public String list(Model model, HttpServletRequest req, HttpServletResponse res) {


        return "/general/role_list";
    }

    /**
     * 跳转到角色添加页面
     * @param model
     * @param req
     * @param res
     * @return
     */
    @RequestMapping (value = "/add", method = {RequestMethod.GET})
    public String toAdd (Model model, HttpServletRequest req, HttpServletResponse res) {



        return "/general/role_save";
    }

    /**
     * 跳转到角色修改页面
     * @param roleId
     * @param model
     * @param req
     * @param res
     * @return
     */
    @RequestMapping (value = "/edit/{role_id}")
    public String toEdit(@PathVariable ("role_id") Long roleId, Model model, HttpServletRequest req, HttpServletResponse res) {


        return "/general/role_save";
    }

    /**
     * 保存角色信息
     * @param role
     * @param model
     * @param req
     * @param res
     * @return
     */
    @RequestMapping (value = "/save")
    public String saveRole(Role role, Model model, HttpServletRequest req, HttpServletResponse res) {

        return "";
    }

    /**
     * 删除角色(单条删除)
     * @param roleId
     * @return
     */
    @RequestMapping (value = "/delete/{role_id}")
    public String deleteRole (@PathVariable ("role_id") Long roleId) {

        return "";
    }



}
