package com.tupu.controller;


import com.tupu.domain.Relation;
import com.tupu.result.JsonResult;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.Map;

import static com.tupu.common.ErrorCodeEnum.DATA_ERROR;
import static com.tupu.common.ErrorCodeEnum.INSERT_FAIL;

@RestController
@ResponseBody
public class JsonTemplate {

   /**

    @RequestMapping(value = "/api/template/json", method = RequestMethod.POST)

    public JsonResult createJsonTemplate(@RequestBody JsonTemplate jsonTemplate) {
        // 参数校验
        JsonResult validateResult = addValidate(jsonTemplate);
        if (!validateResult.isSuccess()) {
            return validateResult;
        }

        if (relationService.checkRelation(relation)) {
            return JsonResult.fail(DATA_ERROR);
        }

        long insertResult = relationService.saveRelation(relation);
        if (insertResult == 1) {
            return JsonResult.success(null);
        } else {
            return JsonResult.success(INSERT_FAIL);
        }
    }

    private JsonResult addValidate(Relation relation) {
        Map<String, String> errorMap = new HashMap<>();

        long templateId = relation.getTemplateId();
        if (StringUtils.isEmpty(templateId)) {
            errorMap.put("templateId", "模版id必填");
        }

        String enRelationName = relation.getEnRelationName();
        if (StringUtils.isEmpty(enRelationName)) {
            errorMap.put("enRelationName", "关系英文名必填");
        }
        String cnRelationName = relation.getCnRelationName();
        if (StringUtils.isEmpty(cnRelationName)) {
            errorMap.put("enRelationName", "关系中文名必填");
        }
        if (CollectionUtils.isEmpty(errorMap)) {
            return JsonResult.success(null);
        }
        return JsonResult.fail(errorMap);
    }
    */
}
