package com.bdyh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdyh.dao.UserAdminRoleMapper;
import com.bdyh.entity.UserAdminRole;
import com.bdyh.service.UserAdminRoleService;

@Service
public class UserAdminRoleServiceImpl implements UserAdminRoleService {
	
	@Autowired
	private UserAdminRoleMapper userAdminRoleMapper;
	
	@Override
	public UserAdminRole findUserAdminRoleByRoleId(Integer roleId) {
		return userAdminRoleMapper.selectByPrimaryKey(roleId);
	}

}
