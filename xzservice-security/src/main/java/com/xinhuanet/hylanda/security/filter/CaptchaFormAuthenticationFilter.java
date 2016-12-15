package com.xinhuanet.hylanda.security.filter;

import com.xinhuanet.hylanda.common.utils.ServletUtils;
import com.xinhuanet.hylanda.security.constants.SecurityConstants;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by Administrator on 2016/12/9.
 */
public class CaptchaFormAuthenticationFilter extends BaseFormAuthenticationFilter {

    private static final Logger log = LoggerFactory.getLogger(CaptchaFormAuthenticationFilter.class);

    private String captchaParam = SecurityConstants.CAPTCHA_KEY;

    public String getCaptchaParam() {
        return captchaParam;
    }

    protected String getCaptcha(ServletRequest request) {
        return WebUtils.getCleanParam(request, getCaptchaParam());
    }

    @Override
    protected AuthenticationToken createToken(ServletRequest request,
                                              ServletResponse response) {
        String username = getUsername(request);
        String password = getPassword(request);
        String captcha = getCaptcha(request);
        boolean rememberMe = isRememberMe(request);
        String host = ServletUtils.getRemoteAddr(request);
        log.info(">>>> getClientIpAddress : " + host);
        return new CaptchaUsernamePasswordToken(username, password, rememberMe,
                host, captcha);
    }

}

