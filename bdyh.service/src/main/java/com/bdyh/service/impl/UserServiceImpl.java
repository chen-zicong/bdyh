package com.bdyh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdyh.dao.UserWechatMapper;
import com.bdyh.entity.UserWechat;
import com.bdyh.service.UserService;
/**
 * 用户业务实现类
 * 2018年1月7日
 * @author cxs
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserWechatMapper userWechatMapper;
	
	@Override
	public void saveUser(UserWechat userWechat) {
		userWechatMapper.insert(userWechat);
	}

	@Override
	public UserWechat findUserWechatByOpenid(String openid) {
		return userWechatMapper.selectByPrimaryKey(openid);
	}
}
