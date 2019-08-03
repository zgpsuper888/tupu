package com.tupu.controller;

import com.tupu.common.ErrorCodeEnum;
import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tupu.common.GlobalVariable;
import com.tupu.result.JsonResult;

/**
 * TODO
 *
 * @author Chunfu.Dong
 * @date 2019-08-03 18:05
 */
@RestController
@RequestMapping(value = "/file/")
public class FileController {
    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Resource
    private GlobalVariable globalVariable;

    @RequestMapping("upload")
    public JsonResult upload(@RequestParam MultipartFile file) {
        String uploadPath = globalVariable.getVariable("uploadPath");
        makeParent(uploadPath);

        try {
            File newFile = new File(uploadPath + file.getOriginalFilename());
            file.transferTo(newFile);
            return JsonResult.success(newFile.getAbsolutePath());
        } catch (IOException ex) {
            logger.error("upload file failed!", ex);
            return JsonResult.fail(ErrorCodeEnum.SYSTEM_ERROR);
        }
    }

    private void makeParent(String uploadPath) {
        File parentFile = new File(uploadPath);
        if (!parentFile.exists()) {
            // noinspection ResultOfMethodCallIgnored
            parentFile.mkdir();
        }
    }
}