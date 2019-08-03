package com.tupu.domain;


import java.util.Date;

/**
 * 配置文件实体类
 */
public class ConfTemplate {
    //配置文件id
    private long id;
    //配置文件名称
    private String templateName;
    //配置文件名称
    private String templateVersion;
    //配置文件部署路径
    private String deployPath;
    // config template status
    private long confStatus;
    //
    private Date createTime;
    private String description;
    private String createUid;
    private Date editTime;

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

    public String getTemplateVersion() {
        return templateVersion;
    }

    public void setTemplateVersion(String templateVersion) {
        this.templateVersion = templateVersion;
    }

    public String getDeployPath() {
        return deployPath;
    }

    public void setDeployPath(String deployPath) {
        this.deployPath = deployPath;
    }

    public long getConfStatus() {
        return confStatus;
    }

    public void setConfStatus(long confStatus) {
        this.confStatus = confStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateUid() {
        return createUid;
    }

    public void setCreateUid(String createUid) {
        this.createUid = createUid;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }
}
