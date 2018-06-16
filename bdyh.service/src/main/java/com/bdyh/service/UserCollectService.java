package com.bdyh.service;

import java.util.List;

import com.bdyh.entity.UserCollectCourseVo;
import com.bdyh.entity.UserCollectTeacherVo;

public interface UserCollectService {

	public List<UserCollectCourseVo> findAllUserCollectCourse();

	public List<UserCollectTeacherVo> findAllUserCollectTeacher();

}
