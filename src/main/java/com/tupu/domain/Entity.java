package com.tupu.domain;

import java.util.Date;

/**
 * entiy 操作
 */
public class Entity {
    // 实体id
    private long id;
    //模版ID
    private long templateId;
    //实体英文名
    private String enEntityName;
    //实体中文名
    private String cnEntityName;
    //实体标签
    private String tags;
    //实体父ID
    private long parentId;
    // 实体级别 1 2 3 级别
    private long level;
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

    public String getEnEntityName() {
        return enEntityName;
    }

    public void setEnEntityName(String enEntityName) {
        this.enEntityName = enEntityName;
    }

    public String getCnEntityName() {
        return cnEntityName;
    }

    public void setCnEntityName(String cnEntityName) {
        this.cnEntityName = cnEntityName;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public long getLevel() {
        return level;
    }

    public void setLevel(long level) {
        this.level = level;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public long getCreateUid() {
        return createUid;
    }

    public void setCreateUid(long createUid) {
        this.createUid = createUid;
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
