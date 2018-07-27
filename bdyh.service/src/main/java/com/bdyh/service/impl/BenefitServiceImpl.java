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
import java.util.Date;
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
            getStatistics(teachers, statisticsList, agent);
        }


        return statisticsList;
    }

    private void getStatistics(List<Teacher> teachers, List<AgentStatistics> statisticsList, Agent agent) {
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
        //没数据2个或者2个以上的数据echarts会报错，弄点假的
        if (list.size() <=1) {
            int i = 2;
            while (i != 0) {
                List<Object> income = new ArrayList<>();
                income.add(0.0);
                income.add(new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date()));
                list.add(income);
                i--;
            }
        }
        return list;


    }

    //查询代理商的各个时间段的收入。
    @Override
    public List<List<Object>> agentIncomeByTime(Integer agentId) {
        List<List<Object>> list = new ArrayList<>();
        List<AgentIncome> incomes = benefitMapper.findAgentIncomeByTime(agentId);
        for (AgentIncome agentIncome : incomes) {
            List<Object> income = new ArrayList<>();
            income.add(agentIncome.getAgentBenefit().floatValue());
            income.add(new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(agentIncome.getDate()));
            list.add(income);
        }
        //没数据echarts会报错，弄点假的
        if (list.size() <=1) {
            int i = 2;
            while (i != 0) {
                List<Object> income = new ArrayList<>();
                income.add(0.0);
                income.add(new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date()));
                list.add(income);
                i--;
            }
        }
        return list;
    }


    public float findTeacherAllIncome(Teacher teacher) {
        BigDecimal teacherAllIncome = benefitMapper.findTeacherAllIncome(teacher.getTeacherId());
        return teacherAllIncome.floatValue();
    }


    /*查询代理商的收入的列表，包括一些信息。代理商等级等等*/
    public AdminStatistics findAgentIncome(Agent agent) {
        BigDecimal agentIncome = benefitMapper.findAgentIncome(agent.getAgentId());
        AdminStatistics adminStatistics = new AdminStatistics();
        if (agentIncome == null) {
            adminStatistics.setAgentBenefit(BigDecimal.ZERO);
        } else {
            adminStatistics.setAgentBenefit(agentIncome);
        }
        adminStatistics.setAgentName(agent.getUsername());
        adminStatistics.setAgentLevel(agent.getAgentLevel());
        adminStatistics.setAgentId(agent.getAgentId());

        return adminStatistics;


    }


     public BigDecimal findAgentAllIncome(Integer agentId){
         return  benefitMapper.findAgentIncome(agentId);
     }
}
