package com.xinhuanet.hylanda.common.exception;


import org.apache.commons.lang.StringUtils;

/**
 * 用于处理business error的相关事务
 * 稳定后倒是可以放到error中
 *
 * @author wanda
 */
public class ErrorBuilder {
    public ErrorCate cate;
    public String msg;//用于扔到前台，但给技术看的信息
    private String _code;
    public String error_code;
    public Throwable cause;

    //
    public static ErrorBuilder createSys() {
        return create(ErrorCate.SYS);
    }

    public static ErrorBuilder createBusiness() {
        return create(ErrorCate.BUS);
    }

    /**
     * 简化处理，直接调用
     *
     * @param t
     */
    public static void process(Throwable t) throws BusinessError {
        createBusiness().cause(t).execute();
    }

    /**
     * @param cate
     * @return
     */
    private static ErrorBuilder create(ErrorCate cate) {
        ErrorBuilder ret = new ErrorBuilder();
        ret.cate = cate;
        return ret;
    }

    public ErrorBuilder msg(String value) {
        this.msg = value;
        return this;
    }

    public ErrorBuilder code(String value) {
        this._code = value;
        return this;
    }

    public ErrorBuilder cause(Throwable cause) {
        this.cause = cause;
        return this;
    }

    public ErrorBuilder error(String error) {
        this.error_code = error;
        return this;
    }

    public void execute(String msg) throws BusinessError {
        this.msg(msg);
        BusinessError error = build();
        throw error;
    }

    public void execute() throws BusinessError {
        BusinessError error = build();
        throw error;
    }

    /**
     * 构建异常
     *
     * @return
     */
    public BusinessError build() {
        BusinessError error = null;
        if (this.cause == null) {
            error = new BusinessError(cate, null, this.msg, null);
        } else {
            if (this.cause instanceof BusinessError) {
                error = (BusinessError) this.cause;
                return error;
            } else {
                error = new BusinessError(this.cate, this.cause, null);
            }
        }
        error.code = this._code;
        error.error = this.error_code;
        if (!StringUtils.isBlank(this.msg)) {
            if (StringUtils.isBlank(error.msg)) {
                error.msg = this.msg + "\n";
            } else {
                error.msg = this.msg + "\n" + error.msg;
            }
        }
        return error;
    }
}
