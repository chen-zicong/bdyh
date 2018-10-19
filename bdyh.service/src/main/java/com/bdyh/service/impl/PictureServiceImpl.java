package com.bdyh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdyh.dao.HomePictureMapper;
import com.bdyh.entity.HomePicture;
import com.bdyh.entity.HomePictureExample;
import com.bdyh.service.PictureService;

/**
 * banner图的管理实现类
 * 2018年2月2日
 * @author cxs
 */
@Service
public class PictureServiceImpl implements PictureService {
	
	@Autowired 
	private HomePictureMapper homePictureMapper;

	/**
	 * 查询所有轮播图
	 */
	@Override
	public List<HomePicture> findAllHomePicture() {
		HomePictureExample homePictureExample=new HomePictureExample();
		HomePictureExample.Criteria criteria=homePictureExample.createCriteria();
		//查询出所有的轮播图
		criteria.andStatusIsNotNull();
		List<HomePicture> homePictureList=homePictureMapper.selectByExample(homePictureExample);
		return homePictureList;
	}

	@Override
	public void saveHomePicture(HomePicture homePicture) {
		homePictureMapper.insert(homePicture);
	}

	@Override
	public HomePicture findHomePictureById(Integer pictureId) {
		return homePictureMapper.selectByPrimaryKey(pictureId);
	}

	@Override
	public void updateHomePicture(HomePicture homePicture) {
		homePictureMapper.updateByPrimaryKey(homePicture);
	}

	@Override
	public void deleteCourseByCourseId(Integer pictureId) {
		homePictureMapper.deleteByPrimaryKey(pictureId);
	}
	/**
	 * 查询所有发布的轮播图
	 */
	@Override
	public List<HomePicture> findHomePictureRelease() {
		HomePictureExample homePictureExample=new HomePictureExample();
		HomePictureExample.Criteria criteria=homePictureExample.createCriteria();
		criteria.andStatusEqualTo(1);
		return homePictureMapper.selectByExample(homePictureExample);
	}

    @Override
    public int batchDeletePicture(int [] pictureIds) {

		return homePictureMapper.deleteList(pictureIds);
    }


}
