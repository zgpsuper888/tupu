package com.tupu.dao;

import com.tupu.domain.ConfTemplate;

import java.util.List;

/**
 * 配置文件操作接口
 */
public interface ConfTemplateDao {
    /**
     * 配置文件接口
     *
     * @return
     */

    List<ConfTemplate> getConfTemplateList();

    ConfTemplate getById(long id);

    Long saveConfTemplate(ConfTemplate configTemplate);

    Long updateConfTemplate(ConfTemplate configTemplate);

    Long deleteConfTemplate(long id);

}
