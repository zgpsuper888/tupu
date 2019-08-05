package com.tupu.service.impl;

import com.tupu.common.GlobalVariable;
import com.tupu.common.IdGen;
import com.tupu.dao.dict.DictRelationDao;
import com.tupu.domain.dict.DictRelation;
import com.tupu.service.DictRelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class DictRelationServiceImpl implements DictRelationService {
    @Resource
    private DictRelationDao dictRelationDao;

    /**
     * 列表
     * @return
     */
    @Override
    public List<DictRelation> getDictRelationList() {
        return dictRelationDao.getDictRelationList();
    }

    /**
     * 新增字典关系
     * @param dictRelation
     * @return
     */
    @Override
    public Long saveDictRelation(DictRelation dictRelation) {
        dictRelation.setId(IdGen.getUniqueId());
        dictRelation.setCreateTime(GlobalVariable.nowDate());
        return dictRelationDao.saveDictRelation(dictRelation);
    }

    /**
     * 删除字典关系
     * @param id
     * @return
     */
    @Override
    public Long deleteDictRelation(long id) {
        return dictRelationDao.deleteDictRelation(id);
    }

    /**
     * 编辑字典关系
     * @param dictRelation
     * @return
     */
    @Override
    public Long editDictRelation(DictRelation dictRelation) {
        dictRelation.setEditTime(GlobalVariable.nowDate());
        return dictRelationDao.updateDictRelation(dictRelation);
    }

    /**
     * 通过id查询字典关系
     * @param id
     * @return
     */
    @Override
    public DictRelation getDictRelationById(long id) {
        return dictRelationDao.getDictRelationById(id);
    }


    /**
     * 检查是否重复
     * @param dictRelationName
     * @return true 不重复 false 重复
     */
    @Override
    public boolean checkDictRelation(String dictRelationName,long id) {
      int relationNameNum  = dictRelationDao.checkDictRelationName(dictRelationName,id);

      return relationNameNum == 0;

    }

}
