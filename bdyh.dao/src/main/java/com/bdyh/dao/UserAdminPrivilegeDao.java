package com.bdyh.dao;

import java.util.List;

import com.bdyh.entity.UserAdminPrivilegeVo;

/**
 * 
 * 2018年1月30日
 * @author cxs
 */
public interface UserAdminPrivilegeDao {

	public List<UserAdminPrivilegeVo> findMenuList(List<String> values);
}