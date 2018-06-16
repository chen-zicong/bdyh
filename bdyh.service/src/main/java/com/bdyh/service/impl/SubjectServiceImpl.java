package com.bdyh.service.impl;

import java.util.List;

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
	
	@Override
	public List<Subject> findSubjectByClazzId(Integer clazzId) {
		SubjectExample subjectExample=new SubjectExample();
		SubjectExample.Criteria criteria=subjectExample.createCriteria();
		criteria.andClazzIdEqualTo(clazzId);
		return subjectMapper.selectByExample(subjectExample);
	}

}
