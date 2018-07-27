package com.bdyh.entity;

import java.math.BigDecimal;
import java.util.Date;

public class AgentIncome {
    private Date date;
    private BigDecimal agentBenefit;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getAgentBenefit() {
        return agentBenefit;
    }

    public void setAgentBenefit(BigDecimal agentBenefit) {
        this.agentBenefit = agentBenefit;
    }
}
