package com.tupu.dao;

import com.tupu.domain.Attribute;

import java.util.List;

/**
 * 配置文件属性管理
 */
public interface AttributeDao {

    List<Attribute> getAttributeByTemplateId(long templateId);

    Long saveAttribute(Attribute attribute);

    Long deleteAttributeById(long id);

    long deleteAttributeByTemplateId(long templateId);

    Long updateAttribute(Attribute attribute);

    Attribute getAttributeById(long id);

    int checkRepeatAttribute(Attribute attribute);

}
