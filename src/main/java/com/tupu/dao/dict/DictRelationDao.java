package com.tupu.dao.dict;


import com.tupu.domain.dict.DictRelation;

import java.util.List;

public interface DictRelationDao {

    /**
     * 关系类型字典保存
     * @param dictRelation
     */
    long saveDictRelation(DictRelation dictRelation);

    /**
     * 关系类型字典删除
     * @param id
     * @return
     */
    long deleteDictRelation(long id);

    /**
     * 关系字典修改
     * @param dictRelation
     * @return
     */
    long updateDictRelation(DictRelation dictRelation);

    /**
     * 关系列表
     * @return
     */
    List<DictRelation> getDictRelationList();

    /**
     * 通过ID查找关系类型信息
     * @param id
     * @return
     */
    DictRelation getDictRelationById(long id);

    int checkDictRelationName(String enRelationName,long id);


}
