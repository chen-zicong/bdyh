package com.bdyh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdyh.dao.UserWechatMapper;
import com.bdyh.entity.UserWechat;
import com.bdyh.entity.UserWechatExample;
import com.bdyh.service.UserWechatService;
/**
 * 微信用户管理
 * 2018年2月2日
 * @author cxs
 */
@Service
public class UserWechatServiceImpl implements UserWechatService {
	
	@Autowired
	private UserWechatMapper userWechatMapper;
	/**
	 * 所有微信用户
	 */
	@Override
	public List<UserWechat> findAllUserWechat() {
		UserWechatExample userWechatExample=new UserWechatExample();
		UserWechatExample.Criteria criteria=userWechatExample.createCriteria();
		criteria.andOpenidIsNotNull();
		return userWechatMapper.selectByExample(userWechatExample);
	}

	
}
