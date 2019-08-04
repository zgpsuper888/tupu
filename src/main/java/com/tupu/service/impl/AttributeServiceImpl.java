package com.tupu.service.impl;

import com.tupu.common.IdGen;
import com.tupu.dao.AttributeDao;
import com.tupu.domain.Attribute;
import com.tupu.service.AttributeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class AttributeServiceImpl implements AttributeService {

    @Resource
    private AttributeDao attributeDao;

    @Override
    public List<Attribute> getAttributeByTemplateId(long templateId) {
        return attributeDao.getAttributeByTemplateId(templateId);
    }

    @Override
    public Long saveAttribute(Attribute attribute) {
        attribute.setId(IdGen.getUniqueId());
        attribute.setCreateTime(new Date());
        return attributeDao.saveAttribute(attribute);
    }

    @Override
    public Long deleteAttributeById(long id) {
        return attributeDao.deleteAttributeById(id);
    }

    @Override
    public long deleteAttributeByTemplateId(long templateId) {
        return attributeDao.deleteAttributeByTemplateId(templateId);
    }

    @Override
    public Long updateAttribute(Attribute attribute) {
        attribute.setEditTime(new Date());
        return attributeDao.updateAttribute(attribute);
    }

    @Override
    public Attribute getAttributeById(long id) {
        return attributeDao.getAttributeById(id);
    }

    @Override
    public boolean checkRepeatAttribute(Attribute attribute) {
        int attributeNum = attributeDao.checkRepeatAttribute(attribute);
        if (attributeNum > 0) {
            return true;
        } else {
            return false;
        }
    }
}
