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

    /**
     * 获取配置文件列表
     * @return list
     */
    @Override
    public List<ConfTemplate> getConfTemplateList() {
        return confTemplateDao.getConfTemplateList();
    }

    /**
     * 根据id查询配置文件
     * @param id 配置文件id
     * @return object
     */
    @Override
    public ConfTemplate  findConfTemplateByid(long id) {
        return confTemplateDao.getById(id);
    }

    /**
     * 根据id删除配置文件
     * @param id 配置文件id
     * @return json
     */
    @Override
    public Long deleteConfTemplate(long id) {
        return confTemplateDao.deleteConfTemplate(id);
    }

    @Override
    public Long updateConfTemplate(ConfTemplate confTemplate) {
        confTemplate.setEditTime(new Date());
        return confTemplateDao.updateConfTemplate(confTemplate);
    }

    /**
     * 新增配置wenjian
     * @param confTemplate  配置文件模版信息
     * @return id templateName
     */
    @Override
    public ConfTemplate saveConfTemplate(ConfTemplate confTemplate) {
        confTemplate.setId(IdGen.getUniqueId());
        confTemplate.setCreateTime(new Date());

        confTemplateDao.saveConfTemplate(confTemplate);
//        confTemplate.getTemplateName();
//        confTemplate.getId();
        return confTemplate;
    }

}
