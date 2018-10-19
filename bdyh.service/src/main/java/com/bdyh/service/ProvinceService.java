package com.bdyh.service;

import java.util.List;

import com.bdyh.common.APIResponse;
import com.bdyh.entity.Course;
import com.bdyh.entity.Province;
import com.bdyh.entity.ProvinceVo;

public interface ProvinceService {

    public Province findProvinceByName(String string);

    public List<Province> findAllProvince();

    public APIResponse setProvinceStatus(int provinceId, int status);

    public List<ProvinceVo> findOpenRegion();


}
