package com.tupu.service;


import com.tupu.domain.dict.DictRelation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DictRelationService {
    /**
     * 获取所有关系字典列表
     * @return list
     */
    List<DictRelation> getDictRelationList();

    /**
     * 新增关系字典
     * @param relation
     * @return
     */
    Long saveDictRelation(DictRelation relation);

    /**
     * 删除关系字典
     * @param id
     * @return
     */
    Long deleteDictRelation(long id);

    /**
     * 编辑关系字典
     * @param relation
     * @return
     */
    Long editDictRelation(DictRelation relation);

    /**
     * 根据实体id获取实体
     * @param id
     * @return
     */
    DictRelation getDictRelationById(long id);


    /**
     * 检查关系字典是否重复
     * @param dictRelationName
     * @return boolean
     */
    boolean checkDictRelation(String dictRelationName ,long id);
}



