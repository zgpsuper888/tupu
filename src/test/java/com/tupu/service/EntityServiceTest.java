package com.tupu.service;

import com.tupu.domain.Entity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EntityServiceTest {
    @Resource
    private EntityService entityService;

    @Test
    public void saveEntity() {

        Entity entity = new Entity();
        entity.setTemplateId(156482);
        entity.setEnEntityName("ThreatActor");
        entity.setParentId(1);

        entityService.saveEntity(entity);
    }
}

