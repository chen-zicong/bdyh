package com.bdyh.dao;

import com.bdyh.entity.OrderDetail;
import com.bdyh.entity.OrderDetailExample;

import java.util.List;

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

    @Select("select * form detail where  orderId =#{orderId}")
    List<OrderDetail> selectByOrderId(@Param("orderId") String orderId);
    @Select("select video_id  from order_detail where  order_id = #{orderId}")
    List<Integer> selectVideosIdByOrderId(@Param("orderId") String orderId);

}