package com.tupu.domain;

import java.util.Date;

public class JsonTemplate {

    private long id;
    private String templateName;
    private long confTemplateId;
    private long entitieId;
    private String templateVersion;
    private String  templateContent;
    private long createUid;
    private String createTime;
    private long editUid;
    private String editTime;
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public long getConfTemplateId() {
        return confTemplateId;
    }

    public void setConfTemplateId(long confTemplateId) {
        this.confTemplateId = confTemplateId;
    }

    public long getEntitieId() {
        return entitieId;
    }

    public void setEntitieId(long entitieId) {
        this.entitieId = entitieId;
    }

    public String getTemplateVersion() {
        return templateVersion;
    }

    public void setTemplateVersion(String templateVersion) {
        this.templateVersion = templateVersion;
    }

    public String getTemplateContent() {
        return templateContent;
    }

    public void setTemplateContent(String templateContent) {
        this.templateContent = templateContent;
    }

    public long getCreateUid() {
        return createUid;
    }

    public void setCreateUid(long createUid) {
        this.createUid = createUid;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public long getEditUid() {
        return editUid;
    }

    public void setEditUid(long editUid) {
        this.editUid = editUid;
    }

    public String getEditTime() {
        return editTime;
    }

    public void setEditTime(String editTime) {
        this.editTime = editTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
