package com.bdyh.service;

import java.util.List;

import com.bdyh.entity.City;

public interface CityService {

	public City findCityByName(String string);

	public List<City> findCityByProvinceId(Integer provinceId);

}
