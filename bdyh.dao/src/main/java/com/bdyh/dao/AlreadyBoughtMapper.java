package com.bdyh.dao;

import com.bdyh.entity.AlreadyBoughtExample;
import com.bdyh.entity.AlreadyBoughtKey;

import java.util.List;

import com.bdyh.entity.OrderDetail;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AlreadyBoughtMapper {
    int countByExample(AlreadyBoughtExample example);

    int deleteByExample(AlreadyBoughtExample example);

    int deleteByPrimaryKey(AlreadyBoughtKey key);

    int insert(AlreadyBoughtKey record);

    int insertSelective(AlreadyBoughtKey record);

    List<AlreadyBoughtKey> selectByExample(AlreadyBoughtExample example);

    int updateByExampleSelective(@Param("record") AlreadyBoughtKey record, @Param("example") AlreadyBoughtExample example);

    int updateByExample(@Param("record") AlreadyBoughtKey record, @Param("example") AlreadyBoughtExample example);

}