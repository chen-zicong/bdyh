package com.bdyh.web.admin.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

public class CustomLoginToken extends UsernamePasswordToken{

	private static final long serialVersionUID = 1110047562560826931L;
	
	/**
	 * 登录类型
	 */
	private String loginType;
	
	/**
	 * 无参构造方法
	 */
	public CustomLoginToken(){}
	
	/**
	 * cxs
	 * @param username
	 * @param password
	 * @param loginType
	 */
	public CustomLoginToken(final String username,final String password,final boolean remeberMe,final String loginType){
		super(username, password,remeberMe);
		this.loginType=loginType;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	
	
	
}
