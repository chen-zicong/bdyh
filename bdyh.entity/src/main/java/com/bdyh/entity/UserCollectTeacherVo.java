package com.bdyh.entity;

/**
 * 继承UserCollectTeacher加入用户收藏的讲师对象
 * 2018年1月16日
 * @author cxs
 */
public class UserCollectTeacherVo extends UserCollectTeacher{
	
	/**
	 * 用户收藏的讲师
	 */
	private Teacher teacher;

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
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
