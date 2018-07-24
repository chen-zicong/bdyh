package com.bdyh.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Benefit {
    private String orderId;

    private Integer teacherId;

    private Integer agentId;

    private BigDecimal teacherBenefit;

    private BigDecimal agentBenefit;

    private BigDecimal adminBenefit;

    private Date date;

    private Integer count;

    public Benefit(String orderId, Integer teacherId, Integer agentId, BigDecimal teacherBenefit, BigDecimal agentBenefit, BigDecimal adminBenefit, Date date, Integer count) {
        this.orderId = orderId;
        this.teacherId = teacherId;
        this.agentId = agentId;
        this.teacherBenefit = teacherBenefit;
        this.agentBenefit = agentBenefit;
        this.adminBenefit = adminBenefit;
        this.date = date;
        this.count = count;
    }

    public Benefit() {
        super();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
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

    public BigDecimal getAdminBenefit() {
        return adminBenefit;
    }

    public void setAdminBenefit(BigDecimal adminBenefit) {
        this.adminBenefit = adminBenefit;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}