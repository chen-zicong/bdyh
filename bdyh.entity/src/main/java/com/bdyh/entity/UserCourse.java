package com.bdyh.entity;

public class UserCourse {
    private Integer ucid;

    private String openid;

    private Integer courseId;

    private Integer pay;

    private String tradeNo;

    public UserCourse(Integer ucid, String openid, Integer courseId, Integer pay, String tradeNo) {
        this.ucid = ucid;
        this.openid = openid;
        this.courseId = courseId;
        this.pay = pay;
        this.tradeNo = tradeNo;
    }

    public UserCourse() {
        super();
    }

    public Integer getUcid() {
        return ucid;
    }

    public void setUcid(Integer ucid) {
        this.ucid = ucid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getPay() {
        return pay;
    }

    public void setPay(Integer pay) {
        this.pay = pay;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }
}