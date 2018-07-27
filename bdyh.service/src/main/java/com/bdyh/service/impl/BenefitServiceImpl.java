package com.bdyh.service.impl;

import com.bdyh.common.APIResponse;
import com.bdyh.dao.BenefitMapper;
import com.bdyh.dao.TeacherMapper;
import com.bdyh.entity.*;
import com.bdyh.service.BenefitService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class BenefitServiceImpl implements BenefitService {
    @Autowired
    private BenefitMapper benefitMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<AgentStatistics> findTeachersIncome(Agent agent) {

        List<Teacher> teachers = teacherMapper.findTeacherByAgentId(agent.getAgentId());
        List<AgentStatistics> statisticsList = new ArrayList<>();
        if (teachers.size() > 0) {
            getStatistics(teachers, statisticsList,agent);
        }


        return statisticsList;
    }

    private void getStatistics(List<Teacher> teachers, List<AgentStatistics> statisticsList,Agent agent) {
        for (Teacher teacher : teachers) {
            AgentStatistics statistics = benefitMapper.findStatisticsByTeacherId(teacher.getTeacherId());
            if (statistics == null) {
                statistics = new AgentStatistics();
                statistics.setTeacherBenefit(new BigDecimal(BigInteger.ZERO));
                statistics.setAgentBenefit(new BigDecimal(BigInteger.ZERO));


            }
            statistics.setTeacherName(teacher.getTeacherName());
            statistics.setTeacherId(teacher.getTeacherId());
            statistics.setAgentName(agent.getUsername());
            statisticsList.add(statistics);
        }
    }

    @Override
    public List<List<Object>> findTeacherByMonth(Integer teacherId) {
        List<List<Object>> list = new ArrayList<>();
        List<TeacherIncome> teacherByMonth = benefitMapper.findTeacherByMonth(teacherId);
        for (TeacherIncome teacherIncome : teacherByMonth) {
            List<Object> income = new ArrayList<>();
            income.add(teacherIncome.getTeacherBenefit().floatValue());
            income.add(new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(teacherIncome.getDate()));
            list.add(income);
        }
        return list;


    }





     public  float findTeacherAllIncome(Teacher teacher){
         BigDecimal teacherAllIncome = benefitMapper.findTeacherAllIncome(teacher.getTeacherId());
         return  teacherAllIncome.floatValue();
     }
}
