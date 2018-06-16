package com.bdyh.dao;

import com.bdyh.entity.TeacherIncome;
import com.bdyh.entity.TeacherIncomeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherIncomeMapper {
    int countByExample(TeacherIncomeExample example);

    int deleteByExample(TeacherIncomeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TeacherIncome record);

    int insertSelective(TeacherIncome record);

    List<TeacherIncome> selectByExample(TeacherIncomeExample example);

    TeacherIncome selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TeacherIncome record, @Param("example") TeacherIncomeExample example);

    int updateByExample(@Param("record") TeacherIncome record, @Param("example") TeacherIncomeExample example);

    int updateByPrimaryKeySelective(TeacherIncome record);

    int updateByPrimaryKey(TeacherIncome record);
}