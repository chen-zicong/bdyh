package com.bdyh.service;

import java.util.List;

import com.bdyh.entity.Clazz;
import com.bdyh.entity.ClazzVo;

public interface ClazzService {

	public List<Clazz> findAllClazz();
	public Clazz findClazzById(Integer id);
	public int updateClazz(Clazz clazz);

	public int insertClazz(Clazz clazz);

	public List<Clazz> findClazzByStatus();

	public List<ClazzVo> findOpenClazzAndSubject();

}
