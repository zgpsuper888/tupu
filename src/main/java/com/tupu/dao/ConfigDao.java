package com.tupu.dao;

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
}