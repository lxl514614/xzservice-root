package com.xinhuanet.hylanda.model.vo.monitor;

import java.io.Serializable;

/**
 * 上稿/下稿任务查询VO
 * Created by Administrator on 2017/1/9.
 */

public class ListQueryVO implements Serializable {

    /**
     * 日期类型
     */
    private Integer date;

    /**
     * 查询关键词
     */
    private String titleKeyword;

    /**
     * 每页显示数量
     */
    private Integer size = 10;

    /**
     * 页码
     */
    private Integer index = 1;

    /**
     * 任务类型
     */
    private Integer type;

    /**
     * 开始时间
     */
    private String startTm;

    /**
     * 结束时间
     */
    private String endTm;


    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getTitleKeyword() {
        return titleKeyword;
    }

    public void setTitleKeyword(String titleKeyword) {
        this.titleKeyword = titleKeyword;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getStartTm() {
        return startTm;
    }

    public void setStartTm(String startTm) {
        this.startTm = startTm;
    }

    public String getEndTm() {
        return endTm;
    }

    public void setEndTm(String endTm) {
        this.endTm = endTm;
    }
}
