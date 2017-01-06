package com.xinhuanet.hylanda.controller.general;

import com.xinhuanet.hylanda.BaseController;
import com.xinhuanet.hylanda.model.entity.Menu;
import com.xinhuanet.hylanda.service.general.IMenuService;
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
 * 菜单操作逻辑控制器
 * Created by Administrator on 2016/12/13.
 */
@Controller
@RequestMapping (value = "/menu")
public class MenuController extends BaseController {

    /**
     * 日志
     */
    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 注入菜单业务操作service
     */
    @Autowired
    private IMenuService menuService;

    /**
     * 查看菜单列表
     * @param model
     * @param req
     * @param res
     * @return
     */
    @RequestMapping (value = "/list", method = {RequestMethod.POST})
    public String menuList(Model model, HttpServletRequest req, HttpServletResponse res) {


        return "";
    }

    /**
     * 跳转到添加页面
     * @param model
     * @param req
     * @param res
     * @return
     */
    @RequestMapping (value = "/add", method = {RequestMethod.GET})
    public String toAdd (Model model, HttpServletRequest req, HttpServletResponse res) {


        return "";
    }

    /**
     * 跳转到菜单编辑页面
     * @param menuId
     * @param model
     * @param req
     * @param res
     * @return
     */
    @RequestMapping (value = "/edit/{menu_id", method = {RequestMethod.GET})
    public String toEdit (@PathVariable("menu_id") Long menuId, Model model, HttpServletRequest req, HttpServletResponse res) {


        return "";
    }

    /**
     * 保存菜单记录
     * @param menu
     * @param model
     * @param req
     * @param res
     * @return
     */
    @RequestMapping (value = "/save", method = {RequestMethod.POST})
    public String saveMenu(Menu menu, Model model, HttpServletRequest req, HttpServletResponse res) {


        return "";
    }

    /**
     * 删除选中菜单项(单条删除)
     * @param menuId
     * @param model
     * @param req
     * @param res
     * @return
     */
    @RequestMapping (value = "/delete/{menu_id}", method = {RequestMethod.GET})
    public String deleteMenu(@PathVariable("menu_id") Long menuId, Model model, HttpServletRequest req, HttpServletResponse res) {

        return "";
    }
}
