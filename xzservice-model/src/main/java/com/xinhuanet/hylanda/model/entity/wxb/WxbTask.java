package com.xinhuanet.hylanda.model.entity.wxb;

import java.io.Serializable;
import java.util.Date;

/**
 * 网信办新闻督查任务实体类
 * Created by LEE XL on 2017/1/9.
 */
public class WxbTask implements Serializable{

    /**
     * 主键id
     */
    private Long id;

    /**
     * 新闻标题
     */
    private String title;

    /**
     * 新闻url
     */
    private String url;

    /**
     * 内容文本
     */
    private String desc;

    /**
     * 关注网站
     */
    private String sites;

    /**
     * 任务要求
     */
    private String demands;

    /**
     * 指令代码
     */
    private String actionCode;

    /**
     * 办领导审核结果
     */
    private String result;

    /**
     * 审核人
     */
    private String reviewer;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 任务类型 1:上稿任务;2:下稿任务
     */
    private Integer type;

    /**
     * 任务状态(1:有效;2:无效)
     */
    private Integer status;

    /**
     * 是否删除(1:未删除;2:已删除)
     */
    private Integer isDelete;

    /**
     * 创建时间
     */
    private Date createTm;

    /**
     * 创建人id
     */
    private Long creatorId;

    private String taskTm;


    public WxbTask() {
    }


    public WxbTask(String title, Date createTm) {
        this.title = title;
        this.createTm = createTm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSites() {
        return sites;
    }

    public void setSites(String sites) {
        this.sites = sites;
    }

    public String getDemands() {
        return demands;
    }

    public void setDemands(String demands) {
        this.demands = demands;
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTm() {
        return createTm;
    }

    public void setCreateTm(Date createTm) {
        this.createTm = createTm;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public String getTaskTm() {
        return taskTm;
    }

    public void setTaskTm(String taskTm) {
        this.taskTm = taskTm;
    }
}
