package com.bdyh.service;

import com.bdyh.common.APIResponse;
import com.bdyh.entity.Agent;
import com.bdyh.entity.AgentStatistics;
import com.bdyh.entity.Benefit;
import com.bdyh.entity.TeacherIncome;

import java.util.List;

public interface BenefitService {
    List<AgentStatistics> findTeachersIncome(Agent agent);

    List<List<Object>> findTeacherByMonth(Integer teacherId);

    List<AgentStatistics> findAllTeacher();
}
