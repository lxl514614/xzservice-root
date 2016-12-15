package com.xinhuanet.hylanda.common.exception;
/**
 * Created by wanda on 4/14/16.
 */
public class RuntimeError extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = -1642671712443301700L;
    //
    public static final String MSG_NORMAL = "系统异常，请与运维人员联系";//FIXME 其实这么写是很不负责任的
    //
    protected ErrorCate _cate = ErrorCate.SYS;//默认为系统异常
    public String code ;
    public String error;
    public String msg;
    //
    public RuntimeError(){
        super();
    }
    public RuntimeError(ErrorCate cate){
        super();
        _cate = cate;
    }
    public RuntimeError(ErrorCate cate, String msg, String code){
        super();
        this.msg = msg;
        _cate = cate;
        this.code = code;
    }
    public RuntimeError(ErrorCate cate, String msg, String tech, String code){
        super(tech);
        this.msg = msg;
        _cate = cate;
        this.code = code;
    }
    public RuntimeError(ErrorCate cate, Throwable cause, String code){
        super(cause.getMessage(),cause);
        _cate = cate;
        this.code = code;
    }

    public RuntimeError(ErrorCate cate, String msg, Throwable cause, String code){
        super(cause.getMessage(),cause);
        _cate = cate;
        this.msg = msg;
        this.code = code;
    }
}
