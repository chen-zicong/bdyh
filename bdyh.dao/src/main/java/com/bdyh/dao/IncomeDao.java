package com.bdyh.dao;

import com.bdyh.entity.IncomeStatisticsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IncomeDao {

    public List<IncomeStatisticsVo> selectByTeacherId(@Param("id") Integer id);
    public Float selectIncomeByTeacherId(@Param("id") Integer id);
    public List<IncomeStatisticsVo> selectByAgentId (@Param("agentId") Integer agentId);
}
