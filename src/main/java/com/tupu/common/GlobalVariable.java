package com.tupu.common;

import java.util.Collections;
import java.util.HashMap;
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

    public Map<String, String> getVariable() {
        if (variableMap == null) {
            Map<String, String> configMap = configDao.getConfig();

            variableMap = CollectionUtils.isEmpty(configMap) ? new HashMap<String, String>(1, 1) : configMap;
        }

        return Collections.unmodifiableMap(variableMap);
    }
}