package com.bdyh.entity;

import java.util.List;

public class ClazzVo {
    private int id;
    private String name;
    private int type;
    private List<SubjectVo> grade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<SubjectVo> getGrade() {
        return grade;
    }

    public void setGrade(List<SubjectVo> grade) {
        this.grade = grade;
    }
}



