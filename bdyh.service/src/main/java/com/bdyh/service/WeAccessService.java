package com.bdyh.service;

import com.bdyh.entity.WeAccess;
/**
 * 
 * 2018年1月7日
 * @author cxs
 */
public interface WeAccessService {
	
	public void saveWeAccess(WeAccess weAccess);
	
	public WeAccess findWeAccessByOpenid(String openid);
}
