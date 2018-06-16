package com.bdyh.dao;

import com.bdyh.entity.UserAdminRole;
import com.bdyh.entity.UserAdminRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAdminRoleMapper {
    int countByExample(UserAdminRoleExample example);

    int deleteByExample(UserAdminRoleExample example);

    int deleteByPrimaryKey(Integer roleId);

    int insert(UserAdminRole record);

    int insertSelective(UserAdminRole record);

    List<UserAdminRole> selectByExampleWithBLOBs(UserAdminRoleExample example);

    List<UserAdminRole> selectByExample(UserAdminRoleExample example);

    UserAdminRole selectByPrimaryKey(Integer roleId);

    int updateByExampleSelective(@Param("record") UserAdminRole record, @Param("example") UserAdminRoleExample example);

    int updateByExampleWithBLOBs(@Param("record") UserAdminRole record, @Param("example") UserAdminRoleExample example);

    int updateByExample(@Param("record") UserAdminRole record, @Param("example") UserAdminRoleExample example);

    int updateByPrimaryKeySelective(UserAdminRole record);

    int updateByPrimaryKeyWithBLOBs(UserAdminRole record);

    int updateByPrimaryKey(UserAdminRole record);
}