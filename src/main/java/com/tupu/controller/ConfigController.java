package com.tupu.controller;

import com.tupu.domain.Config;
import com.tupu.result.JsonResult;
import com.tupu.service.ConfigService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@ResponseBody
public class ConfigController {


    @Resource
    private ConfigService configService;

    /**
     * 查询全局系统配置信息
     * @return list
     */
    @RequestMapping(value = "/api/sys/config", method = RequestMethod.GET)
    public JsonResult findAllUser() {
        List<Config> configs = configService.getConfigList();
        return JsonResult.success(configs);
    }

    /**
     * 更新全局系统配置信息
     * @param config
     */
    @RequestMapping(value = "/api/sys/config", method = RequestMethod.PUT)
    public JsonResult modifyUser(@RequestBody Config config) {
//        System.out.println(config);
        configService.updateConfig(config);
        return JsonResult.success(null);
    }

}
