package com.bdyh.entity;

public class UserCollectTeacher {
    private Integer uctid;

    private String openid;

    private Integer teacherId;

    public Integer getUctid() {
        return uctid;
    }

    public void setUctid(Integer uctid) {
        this.uctid = uctid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}