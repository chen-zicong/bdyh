package com.bdyh.entity;

import java.util.List;

public class UserAdminPrivilegeVo extends UserAdminPrivilege {
	//子菜单列表
	private List<Menu> menus;

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	
}
