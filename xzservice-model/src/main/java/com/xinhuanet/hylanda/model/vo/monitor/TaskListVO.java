package com.xinhuanet.hylanda.model.vo.monitor;

/**
 * 上稿/下稿任务
 * Created by Administrator on 2017/1/9.
 */

public class TaskListVO {

    /**
     * 任务id
     */
    private Long taskId;

    /**
     * 新闻标题
     */
    private String title;

    /**
     * 新闻url
     */
    private String url;

    /**
     * 任务发起人
     */
    private String sponsor;

    /**
     * 任务创建时间
     */
    private String cr_tm;

    /**
     * 任务完成率
     */
    private String completeness;


    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
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

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getCr_tm() {
        return cr_tm;
    }

    public void setCr_tm(String cr_tm) {
        this.cr_tm = cr_tm;
    }

    public String getCompleteness() {
        return completeness;
    }

    public void setCompleteness(String completeness) {
        this.completeness = completeness;
    }
}
