package com.bdyh.dao;

import com.bdyh.entity.PaidVideos;
import com.bdyh.entity.UserOrderAndDetail;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserOrderDao {


    List<UserOrderAndDetail> selectUnpayOrder(@Param("openId") String openId);



    List<UserOrderAndDetail> selectpayOrder(@Param("openId") String openId);

    UserOrderAndDetail findPiadOrder(String orderId);
}
