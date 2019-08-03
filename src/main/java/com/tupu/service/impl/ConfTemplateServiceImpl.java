package com.tupu.service.impl;

import com.tupu.common.IdGen;
import com.tupu.dao.ConfTemplateDao;
import com.tupu.domain.ConfTemplate;
import com.tupu.service.ConfTemplateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
 *
 */
@Service
public class ConfTemplateServiceImpl implements ConfTemplateService {

    @Resource
    private ConfTemplateDao confTemplateDao;

    @Override
    public List<ConfTemplate> getConfTemplateList() {
        return confTemplateDao.getConfTemplateList();
    }
    @Override
    public ConfTemplate  findConfTemplateByid(long id) {
        return confTemplateDao.getById(id);
    }

    @Override
    public Long deleteConfTemplate(long id) {
        return confTemplateDao.deleteConfTemplate(id);
    }

    @Override
    public Long updateConfTemplate(ConfTemplate confTemplate) {
        confTemplate.setEditTime(new Date());
        return confTemplateDao.updateConfTemplate(confTemplate);
    }

    @Override
    public Long saveConfTemplate(ConfTemplate confTemplate) {
        confTemplate.setId(IdGen.getUniqueId());
        confTemplate.setCreateTime(new Date());
        return confTemplateDao.saveConfTemplate(confTemplate);
    }

}
