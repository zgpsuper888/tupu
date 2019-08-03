package com.tupu.common;

import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.tupu.dao.ConfigDao;

/**
 * 全局配置
 */
@Component
public class GlobalVariable {
    private static Map<String, String> variableMap;

    @Resource
    private ConfigDao configDao;

    public String getVariable(String configKey) {
        if (variableMap == null) {
            List<Map<String, String>> configMap = configDao.getGlobalConfig();
            variableMap = new HashMap<>();
            if (!CollectionUtils.isEmpty(configMap)) {
                configMap.forEach((a)->{
                    String config_key = a.get("config_key");
                    String config_value = a.get("config_value");
                    variableMap.put(config_key,config_value);
                });
            }
        }

        return variableMap.get(configKey);
    }
}