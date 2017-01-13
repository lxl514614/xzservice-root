package com.xinhuanet.hylanda.model.vo.monitor;

import java.util.Date;

/**
 * Created by Administrator on 2017/1/10.
 */

public class TaskQuery {

    /**
     * 查询关键词
     */
    private String title_keword;

    /**
     * 查询开始时间
     */
    private Date sart_tm;

    /**
     * 查询结束时间
     */
    private Date end_tm;

    /**
     * 任务状态
     */
    private Integer status = 1;

    /**
     * 任务是否被删除
     */
    private Integer is_delete = 1;

    /**
     * 创建时间
     */
    private Date create_tm;

    public String getTitle_keword() {
        return title_keword;
    }

    public void setTitle_keword(String title_keword) {
        this.title_keword = title_keword;
    }

    public Date getSart_tm() {
        return sart_tm;
    }

    public void setSart_tm(Date sart_tm) {
        this.sart_tm = sart_tm;
    }

    public Date getEnd_tm() {
        return end_tm;
    }

    public void setEnd_tm(Date end_tm) {
        this.end_tm = end_tm;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Integer is_delete) {
        this.is_delete = is_delete;
    }

    public Date getCreate_tm() {
        return create_tm;
    }

    public void setCreate_tm(Date create_tm) {
        this.create_tm = create_tm;
    }
}
