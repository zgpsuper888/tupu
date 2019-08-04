package com.tupu.controller;


import com.tupu.domain.Entity;
import com.tupu.result.JsonResult;
import com.tupu.service.EntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class EntityController {
    final static Logger log = LoggerFactory.getLogger(UserController.class);
    @Resource
    private EntityService entityService;

    /**
     * 根据模版id查询实体列表
     *
     * @param templateId 模版id
     * @return list
     */
    @RequestMapping(value = "/api/conf/entity/templateid/{templateId}", method = RequestMethod.GET)
    public JsonResult getEntityList(@PathVariable("templateId") long templateId) {
        List<Entity> entities = entityService.getEntityByTemplateId(templateId);
        return JsonResult.success(entities);
    }

    /**
     * 根据实体ID查询
     *
     * @param id
     * @return entity
     */
    @RequestMapping(value = "/api/conf/entity/{id}", method = RequestMethod.GET)
    public JsonResult getEntity(@PathVariable("id") long id) {
        Entity entity = entityService.getEntityById(id);
        return JsonResult.success(entity);
    }

    /**
     * 创建实体
     *
     * @param entity
     * @return
     */
    @RequestMapping(value = "/api/conf/entity", method = RequestMethod.POST)
    public JsonResult createEntity(@RequestBody Entity entity) {
        // 参数校验
        JsonResult validateResult = addValidate(entity);
        if (!validateResult.isSuccess()) {
            return validateResult;
        }

        if (entityService.checkEntity(entity)) {
            return JsonResult.fail(DATA_ERROR);
        }

        long insertResult=entityService.saveEntity(entity);
        if (insertResult == 1) {
            return JsonResult.success(null);
        }else{
            return JsonResult.success(INSERT_FAIL);
        }


    }

    private JsonResult addValidate(Entity entity) {
        Map<String, String> errorMap = new HashMap<>();

        long tempalteId = entity.getTemplateId();
        if (StringUtils.isEmpty(tempalteId)) {
            errorMap.put("tempalteId", "模版id必填");
        }

        String enEntityName = entity.getEnEntityName();
        if (StringUtils.isEmpty(enEntityName)) {
            errorMap.put("enEntityName", "实体英文名必填");
        }
        String cnEntityName = entity.getCnEntityName();
        if (StringUtils.isEmpty(cnEntityName)) {
            errorMap.put("enEntityName", "实体中文名必填");
        }
        if (CollectionUtils.isEmpty(errorMap)) {
            return JsonResult.success(null);
        }
        return JsonResult.fail(errorMap);
    }

    @RequestMapping(value = "/api/conf/entity/{id}", method = RequestMethod.DELETE)
    public JsonResult delEntity(@PathVariable("id") long id) {
        entityService.deleteEntity(id);
        return JsonResult.success(null);
    }

    /**
     * 更新实体
     *
     * @param entity
     */
    @RequestMapping(value = "/api/conf/entity", method = RequestMethod.PUT)
    public JsonResult modifyEntity(@RequestBody Entity entity) {
        JsonResult validateResult = idValidate(entity);
        if (!validateResult.isSuccess()) {
            return validateResult;
        }
        long reslut = entityService.editEntity(entity);
        if (reslut == 1) {
            return JsonResult.success(null);
        } else {
            return JsonResult.fail(UPDATA_FAIL);
        }

    }

    private JsonResult idValidate(Entity entity) {
        Map<String, String> errorMap = new HashMap<>();

        long templateId = entity.getTemplateId();
        if (StringUtils.isEmpty(templateId)) {
            errorMap.put("templateId", "模版Id必填");
        }
        if (CollectionUtils.isEmpty(errorMap)) {
            return JsonResult.success(null);
        }
        return JsonResult.fail(errorMap);
    }
}
