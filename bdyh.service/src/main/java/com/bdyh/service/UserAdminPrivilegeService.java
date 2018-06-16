package com.bdyh.service;

import java.util.List;

import com.bdyh.entity.UserAdminPrivilegeVo;


public interface UserAdminPrivilegeService {

	public List<UserAdminPrivilegeVo> findMenuListByRolePowers(String rolePowers);

}
