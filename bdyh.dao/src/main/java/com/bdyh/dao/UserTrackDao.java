package com.bdyh.dao;

import java.util.List;

import com.bdyh.entity.UserTrackVo;

public interface UserTrackDao {

	public List<UserTrackVo> findUserTrack(String openid);
}