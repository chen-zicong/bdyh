package com.bdyh.dao;

import com.bdyh.entity.Course;
import com.bdyh.entity.CourseExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

public interface CourseMapper {
    int countByExample(CourseExample example);

    int deleteByExample(CourseExample example);

    int deleteByPrimaryKey(Integer courseId);

    int insert(Course record);

    int insertSelective(Course record);

    List<Course> selectByExample(CourseExample example);

    Course selectByPrimaryKey(Integer courseId);

    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    @Select("select * from course where teacher_id = #{teacherId}")
    List<Course> selectAllCourseByTeacherId(@Param("teacherId") Integer teacherId);

    @Update("update course set status = #{status} where  course_level = #{clazzId}")
    int updateByClazz(@Param("clazzId") int clazzId, @Param("status") int status);
    @Update("update course set status = #{status} where  course_level = #{clazzId} and course_type = #{subjectName}")
    int updateBySubject(@Param("clazzId") int clazzId, @Param("subjectName") String subjectName ,@Param("status") int status);

}