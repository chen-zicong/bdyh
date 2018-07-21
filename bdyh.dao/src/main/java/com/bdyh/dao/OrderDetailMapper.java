package com.bdyh.dao;

import com.bdyh.entity.OrderDetail;
import com.bdyh.entity.OrderDetailExample;

import java.util.List;

import com.bdyh.entity.UserOrder;
import com.bdyh.entity.UserOrderAndDetail;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import retrofit2.http.PATCH;

public interface OrderDetailMapper {
    int countByExample(OrderDetailExample example);

    int deleteByExample(OrderDetailExample example);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    List<OrderDetail> selectByExample(OrderDetailExample example);

    int updateByExampleSelective(@Param("record") OrderDetail record, @Param("example") OrderDetailExample example);

    int updateByExample(@Param("record") OrderDetail record, @Param("example") OrderDetailExample example);

    @Select("select * from order_detail where  order_id =#{orderId}")
    List<OrderDetail> selectByOrderId(@Param("orderId") String orderId);

    @Select("select video_id  from order_detail where  order_id = #{orderId}")
    List<Integer> selectVideosIdByOrderId(@Param("orderId") String orderId);

    @Select("select * " +
            "   from user_order,order_detail " +
            "       where user_order.open_id=#{openId} " +
            "       and order_detail.order_id = user_order.order_id "+
            "       and pay = 0 ")
    List<UserOrderAndDetail> selectUnpayOrder(@Param("openId") String openId);


    @Select("select * " +
            "   from user_order,order_detail " +
            "       where user_order.open_id=#{openId} " +
            "       and order_detail.order_id = user_order.order_id "+
            "       and pay = 1 ")
    List<UserOrderAndDetail> selectpayOrder(@Param("openId") String openId);

  @Delete("delete from user_order where  order_id = #{orderId}")
    int deleteOrder(@Param("orderId") String orderId);
    @Delete("delete from order_detail where  order_id = #{orderId}")
  int deleteOrderDetail(@Param("orderId") String orderId);
}