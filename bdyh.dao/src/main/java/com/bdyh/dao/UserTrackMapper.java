package com.bdyh.dao;

import com.bdyh.entity.UserTrack;
import com.bdyh.entity.UserTrackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserTrackMapper {
    int countByExample(UserTrackExample example);

    int deleteByExample(UserTrackExample example);

    int deleteByPrimaryKey(Integer utid);

    int insert(UserTrack record);

    int insertSelective(UserTrack record);

    List<UserTrack> selectByExample(UserTrackExample example);

    UserTrack selectByPrimaryKey(Integer utid);

    int updateByExampleSelective(@Param("record") UserTrack record, @Param("example") UserTrackExample example);

    int updateByExample(@Param("record") UserTrack record, @Param("example") UserTrackExample example);

    int updateByPrimaryKeySelective(UserTrack record);

    int updateByPrimaryKey(UserTrack record);
}