package com.bdyh.entity;


/**
 * 继承UserOpinion
 * 一条记录对应一条意见反馈，带用户信息
 * 2018年2月3日
 * @author cxs
 */
public class UserOpinionVo extends UserOpinion {
	
	private UserWechat userWechat;

	public UserWechat getUserWechat() {
		return userWechat;
	}

	public void setUserWechat(UserWechat userWechat) {
		this.userWechat = userWechat;
	}
	
	
}
