package com.bdyh.entity;

import java.math.BigDecimal;
import java.util.Date;

public class AgentIncome {
    private Date date;
    private BigDecimal agent_benefit;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getAgent_benefit() {
        return agent_benefit;
    }

    public void setAgent_benefit(BigDecimal agent_benefit) {
        this.agent_benefit = agent_benefit;
    }
}
