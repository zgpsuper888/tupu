package com.tupu.domain;

import java.util.Date;

public class Relation {

    // 实体id
    private long id;
    //模版ID
    private long templateId;
    private String enRelationName;
    private String cnRelationName;
    //实体父ID
    private long parentId;
    private String sEntityId;
    private String tEntityId;
    //实体英文名
    private String sEntityName;
    //实体中文名
    private String tEntityName;
    private long createUid;
    private Date createTime;
    private long editUid;
    private Date editTime;
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(long templateId) {
        this.templateId = templateId;
    }

    public String getEnRelationName() {
        return enRelationName;
    }

    public void setEnRelationName(String enRelationName) {
        this.enRelationName = enRelationName;
    }

    public String getCnRelationName() {
        return cnRelationName;
    }

    public void setCnRelationName(String cnRelationName) {
        this.cnRelationName = cnRelationName;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getsEntityId() {
        return sEntityId;
    }

    public void setsEntityId(String sEntityId) {
        this.sEntityId = sEntityId;
    }

    public String gettEntityId() {
        return tEntityId;
    }

    public void settEntityId(String tEntityId) {
        this.tEntityId = tEntityId;
    }

    public String getsEntityName() {
        return sEntityName;
    }

    public void setsEntityName(String sEntityName) {
        this.sEntityName = sEntityName;
    }

    public String gettEntityName() {
        return tEntityName;
    }

    public void settEntityName(String tEntityName) {
        this.tEntityName = tEntityName;
    }

    public long getCreateUid() {
        return createUid;
    }

    public void setCreateUid(long createUid) {
        this.createUid = createUid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public long getEditUid() {
        return editUid;
    }

    public void setEditUid(long editUid) {
        this.editUid = editUid;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
