package com.tupu.service;

import com.tupu.result.FileResult;
import com.tupu.utils.JsonUtils;
import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FileServiceTest {

    @Resource
    private FileService fileService;

    @Test
    public void traverseDir() {
        FileResult fileResult = fileService.traverseDir("/temp/","java");

        System.out.println(JsonUtils.object2Json(fileResult));
    }
}
