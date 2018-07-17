package com.bdyh.entity;

public class AgentDivide {
    private Integer agentId;

       private Integer teacherId;

    private String teacherName;

    private String agentName;

    private Integer divide;

    public AgentDivide(Integer agentId, Integer teacherId, String teacherName, String agentName, Integer divide) {
        this.agentId = agentId;
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.agentName = agentName;
        this.divide = divide;
    }

    public AgentDivide() {
        super();
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName == null ? null : agentName.trim();
    }

    public Integer getDivide() {
        return divide;
    }

    public void setDivide(Integer divide) {
        this.divide = divide;
    }
}