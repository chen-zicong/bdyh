package com.bdyh.entity;

import java.math.BigDecimal;

public class AgentStatistics {
    private Integer teacherId;
    private String AgentName;
    private String teacherName;
    private BigDecimal teacherBenefit;
    private BigDecimal agentBenefit;

    public String getAgentName() {
        return AgentName;
    }

    public void setAgentName(String agentName) {
        AgentName = agentName;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public BigDecimal getTeacherBenefit() {
        return teacherBenefit;
    }

    public void setTeacherBenefit(BigDecimal teacherBenefit) {
        this.teacherBenefit = teacherBenefit;
    }

    public BigDecimal getAgentBenefit() {
        return agentBenefit;
    }

    public void setAgentBenefit(BigDecimal agentBenefit) {
        this.agentBenefit = agentBenefit;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
