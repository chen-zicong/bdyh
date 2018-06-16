package com.bdyh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdyh.dao.UserAdminMapper;
import com.bdyh.entity.UserAdmin;
import com.bdyh.entity.UserAdminExample;
import com.bdyh.service.UserAdminService;

@Service
public class UserAdminServiceImpl implements UserAdminService {

	@Autowired
	private UserAdminMapper userAdminMapper;
	

	@Override
	public UserAdmin findUserAdminByUsername(String username) {
		UserAdminExample userAdminExample=new UserAdminExample();
		UserAdminExample.Criteria criteria=userAdminExample.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<UserAdmin> userAdminList=userAdminMapper.selectByExample(userAdminExample);
		if(userAdminList!=null && userAdminList.size()>0){
			return userAdminList.get(0);
		}
		return null;
	}


	@Override
	public void updateUserAdmin(UserAdmin userAdmin) {
		userAdminMapper.updateByPrimaryKey(userAdmin);
	}
	
}
