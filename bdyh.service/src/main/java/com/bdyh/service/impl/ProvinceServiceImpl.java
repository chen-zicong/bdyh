package com.bdyh.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bdyh.common.APIResponse;
import com.bdyh.dao.CityMapper;
import com.bdyh.dao.ProvinceMapper;
import com.bdyh.entity.*;
import com.bdyh.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdyh.service.ProvinceService;


@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    private ProvinceMapper provinceMapper;

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private CourseService courseService;

    @Override
    public Province findProvinceByName(String string) {
        ProvinceExample provinceExample = new ProvinceExample();
        ProvinceExample.Criteria criteria = provinceExample.createCriteria();
        criteria.andNameEqualTo(string);
        List<Province> provinceList = provinceMapper.selectByExample(provinceExample);
        if (provinceList != null && provinceList.size() > 0) {
            return provinceList.get(0);
        }
        return null;
    }

    @Override
    public List<Province> findAllProvince() {
        ProvinceExample provinceExample = new ProvinceExample();
        ProvinceExample.Criteria criteria = provinceExample.createCriteria();
        criteria.andProvinceIdIsNotNull();

        return provinceMapper.selectByExample(provinceExample);
    }

    public APIResponse setProvinceStatus(int provinceId, int status) {
        int result = provinceMapper.updateProvinceStatus(provinceId, status);
        if (result == 1) {
            return APIResponse.success();
        }
        return APIResponse.fail("更新失败");
    }

    public List<ProvinceVo> findOpenRegion() {
        List<Province> openProvince = provinceMapper.findOpenProvince();
        List<ProvinceVo> provinceVos = new ArrayList<>();
        List<Course> allAuditCourse = courseService.findAllAuditCourse();


        for (Province province : openProvince) {
            ProvinceVo provinceVo = new ProvinceVo();
            provinceVo.setId(province.getProvinceId());
            provinceVo.setName(province.getName());
            List<City> cities = cityMapper.findOpenCityByProvinceId(province.getProvinceId());
            List<CityVo> cityVos = new ArrayList<>();
            for (City city : cities) {
                for (Course course : allAuditCourse) {
                    if (course.getDistrictId().equals(city.getCityId())) {
                        CityVo cityVo = new CityVo();
                        cityVo.setId(city.getCityId());
                        cityVo.setName(city.getName());
                        cityVos.add(cityVo);
                        break;
                    }
                }


            }

            provinceVo.setCity(cityVos);
            if (provinceVo.getCity().size() > 0) {
                provinceVos.add(provinceVo);
            }

        }
        return provinceVos;
    }

}
