package com.tupu.service;

import com.tupu.domain.ConfTemplate;
import com.tupu.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * conf template interface
 */

@Service
public interface ConfTemplateService {

    /**
     * 获取配置模版列表
     *
     * @return List
     */
    List<ConfTemplate> getConfTemplateList();

    /**
     * 根据模版ID,查询模版信息
     *
     * @param id
     * @return
     */
    ConfTemplate findConfTemplateByid(long id);

    /**
     * 新增模版
     *
     * @param confTemplate
     * @return
     */
    ConfTemplate saveConfTemplate(ConfTemplate confTemplate);

    /**
     * 更新模版
     *
     * @param confTemplate
     * @return
     */
    Long updateConfTemplate(ConfTemplate confTemplate);

    /**
     * 根据模版 ID,删除模版
     *
     * @param id
     * @return
     */
    Long deleteConfTemplate(long id);
}
