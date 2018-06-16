package com.bdyh.dao;

import java.util.List;

import com.bdyh.entity.UserCollectCourseVo;

public interface UserCollectCourseDao {

	public List<UserCollectCourseVo> findCollectCourseOfUser(String openid);

	public List<UserCollectCourseVo> findAllUserCollectCourse();
	
}