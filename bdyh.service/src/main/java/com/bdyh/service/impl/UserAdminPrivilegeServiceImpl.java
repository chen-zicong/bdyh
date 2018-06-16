package com.bdyh.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdyh.dao.UserAdminPrivilegeDao;
import com.bdyh.dao.UserAdminPrivilegeMapper;
import com.bdyh.entity.UserAdminPrivilegeVo;
import com.bdyh.service.UserAdminPrivilegeService;

@Service
public class UserAdminPrivilegeServiceImpl implements UserAdminPrivilegeService {

	@Autowired
	private UserAdminPrivilegeMapper userAdminPrivilegeMapper;
	
	/**
	 * 查询菜单时候把menu表也查询出来
	 */
	@Autowired
	private UserAdminPrivilegeDao userAdminPrivilegeDao;
	
	@Override
	public List<UserAdminPrivilegeVo> findMenuListByRolePowers(String rolePowers) {
		
		String[] powers=rolePowers.split(",");
		List<String> values = new ArrayList<String>();
		Collections.addAll(values, powers);
		/*for(int i=0;i<powers.length;i++){
			values.add(powers[i]);
		}*/
		/*UserAdminPrivilegeExample userAdminPrivilegeExample=new UserAdminPrivilegeExample();
		UserAdminPrivilegeExample.Criteria criteria=userAdminPrivilegeExample.createCriteria();
		criteria.andPrivilegeNameIn(values);*/
		List<UserAdminPrivilegeVo> menuList=null;
		try{
			menuList=userAdminPrivilegeDao.findMenuList(values);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(menuList!=null && menuList.size()>0){
			
			return menuList;
		}
		return null;
	}

}
