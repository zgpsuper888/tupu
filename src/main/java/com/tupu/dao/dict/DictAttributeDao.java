package com.tupu.dao.dict;


import com.tupu.domain.dict.DictAttribute;

import java.util.List;

public interface DictAttributeDao {

    /**
     * 属性字典保存
     * @param dictAttribute
     */
    long saveDictAttribute(DictAttribute dictAttribute);

    /**
     * 属性字典删除
     * @param id
     * @return
     */
    long deleteDictAttribute(long id);

    /**
     * 关系字典修改
     * @param dictAttribute
     * @return
     */
    long updateDictAttribute(DictAttribute dictAttribute);

    /**
     * 关系列表
     * @return
     */
    List<DictAttribute> getDictAttributeList();

    /**
     * 通过ID查找属性信息
     * @param id
     * @return
     */
    DictAttribute getDictAttributeById(long id);

    /**
     * 检查属性名是否重复
     * @param enAttributeName
     * @param id
     * @return
     */
    int checkDictAttributeName(String enAttributeName,long id);


}
