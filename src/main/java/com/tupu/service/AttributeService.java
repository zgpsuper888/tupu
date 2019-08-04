package com.tupu.service;

import com.tupu.domain.Attribute;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AttributeService {
    List<Attribute> getAttributeByTemplateId(long templateId);

    /**
     * 新增实体属性
     * @param attribute
     */
    Long saveAttribute(Attribute attribute);

    /**
     * 通过属性id删除
     * @param id
     */
    Long deleteAttributeById(long id);

    /**
     * 通过模版id删除
     * @param templateId  模版id
     */
    long deleteAttributeByTemplateId(long templateId);

    /**
     * 属性更新
     * @param id
     */
    Long updateAttribute(Attribute attribute);

    /**
     * 通过属性id查找属性
     * @param id 属性id
     */
    Attribute getAttributeById(long id);


    boolean checkRepeatAttribute(Attribute attribute);
}
