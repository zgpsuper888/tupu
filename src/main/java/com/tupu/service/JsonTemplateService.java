package com.tupu.service;

import com.tupu.domain.JsonTemplate;
import org.springframework.stereotype.Service;

@Service
public interface JsonTemplateService {

    /**
     * 新增json模版
     * @param jsonTemplate
     * @return
     */
    Long saveJsonTemplate(JsonTemplate jsonTemplate);

    Long deleteJsonTemplate(String ids);

    Long updateJsonTemplate(JsonTemplate jsonTemplate);

    Long getJsonTemplateById(long id);

}
