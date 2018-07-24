package com.bdyh.service;

import java.util.List;

import com.bdyh.entity.OrderDetail;
import com.bdyh.entity.Video;

public interface VideoService {

    public List<Video> findVideoByCourseId(Integer courseId);

    public void saveVideo(Video newVideo);

    public Video findVideoById(Integer videoId);

    List<Video> findBoughtVideo(List<Integer> videos);

}
