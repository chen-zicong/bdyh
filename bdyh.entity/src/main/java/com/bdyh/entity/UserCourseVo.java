package com.bdyh.entity;

import java.io.Serializable;

/**
 * 继承UserCourse，加入课程的列表
 * 2018年1月15日
 * @author cxs
 */
public class UserCourseVo extends UserCourse implements Serializable{
	
	private static final long serialVersionUID = -796476105902088410L;
	
	//课程集合
	private Course course;

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	
}
