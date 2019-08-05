package com.tupu.controller;

import com.tupu.domain.Config;
import com.tupu.result.JsonResult;
import com.tupu.service.ConfigService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@ResponseBody
public class ConfigController {


    @Resource
    private ConfigService configService;

    /**
     * 查询全局系统配置信息
     *
     * @return list
     */
    @RequestMapping(value = "/api/sys/config", method = RequestMethod.GET)
    public JsonResult getConfigs() {

        Map<String, String> configMap = new HashMap<>();

        List<Config> configs = configService.getConfigList();
        for (Config v : configs) {
//            System.out.println(v.getConfigKey());
            configMap.put(v.getConfigKey(),v.getConfigValue());
        }
        return JsonResult.success(configMap);
    }

    /**
     * 更新全局系统配置信息
     *
     * @param config
     */
    @RequestMapping(value = "/api/sys/config", method = RequestMethod.PUT)
    public JsonResult modifyConfig(@RequestBody Config config) {
//        System.out.println(config);
        configService.updateConfig(config);
        return JsonResult.success(null);
    }

}
