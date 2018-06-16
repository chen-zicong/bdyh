package com.bdyh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdyh.dao.UserOpinionDao;
import com.bdyh.dao.UserOpinionMapper;
import com.bdyh.entity.UserOpinion;
import com.bdyh.entity.UserOpinionVo;
import com.bdyh.service.OpinionService;
/**
 * 管理员操作意见service
 * 2018年2月3日
 * @author cxs
 */
@Service
public class OpinionServiceImpl implements OpinionService {

	@Autowired
	private UserOpinionMapper userOpinionMapper;
	
	@Autowired
	private UserOpinionDao userOpinionDao;
	
	@Override
	public void saveOpinion(UserOpinion userOpinion) {
		userOpinionMapper.insert(userOpinion);
	}

	@Override
	public List<UserOpinionVo> findAllOpinionOfUsers() {
		List<UserOpinionVo> userOpinionList=userOpinionDao.findAllOpinionOfUsers();
		return userOpinionList;
	}
	/**
	 * 管理员删除意见反馈
	 */
	@Override
	public void deleteUserOpinionById(Integer uoid) {
		userOpinionMapper.deleteByPrimaryKey(uoid);
	}
	
}
