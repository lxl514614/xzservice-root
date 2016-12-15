package com.xinhuanet.hylanda.controller;

import com.xinhuanet.hylanda.controller.base.BaseController;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/12/9.
 */
@Controller
public class LoginController extends BaseController {

    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String showLoginForm(HttpServletRequest req, Model model) {

        return "login/login";
    }

    @RequestMapping (value = "/login", method = {RequestMethod.POST})
    public String login(HttpServletRequest req, HttpServletResponse res, Model model, String username, String password) {

        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {

            model.addAttribute("message", "请输入用户名和密码!!");

            return "login/login";
        }

        if (!username.equals("admin") || !password.equals("admin")) {
            model.addAttribute("message", "用户名或密码错误!!");

            return "login/login";
        }
        else {
            return "redirect:/index";
        }
    }

    @RequestMapping (value = "/logout")
    public  String logout(HttpServletRequest req, HttpServletResponse res) {

        return  "/login/logout";
    }
}
