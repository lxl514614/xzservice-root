package com.xinhuanet.hylanda.model.entity;

import java.util.Date;

public class Menu {
    private Long id;

    private Date crtTs;

    private Date updateTs;

    private String name;

    private String code;

    private Byte level;

    private String dataTrigger;

    private String parentCode;

    private String action;

    private Byte status;

    private Byte sort;

    private String icon;

    private String footIcon;

    private String srcType;

    private String execExp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCrtTs() {
        return crtTs;
    }

    public void setCrtTs(Date crtTs) {
        this.crtTs = crtTs;
    }

    public Date getUpdateTs() {
        return updateTs;
    }

    public void setUpdateTs(Date updateTs) {
        this.updateTs = updateTs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public String getDataTrigger() {
        return dataTrigger;
    }

    public void setDataTrigger(String dataTrigger) {
        this.dataTrigger = dataTrigger == null ? null : dataTrigger.trim();
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getSort() {
        return sort;
    }

    public void setSort(Byte sort) {
        this.sort = sort;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getFootIcon() {
        return footIcon;
    }

    public void setFootIcon(String footIcon) {
        this.footIcon = footIcon == null ? null : footIcon.trim();
    }

    public String getSrcType() {
        return srcType;
    }

    public void setSrcType(String srcType) {
        this.srcType = srcType == null ? null : srcType.trim();
    }

    public String getExecExp() {
        return execExp;
    }

    public void setExecExp(String execExp) {
        this.execExp = execExp == null ? null : execExp.trim();
    }
}