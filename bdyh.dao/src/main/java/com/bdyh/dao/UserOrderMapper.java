package com.bdyh.dao;

import com.bdyh.entity.UserOrder;
import com.bdyh.entity.UserOrderExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserOrderMapper {
    int countByExample(UserOrderExample example);

    int deleteByExample(UserOrderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(UserOrder record);

    int insertSelective(UserOrder record);

    List<UserOrder> selectByExample(UserOrderExample example);

    UserOrder selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") UserOrder record, @Param("example") UserOrderExample example);

    int updateByExample(@Param("record") UserOrder record, @Param("example") UserOrderExample example);

    int updateByPrimaryKeySelective(UserOrder record);

    int updateByPrimaryKey(UserOrder record);

    @Select("select * from user_order where open_id =#{openId} and orderId = #{order_id}")
    UserOrder selectByOpenIdAndOrderId(@Param("openId") String openId, @Param("orderId") String orderId);
}