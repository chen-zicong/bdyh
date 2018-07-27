package com.bdyh.service;

import com.bdyh.common.APIResponse;
import com.bdyh.entity.*;

import java.math.BigDecimal;
import java.util.List;

public interface BenefitService {
    List<AgentStatistics> findTeachersIncome(Agent agent);

    List<List<Object>> findTeacherByMonth(Integer teacherId);



    public float findTeacherAllIncome(Teacher teacher);

    List<List<Object>> agentIncomeByTime(Integer agentId);
    public AdminStatistics findAgentIncome(Agent agent);
    public BigDecimal findAgentAllIncome(Integer agentId);

}
