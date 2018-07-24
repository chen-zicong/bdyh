package com.bdyh.entity;

public class AlreadyBoughtKey {
    private String openId;

    private Integer courseId;

    private Integer videoId;

    public AlreadyBoughtKey(String openId, Integer courseId, Integer videoId) {
        this.openId = openId;
        this.courseId = courseId;
        this.videoId = videoId;
    }

    public AlreadyBoughtKey() {
        super();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }
}