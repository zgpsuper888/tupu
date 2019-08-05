package com.tupu.domain.dict;

import java.util.Date;

public class DictAttribute {

    private long id;
    private String enAttributeName;
    private String cnAttributeName;
    // 1 枚举类型 2 非枚举类型
    private long attributeType;
    private String enAttributeValue;
    private String cnAttributeValue;
    private String tags;
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

    public long getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(long attributeType) {
        this.attributeType = attributeType;
    }

    public String getEnAttributeValue() {
        return enAttributeValue;
    }

    public void setEnAttributeValue(String enAttributeValue) {
        this.enAttributeValue = enAttributeValue;
    }

    public String getCnAttributeValue() {
        return cnAttributeValue;
    }

    public void setCnAttributeValue(String cnAttributeValue) {
        this.cnAttributeValue = cnAttributeValue;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
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
