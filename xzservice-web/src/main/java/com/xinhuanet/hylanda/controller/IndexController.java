package com.xinhuanet.hylanda.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 项目启动欢迎页面
 * Created by Administrator on 2016/12/8.
 */
@Controller
public class IndexController {

    /**
     * 日志
     */
    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping (value = "/index/{name}")
    public String index(@PathVariable String name, Model model) {


        logger.info("进入index方法区==========");
        model.addAttribute("name",name);
        logger.info("方法执行完毕======");

        return "/index/home";

    }

    @RequestMapping (value = "/index")
    public String index(Model model) {


        // 主页业务


        return "/index/home";

    }
}
