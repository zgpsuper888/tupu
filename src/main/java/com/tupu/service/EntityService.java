package com.tupu.service;

import com.tupu.domain.Entity;

import java.util.List;

public interface EntityService {
    /**
     * 获取所有实体信息
     * @return list
     */
    List<Entity> getEntityList();

    /**
     * 新增实体服务
     * @param entity
     * @return
     */
    Long saveEntity(Entity entity);

    /**
     * 删除实体
     * @param id
     * @return
     */
    Long deleteEntity(long id);

    /**
     * 编辑实体
     * @param entity
     * @return
     */
    Long updateEntity(Entity entity);

    /**
     * 根据实体id获取实体
     * @param id
     * @return
     */
    Entity getEntityById(long id);

    /**
     * 根据模版id查询实体信息
     * @param templateId
     * @return list
     */
    List<Entity> getEntityByTemplateId(long templateId);

    boolean checkEntity(Entity entity);

}
