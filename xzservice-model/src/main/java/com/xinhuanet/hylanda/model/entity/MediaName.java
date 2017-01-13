package com.xinhuanet.hylanda.model.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 网站媒体名称实体类
 * Created by Lee XL on 2017/1/13.
 */

public class MediaName implements Serializable {


    private Long standardId;

    private String mediaName;

    private String siteType;

    private Date tmcreate;

    private String area;

    private Integer isRank;

    private String url;

    public Long getStandardId() {
        return standardId;
    }

    public void setStandardId(Long standardId) {
        this.standardId = standardId;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    public String getSiteType() {
        return siteType;
    }

    public void setSiteType(String siteType) {
        this.siteType = siteType;
    }

    public Date getTmcreate() {
        return tmcreate;
    }

    public void setTmcreate(Date tmcreate) {
        this.tmcreate = tmcreate;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getIsRank() {
        return isRank;
    }

    public void setIsRank(Integer isRank) {
        this.isRank = isRank;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
