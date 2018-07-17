package com.bdyh.entity;

import java.io.Serializable;

public class Course  implements Serializable {
    private Integer courseId;

    private Integer teacherId;

    private Integer lessionNum;

    private Integer courseLevel;

    private Double coursePrice;

    private String courseDesc;

    private String courseImg;

    private String courseIntro;

    private String courseName;

    private Integer courseRecommend;

    private Integer courseDifficulty;

    private String courseType;

    private Integer districtId;

    private Integer status;

    private Integer collectNumber;

    private Integer flowNumber;

    private Double benefit;

    private Integer agentId;

    public Course(Integer courseId, Integer teacherId, Integer lessionNum, Integer courseLevel, Double coursePrice, String courseDesc, String courseImg, String courseIntro, String courseName, Integer courseRecommend, Integer courseDifficulty, String courseType, Integer districtId, Integer status, Integer collectNumber, Integer flowNumber, Double benefit, Integer agentId) {
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.lessionNum = lessionNum;
        this.courseLevel = courseLevel;
        this.coursePrice = coursePrice;
        this.courseDesc = courseDesc;
        this.courseImg = courseImg;
        this.courseIntro = courseIntro;
        this.courseName = courseName;
        this.courseRecommend = courseRecommend;
        this.courseDifficulty = courseDifficulty;
        this.courseType = courseType;
        this.districtId = districtId;
        this.status = status;
        this.collectNumber = collectNumber;
        this.flowNumber = flowNumber;
        this.benefit = benefit;
        this.agentId = agentId;
    }

    public Course() {
        super();
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getLessionNum() {
        return lessionNum;
    }

    public void setLessionNum(Integer lessionNum) {
        this.lessionNum = lessionNum;
    }

    public Integer getCourseLevel() {
        return courseLevel;
    }

    public void setCourseLevel(Integer courseLevel) {
        this.courseLevel = courseLevel;
    }

    public Double getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(Double coursePrice) {
        this.coursePrice = coursePrice;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc == null ? null : courseDesc.trim();
    }

    public String getCourseImg() {
        return courseImg;
    }

    public void setCourseImg(String courseImg) {
        this.courseImg = courseImg == null ? null : courseImg.trim();
    }

    public String getCourseIntro() {
        return courseIntro;
    }

    public void setCourseIntro(String courseIntro) {
        this.courseIntro = courseIntro == null ? null : courseIntro.trim();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public Integer getCourseRecommend() {
        return courseRecommend;
    }

    public void setCourseRecommend(Integer courseRecommend) {
        this.courseRecommend = courseRecommend;
    }

    public Integer getCourseDifficulty() {
        return courseDifficulty;
    }

    public void setCourseDifficulty(Integer courseDifficulty) {
        this.courseDifficulty = courseDifficulty;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType == null ? null : courseType.trim();
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCollectNumber() {
        return collectNumber;
    }

    public void setCollectNumber(Integer collectNumber) {
        this.collectNumber = collectNumber;
    }

    public Integer getFlowNumber() {
        return flowNumber;
    }

    public void setFlowNumber(Integer flowNumber) {
        this.flowNumber = flowNumber;
    }

    public Double getBenefit() {
        return benefit;
    }

    public void setBenefit(Double benefit) {
        this.benefit = benefit;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }
}