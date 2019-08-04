package com.tupu.service.impl;

import com.tupu.common.IdGen;
import com.tupu.dao.RelationDao;
import com.tupu.domain.Relation;
import com.tupu.service.RelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class RelationServiceImpl  implements RelationService {

    @Resource
    private RelationDao relationDao;


    @Override
    public List<Relation> getRelationList() {
        return relationDao.getRelationList();
    }

    /**
     * 新增实体关系
     * @param relation
     */
    @Override
    public Long saveRelation(Relation relation) {
        relation.setId(IdGen.getUniqueId());
        relation.setCreateTime(new Date());
        return relationDao.saveRelation(relation);
    }

    /**
     * 删除实体关系
     * @param id
     * @return long
     */
    @Override
    public Long deleteRelation(long id) {
        return relationDao.deleteRelation(id);
    }

    /**
     * 实体编辑
     *
     * @param relation
     * @return long
     */
    @Override
    public Long editRelation(Relation relation) {
        relation.setEditTime(new Date());
        return relationDao.updateRelation(relation);
    }

    @Override
    public Relation getRelationById(long id) {
        return relationDao.getRelationById(id);
    }


    @Override
    public List<Relation> getRelationByTemplateId(long templateId) {
        return relationDao.getRelationByTemplateId(templateId);
    }

    /**
     * 通过模版id 主体英文名检查是否重复
     *
     * @param relation
     * @return boolean
     */
    @Override
    public boolean checkRelation(Relation relation) {
        int relationNum = relationDao.checkRelationName(relation);
        if (relationNum > 0) {
            return true;
        } else {
            return false;
        }
    }

}
