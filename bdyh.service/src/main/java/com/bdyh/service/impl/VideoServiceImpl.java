 package com.bdyh.service.impl;

import java.util.List;

import com.bdyh.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdyh.dao.VideoMapper;
import com.bdyh.entity.Video;
import com.bdyh.entity.VideoExample;
import com.bdyh.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService{

	@Autowired
	private VideoMapper videoMapper;
	
	@Override
	public List<Video> findVideoByCourseId(Integer courseId) {
		VideoExample videoExample=new VideoExample();
		VideoExample.Criteria criteria=videoExample.createCriteria();
		criteria.andCourseIdEqualTo(courseId);
		return videoMapper.selectByExample(videoExample);
	}
	/**
	 * 保存视频记录
	 */
	@Override
	public void saveVideo(Video newVideo) {
		videoMapper.insert(newVideo);
	}
	@Override
	public Video findVideoById(Integer videoId) {
		return videoMapper.selectByPrimaryKey(videoId);
	}
	
}
