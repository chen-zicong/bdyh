package com.bdyh.dao;

import com.bdyh.entity.UserCourse;
import com.bdyh.entity.UserCourseExample;

import java.util.List;

import com.bdyh.entity.UserCourseVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserCourseMapper {
    int countByExample(UserCourseExample example);

    int deleteByExample(UserCourseExample example);

    int deleteByPrimaryKey(Integer ucid);

    int insert(UserCourse record);

    int insertSelective(UserCourse record);

    List<UserCourse> selectByExample(UserCourseExample example);

    UserCourse selectByPrimaryKey(Integer ucid);

    int updateByExampleSelective(@Param("record") UserCourse record, @Param("example") UserCourseExample example);

    int updateByExample(@Param("record") UserCourse record, @Param("example") UserCourseExample example);

    int updateByPrimaryKeySelective(UserCourse record);

    int updateByPrimaryKey(UserCourse record);

    /**
     * 根据用户的唯一标识openid查询用户所属的课程
     *
     * @param openid
     * @return
     */
    public List<UserCourseVo> findCourseOfUser(String openid);

    public List<UserCourseVo> findUnPayCourseOfUser(String openid);

    public List<UserCourseVo> findPayedCourseOfUser(String openid);


    @Select("select  order_id  from user_order where  course_id = #{courseId}")
    List<String> selectOrderIdByCourseId(@Param("courseId") Integer courseId);
}