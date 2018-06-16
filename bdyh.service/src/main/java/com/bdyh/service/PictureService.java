package com.bdyh.service;

import java.util.List;

import com.bdyh.entity.HomePicture;

public interface PictureService {

	public List<HomePicture> findAllHomePicture();

	public void saveHomePicture(HomePicture homePicture);

	public HomePicture findHomePictureById(Integer pictureId);

	public void updateHomePicture(HomePicture homePicture);

	public void deleteCourseByCourseId(Integer pictureId);

	public List<HomePicture> findHomePictureRelease();

}
