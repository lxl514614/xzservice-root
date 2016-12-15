package com.xinhuanet.hylanda.security.constants;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-15
 * <p>Version: 1.0
 */
public interface SecurityConstants {

    public static final String CURRENT_USER = "user";
    /**
     * 登录用户
     */
    public final static String LOGIN_USER = "login_user";

    /**
     * 验证码
     */
    public final static String CAPTCHA_KEY = "captcha_key";

    /**
     * 日志参数
     */
    public final static String LOG_ARGUMENTS = "log_arguments";

    /**
     * 动态查询，参数前缀
     */
    public final static String SEARCH_PREFIX = "search_";

    /**
     * 内部动态查询参数常量
     */
    public final static String NEST_DYNAMIC_SEARCH = "$nest_dynamic_search$";

    /**
     * 内部动态查询参数常量，logical
     */
    public final static String NEST_DYNAMIC_SEARCH_LOGICAL = "$nest_dynamic_search_logical$";
}
