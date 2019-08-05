package com.tupu.service.impl;

import com.tupu.common.IdGen;
import com.tupu.dao.dict.DictAttributeDao;
import com.tupu.domain.dict.DictAttribute;
import com.tupu.service.DictAttributeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class DictAttributeServiceImpl implements DictAttributeService {
    @Resource
    private DictAttributeDao dictAttributeDao;

    /**
     * 列表
     * @return
     */
    @Override
    public List<DictAttribute> getDictAttributeList() {
        return dictAttributeDao.getDictAttributeList();
    }

    /**
     * 新增字典关系
     * @param dictAttribute
     * @return
     */
    @Override
    public Long saveDictAttribute(DictAttribute dictAttribute) {
        dictAttribute.setId(IdGen.getUniqueId());
        dictAttribute.setCreateTime(new Date());
        return dictAttributeDao.saveDictAttribute(dictAttribute);
    }

    /**
     * 删除字典关系
     * @param id
     * @return
     */
    @Override
    public Long deleteDictAttribute(long id) {
        return dictAttributeDao.deleteDictAttribute(id);
    }

    /**
     * 编辑字典关系
     * @param dictAttribute
     * @return
     */
    @Override
    public Long editDictAttribute(DictAttribute dictAttribute) {
        dictAttribute.setEditTime(new Date());
        return dictAttributeDao.updateDictAttribute(dictAttribute);
    }

    /**
     * 通过id查询字典关系
     * @param id
     * @return
     */
    @Override
    public DictAttribute getDictAttributeById(long id) {
        return dictAttributeDao.getDictAttributeById(id);
    }


    /**
     * 判断是否重复
     * @param dictAttributeName
     * @param id
     * @return true 不重复 false 重复
     */
    @Override
    public boolean checkDictAttribute(String dictAttributeName,long id) {
      int relationNameNum  = dictAttributeDao.checkDictAttributeName(dictAttributeName,id);

      return relationNameNum == 0;

    }

}
