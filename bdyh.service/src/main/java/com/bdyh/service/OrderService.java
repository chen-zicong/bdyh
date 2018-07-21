package com.bdyh.service;

import com.bdyh.common.APIResponse;
import com.bdyh.entity.*;
import org.simpleframework.xml.Order;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface OrderService {
    OrderVo createOrder(Integer courseId, Integer[] videosId, UserWechat userWechat);

    APIResponse cancel(String orderId);

    APIResponse finish(UserOrder orderId);

    APIResponse pay(String orderId);

    UserOrderAndDetail findPaid(String orderId);

    UserOrder findByOpenIdAndOrderId(String openId, String orderId);

    List<UserOrder> findBoughtByOpenIdandCourseId(String openId, int courseId);

    List<UserOrder> findUnBoughtByOpenIdandCourseId(String openId, int courseId);


    List<Integer> findOrderDetailByOrderId(String OrderId);

    OrderVo findOne(String orderId);
    UserOrder findUserOrder(String orderId);

    public List<PayOrder> findpayOrderByOpenId(String openId);

    public List<UnPayOrder> findUnpayOrderByOpenId(String openId);
}
