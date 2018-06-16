package com.bdyh.dao;

import com.bdyh.entity.UserAdminPrivilege;
import com.bdyh.entity.UserAdminPrivilegeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAdminPrivilegeMapper {
    int countByExample(UserAdminPrivilegeExample example);

    int deleteByExample(UserAdminPrivilegeExample example);

    int deleteByPrimaryKey(Integer privilegeId);

    int insert(UserAdminPrivilege record);

    int insertSelective(UserAdminPrivilege record);

    List<UserAdminPrivilege> selectByExample(UserAdminPrivilegeExample example);

    UserAdminPrivilege selectByPrimaryKey(Integer privilegeId);

    int updateByExampleSelective(@Param("record") UserAdminPrivilege record, @Param("example") UserAdminPrivilegeExample example);

    int updateByExample(@Param("record") UserAdminPrivilege record, @Param("example") UserAdminPrivilegeExample example);

    int updateByPrimaryKeySelective(UserAdminPrivilege record);

    int updateByPrimaryKey(UserAdminPrivilege record);
}