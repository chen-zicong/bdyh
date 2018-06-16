package com.bdyh.dao;

import com.bdyh.entity.WeAccess;
import com.bdyh.entity.WeAccessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeAccessMapper {
    int countByExample(WeAccessExample example);

    int deleteByExample(WeAccessExample example);

    int deleteByPrimaryKey(String openId);

    int insert(WeAccess record);

    int insertSelective(WeAccess record);

    List<WeAccess> selectByExample(WeAccessExample example);

    WeAccess selectByPrimaryKey(String openId);

    int updateByExampleSelective(@Param("record") WeAccess record, @Param("example") WeAccessExample example);

    int updateByExample(@Param("record") WeAccess record, @Param("example") WeAccessExample example);

    int updateByPrimaryKeySelective(WeAccess record);

    int updateByPrimaryKey(WeAccess record);
}