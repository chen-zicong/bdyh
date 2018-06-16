package com.bdyh.dao;

import com.bdyh.entity.UserWechat;
import com.bdyh.entity.UserWechatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserWechatMapper {
    int countByExample(UserWechatExample example);

    int deleteByExample(UserWechatExample example);

    int deleteByPrimaryKey(String openid);

    int insert(UserWechat record);

    int insertSelective(UserWechat record);

    List<UserWechat> selectByExample(UserWechatExample example);

    UserWechat selectByPrimaryKey(String openid);

    int updateByExampleSelective(@Param("record") UserWechat record, @Param("example") UserWechatExample example);

    int updateByExample(@Param("record") UserWechat record, @Param("example") UserWechatExample example);

    int updateByPrimaryKeySelective(UserWechat record);

    int updateByPrimaryKey(UserWechat record);
}