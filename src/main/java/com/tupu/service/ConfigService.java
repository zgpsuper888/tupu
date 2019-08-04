package com.tupu.service;

import com.tupu.domain.Config;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ConfigService {
    List<Config> getConfigList();

    Long updateConfig(Config config);
}
