package com.bdyh.web.admin.action;

import java.util.List;

import com.bdyh.common.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.bdyh.entity.City;
import com.bdyh.entity.District;
import com.bdyh.entity.Province;
import com.bdyh.service.CityService;
import com.bdyh.service.DistrictService;
import com.bdyh.service.ProvinceService;


/**
 * 区域管理
 * 2018年2月8日
 *
 * @author cxs
 */

@Controller
@RequestMapping(value = "district")
public class DistrictAction {

    @Autowired
    private DistrictService districtService;
    @Autowired
    private CityService cityService;
    @Autowired
    private ProvinceService provinceService;

    @RequestMapping(value = "provinceList")
    public String provinceList(Model model) {
      List<Province> provinceList = provinceService.findAllProvince();
            PictureAction pictureAction = new PictureAction();
        model.addAttribute("provinceList", provinceList);
        return "district/province-list";
    }

    @RequestMapping("provinceDown")
    @ResponseBody
    public APIResponse provinceDown(int provinceId) {
        return provinceService.setProvinceStatus(provinceId, 0);

    }

    @RequestMapping("provinceStart")
    @ResponseBody
    public APIResponse provinceStart(int provinceId) {
        return provinceService.setProvinceStatus(provinceId, 1);

    }


    @RequestMapping(value = "cityList/{provinceId}")
    public String cityList(Model model, @PathVariable("provinceId") Integer provinceId) {
        //TODO 从缓存里取数据
        List<City> cityList = cityService.findCityByProvinceId(provinceId);
        model.addAttribute("cityList", cityList);
        return "district/city-list";
    }

    @RequestMapping(value = "districtList/{cityId}")
    public String districtList(Model model, @PathVariable("cityId") Integer cityId) {
        //TODO 从缓存里取数据
        List<District> districtList = districtService.findDistrictByCityId(cityId);
        model.addAttribute("districtList", districtList);
        return "district/district-list";
    }
}
