package com.tupu.common;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GlobalVariableTest {
    @Resource
    private GlobalVariable globalVariable;

    @Test
    public void getVariable() {
//        Map<String, String> variable = globalVariable.getVariable();
        System.out.println(globalVariable.getVariable("uploadPath"));
    }
}
