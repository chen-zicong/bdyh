package com.bdyh.service;

import com.bdyh.entity.UserWechat;

/**
 * 用户业务层接口
 * 2018年1月7日
 * @author cxs
 */
public interface UserService {
	
	public void saveUser(UserWechat userWechat);
	
	public UserWechat findUserWechatByOpenid(String openid);
}
