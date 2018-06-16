package com.bdyh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdyh.dao.UserTrackDao;
import com.bdyh.dao.UserTrackMapper;
import com.bdyh.entity.UserTrack;
import com.bdyh.entity.UserTrackExample;
import com.bdyh.entity.UserTrackVo;
import com.bdyh.entity.UserWechat;
import com.bdyh.service.UserTrackService;

@Service
public class UserTrackServiceImpl implements UserTrackService {
	
	@Autowired
	private UserTrackMapper userTrackMapper;
	
	@Autowired
	private UserTrackDao userTrackDao;

	@Override
	public void saveUserTrack(UserTrack userTrack) {
		userTrackMapper.insert(userTrack);
	}

	@Override
	public List<UserTrackVo> findUserTrack(UserWechat user) {
		
		return userTrackDao.findUserTrack(user.getOpenid());
	}

	
	@Override
	public void updateUserTrack(UserTrack userTrack) {
		userTrackMapper.updateByPrimaryKey(userTrack);
	}

	@Override
	public UserTrack findUserTrackByCourseIdAndOpenId(Integer courseId, String openid) {
		UserTrackExample userTrackExample=new UserTrackExample();
		UserTrackExample.Criteria criteria=userTrackExample.createCriteria();
		criteria.andCourseIdEqualTo(courseId);
		criteria.andOpenidEqualTo(openid);
		//这里只需使用UserTrack对象
		List<UserTrack> userTrackList=userTrackMapper.selectByExample(userTrackExample);
		if(userTrackList.size()>0){
			return userTrackList.get(0);
		}
		return null;
	}
	
}
