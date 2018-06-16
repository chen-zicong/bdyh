package com.bdyh.service;

import java.util.List;

import com.bdyh.entity.UserTrack;
import com.bdyh.entity.UserTrackVo;
import com.bdyh.entity.UserWechat;

public interface UserTrackService {

	public void saveUserTrack(UserTrack userTrack);

	public List<UserTrackVo> findUserTrack(UserWechat user);

	public void updateUserTrack(UserTrack userTrack);

	public UserTrack findUserTrackByCourseIdAndOpenId(Integer courseId, String openid);

}
