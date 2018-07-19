package com.bdyh.service.impl;

import com.bdyh.common.APIResponse;
import com.bdyh.common.Util;
import com.bdyh.dao.AlreadyBoughtMapper;
import com.bdyh.dao.OrderDetailMapper;
import com.bdyh.dao.UserOrderMapper;
import com.bdyh.entity.*;
import com.bdyh.service.CourseService;
import com.bdyh.service.OrderService;
import com.bdyh.service.VideoService;
import com.bdyh.common.enums.ResultEnum;
import com.bdyh.common.exception.BdyhException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private VideoService videoService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserOrderMapper userOrderMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private AlreadyBoughtMapper alreadyBoughtMapper;

    @Override
    public OrderVo createOrder(Integer courseId, Integer[] videosId, UserWechat userWechat) {
        UserOrder userOrder = new UserOrder();
        OrderDetail orderDetail;
        Course course = courseService.findCourseById(courseId);
        userOrder.setOpenId(userWechat.getOpenid());
        userOrder.setOrderId(Util.generateUUID());
        userOrder.setCourseId(courseId);
        userOrder.setPay(0);
        //金额初始化为0
        BigDecimal orderAmount = new BigDecimal("0.0");
        for (Integer videoId : videosId) {
            orderDetail = new OrderDetail();
            Video video = videoService.findVideoById(videoId);
            Double videoPrice = video.getVideoPrice();
           orderAmount = orderAmount.add(new BigDecimal(Double.toString(videoPrice)));
            orderDetail.setDetailId(Util.generateUUID());
            orderDetail.setCourseId(courseId);
            orderDetail.setVideoId(videoId);
            orderDetail.setPrice(new BigDecimal(video.getVideoPrice()));
            orderDetail.setCourseName(course.getCourseName());
            orderDetail.setVideoName(video.getVideoName());
            orderDetail.setDate(new Date());
            orderDetail.setOrderId(userOrder.getOrderId());
            int insert = orderDetailMapper.insert(orderDetail);
            if (insert != 1) {
                throw new BdyhException(ResultEnum.DETAIL_ERROR);
            }

        }
        userOrder.setDate(new Date());
        userOrder.setPrice(orderAmount);
        int insert = userOrderMapper.insert(userOrder);
        if (insert == 1) {
            OrderVo orderVo = new OrderVo();
            orderVo.setCourse(course);
            orderVo.setPrice(orderAmount.floatValue());
            orderVo.setCount(videosId.length);
            orderVo.setOrderId(userOrder.getOrderId());
            return orderVo;
        } else {
             throw  new BdyhException(ResultEnum.ORDER_NOT_EXIST);
        }

    }

    @Override
    public APIResponse cancel(String orderId) {
        return null;
    }

    @Override
    public APIResponse finish(UserOrder order) {

        AlreadyBoughtKey alreadyBoughtKey;
        order.setPay(1);
        int i = userOrderMapper.updateByPrimaryKeySelective(order);
//        List<OrderDetail> orderDetails = orderDetailMapper.selectByOrderId(order.getOrderId());
//        for (OrderDetail orderDetail : orderDetails) {
//            alreadyBoughtKey = new AlreadyBoughtKey(order.getOpenId(), orderDetail.getVideoId())
//        }
//        alreadyBoughtKey.setCourseId();
//        return null;
        if (i == 1) {
            return APIResponse.success();
        } else {

            return APIResponse.fail("失败");
        }
    }

    @Override
    public APIResponse pay(String orderId) {
        return null;
    }

    @Override
    public UserOrder findOne(String orderId) {
        return userOrderMapper.selectByPrimaryKey(orderId);

    }

    @Override
    public UserOrder findByOpenIdAndOrderId(String openId, String orderId) {
        return userOrderMapper.selectByOpenIdAndOrderId(openId, orderId);

    }

    @Override
    public List<UserOrder> findBoughtByOpenIdandCourseId(String openId, int courseId) {
        return userOrderMapper.findBoughtByOpenIdandCourseId(openId, courseId);

    }

    @Override
    public List<UserOrder> findUnBoughtByOpenIdandCourseId(String openId, int courseId) {
        return userOrderMapper.findUnBoughtByOpenIdAndCourseId(openId, courseId);

    }

    @Override
    public List<Integer> findOrderDetailByOrderId(String orderId) {
        return orderDetailMapper.selectVideosIdByOrderId(orderId);

    }

}
