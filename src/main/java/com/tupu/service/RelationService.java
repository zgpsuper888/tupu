package com.tupu.service;


import com.tupu.domain.Relation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RelationService {
    /**
     * 获取所有关系字典列表
     * @return list
     */
    List<Relation> getRelationList();

    /**
     * 新增关系字典
     * @param relation
     * @return
     */
    Long saveRelation(Relation relation);

    /**
     * 删除关系字典
     * @param id
     * @return
     */
    Long deleteRelation(long id);

    /**
     * 编辑关系字典
     * @param relation
     * @return
     */
    Long editRelation(Relation relation);

    /**
     * 根据实体id获取实体
     * @param id
     * @return
     */
    Relation getRelationById(long id);

    /**
     * 根据模版id查询关系字典列表
     * @param templateId
     * @return list
     */
    List<Relation> getRelationByTemplateId(long templateId);

    /**
     * 检查关系字典是否重复
     * @param relation
     * @return boolean
     */
    boolean checkRelation(Relation relation);
}



