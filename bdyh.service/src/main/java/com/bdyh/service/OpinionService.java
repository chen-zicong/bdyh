package com.bdyh.service;

import java.util.List;

import com.bdyh.entity.UserOpinion;
import com.bdyh.entity.UserOpinionVo;

public interface OpinionService {

	public void saveOpinion(UserOpinion userOpinion);

	public List<UserOpinionVo> findAllOpinionOfUsers();

	public void deleteUserOpinionById(Integer uoid);
	
}
