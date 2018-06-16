package com.bdyh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdyh.dao.DistrictMapper;
import com.bdyh.entity.District;
import com.bdyh.entity.DistrictExample;
import com.bdyh.service.DistrictService;

@Service
public class DistrictServiceImpl implements DistrictService{

	@Autowired
	private DistrictMapper districtMapper;
	
	@Override
	public District findDistrictByName(String districtName) {
		DistrictExample districtExample=new DistrictExample();
		DistrictExample.Criteria criteria=districtExample.createCriteria();
		criteria.andNameEqualTo(districtName);
		List<District> districtList=districtMapper.selectByExample(districtExample);
		if(districtList.size()>0){
			return districtList.get(0);
		}
		return null;
	}

	@Override
	public List<District> findDistrictByCityId(Integer cityId) {
		DistrictExample districtExample=new DistrictExample();
		DistrictExample.Criteria criteria=districtExample.createCriteria();
		criteria.andCityIdEqualTo(cityId);
		return districtMapper.selectByExample(districtExample);
	}
	
}
