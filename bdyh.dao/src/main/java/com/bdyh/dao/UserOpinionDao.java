package com.bdyh.dao;

import java.util.List;

import com.bdyh.entity.UserOpinionVo;

public interface UserOpinionDao {

	public List<UserOpinionVo> findAllOpinionOfUsers();

	
}
