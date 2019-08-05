package com.tupu.controller.dict;

import com.tupu.domain.dict.DictRelation;
import com.tupu.result.JsonResult;
import com.tupu.service.DictRelationService;
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
public class DictRelationController {
    @Resource
    private DictRelationService dictRelationService;


    /**
     * 根据关系ID查询
     * @param id
     * @return relation
     */
    @RequestMapping(value = "/api/dict/relation/{id}", method = RequestMethod.GET)
    public JsonResult getDictRelation(@PathVariable("id") long id) {
        System.out.println(new Date());
        DictRelation relation = dictRelationService.getDictRelationById(id);
        if (relation==null) {
            return  JsonResult.success(null);
        }
        return JsonResult.success(relation);
    }

    /**
     * 获取字典关系列表
     * @return
     */
    @RequestMapping(value = "/api/dict/relation", method = RequestMethod.GET)
    public JsonResult getDictRelationList() {
        System.out.println(new Date());
        List<DictRelation> dictRelations = dictRelationService.getDictRelationList();
        return JsonResult.success(dictRelations);
    }

    /**
     * 创建关系
     * @param dictRelation 关系信息
     * @return
     */
    @RequestMapping(value = "/api/dict/relation", method = RequestMethod.POST)
    public JsonResult createDictDictRelation(@RequestBody DictRelation dictRelation) {
        // 参数校验
        JsonResult validateResult = addValidate(dictRelation);
        if (!validateResult.isSuccess()) {
            return validateResult;
        }

        String dictRelationName = dictRelation.getEnRelationName();
        long relationId = dictRelation.getId();

        if (!dictRelationService.checkDictRelation(dictRelationName,relationId)) {
            return JsonResult.fail(DATA_ERROR);
        }

        long insertResult = dictRelationService.saveDictRelation(dictRelation);
        if (insertResult == 1) {
            return JsonResult.success(null);
        } else {
            return JsonResult.success(INSERT_FAIL);
        }
    }

    private JsonResult addValidate(DictRelation dictRelation) {
        Map<String, String> errorMap = new HashMap<>();

        String enRelationName = dictRelation.getEnRelationName();
        if (StringUtils.isEmpty(enRelationName)) {
            errorMap.put("enRelationName", "关系英文名必填");
        }
        if (CollectionUtils.isEmpty(errorMap)) {
            return JsonResult.success(null);
        }
        return JsonResult.fail(errorMap);
    }

    @RequestMapping(value = "/api/dict/relation/{id}", method = RequestMethod.DELETE)
    public JsonResult delDictDictRelation(@PathVariable("id") long id) {
        long deleteResult = dictRelationService.deleteDictRelation(id);
        if (deleteResult > 0) {
            return JsonResult.success(null);
        } else {
            return JsonResult.fail(DELETE_FAIL);
        }
    }

    /**
     * 更新关系
     * @param dictRelation
     */
    @RequestMapping(value = "/api/dict/relation", method = RequestMethod.PUT)
    public JsonResult modifyDictRelation(@RequestBody DictRelation dictRelation) {
        JsonResult validateResult = idValidate(dictRelation);
        if (!validateResult.isSuccess()) {
            return validateResult;
        }
        String  enRelationName = dictRelation.getEnRelationName();
        long relationId = dictRelation.getId();
        boolean checkDictRelation  = dictRelationService.checkDictRelation(enRelationName,relationId);
        if(!checkDictRelation){
            return JsonResult.fail(DATA_ERROR);
        }
        dictRelationService.editDictRelation(dictRelation);
        return JsonResult.success(null);
    }

    private JsonResult idValidate(DictRelation dictRelation) {
        Map<String, String> errorMap = new HashMap<>();

        long dictRelationId = dictRelation.getId();
//        System.out.println(dictRelationId);
        if (dictRelationId == 0) {
            errorMap.put("dictRelationId", "Id必填");
        }
        if (CollectionUtils.isEmpty(errorMap)) {
            return JsonResult.success(null);
        }
        return JsonResult.fail(errorMap);
    }
}
