package com.bdyh.dao;

import com.bdyh.entity.UserOpinion;
import com.bdyh.entity.UserOpinionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserOpinionMapper {
    int countByExample(UserOpinionExample example);

    int deleteByExample(UserOpinionExample example);

    int deleteByPrimaryKey(Integer uoid);

    int insert(UserOpinion record);

    int insertSelective(UserOpinion record);

    List<UserOpinion> selectByExample(UserOpinionExample example);

    UserOpinion selectByPrimaryKey(Integer uoid);

    int updateByExampleSelective(@Param("record") UserOpinion record, @Param("example") UserOpinionExample example);

    int updateByExample(@Param("record") UserOpinion record, @Param("example") UserOpinionExample example);

    int updateByPrimaryKeySelective(UserOpinion record);

    int updateByPrimaryKey(UserOpinion record);
}