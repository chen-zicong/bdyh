package com.bdyh.dao;

import com.bdyh.entity.AgentDivide;
import com.bdyh.entity.AgentDivideExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AgentDivideMapper {
    int countByExample(AgentDivideExample example);

    int deleteByExample(AgentDivideExample example);

    int deleteByPrimaryKey(Integer agentId);

    int insert(AgentDivide record);

    int insertSelective(AgentDivide record);

    List<AgentDivide> selectByExample(AgentDivideExample example);

    AgentDivide selectByPrimaryKey(Integer agentId);

    int updateByExampleSelective(@Param("record") AgentDivide record, @Param("example") AgentDivideExample example);

    int updateByExample(@Param("record") AgentDivide record, @Param("example") AgentDivideExample example);

    int updateByPrimaryKeySelective(AgentDivide record);

    int updateByPrimaryKey(AgentDivide record);

    @Select("select * from agent_divide where agent_id = #{agentId} and teacher_id=#{teacherId}")
    AgentDivide findOne(@Param("agentId") int agentId, @Param("teacherId") int teacherId);

    @Update("update agent_divide set divide = #{divideNum} where agent_id =#{agentId} and teacher_id = #{teacherId}")
    int updateDivideNum(@Param("agentId") int agentId, @Param("teacherId") int teacherId, @Param("divideNum") int divideNum);



}