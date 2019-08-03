package com.tupu.service;

import com.tupu.result.FileResult;

/**
 * 文件服务
 */
public interface FileService {

    /**
     * 变量文件夹下所有指定类型文件
     * 
     * @param filePath 文件路径
     * @param fileType 文件类型
     * @return 文件信息
     */
    FileResult traverseDir(String filePath, String fileType);
}
