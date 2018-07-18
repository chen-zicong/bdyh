package com.bdyh.entity;

public class AlreadyBoughtKey {
    private byte[] openId;

    private Integer courseId;

    private Integer videoId;

    public AlreadyBoughtKey(byte[] openId, Integer courseId, Integer videoId) {
        this.openId = openId;
        this.courseId = courseId;
        this.videoId = videoId;
    }

    public AlreadyBoughtKey() {
        super();
    }

    public byte[] getOpenId() {
        return openId;
    }

    public void setOpenId(byte[] openId) {
        this.openId = openId;
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