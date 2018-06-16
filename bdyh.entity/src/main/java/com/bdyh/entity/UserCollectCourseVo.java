package com.bdyh.entity;
/**
 * 继承UserCollectCourse加入关联的课程对象
 * 2018年1月16日
 * @author cxs
 */
public class UserCollectCourseVo extends UserCollectCourse{
	
	/**
	 * 用户收藏的课程
	 */
	private Course course;

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	/*-------------------------------------------------------后台模块加的---------------------------------------------------------------------*/
	/**
	 * 用户收藏的课程
	 */
	private UserWechat userWechat;

	public UserWechat getUserWechat() {
		return userWechat;
	}

	public void setUserWechat(UserWechat userWechat) {
		this.userWechat = userWechat;
	}

	/*-------------------------------------------------------后台模块加的---------------------------------------------------------------------*/
}
