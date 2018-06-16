package com.bdyh.entity;

public class UserCollectCourse {
    private Integer uccid;

    private String openid;

    private Integer courseId;

    public Integer getUccid() {
        return uccid;
    }

    public void setUccid(Integer uccid) {
        this.uccid = uccid;
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
}