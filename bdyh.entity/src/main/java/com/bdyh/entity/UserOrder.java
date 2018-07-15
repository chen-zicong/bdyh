package com.bdyh.entity;

import java.util.Date;

public class UserOrder {
    private String openId;

    private Integer ccourseId;

    private Integer videoId;

    private Integer pay;

    private Date date;

    public UserOrder(String openId, Integer ccourseId, Integer videoId, Integer pay, Date date) {
        this.openId = openId;
        this.ccourseId = ccourseId;
        this.videoId = videoId;
        this.pay = pay;
        this.date = date;
    }

    public UserOrder() {
        super();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public Integer getCcourseId() {
        return ccourseId;
    }

    public void setCcourseId(Integer ccourseId) {
        this.ccourseId = ccourseId;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Integer getPay() {
        return pay;
    }

    public void setPay(Integer pay) {
        this.pay = pay;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}