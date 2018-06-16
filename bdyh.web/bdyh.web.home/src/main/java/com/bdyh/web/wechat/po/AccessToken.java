package com.bdyh.web.wechat.po;
/**
 * 微信的基础Access_token
 * 2018年1月7日
 * @author cxs
 */
public class AccessToken {
	private String token;
	private int expiresIn;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}
}
