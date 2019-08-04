package com.tupu.dao;

import com.tupu.domain.Entity;

import java.util.List;

/**
 * 实体操作
 */
public interface EntityDao {

    /**
     * 实体列表
     * @return list
     */
    List<Entity> getEntityList();

    /**
     * 根据id 获取实体
     * @return Entity
     */
    Entity getEntityById(Long id);

    /**
     * 增加实体
     * @return entity
     */
    Long saveEntity(Entity entity);

    /**
     * 删除实体
     */
    Long deleteEntity(Long id);

    /**
     * 实体编辑
     * @param entity
     */
    Long updateEntity(Entity entity);

    /**
     * 通过模版id获取实体列表
     * @param templateId
     * @return
     */
    List<Entity> getEntityByTemplateId(Long templateId);

    /**
     * 通过模版id，实体英文名称获取是否有值
     * @param entity
     * @return int
     */
    int checkEnEntityName(Entity entity);

}
