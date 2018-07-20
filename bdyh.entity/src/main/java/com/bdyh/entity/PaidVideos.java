package com.bdyh.entity;

import java.util.List;

public class PaidVideos {

    private List<Integer> videoId;
    private Integer courseId;

    public List<Integer> getVideoId() {
        return videoId;
    }

    public void setVideoId(List<Integer> videoId) {
        this.videoId = videoId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
}
