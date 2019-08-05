package com.tupu.service;


import com.tupu.domain.dict.DictAttribute;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DictAttributeService {
    /**
     * 获取所有属性字典列表
     * @return list
     */
    List<DictAttribute> getDictAttributeList();

    /**
     * 新增属性字典
     * @param relation
     * @return
     */
    Long saveDictAttribute(DictAttribute relation);

    /**
     * 删除属性字典
     * @param id
     * @return
     */
    Long deleteDictAttribute(long id);

    /**
     * 编辑属性字典
     * @param relation
     * @return
     */
    Long editDictAttribute(DictAttribute relation);

    /**
     * 根据实体id获取实体
     * @param id
     * @return
     */
    DictAttribute getDictAttributeById(long id);


    /**
     * 检查属性字典是否重复
     * @param dictAttributeName
     * @return boolean
     */
    boolean checkDictAttribute(String dictAttributeName, long id);
}



