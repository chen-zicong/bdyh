package com.bdyh.service;

import java.util.List;

import com.bdyh.common.APIResponse;
import com.bdyh.entity.Subject;

public interface SubjectService {

    public List<Subject> findSubjectByClazzId(Integer clazzId);

    public List<String> findAll();

    public Subject findSubjectById(Integer subjectId);

    public APIResponse updateStatusById(Integer subjectId, Integer status);

    APIResponse addSubject(Subject subject);

    int startSubjectStatus(int clazzId, String subjectName);

    int downSubjectStatus(int clazzId, String subjectName);

}
