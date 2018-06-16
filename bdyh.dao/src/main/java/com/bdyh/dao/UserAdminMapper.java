package com.bdyh.dao;

import com.bdyh.entity.UserAdmin;
import com.bdyh.entity.UserAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAdminMapper {
    int countByExample(UserAdminExample example);

    int deleteByExample(UserAdminExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(UserAdmin record);

    int insertSelective(UserAdmin record);

    List<UserAdmin> selectByExample(UserAdminExample example);

    UserAdmin selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") UserAdmin record, @Param("example") UserAdminExample example);

    int updateByExample(@Param("record") UserAdmin record, @Param("example") UserAdminExample example);

    int updateByPrimaryKeySelective(UserAdmin record);

    int updateByPrimaryKey(UserAdmin record);
}