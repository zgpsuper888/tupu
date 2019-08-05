package com.tupu.service.impl;

import com.tupu.dao.JsonTemplateDao;
import com.tupu.domain.JsonTemplate;
import com.tupu.service.JsonTemplateService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

@Service
public class JsonTemplateServiceImpl implements JsonTemplateService {

    @Resource
    private JsonTemplateDao jsonTemplateDao;

    @Override
    public Long saveJsonTemplate(JsonTemplate jsonTemplate) {
        return  jsonTemplateDao.saveJsonTemplate(jsonTemplate);

    }

    @Override
    public Long deleteJsonTemplate(String ids) {
        return null;
    }

    @Override
    public Long updateJsonTemplate(JsonTemplate jsonTemplate) {
        return null;
    }

    @Override
    public Long getJsonTemplateById(long id) {
        return null;
    }
}
