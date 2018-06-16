package com.bdyh.service;

import java.util.List;

import com.bdyh.entity.District;

public interface DistrictService {

	public District findDistrictByName(String districtName);

	public List<District> findDistrictByCityId(Integer cityId);

}
