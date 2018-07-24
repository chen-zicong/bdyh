package com.bdyh.service.impl;

import com.bdyh.common.APIResponse;
import com.bdyh.common.Util;
import com.bdyh.dao.*;
import com.bdyh.entity.*;
import com.bdyh.service.CourseService;
import com.bdyh.service.OrderService;
import com.bdyh.service.TeacherService;
import com.bdyh.service.VideoService;
import com.bdyh.common.enums.ResultEnum;
import com.bdyh.common.exception.BdyhException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    @Autowired
    private UserOrderDao userOrderDao;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private BenefitMapper benefitMapper;

    @Autowired
    private AgentDivideMapper agentDivideMapper;

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
            throw new BdyhException(ResultEnum.ORDER_NOT_EXIST);
        }

    }

    @Override
    public APIResponse cancel(String orderId) {
        int result = orderDetailMapper.deleteOrder(orderId);
        int i = orderDetailMapper.deleteOrderDetail(orderId);
        if (result > 0 && i>0) {
            return APIResponse.success();
        } else {
            return APIResponse.fail("取消订单失败");
        }

    }

    @Override
    public APIResponse finish(UserOrder order) {
        Course course = courseService.findCourseById(order.getCourseId());
//        TeacherIncome teacherIncome = teacherService.findTeacherIncome(order.getCourseId(), course.getTeacherId());
        List<Integer> videosID = orderDetailMapper.selectVideosIdByOrderId(order.getOrderId());
        AgentDivide one = agentDivideMapper.findOne(course.getAgentId(), course.getTeacherId());

       if (benefitMapper.selectByPrimaryKey(order.getOrderId())==null){
            Benefit benefit = new Benefit();
            benefit.setAgentId(one.getAgentId());
            benefit.setTeacherId(one.getTeacherId());
            benefit.setTeacherBenefit(order.getPrice().multiply(new BigDecimal((float)one.getDivide()/100)));
            benefit.setAgentBenefit(order.getPrice().subtract(benefit.getTeacherBenefit()));
            benefit.setCount(videosID.size());
            benefit.setDate(new Date());
            benefit.setOrderId(order.getOrderId());
           int insert = benefitMapper.insert(benefit);
           if (insert == 0) {
               throw new BdyhException(ResultEnum.ORDER_UPDATE_FAIL);
           }
        }
//        AlreadyBoughtKey alreadyBoughtKey;
        order.setPay(1);

        int i = userOrderMapper.updateByPrimaryKeySelective(order);
        if(i==0){
            throw new BdyhException(ResultEnum.ORDER_UPDATE_FAIL);
        }


        return APIResponse.success();

//

    }

    @Override
    public APIResponse pay(String orderId) {
        return null;
    }

    /* 通过订单号找到已经支付的所有的videosId和courseId*/
    @Override
    public UserOrderAndDetail findPaid(String orderId) {
        return userOrderDao.findPiadOrder(orderId);

    }

    @Override
    public UserOrder findByOpenIdAndOrderId(String openId, String orderId) {
        return userOrderMapper.selectByOpenIdAndOrderId(openId, orderId);

    }

    /*找到该课程已经购买的所有的order*/
    @Override
    public List<UserOrder> findBoughtByOpenIdandCourseId(String openId, int courseId) {
        return userOrderMapper.findBoughtByOpenIdandCourseId(openId, courseId);

    }

    /*找到该课程未购买的所有的order*/
    @Override
    public List<UserOrder> findUnBoughtByOpenIdandCourseId(String openId, int courseId) {
        return userOrderMapper.findUnBoughtByOpenIdAndCourseId(openId, courseId);

    }

    /*通过orderId找到videos数组*/
    @Override
    public List<Integer> findOrderDetailByOrderId(String orderId) {
        return orderDetailMapper.selectVideosIdByOrderId(orderId);

    }

    @Override
    public OrderVo findOne(String orderId) {
        UserOrder order = userOrderMapper.selectByPrimaryKey(orderId);
        List<OrderDetail> orderDetails = orderDetailMapper.selectByOrderId(orderId);
        Course course = courseService.findCourseById(order.getCourseId());
        OrderVo orderVo = new OrderVo();
        orderVo.setOrderId(orderId);
        orderVo.setPrice(order.getPrice().floatValue());
        orderVo.setCourse(course);
        orderVo.setCount(orderDetails.size());
        return orderVo;
    }

    @Override
    public UserOrder findUserOrder(String orderId) {
        return userOrderMapper.selectByPrimaryKey(orderId);

    }

    /*找到该用户的所有的未支付的订单*/
    public List<UnPayOrder> findUnpayOrderByOpenId(String openId) {
        List<UserOrderAndDetail> userOrderAndDetails = userOrderDao.selectUnpayOrder(openId);
        UnPayOrder unPayOrder;
        Course course;
        List<UnPayOrder> unPayOrderList = new ArrayList<>();
        for (UserOrderAndDetail userOrderAndDetail : userOrderAndDetails) {


            unPayOrder = new UnPayOrder();
            course = courseService.findCourseById(userOrderAndDetail.getCourseId());
            unPayOrder.setCourse(course);
            unPayOrder.setCount(userOrderAndDetail.getOrderDetail().size());
            unPayOrder.setOrderId(userOrderAndDetail.getOrderId());
            unPayOrder.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(userOrderAndDetail.getDate()));
            unPayOrder.setPrice(userOrderAndDetail.getPrice().floatValue());
            unPayOrderList.add(unPayOrder);
        }
        return unPayOrderList;
    }

    public List<PayOrder> findpayOrderByOpenId(String openId) {
        List<UserOrderAndDetail> userOrderAndDetails = userOrderDao.selectpayOrder(openId);
        PayOrder payOrder;
        Course course;
        List<PayOrder> payOrderList = new ArrayList<>();
        for (UserOrderAndDetail userOrderAndDetail : userOrderAndDetails) {

            payOrder = new PayOrder();
            course = courseService.findCourseById(userOrderAndDetail.getCourseId());
            payOrder.setCourse(course);
            payOrder.setCount(userOrderAndDetail.getOrderDetail().size());
            payOrder.setOrderId(userOrderAndDetail.getOrderId());
            payOrder.setDate(userOrderAndDetail.getDate());
            payOrder.setPrice(userOrderAndDetail.getPrice().floatValue());
            payOrderList.add(payOrder);
        }
        return payOrderList;
    }

}
