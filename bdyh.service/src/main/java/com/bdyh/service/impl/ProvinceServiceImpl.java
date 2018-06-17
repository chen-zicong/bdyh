package com.bdyh.service.impl;

import java.util.List;

import com.bdyh.common.APIResponse;
import com.bdyh.dao.ProvinceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdyh.entity.Province;
import com.bdyh.entity.ProvinceExample;
import com.bdyh.service.ProvinceService;


@Service
public class ProvinceServiceImpl implements ProvinceService {

	@Autowired
	private ProvinceMapper provinceMapper;

	@Override
	public Province findProvinceByName(String string) {
		ProvinceExample provinceExample=new ProvinceExample();
		ProvinceExample.Criteria criteria=provinceExample.createCriteria();
		criteria.andNameEqualTo(string);
		List<Province> provinceList=provinceMapper.selectByExample(provinceExample);
		if(provinceList!=null && provinceList.size()>0){
			return provinceList.get(0);
		}
		return null;
	}

	@Override
	public List<Province> findAllProvince() {
		ProvinceExample provinceExample=new ProvinceExample();
		ProvinceExample.Criteria criteria=provinceExample.createCriteria();
		criteria.andProvinceIdIsNotNull();

		return provinceMapper.selectByExample(provinceExample);
	}

	public APIResponse setProvinceStatus(int provinceId, int status){
		int result=provinceMapper.updateProvinceStatus(provinceId,status);
		if(result==1){
		    return APIResponse.success();
        }
        return APIResponse.fail("更新失败");
    }
}
