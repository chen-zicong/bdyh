package com.bdyh.dao;

import java.util.List;

import com.bdyh.entity.UserCollectTeacherVo;

public interface UserCollectTeacherDao {
	
	public List<UserCollectTeacherVo> findCollectTeacherOfUser(String openid);

	public List<UserCollectTeacherVo> findAllUserCollectTeacher();
	
}