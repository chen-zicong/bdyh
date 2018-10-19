package com.bdyh.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bdyh.common.APIResponse;
import com.bdyh.dao.ClazzDao;
import com.bdyh.dao.SubjectMapper;
import com.bdyh.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdyh.dao.ClazzMapper;
import com.bdyh.service.ClazzService;


@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private ClazzDao clazzDao;
    @Autowired
    private SubjectMapper subjectMapper;

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
        int insert;
        Clazz result = clazzDao.selectByClazzName(clazz.getClazz());
        if (result == null) {
            insert = clazzMapper.insert(clazz);
        } else {
            insert = 0;
        }
        return insert;
    }

    public List<Clazz> findClazzByStatus() {
        ClazzExample clazzExample = new ClazzExample();
        ClazzExample.Criteria criteria = clazzExample.createCriteria();
        criteria.andStatusEqualTo(1);
        return clazzMapper.selectByExample(clazzExample);
    }

    public List<ClazzVo> findOpenClazzAndSubject() {
        List<ClazzVo> clazzVos = new ArrayList<>();
        List<SubjectVo> subjectVos;
        List<Clazz> openClazz = clazzMapper.findOpenClazz();

        for (Clazz clazz : openClazz) {
            subjectVos = new ArrayList<>();
            List<Subject> subjects = subjectMapper.findOpenSubejct(clazz.getClazzId());
            for (int i = 0; i < subjects.size(); i++) {
                SubjectVo subjectVo = new SubjectVo();
                subjectVo.setId(subjects.get(i).getSubjectId());
                subjectVo.setName(subjects.get(i).getSubject());
                subjectVos.add(subjectVo);
            }
            ClazzVo clazzVo = new ClazzVo();
            clazzVo.setId(clazz.getClazzId());
            clazzVo.setName(clazz.getClazz());
            clazzVo.setType(0);
            clazzVo.setGrade(subjectVos);
            clazzVos.add(clazzVo);

        }
        return clazzVos;

    }
}
