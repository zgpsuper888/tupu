package com.tupu.domain;

import java.util.Date;

/**
 * 配置文件实体属性
 */
public class Attribute {
    private long id;
    private long templateId;
    private long entityId;
    private String entityName;
    private String enAttributeName;
    private String cnAttributeName;
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

    public long getEntityId() {
        return entityId;
    }

    public void setEntityId(long entityId) {
        this.entityId = entityId;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEnAttributeName() {
        return enAttributeName;
    }

    public void setEnAttributeName(String enAttributeName) {
        this.enAttributeName = enAttributeName;
    }

    public String getCnAttributeName() {
        return cnAttributeName;
    }

    public void setCnAttributeName(String cnAttributeName) {
        this.cnAttributeName = cnAttributeName;
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
