package com.bdyh.service;

import java.util.List;

import com.bdyh.entity.Subject;

public interface SubjectService {

	public List<Subject> findSubjectByClazzId(Integer clazzId);

}
