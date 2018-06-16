package com.bdyh.service;

import com.bdyh.entity.UserAdmin;

public interface UserAdminService {

	public UserAdmin findUserAdminByUsername(String username);

	public void updateUserAdmin(UserAdmin userAdmin);

}
