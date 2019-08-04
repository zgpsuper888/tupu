package com.tupu.service.impl;

import com.tupu.dao.ConfigDao;
import com.tupu.domain.Config;
import com.tupu.service.ConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ConfigServiceImpl implements ConfigService {
    @Resource
    private ConfigDao configDao;

    @Override
    public List<Config> getConfigList(){
        return configDao.getConfigList();
    }

    @Override
    public Long updateConfig(Config config){
        config.setEditTime(new Date());
        return configDao.updateConfig(config);
    }

}
