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

    @Select("select * from user_order  where open_id = #{openId} and order_id = #{orderId}")
    UserOrder selectByOpenIdAndOrderId(@Param("openId") String openId, @Param("orderId") String orderID);

    @Select("select * from user_order where  open_id = #{openId} and pay= 1 and course_id = #{courseId}")
    List<UserOrder> findBoughtByOpenIdandCourseId(@Param("openId") String openId, @Param("courseId") int courseId);

    @Select("select * from user_order where  open_id = #{openId} and pay= 0 and course_id = #{courseId}")
    List<UserOrder> findUnBoughtByOpenIdAndCourseId(@Param("openId") String openId, @Param("courseId") int courseId);


}