package com.bdyh.dao;

import com.bdyh.entity.Benefit;
import com.bdyh.entity.BenefitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BenefitMapper {
    int countByExample(BenefitExample example);

    int deleteByExample(BenefitExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(Benefit record);

    int insertSelective(Benefit record);

    List<Benefit> selectByExample(BenefitExample example);

    Benefit selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") Benefit record, @Param("example") BenefitExample example);

    int updateByExample(@Param("record") Benefit record, @Param("example") BenefitExample example);

    int updateByPrimaryKeySelective(Benefit record);

    int updateByPrimaryKey(Benefit record);
}