package com.bdyh.dao;

import com.bdyh.entity.Teacher;
import com.bdyh.entity.TeacherExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {
    int countByExample(TeacherExample example);

    int deleteByExample(TeacherExample example);

    int deleteByPrimaryKey(Integer teacherId);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    List<Teacher> selectByExample(TeacherExample example);

    Teacher selectByPrimaryKey(Integer teacherId);

    int updateByExampleSelective(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByExample(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    @Select("select * from  teacher where agent_id = #{agentId} ")
    List<Teacher> findTeacherByAgentId(@Param("agentId") Integer agentId);
    @Select("select * from teacher")
    List<Teacher> findAllTeacher();
}