package com.tupu.dao;

import com.tupu.domain.Relation;

import java.util.List;

public interface RelationDao {

    /**
     * 获取关系列表
     *
     * @return
     */
    List<Relation> getRelationList();

    /**
     * 根据关系id获取关系
     *
     * @param id
     * @return relation
     */
    Relation getRelationById(long id);

    /**
     * 根据模版id获取关系列表
     *
     * @param templateId 模版ID
     * @return list
     */
    List<Relation> getRelationByTemplateId(long templateId);

    /**
     * 删除关系
     *
     * @param id
     */
    Long deleteRelation(long id);

    /**
     * 关系编辑
     *
     * @param relation
     */
    Long updateRelation(Relation relation);

    /**
     * 关系新增
     *
     * @param relation
     */
    Long saveRelation(Relation relation);

    int checkRelationName(Relation relation);

}
