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
    public String login(HttpServletRequest req, HttpServletResponse res, Model model, String username, String password) throws Exception {

        // shiro在认证过程中出现错误后将异常类路径通过request返回
        String exceptionClassName = (String) req
                .getAttribute("shiroLoginFailure");
        if(exceptionClassName!=null){
            if (UnknownAccountException.class.getName().equals(exceptionClassName)){
                model.addAttribute("message","账号不存在");
            } else if (IncorrectCredentialsException.class.getName().equals(
                    exceptionClassName)) {
                model.addAttribute("message","用户名/密码错误");
            } else if("randomCodeError".equals(exceptionClassName)){
                model.addAttribute("message","验证码错误");
            } else{
                throw new Exception();//最终在异常处理器生成未知错误
            }
        }

        return "/login/login";
    }

    @RequestMapping (value = "/logout")
    public  String logout(HttpServletRequest req, HttpServletResponse res) {

        return  "/login/logout";
    }
}
