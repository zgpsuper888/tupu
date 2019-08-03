package com.tupu.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            List<Map<String, String>> configMap = configDao.getConfig();
            variableMap = new HashMap<>(configMap.size(),1);
            if (!CollectionUtils.isEmpty(configMap)) {
                configMap.forEach((a) -> {
                    String key = a.get("config_key");
                    String value = a.get("config_value");
                    variableMap.put(key, value);
                });
            }
        }

        return variableMap.get(configKey);
    }
}