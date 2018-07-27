package com.bdyh.service;

import com.bdyh.common.APIResponse;
import com.bdyh.entity.*;

import java.util.List;

public interface BenefitService {
    List<AgentStatistics> findTeachersIncome(Agent agent);

    List<List<Object>> findTeacherByMonth(Integer teacherId);



    public float findTeacherAllIncome(Teacher teacher);
}
