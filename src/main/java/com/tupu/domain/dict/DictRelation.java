package com.tupu.domain.dict;

import java.util.Date;

public class DictRelation {
    private long id;
    private String enRelationName;
    private String cnRelationName;
    private long parentId;
    private String tags;
    private int level;
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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
