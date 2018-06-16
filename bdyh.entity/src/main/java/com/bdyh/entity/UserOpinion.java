package com.bdyh.entity;

public class UserOpinion {
    private Integer uoid;

    private String openid;

    private String opinion;

    private String feedbackTime;

    public Integer getUoid() {
        return uoid;
    }

    public void setUoid(Integer uoid) {
        this.uoid = uoid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion == null ? null : opinion.trim();
    }

    public String getFeedbackTime() {
        return feedbackTime;
    }

    public void setFeedbackTime(String feedbackTime) {
        this.feedbackTime = feedbackTime == null ? null : feedbackTime.trim();
    }
}