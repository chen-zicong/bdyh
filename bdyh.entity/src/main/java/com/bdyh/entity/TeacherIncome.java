package com.bdyh.entity;

import java.math.BigDecimal;
import java.util.Date;

public class TeacherIncome {

    private Date date;
    private BigDecimal teacherBenefit;


    public BigDecimal getTeacherBenefit() {
        return teacherBenefit;
    }

    public void setTeacherBenefit(BigDecimal teacherBenefit) {
        this.teacherBenefit = teacherBenefit;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}