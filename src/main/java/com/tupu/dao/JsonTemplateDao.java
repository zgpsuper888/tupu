package com.tupu.dao;

import com.tupu.domain.JsonTemplate;

import java.util.List;

public interface JsonTemplateDao {

    /**
     * Json模版类型字典保存
     * @param jsonTemplate
     */
    long saveJsonTemplate(JsonTemplate jsonTemplate);

    /**
     * Json模版类型字典删除
     * @param id
     * @return
     */
    long deleteJsonTemplate(long id);

    /**
     * Json模版字典修改
     * @param jsonTemplate
     * @return
     */
    long updateJsonTemplate(JsonTemplate jsonTemplate);

    /**
     * Json模版列表
     * @return
     */
    List<JsonTemplateDao> getJsonTemplateList();

    /**
     * 通过ID查找Json模版类型信息
     * @param id
     * @return
     */
    JsonTemplate getJsonTemplateById(long id);

    int checkJsonTemplateName(String enRelationName,long id);
}
