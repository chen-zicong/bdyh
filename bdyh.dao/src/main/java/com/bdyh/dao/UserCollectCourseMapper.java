package com.bdyh.dao;

import com.bdyh.entity.UserCollectCourse;
import com.bdyh.entity.UserCollectCourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserCollectCourseMapper {
    int countByExample(UserCollectCourseExample example);

    int deleteByExample(UserCollectCourseExample example);

    int deleteByPrimaryKey(Integer uccid);

    int insert(UserCollectCourse record);

    int insertSelective(UserCollectCourse record);

    List<UserCollectCourse> selectByExample(UserCollectCourseExample example);

    UserCollectCourse selectByPrimaryKey(Integer uccid);

    int updateByExampleSelective(@Param("record") UserCollectCourse record, @Param("example") UserCollectCourseExample example);

    int updateByExample(@Param("record") UserCollectCourse record, @Param("example") UserCollectCourseExample example);

    int updateByPrimaryKeySelective(UserCollectCourse record);

    int updateByPrimaryKey(UserCollectCourse record);
}