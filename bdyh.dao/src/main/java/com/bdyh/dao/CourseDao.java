package com.bdyh.dao;

import java.util.List;

import com.bdyh.entity.Course;

/**
 * 实现课程自定义的查询
 * 2018年1月15日
 * @author cxs
 */
public interface CourseDao {
	/**
	 * 自定义条件查询课程列表
	 * @param course
	 * @return
	 */
	public List<Course> searchCourseByExample(Course course);

}