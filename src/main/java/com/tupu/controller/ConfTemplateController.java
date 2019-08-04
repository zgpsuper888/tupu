package com.tupu.controller;

import com.tupu.domain.ConfTemplate;
import com.tupu.result.JsonResult;
import com.tupu.service.ConfTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */

@RestController
@ResponseBody
public class ConfTemplateController {
    final static Logger log= LoggerFactory.getLogger(UserController.class);
    @Resource
    private ConfTemplateService confTemplateService;

    /**
     * 配置文件列表
     * @return list
     */
    @RequestMapping(value = "/api/conf", method = RequestMethod.GET)
    public JsonResult getConfTemplateList() {
        List<ConfTemplate> confTemplates = confTemplateService.getConfTemplateList();

        return JsonResult.success(confTemplates);
    }
    /**
     * 根据ID获取配置文件模版信息
     * @param  id  配置文件ID
     * @return object
     */
    @RequestMapping(value = "/api/conf/{id}", method = RequestMethod.GET)
    public JsonResult getOneConfTemplate(@PathVariable("id") long id) {
        ConfTemplate confTemplate = confTemplateService.findConfTemplateByid(id);
        return JsonResult.success(confTemplate);
    }

    /**
     *  新增模版
     * @param confTemplate
     * @return
     */
    @RequestMapping(value = "/api/conf", method = RequestMethod.POST)
    public JsonResult createConfTemplate(@RequestBody ConfTemplate confTemplate) {
        // 参数校验
        JsonResult validateResult = addValidate(confTemplate);
        if (!validateResult.isSuccess()) {
            return validateResult;
        }
        ConfTemplate confInfo=confTemplateService.saveConfTemplate(confTemplate);

        return JsonResult.success(confInfo);
    }

    private JsonResult addValidate(ConfTemplate confTemplate) {
        Map<String, String> errorMap = new HashMap<>();

        String templateName = confTemplate.getTemplateName();
        if (StringUtils.isEmpty(templateName)) {
            errorMap.put("templateName", "模版名必填");
        }

        String templateVersion = confTemplate.getTemplateVersion();
        if (StringUtils.isEmpty(templateVersion)) {
            errorMap.put("templateVersion", "版本必填");
        }
        if (CollectionUtils.isEmpty(errorMap)) {
            return JsonResult.success(null);
        }
        return JsonResult.fail(errorMap);
    }

    /**
     * 通过模版id 删除模版
     * @param id
     */
    @RequestMapping(value = "/api/conf/{id}", method = RequestMethod.DELETE)
    public JsonResult delConfTemplate(@PathVariable("id") long id) {
        confTemplateService.deleteConfTemplate(id);
        return JsonResult.success(null);
    }

    /**
     *
     * @param confTemplate
     * @return
     */
    @RequestMapping(value = "/api/conf", method = RequestMethod.PUT)
    public JsonResult modifyConfTemplate(@RequestBody ConfTemplate confTemplate) {
        JsonResult validateResult = idValidate(confTemplate);
        if (!validateResult.isSuccess()) {
            return validateResult;
        }
        confTemplateService.updateConfTemplate(confTemplate);
        return JsonResult.success(null);
    }

    private JsonResult idValidate(ConfTemplate confTemplate) {
        Map<String, String> errorMap = new HashMap<>();

        long templateId = confTemplate.getId();
        if (StringUtils.isEmpty(templateId)) {
            errorMap.put("templateId", "模版Id必填");
        }
        if (CollectionUtils.isEmpty(errorMap)) {
            return JsonResult.success(null);
        }
        return JsonResult.fail(errorMap);
    }



}
