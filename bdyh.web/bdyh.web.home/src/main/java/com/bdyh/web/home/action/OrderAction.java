package com.bdyh.web.home.action;

import com.bdyh.common.APIResponse;
import com.bdyh.entity.*;
import com.bdyh.service.OrderService;
import com.bdyh.common.enums.ResultEnum;
import com.bdyh.common.exception.BdyhException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("order")
public class OrderAction {


    @Autowired
    private OrderService orderService;

    @RequestMapping("createOrder")
    @Transactional
    public APIResponse CreateOrder(Integer courseId, Integer[] videosId, HttpSession session) {
        UserWechat userWechat = (UserWechat) session.getAttribute("user");
        if (userWechat == null) {
            throw new BdyhException(ResultEnum.USER_NOT_EXIST);
        }
        if (courseId == null || videosId == null) {
            throw new BdyhException(ResultEnum.PROPERTY_ERROR);
        }
        return orderService.createOrder(courseId, videosId, userWechat);

    }



}
