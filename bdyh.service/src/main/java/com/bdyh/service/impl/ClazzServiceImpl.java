package com.bdyh.service.impl;

import java.util.List;

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
	
	@Override
	public List<Clazz> findAllClazz() {
		ClazzExample clazzExample=new ClazzExample();
		ClazzExample.Criteria criteria=clazzExample.createCriteria();
		criteria.andClazzIdIsNotNull();
		return clazzMapper.selectByExample(clazzExample);
	}

	@Override
	public Clazz findClazzById(Integer id) {
		ClazzExample clazzExample=new ClazzExample();
		ClazzExample.Criteria criteria=clazzExample.createCriteria();
		criteria.andClazzIdEqualTo(id);

		return clazzMapper.selectByExample(clazzExample).get(0);
	}

	public int updateClazz(Clazz clazz){
		ClazzExample clazzExample=new ClazzExample();
		ClazzExample.Criteria criteria=clazzExample.createCriteria();
		criteria.andClazzIdEqualTo(clazz.getClazzId());
		return clazzMapper.updateByExampleSelective(clazz,clazzExample);
	}

}
