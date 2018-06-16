package com.bdyh.service;

import java.util.List;

import com.bdyh.entity.Clazz;

public interface ClazzService {

	public List<Clazz> findAllClazz();
	public Clazz findClazzById(Integer id);
	public int updateClazz(Clazz clazz);

}
