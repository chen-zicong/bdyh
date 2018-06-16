package com.bdyh.entity;

public class Province {
    private Integer provinceId;

    private Integer status;

    private String name;

    private Integer weight;

    private String type;

    public Province(Integer provinceId, Integer status, String name, Integer weight, String type) {
        this.provinceId = provinceId;
        this.status = status;
        this.name = name;
        this.weight = weight;
        this.type = type;
    }

    public Province() {
        super();
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}