package com.bdyh.service.impl;

import java.util.List;

import com.bdyh.common.APIResponse;
import com.bdyh.dao.SubjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdyh.dao.SubjectMapper;
import com.bdyh.entity.Subject;
import com.bdyh.entity.SubjectExample;
import com.bdyh.service.SubjectService;


@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private SubjectDao subjectDao;


    @Override
    public List<Subject> findSubjectByClazzId(Integer clazzId) {
        SubjectExample subjectExample = new SubjectExample();
        SubjectExample.Criteria criteria = subjectExample.createCriteria();
        criteria.andClazzIdEqualTo(clazzId);
        return subjectMapper.selectByExample(subjectExample);
    }

    public List<String> findAll() {
        return subjectMapper.findAll();
    }

    @Override
    public Subject findSubjectById(Integer subjectId) {
        return subjectMapper.selectByPrimaryKey(subjectId);

    }

    @Override
    public APIResponse updateStatusById(Integer subjectId, Integer status) {

        int i = subjectDao.updateStatusById(subjectId, status);
        if (i == 1) {
            return APIResponse.success();
        } else {
            return APIResponse.fail("更新失败");
        }

    }

    /**
     * 添加某个年级的某个科目
     *
     * @param subject
     * @return
     */
    @Override
    public APIResponse addSubject(Subject subject) {
        Subject subject1 = subjectDao.selectBySubjectName(subject.getSubject());
        if (subject1 != null) {
            return APIResponse.fail("科目名重复");
        } else {
            subject.setStatus(1);
            int insert = subjectMapper.insert(subject);
            if (insert == 1) {
                return APIResponse.success("添加成功");
            } else {
                return APIResponse.fail("添加失败");
            }
        }

    }

}
