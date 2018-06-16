package com.bdyh.entity;

public class TeacherIncome {
    private Integer id;

    private Integer teacherId;

    private Float income;

    private Integer courseId;

    private Integer count;

    public TeacherIncome(Integer id, Integer teacherId, Float income, Integer courseId, Integer count) {
        this.id = id;
        this.teacherId = teacherId;
        this.income = income;
        this.courseId = courseId;
        this.count = count;
    }

    public TeacherIncome() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Float getIncome() {
        return income;
    }

    public void setIncome(Float income) {
        this.income = income;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}