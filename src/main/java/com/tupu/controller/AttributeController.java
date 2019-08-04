package com.tupu.controller;


import com.tupu.domain.Attribute;
import com.tupu.result.JsonResult;
import com.tupu.service.AttributeService;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.tupu.common.ErrorCodeEnum.*;

@RestController
@ResponseBody
public class AttributeController {
    @Resource
    private AttributeService attributeService;

    /**
     * 根据模版id查询属性列表
     *
     * @param templateId 模版id
     * @return list
     */
    @RequestMapping(value = "/api/conf/attribute/templateid/{templateId}", method = RequestMethod.GET)
    public JsonResult getAttributeList(@PathVariable("templateId") long templateId) {
        List<Attribute> attributes = attributeService.getAttributeByTemplateId(templateId);
        return JsonResult.success(attributes);
    }

    /**
     * 根据属性ID查询
     * @param id 属性id
     * @return attribute
     */
    @RequestMapping(value = "/api/conf/attribute/{id}", method = RequestMethod.GET)
    public JsonResult getAttribute(@PathVariable("id") long id) {
        Attribute attribute = attributeService.getAttributeById(id);
        return JsonResult.success(attribute);
    }

    /**
     * 创建属性
     * @param attribute 属性信息
     * @return  boolean
     */
    @RequestMapping(value = "/api/conf/attribute", method = RequestMethod.POST)
    public JsonResult createAttribute(@RequestBody Attribute attribute) {
        // 参数校验
        JsonResult validateResult = addValidate(attribute);
        if (!validateResult.isSuccess()) {
            return validateResult;
        }

        /**
         * 验证是否有重名
         */
        if (attributeService.checkRepeatAttribute(attribute)) {
            return JsonResult.fail(DATA_ERROR);
        }

        long insertResult = attributeService.saveAttribute(attribute);
        if (insertResult == 1) {
            return JsonResult.success(null);
        } else {
            return JsonResult.success(INSERT_FAIL);
        }
    }

    private JsonResult addValidate(Attribute attribute) {
        Map<String, String> errorMap = new HashMap<>();

        long templateId = attribute.getTemplateId();
        if (StringUtils.isEmpty(templateId)) {
            errorMap.put("templateId", "模版id必填");
        }

        String enAttributeName = attribute.getEnAttributeName();
        if (StringUtils.isEmpty(enAttributeName)) {
            errorMap.put("enAttributeName", "属性英文名必填");
        }
        String cnAttributeName = attribute.getCnAttributeName();
        if (StringUtils.isEmpty(cnAttributeName)) {
            errorMap.put("cnAttributeName", "属性中文名必填");
        }
        if (CollectionUtils.isEmpty(errorMap)) {
            return JsonResult.success(null);
        }
        return JsonResult.fail(errorMap);
    }

    @RequestMapping(value = "/api/conf/attribute/{id}", method = RequestMethod.DELETE)
    public JsonResult delAttribute(@PathVariable("id") long id) {
        long deleteResult = attributeService.deleteAttributeById(id);
        if (deleteResult > 0) {
            return JsonResult.success(null);
        } else {
            return JsonResult.fail(DELETE_FAIL);
        }
    }

    /**
     * 更新属性
     *
     * @param attribute
     */
    @RequestMapping(value = "/api/conf/attribute", method = RequestMethod.PUT)
    public JsonResult modifyAttribute(@RequestBody Attribute attribute) {
        JsonResult validateResult = idValidate(attribute);
        if (!validateResult.isSuccess()) {
            return validateResult;
        }
        attributeService.updateAttribute(attribute);
        return JsonResult.success(null);
    }

    private JsonResult idValidate(Attribute attribute) {
        Map<String, String> errorMap = new HashMap<>();
        long attributeId = attribute.getId();
        if (StringUtils.isEmpty(attributeId)) {
            errorMap.put("attributeId", "Id必填");
        }
        if (CollectionUtils.isEmpty(errorMap)) {
            return JsonResult.success(null);
        }
        return JsonResult.fail(errorMap);
    }
}
