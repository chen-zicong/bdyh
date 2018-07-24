package com.bdyh.entity;

import java.math.BigDecimal;

public class IncomeStatisticsVo extends Course {

    private Integer count;
    private BigDecimal teacherBenefit;

    public BigDecimal getTeacherBenefit() {
        return teacherBenefit;
    }

    public void setTeacherBenefit(BigDecimal teacherBenefit) {
        this.teacherBenefit = teacherBenefit;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }


}
