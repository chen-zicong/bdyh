package com.bdyh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdyh.dao.CityMapper;
import com.bdyh.entity.City;
import com.bdyh.entity.CityExample;
import com.bdyh.service.CityService;


@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityMapper cityMapper;
	
	@Override
	public City findCityByName(String string) {
		CityExample cityExample=new CityExample();
		CityExample.Criteria criteria=cityExample.createCriteria();
		criteria.andNameEqualTo(string);
		List<City> cityList=cityMapper.selectByExample(cityExample);
		if(cityList!=null && cityList.size()>0){
			return cityList.get(0);
		}
		return null;
	}

	@Override
	public List<City> findCityByProvinceId(Integer provinceId) {
		CityExample cityExample=new CityExample();
		CityExample.Criteria criteria=cityExample.createCriteria();
		criteria.andProvinceIdEqualTo(provinceId);
		return cityMapper.selectByExample(cityExample);
	}

}
