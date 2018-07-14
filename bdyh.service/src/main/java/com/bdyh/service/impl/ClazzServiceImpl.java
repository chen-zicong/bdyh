package com.bdyh.service.impl;

import java.util.List;

import com.bdyh.common.APIResponse;
import com.bdyh.dao.ClazzDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdyh.dao.ClazzMapper;
import com.bdyh.entity.Clazz;
import com.bdyh.entity.ClazzExample;
import com.bdyh.service.ClazzService;


@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private ClazzDao clazzDao;

    @Override
    public List<Clazz> findAllClazz() {
        ClazzExample clazzExample = new ClazzExample();
        ClazzExample.Criteria criteria = clazzExample.createCriteria();
        criteria.andClazzIdIsNotNull();
        return clazzMapper.selectByExample(clazzExample);
    }

    @Override
    public Clazz findClazzById(Integer id) {
        ClazzExample clazzExample = new ClazzExample();
        ClazzExample.Criteria criteria = clazzExample.createCriteria();
        criteria.andClazzIdEqualTo(id);

        return clazzMapper.selectByExample(clazzExample).get(0);
    }

    public int updateClazz(Clazz clazz) {
        ClazzExample clazzExample = new ClazzExample();
        ClazzExample.Criteria criteria = clazzExample.createCriteria();
        criteria.andClazzIdEqualTo(clazz.getClazzId());
        return clazzMapper.updateByExampleSelective(clazz, clazzExample);
    }

    @Override
    public int insertClazz(Clazz clazz) {
        int insert ;
        Clazz result = clazzDao.selectByClazzName(clazz.getClazz());
        if(result==null){
        insert = clazzMapper.insert(clazz);
        }
        else {
            insert = 0;
        }
        return insert;
    }

}
