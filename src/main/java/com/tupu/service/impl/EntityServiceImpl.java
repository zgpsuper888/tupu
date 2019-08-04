package com.tupu.service.impl;

import com.tupu.common.IdGen;
import com.tupu.dao.EntityDao;
import com.tupu.domain.Entity;
import com.tupu.service.EntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class EntityServiceImpl implements EntityService {

    private final Logger log = LoggerFactory.getLogger(EntityServiceImpl.class);

    @Resource
    private EntityDao entityDao;

    // 列表
    @Override
    public List<Entity> getEntityList() {
        return entityDao.getEntityList();
    }

    //新增
    @Override
    public Long saveEntity(Entity entity) {
        entity.setId(IdGen.getUniqueId());
        entity.setCreateTime(new Date());
        return entityDao.saveEntity(entity);
    }

    @Override
    public Long deleteEntity(long id) {
        return entityDao.deleteEntity(id);
    }

    /**
     * 实体编辑
     *
     * @param entity
     * @return long
     */
    @Override
    public Long editEntity(Entity entity) {
        entity.setEditTime(new Date());
        return entityDao.updateEntity(entity);
    }

    @Override
    public Entity getEntityById(long id) {
        return entityDao.getEntityById(id);
    }


    @Override
    public List<Entity> getEntityByTemplateId(long templateId) {
        return entityDao.getEntityByTemplateId(templateId);
    }

    /**
     * 通过模版id 主体英文名检查是否重复
     *
     * @param entity
     * @return boolean
     */
    @Override
    public boolean checkEntity(Entity entity) {
        int entityNum = entityDao.checkEnEntityName(entity);
        if (entityNum > 0) {
            return true;
        } else {
            return false;
        }
    }

}
