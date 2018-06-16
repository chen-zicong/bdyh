package com.bdyh.service.impl;

import java.util.List;

import com.bdyh.dao.TeacherIncomeMapper;
import com.bdyh.dao.TeacherMapper;
import com.bdyh.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdyh.dao.UserCollectTeacherDao;
import com.bdyh.dao.UserCollectTeacherMapper;
import com.bdyh.service.TeacherService;

/**
 * 2018年1月17日
 *
 * @author cxs
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private UserCollectTeacherDao userCollectTeacherDao;

    @Autowired
    private UserCollectTeacherMapper userCollectTeacherMapper;

    @Autowired
    private TeacherIncomeMapper teacherIncomeMapper;

    /*-------------------------------------------------------------------微信端模块---------------------------------------------------------------------------*/
    @Override
    public Teacher findTeacherById(Integer teacherId) {
        return teacherMapper.selectByPrimaryKey(teacherId);
    }

    @Override
    public List<UserCollectTeacherVo> findCollectTeacherOfUser(UserWechat user) {
        return userCollectTeacherDao.findCollectTeacherOfUser(user.getOpenid());
    }

    @Override
    public UserCollectTeacher findCollectTeacherByTeacherIdAndOpenId(Integer teacherId, String openid) {
        UserCollectTeacherExample userCollectTeacherExample = new UserCollectTeacherExample();
        UserCollectTeacherExample.Criteria criteria = userCollectTeacherExample.createCriteria();
        criteria.andTeacherIdEqualTo(teacherId);
        criteria.andOpenidEqualTo(openid);
        List<UserCollectTeacher> userCollectTeacherList = userCollectTeacherMapper.selectByExample(userCollectTeacherExample);
        if (userCollectTeacherList.size() > 0) {
            return userCollectTeacherList.get(0);
        }
        return null;
    }

    /**
     * 收藏教师
     */
    @Override
    public void saveUserCollectTeacher(UserCollectTeacher userCollectTeacher) {
        userCollectTeacherMapper.insert(userCollectTeacher);
    }

    /**
     * 取消收藏教师
     */
    @Override
    public void deleteUserCollectTeacherByOpenIdAndCourseId(String openid, Integer teacherId) {
        UserCollectTeacherExample userCollectTeacherExample = new UserCollectTeacherExample();
        UserCollectTeacherExample.Criteria criteria = userCollectTeacherExample.createCriteria();
        criteria.andOpenidEqualTo(openid);
        criteria.andTeacherIdEqualTo(teacherId);
        userCollectTeacherMapper.deleteByExample(userCollectTeacherExample);

    }


    /*-------------------------------------------------------------------后台模块---------------------------------------------------------------------------*/

    /**
     * 根据用户名查询教师
     */
    @Override
    public Teacher findTeacherByUsername(String username) {
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<Teacher> teacherList = teacherMapper.selectByExample(teacherExample);
        if (teacherList != null && teacherList.size() > 0) {
            return teacherList.get(0);
        }
        return null;
    }

    /**
     * 查询所有教师对象
     */
    @Override
    public List<Teacher> findAllTeacher() {
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        criteria.andTeacherIdIsNotNull();
        return teacherMapper.selectByExample(teacherExample);
    }

    /**
     * 保存教师
     */
    @Override
    public void saveTeacher(Teacher teacher) {
        teacherMapper.insert(teacher);
    }

    /**
     * 更新教师信息
     */
    @Override
    public void updateTeacher(Teacher teacher) {
        teacherMapper.updateByPrimaryKeySelective(teacher);
    }

    /**
     * 删除教师
     */
    @Override
    public void deleteTeacherById(Integer teacherId) {
        teacherMapper.deleteByPrimaryKey(teacherId);
    }

    /**
     * 查询所有收藏不只一次的教师
     */
    @Override
    public List<Teacher> findAllTeacherBeenCollected() {
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        criteria.andCollectNumberNotEqualTo(0);
        return teacherMapper.selectByExample(teacherExample);
    }

    /**
     * 查询省级代理以下的老师
     *
     * @return
     */
    @Override
    public List<Teacher> findTeacherByProvince(Integer provinceId) {
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        criteria.andProvinceIdEqualTo(provinceId);
        return teacherMapper.selectByExample(teacherExample);
    }

    /**
     * 查询市级代理以下的老师
     *
     * @return
     */
    @Override
    public List<Teacher> findTeacherByCity(Integer cityId) {
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        criteria.andCityIdEqualTo(cityId);
        return teacherMapper.selectByExample(teacherExample);
    }

    /**
     * 查询县级代理以下的老师
     *
     * @return
     */
    @Override
    public List<Teacher> findTeacherByDistrict(Integer districtId) {
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        criteria.andDistrictIdEqualTo(districtId);
        return teacherMapper.selectByExample(teacherExample);
    }

    @Override
    public List<Teacher> findTeacherByAgent(Integer agentId) {
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        criteria.andAgentIdEqualTo(agentId);
        return teacherMapper.selectByExample(teacherExample);
    }

    @Override
    public TeacherIncome findTeacherIncome(int courseId, int teacherId) {
        TeacherIncomeExample teacherIncomeExample = new TeacherIncomeExample();
        TeacherIncomeExample.Criteria criteria = teacherIncomeExample.createCriteria();
        criteria.andCourseIdEqualTo(courseId).andTeacherIdEqualTo(teacherId);
        List<TeacherIncome> teacherIncomes = teacherIncomeMapper.selectByExample(teacherIncomeExample);
        if (teacherIncomes.size() > 0) {
            return teacherIncomes.get(0);
        }
        return null;

    }

    public int addTeacherIncome(TeacherIncome teacherIncome) {
        TeacherIncomeExample teacherIncomeExample = new TeacherIncomeExample();
        return teacherIncomeMapper.insert(teacherIncome);

    }

    public int updateTeacherIncome(TeacherIncome teacherIncome) {
        TeacherIncomeExample teacherIncomeExample = new TeacherIncomeExample();
        TeacherIncomeExample.Criteria criteria = teacherIncomeExample.createCriteria();
        criteria.andCourseIdEqualTo(teacherIncome.getCourseId()).andTeacherIdEqualTo(teacherIncome.getTeacherId());
        return teacherIncomeMapper.updateByExampleSelective(teacherIncome, teacherIncomeExample);
    }

    public TeacherIncome findTeacherIncomeByTeacherId(int teacherId) {
        TeacherIncomeExample teacherIncomeExample = new TeacherIncomeExample();
        TeacherIncomeExample.Criteria criteria = teacherIncomeExample.createCriteria();
        criteria.andTeacherIdEqualTo(teacherId);
        List<TeacherIncome> teacherIncomes = teacherIncomeMapper.selectByExample(teacherIncomeExample);
        if (teacherIncomes.size() > 0) {
            return teacherIncomes.get(0);
        }
        return null;
    }

}
