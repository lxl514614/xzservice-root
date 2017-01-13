package com.xinhuanet.hylanda.common.contant;

/**
 * Created by Administrator on 2017/1/10.
 */
public enum StatusCodeHelper {


    INSTANCE;

    /************************************数据库操作状态码************************************/

    /**
     * 操作成功
     */
    public static final Integer OP_SUCCESS = 1;

    /**
     * 操作失败
     */
    public static final Integer OP_FAIL = 0;


    /**************************************列表日期查询状态码************************************/

    /**
     * 当天
     */
    public static final Integer TODAY_CODE = 1;

    /**
     * 全部
     */
    public static final Integer ALL_DAY_CODE = 2;

    /**************************************任务类型状态码************************************/

    /**
     * 上稿监控类型码
     */
    public static final Integer TASK_UPER = 1;

    /**
     * 下稿监控类型码
     */
    public static final Integer TASK_UNDER = 2;

}
