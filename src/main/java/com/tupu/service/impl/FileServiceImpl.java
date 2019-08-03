package com.tupu.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import java.util.Objects;
import org.springframework.stereotype.Service;

import com.tupu.result.FileResult;
import com.tupu.service.FileService;
import org.springframework.util.StringUtils;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public FileResult traverseDir(String filePath,String fileType) {
        if (hiddenFile(filePath)) {
            return null;
        }

        String fullDir = System.getProperty("user.home") + filePath;

        File targetFile = new File(fullDir);

        if (!targetFile.exists()) {
            return null;
        }

        return doTraverseDir(targetFile,fileType);
    }

    private boolean hiddenFile(String fileName) {
        return fileName.startsWith(".");
    }

    private FileResult doTraverseDir(File targetFile,String fileType) {
        FileResult fileResult = wrapFile(targetFile);

        File[] subFiles = targetFile.listFiles();
        if (subFiles == null || subFiles.length == 0) {
            return fileResult;
        }

        List<FileResult> subFileResults = new ArrayList<>(subFiles.length);
        for (File subFile : subFiles) {
            if (hiddenFile(subFile.getName())) {
                continue;
            }

            if (!StringUtils.isEmpty(fileType)) {
                if (subFile.isFile()) {
                    String[] names = subFile.getName().split("\\.");
                    if (!Objects.equals(fileType,names[1])) {
                        continue;
                    }
                }
            }

            FileResult subFileResult = doTraverseDir(subFile,fileType);
            subFileResults.add(subFileResult);
        }

        fileResult.setChildren(subFileResults);
        return fileResult;
    }

    private FileResult wrapFile(File file) {
        FileResult fileResult = new FileResult();
        String name = file.getName();
        boolean directory = file.isDirectory();
        fileResult.setFileName(name);
        fileResult.setDirectory(directory);
        if (!directory) {
            String[] names = name.split("\\.");
            fileResult.setFileName(names[0]);
            fileResult.setFileType(names[1]);
        }

        return fileResult;
    }
}