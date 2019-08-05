package com.tupu.controller.dict;

import com.tupu.domain.dict.DictAttribute;
import com.tupu.result.JsonResult;
import com.tupu.service.DictAttributeService;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.tupu.common.ErrorCodeEnum.*;

@RestController
@ResponseBody
public class DictAttributeController {
    @Resource
    private DictAttributeService dictAttributeService;


    /**
     * 根据属性ID查询
     * @param id
     * @return attribute
     */
    @RequestMapping(value = "/api/dict/attribute/{id}", method = RequestMethod.GET)
    public JsonResult getDictAttribute(@PathVariable("id") long id) {
        DictAttribute attribute = dictAttributeService.getDictAttributeById(id);

        if (attribute==null) {
            return  JsonResult.success(null);
        }
        return JsonResult.success(attribute);
    }

    /**
     * 获取字典属性列表
     * @return
     */
    @RequestMapping(value = "/api/dict/attribute", method = RequestMethod.GET)
    public JsonResult getDictAttributeList() {
        List<DictAttribute> dictAttributes = dictAttributeService.getDictAttributeList();
        return JsonResult.success(dictAttributes);
    }

    /**
     * 创建属性
     * @param dictAttribute 属性信息
     * @return
     */
    @RequestMapping(value = "/api/dict/attribute", method = RequestMethod.POST)
    public JsonResult createDictDictAttribute(@RequestBody DictAttribute dictAttribute) {
        // 参数校验
        JsonResult validateResult = addValidate(dictAttribute);
        if (!validateResult.isSuccess()) {
            return validateResult;
        }

        String dictAttributeName = dictAttribute.getEnAttributeName();
        long attributeId = dictAttribute.getId();

        if (!dictAttributeService.checkDictAttribute(dictAttributeName,attributeId)) {
            return JsonResult.fail(DATA_ERROR);
        }

        long insertResult = dictAttributeService.saveDictAttribute(dictAttribute);
        if (insertResult == 1) {
            return JsonResult.success(null);
        } else {
            return JsonResult.success(INSERT_FAIL);
        }
    }

    private JsonResult addValidate(DictAttribute dictAttribute) {
        Map<String, String> errorMap = new HashMap<>();

        String enAttributeName = dictAttribute.getEnAttributeName();
        if (StringUtils.isEmpty(enAttributeName)) {
            errorMap.put("enAttributeName", "属性英文名必填");
        }
        String  enAttributeValue = dictAttribute.getEnAttributeValue();

        if (StringUtils.isEmpty(enAttributeValue)) {
            errorMap.put("enAttributeValue", "属性英文值必填");
        }

        if (CollectionUtils.isEmpty(errorMap)) {
            return JsonResult.success(null);
        }
        return JsonResult.fail(errorMap);
    }

    @RequestMapping(value = "/api/dict/attribute/{id}", method = RequestMethod.DELETE)
    public JsonResult delDictDictAttribute(@PathVariable("id") long id) {
        long deleteResult = dictAttributeService.deleteDictAttribute(id);
        if (deleteResult > 0) {
            return JsonResult.success(null);
        } else {
            return JsonResult.fail(DELETE_FAIL);
        }
    }

    /**
     * 更新属性
     * @param dictAttribute
     */
    @RequestMapping(value = "/api/dict/attribute", method = RequestMethod.PUT)
    public JsonResult modifyDictAttribute(@RequestBody DictAttribute dictAttribute) {
        JsonResult validateResult = idValidate(dictAttribute);
        if (!validateResult.isSuccess()) {
            return validateResult;
        }
        String  enAttributeName = dictAttribute.getEnAttributeName();
        long attributeId = dictAttribute.getId();
        boolean checkDictAttribute  = dictAttributeService.checkDictAttribute(enAttributeName,attributeId);
        if(!checkDictAttribute){
            return JsonResult.fail(DATA_ERROR);
        }
        dictAttributeService.editDictAttribute(dictAttribute);
        return JsonResult.success(null);
    }

    private JsonResult idValidate(DictAttribute dictAttribute) {
        Map<String, String> errorMap = new HashMap<>();

        long dictAttributeId = dictAttribute.getId();
//        System.out.println(dictAttributeId);
        if (dictAttributeId == 0) {
            errorMap.put("dictAttributeId", "Id必填");
        }
        if (CollectionUtils.isEmpty(errorMap)) {
            return JsonResult.success(null);
        }
        return JsonResult.fail(errorMap);
    }
}
