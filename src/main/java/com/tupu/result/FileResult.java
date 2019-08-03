package com.tupu.result;

import java.util.List;

/**
 * 文件结果
 */
public class FileResult {
    /** 文件名称 */
    private String fileName;
    /** 目录,true 目录;false 文件 */
    private boolean directory;
    /** 文件类型 */
    private String fileType;

    private List<FileResult> children;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isDirectory() {
        return directory;
    }

    public void setDirectory(boolean directory) {
        this.directory = directory;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public List<FileResult> getChildren() {
        return children;
    }

    public void setChildren(List<FileResult> children) {
        this.children = children;
    }
}