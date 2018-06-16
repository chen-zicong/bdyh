package com.bdyh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdyh.dao.WeAccessMapper;
import com.bdyh.entity.WeAccess;
import com.bdyh.service.WeAccessService;
/**
 * 
 * 2018年1月7日
 * @author cxs
 */
@Service
public class WeAccessServiceImpl implements WeAccessService{
	
	@Autowired
	private WeAccessMapper weAccessMapper;
	
	@Override
	public void saveWeAccess(WeAccess weAccess) {
		weAccessMapper.insert(weAccess);
	}

	@Override
	public WeAccess findWeAccessByOpenid(String openid) {
		return weAccessMapper.selectByPrimaryKey(openid);
	}
	
}
