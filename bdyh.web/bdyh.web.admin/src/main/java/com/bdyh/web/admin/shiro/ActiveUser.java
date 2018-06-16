package com.bdyh.web.admin.shiro;

import java.io.Serializable;
import java.util.List;

import com.bdyh.entity.UserAdminPrivilegeVo;


public class ActiveUser implements Serializable{

	private static final long serialVersionUID = 4013088288172590957L;
	private Integer userid;//用户id（主键）
	private String username;//用户账号
	private String nickname;//用户名称
	private String loginTime;//上次登录时间
	private Integer loginNumber;//登录系统次数
	private String password;//用户密码
	private String loginType;
	private Integer roleId;
	private Integer districtId;
	
	private List<UserAdminPrivilegeVo> menuList;
	
	
	public Integer getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}
	public List<UserAdminPrivilegeVo> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<UserAdminPrivilegeVo> menuList) {
		this.menuList = menuList;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getLoginType() {
		return loginType;
	}
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String role;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	public Integer getLoginNumber() {
		return loginNumber;
	}
	public void setLoginNumber(Integer loginNumber) {
		this.loginNumber = loginNumber;
	}
	
	/*
	private List<SysPermission> menus;// 菜单
	private List<SysPermission> permissions;// 权限
	*/
	
	
	
}
