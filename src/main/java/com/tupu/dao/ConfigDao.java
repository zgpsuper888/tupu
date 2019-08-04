package com.tupu.dao;

import com.tupu.domain.Config;

import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author Chunfu.Dong
 * @date 2019-08-03 15:03
 */
public interface ConfigDao {
    List<Map<String,String>> getConfig();

    List<Config> getConfigList();

    Long updateConfig(Config config);
}