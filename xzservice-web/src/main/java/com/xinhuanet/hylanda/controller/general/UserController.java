package com.xinhuanet.hylanda.controller.general;

import com.xinhuanet.hylanda.BaseController;
import com.xinhuanet.hylanda.model.entity.User;
import com.xinhuanet.hylanda.service.general.IUserService;
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
import java.util.List;

/**
 * 系统用户管理,用于对用户信息的基本设置CRUD
 * Created by Administrator on 2016/12/13.
 */
@Controller
@RequestMapping (value = "/user")
public class UserController extends BaseController {


    /**
     * 日志
     */
    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 注入用户操作service
     */
    @Autowired
    private IUserService userService;

    /**
     * 获取用户列表
     * @param model
     * @param req
     * @param response
     * @return
     */
    @RequestMapping (value = "/list")
    public String userList(Model model, HttpServletRequest req, HttpServletResponse response) {

        List<User> userList = userService.getAllUser();

        model.addAttribute("userList", userList);

        return "/general/user_list";
    }

    /**
     * 跳转到新建用户页面
     * @param model
     * @param req
     * @param response
     * @return
     */
    @RequestMapping (value = "/add", method = {RequestMethod.GET})
    public String toAdd (Model model, HttpServletRequest req, HttpServletResponse response) {



        return "/general/user_save";
    }

    /**
     * 跳转到编辑用户页面
     * @param userId
     * @param model
     * @param req
     * @param response
     * @return
     */
    @RequestMapping (value = "/edit/{user_id}", method = {RequestMethod.GET})
    public String toEdit (@PathVariable("user_id") Long userId, Model model, HttpServletRequest req, HttpServletResponse response) {


        return "/general/user_save";
    }

    /**
     * 保存用户信息
     * @param user
     * @param model
     * @param req
     * @param response
     * @return
     */
    @RequestMapping (value = "/save", method = {RequestMethod.POST})
    public String saveUser (User user,Model model, HttpServletRequest req, HttpServletResponse response) {


        return "";
    }

    /**
     * 删除用户信息(单条删除)
     * @param userId
     * @param model
     * @param req
     * @param response
     * @return
     */
    @RequestMapping (value = "/delete/{user_id}", method = {RequestMethod.GET})
    public String deleteUser (@PathVariable("user_id") Long userId, Model model, HttpServletRequest req, HttpServletResponse response) {



        return "";
    }

    /**
     * 跳转到修改密码页面
     * @param userId
     * @param model
     * @param req
     * @param response
     * @return
     */
    @RequestMapping (value = "/settings/password/{user_id}", method = {RequestMethod.GET})
    public String settiongPassword (@PathVariable ("user_id") Long userId, Model model, HttpServletRequest req, HttpServletResponse response) {

        return "";
    }

    /**
     * 修改用户密码
     * @param userId
     * @param model
     * @param req
     * @param response
     * @return
     */
    @RequestMapping (value = "/settings/password", method = {RequestMethod.POST})
    public String updatePassword (@PathVariable ("user_id") Long userId, String oldPassword, String newPassword, Model model, HttpServletRequest req, HttpServletResponse response) {


        return "";
    }


}
