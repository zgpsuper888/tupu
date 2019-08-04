package com.tupu.controller;

import com.tupu.domain.Relation;
import com.tupu.result.JsonResult;
import com.tupu.service.RelationService;
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
public class RelationController {
    @Resource
    private RelationService relationService;

    /**
     * 根据模版id查询关系列表
     *
     * @param templateId 模版id
     * @return list
     */
    @RequestMapping(value = "/api/conf/relation/templateid/{templateId}", method = RequestMethod.GET)
    public JsonResult getRelationList(@PathVariable("templateId") long templateId) {
        List<Relation> entities = relationService.getRelationByTemplateId(templateId);
        return JsonResult.success(entities);
    }

    /**
     * 根据关系ID查询
     *
     * @param id
     * @return relation
     */
    @RequestMapping(value = "/api/conf/relation/{id}", method = RequestMethod.GET)
    public JsonResult getRelation(@PathVariable("id") long id) {
        Relation relation = relationService.getRelationById(id);
        return JsonResult.success(relation);
    }

    /**
     * 创建关系
     *
     * @param relation
     * @return
     */
    @RequestMapping(value = "/api/conf/relation", method = RequestMethod.POST)
    public JsonResult createRelation(@RequestBody Relation relation) {
        // 参数校验
        JsonResult validateResult = addValidate(relation);
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

    @RequestMapping(value = "/api/conf/relation/{id}", method = RequestMethod.DELETE)
    public JsonResult delRelation(@PathVariable("id") long id) {
        long deleteResult = relationService.deleteRelation(id);
        if (deleteResult > 0) {
            return JsonResult.success(null);
        } else {
            return JsonResult.fail(DELETE_FAIL);
        }
    }

    /**
     * 更新关系
     *
     * @param relation
     */
    @RequestMapping(value = "/api/conf/relation", method = RequestMethod.PUT)
    public JsonResult modifyRelation(@RequestBody Relation relation) {
        JsonResult validateResult = idValidate(relation);
        if (!validateResult.isSuccess()) {
            return validateResult;
        }
        relationService.editRelation(relation);
        return JsonResult.success(null);
    }

    private JsonResult idValidate(Relation relation) {
        Map<String, String> errorMap = new HashMap<>();
        long relationId = relation.getId();
        if (StringUtils.isEmpty(relationId)) {
            errorMap.put("relationId", "Id必填");
        }
        if (CollectionUtils.isEmpty(errorMap)) {
            return JsonResult.success(null);
        }
        return JsonResult.fail(errorMap);
    }
}
