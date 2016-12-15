package com.xinhuanet.hylanda.security.filter;

import com.xinhuanet.hylanda.security.constants.SecurityConstants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by Administrator on 2016/12/9.
 */
public class SysUserFilter extends PathMatchingFilter {


    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

//        String username = (String) SecurityUtils.getSubject().getPrincipal();
//        request.setAttribute(SecurityConstants.CURRENT_USER, userService.findByUsername(username));
        return true;
    }

}
