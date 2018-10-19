package com.bdyh.entity;

import java.util.List;

public class ProvinceVo {
    private  int id;
    private  String name;
    private List<CityVo> city;

    public List<CityVo> getCity() {
        return city;
    }

    public void setCity(List<CityVo> city) {
        this.city = city;
    }

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
}
