package com.bdyh.service;

import java.util.List;

import com.bdyh.entity.Province;

public interface ProvinceService {

	public Province findProvinceByName(String string);

	public List<Province> findAllProvince();

}
