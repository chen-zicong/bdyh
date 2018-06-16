package com.bdyh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdyh.dao.UserCollectCourseDao;
import com.bdyh.dao.UserCollectTeacherDao;
import com.bdyh.entity.UserCollectCourseVo;
import com.bdyh.entity.UserCollectTeacherVo;
import com.bdyh.service.UserCollectService;

/**
 * 收藏记录
 * 2018年2月3日
 * @author cxs
 */
@Service
public class UserCollectServiceImpl implements UserCollectService {

	@Autowired
	private UserCollectCourseDao userCollectCourseDao;
	
	@Autowired
	private UserCollectTeacherDao userCollectTeacherDao;
	
	@Override
	public List<UserCollectCourseVo> findAllUserCollectCourse() {
		return userCollectCourseDao.findAllUserCollectCourse();
	}

	@Override
	public List<UserCollectTeacherVo> findAllUserCollectTeacher() {
		return userCollectTeacherDao.findAllUserCollectTeacher();
	}
	
}
