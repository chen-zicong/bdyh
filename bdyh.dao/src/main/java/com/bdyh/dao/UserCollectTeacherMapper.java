package com.bdyh.dao;

import com.bdyh.entity.UserCollectTeacher;
import com.bdyh.entity.UserCollectTeacherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserCollectTeacherMapper {
    int countByExample(UserCollectTeacherExample example);

    int deleteByExample(UserCollectTeacherExample example);

    int deleteByPrimaryKey(Integer uctid);

    int insert(UserCollectTeacher record);

    int insertSelective(UserCollectTeacher record);

    List<UserCollectTeacher> selectByExample(UserCollectTeacherExample example);

    UserCollectTeacher selectByPrimaryKey(Integer uctid);

    int updateByExampleSelective(@Param("record") UserCollectTeacher record, @Param("example") UserCollectTeacherExample example);

    int updateByExample(@Param("record") UserCollectTeacher record, @Param("example") UserCollectTeacherExample example);

    int updateByPrimaryKeySelective(UserCollectTeacher record);

    int updateByPrimaryKey(UserCollectTeacher record);
}