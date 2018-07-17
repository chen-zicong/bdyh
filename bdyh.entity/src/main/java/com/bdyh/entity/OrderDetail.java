package com.bdyh.entity;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDetail {
    private String detailId;

    private String orderId;

    private String courseName;

    private Integer courseId;

    private Integer videoId;

    private String videoName;

    private BigDecimal price;

    private Date date;

    public OrderDetail(String detailId, String orderId, String courseName, Integer courseId, Integer videoId, String videoName, BigDecimal price, Date date) {
        this.detailId = detailId;
        this.orderId = orderId;
        this.courseName = courseName;
        this.courseId = courseId;
        this.videoId = videoId;
        this.videoName = videoName;
        this.price = price;
        this.date = date;
    }

    public OrderDetail() {
        super();
    }

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId == null ? null : detailId.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
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

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName == null ? null : videoName.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}