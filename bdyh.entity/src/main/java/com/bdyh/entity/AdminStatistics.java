package com.bdyh.entity;

import java.math.BigDecimal;

public class AdminStatistics {
    private Integer agentId;
    private String agentName;
    private Integer agentLevel;
    private BigDecimal agentBenefit;

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public Integer getAgentLevel() {
        return agentLevel;
    }

    public void setAgentLevel(Integer agentLevel) {
        this.agentLevel = agentLevel;
    }

    public BigDecimal getAgentBenefit() {
        return agentBenefit;
    }

    public void setAgentBenefit(BigDecimal agentBenefit) {
        this.agentBenefit = agentBenefit;
    }
}
