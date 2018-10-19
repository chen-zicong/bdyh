package com.bdyh.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.bdyh.dao.*;
import com.bdyh.entity.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdyh.service.CourseService;
import com.github.pagehelper.PageHelper;

/**
 * 课程的业务层对象实现类
 * 2018年1月15日
 *
 * @author cxs
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private UserOrderMapper userOrderMapper;

    /**
     * CourseDao为自定义的dao层接口
     */
    @Autowired
    private CourseDao courseDao;

    @Autowired
    private UserCourseMapper userCourseMapper;

    @Autowired
    private UserCollectCourseDao userCollectCourseDao;

    @Autowired
    private UserCollectCourseMapper userCollectCourseMapper;

    @Autowired
    private IncomeDao incomeDao;

    @Autowired
    private BenefitMapper benefitMapper;


    @Autowired
    private ClazzMapper clazzMapper;

    /*---------------------------------------------------------------------微信端模块--------------------------------------------------------------------*/

    /**
     * 查询三条推荐的课程
     */
    @Override
    public List<Course> findRecommandCourse() {


        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        //当recommand为1时候为推荐课程
        criteria.andCourseRecommendEqualTo(1);
        //该课程是已发布的
        criteria.andStatusEqualTo(2);
        //查询前三条，使用分页插件
        PageHelper.startPage(1, 3);
        return courseMapper.selectByExample(courseExample);
    }

    /**
     * 查询推荐的课程
     */
    @Override
    public List<Course> findAllRecommandCourse() {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        //当recommand为1时候为推荐课程
        criteria.andCourseRecommendEqualTo(1);
        //已发布
        criteria.andStatusEqualTo(2);
        return courseMapper.selectByExample(courseExample);
    }

    /**
     * 根据课程ID查询课程
     */
    @Override
    public Course findCourseById(Integer courseId) {
        return courseMapper.selectByPrimaryKey(courseId);
    }

    /**
     * 根据年级查询相应的课程
     */
    @Override
    public List<Course> findCourseByCourseLevel(Integer courseLevel) {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andCourseLevelEqualTo(courseLevel);
        //已发布
        criteria.andStatusEqualTo(2);

        return courseMapper.selectByExample(courseExample);
    }


    /**
     * 根据条件搜索相应的课程列表
     * 使用逆向工程的xml文件
     * 不能非空判断
     *
     */
	/*@Override
	public List<Course> searchCourseExample(Course course) {
		CourseExample courseExample=new CourseExample();
		CourseExample.Criteria criteria=courseExample.createCriteria();
		//当查询条件不为空时才去查询
		if(course.getCourseName()!=null && !"".equals(course.getCourseName())){
			criteria.andCourseNameLike(course.getCourseName());
		}
		if(course.getCourseRecommend()!=null){
			criteria.andCourseRecommendEqualTo(course.getCourseRecommend());
		}
		if(course.getCourseLevel()!=null){
			criteria.andCourseLevelEqualTo(course.getCourseLevel());
		}
		return courseMapper.selectByExample(courseExample);
	}*/

    /**
     * 根据条件搜索相应的课程列表
     * 使用自己写的dao层xml文件
     */
    @Override
    public List<Course> searchCourseExample(Course course) {
        return courseDao.searchCourseByExample(course);
    }

    /**
     * 根据用户openid，用户的唯一标识取出用户的课程列表
     * 使用自定义的UserCourseMapper.xml
     */
    @Override
    public List<UserCourseVo> findCourseOfUser(UserWechat user) {
        return userCourseMapper.findCourseOfUser(user.getOpenid());
    }

    @Override
    public List<UserCourseVo> findUnPayCourseOfUser(UserWechat user) {

        return userCourseMapper.findUnPayCourseOfUser(user.getOpenid());
    }

    @Override
    public List<UserCourseVo> findPayedCourseOfUser(UserWechat user) {
        return userCourseMapper.findPayedCourseOfUser(user.getOpenid());
    }

    @Override
    public List<UserCollectCourseVo> findCollectCourseOfUser(UserWechat user) {
        return userCollectCourseDao.findCollectCourseOfUser(user.getOpenid());
    }

    @Override
    public UserCollectCourse findCollectCourseByCourseIdAndOpenId(Integer courseId, String openid) {
        UserCollectCourseExample userCollectCourseExample = new UserCollectCourseExample();
        UserCollectCourseExample.Criteria criteria = userCollectCourseExample.createCriteria();
        criteria.andCourseIdEqualTo(courseId);
        criteria.andOpenidEqualTo(openid);
        List<UserCollectCourse> userCollectCourseList = userCollectCourseMapper.selectByExample(userCollectCourseExample);
        if (userCollectCourseList.size() > 0) {
            return userCollectCourseList.get(0);
        }
        return null;
    }

    /**
     * 取消收藏课程，直接删除记录
     *
     * @param openid
     * @param courseId
     */
    @Override
    public void deleteUserCollectCourseByOpenIdAndCourseId(String openid, Integer courseId) {
        UserCollectCourseExample userCollectCourseExample = new UserCollectCourseExample();
        UserCollectCourseExample.Criteria criteria = userCollectCourseExample.createCriteria();
        criteria.andOpenidEqualTo(openid);
        criteria.andCourseIdEqualTo(courseId);
        userCollectCourseMapper.deleteByExample(userCollectCourseExample);
    }


    /**
     * 收藏课程
     */
    @Override
    public void saveUserCollectCourse(UserCollectCourse userCollectCourse) {
        userCollectCourseMapper.insert(userCollectCourse);
    }
    /*-----------------------------------------------------------------------微信端模块-----------------------------------------------------------------*/
    /*-----------------------------------------------------------------------后台模块------------------------------------------------------------------*/

    /**
     * 不分页 查询教师所属的课程列表
     */
    @Override
    public List<Course> findCourseOfTeacher(Integer teacherId) {

        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andTeacherIdEqualTo(teacherId);
        List<Course> courseList = courseMapper.selectByExample(courseExample);
        return courseList;
    }

    @Override
    public void updateCourse(Course course) {
        courseMapper.updateByPrimaryKeySelective(course);
    }

    @Override
    public void saveCourse(Course course) {
        courseMapper.insert(course);
    }

    @Override
    public void deleteCourseByCourseId(Integer courseId) {
        courseMapper.deleteByPrimaryKey(courseId);
    }

    /**
     * 所有已审核课程
     */
    @Override
    public List<Course> findAllAuditCourse() {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andStatusEqualTo(2);
        List<Course> courseList = courseMapper.selectByExample(courseExample);
        return courseList;
    }

    /**
     * 所有未审核课程
     */
    @Override
    public List<Course> findAllUnAuditCourse() {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andStatusEqualTo(1);
        List<Course> courseList = courseMapper.selectByExample(courseExample);
        return courseList;
    }

    /**
     * 所有课程
     */
    @Override
    public List<Course> findAllCourse() {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andCourseIdIsNotNull();
        List<Course> courseList = courseMapper.selectByExample(courseExample);
        return courseList;
    }

    /**
     * 收藏一次以上
     */
    @Override
    public List<Course> findAllCourseBeenCollected() {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andCollectNumberNotEqualTo(0);
        List<Course> courseList = courseMapper.selectByExample(courseExample);
        return courseList;
    }

    /**
     * 浏览一次以上
     */
    @Override
    public List<Course> findAllCourseBeenFlowed() {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andFlowNumberNotEqualTo(0);
        List<Course> courseList = courseMapper.selectByExample(courseExample);
        return courseList;
    }

    @Override
    public List<IncomeStatisticsVo> findSoldCourseOfTeacher(Integer teacherId) {
        List<IncomeStatisticsVo> incomeStatisticsVoList = new ArrayList<>();
        List<Course> courses = courseMapper.selectAllCourseByTeacherId(teacherId);
        if (courses != null && courses.size() != 0) {
            for (Course course : courses) {
                List<String> orderIds = userCourseMapper.selectOrderIdByCourseId(course.getCourseId());
                if (orderIds.size() != 0) {
                    IncomeStatisticsVo incomeStatisticsVo = benefitMapper.selectBenefitByOrderId(orderIds);
                    BeanUtils.copyProperties(course, incomeStatisticsVo);
                    incomeStatisticsVoList.add(incomeStatisticsVo);
                } else {
                    IncomeStatisticsVo incomeStatisticsVo = new IncomeStatisticsVo();
                    BeanUtils.copyProperties(course, incomeStatisticsVo);
                    incomeStatisticsVo.setCount(0);
                    incomeStatisticsVo.setTeacherBenefit(new BigDecimal(BigInteger.ZERO));
                }
            }
        }
        return incomeStatisticsVoList;
    }

    @Override
    public List<IncomeStatisticsVo> findSoldCourseOfAgent(Integer agentId) {
//        CourseExample courseExample = new CourseExample();
//        CourseExample.Criteria criteria = courseExample.createCriteria();
//        criteria.andTeacherIdEqualTo(teacherId);
        //  criteria.andBenefitNotEqualTo(0.0);
        List<IncomeStatisticsVo> incomeStatisticsVos = incomeDao.selectByAgentId(agentId);
        return incomeStatisticsVos;
    }

    @Override
    public int addOrder(UserOrder userOrder) {
        return userOrderMapper.insert(userOrder);

    }

    @Override
    public List<Course> findCollectedCourseOfTeacher(Integer teacherId) {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andTeacherIdEqualTo(teacherId);
        criteria.andCollectNumberNotEqualTo(0);
        return courseMapper.selectByExample(courseExample);
    }

    @Override
    public List<Course> findFlowedCourseOfTeacher(Integer teacherId) {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andTeacherIdEqualTo(teacherId);
        criteria.andFlowNumberNotEqualTo(0);
        return courseMapper.selectByExample(courseExample);
    }

    @Override
    public List<Course> findFlowedCourseOfAgent(Integer agentId) {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andAgentIdEqualTo(agentId);
        criteria.andFlowNumberNotEqualTo(0);
        return courseMapper.selectByExample(courseExample);
    }

    @Override
    public List<Course> findAuditCourseByAgentId(Integer agentId) {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andAgentIdEqualTo(agentId).andStatusEqualTo(2);
        return courseMapper.selectByExample(courseExample);
    }

    @Override
    public List<Course> findUnAuditCourseByAgentId(Integer agentId) {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andAgentIdEqualTo(agentId).andStatusEqualTo(1);
        return courseMapper.selectByExample(courseExample);
    }


    public UserCourse findUserCourseByOpenIdAndCourseId(String openId, Integer courseId) {
        UserCourseExample userCourseExample = new UserCourseExample();
        UserCourseExample.Criteria criteria = userCourseExample.createCriteria();
        criteria.andOpenidEqualTo(openId).andCourseIdEqualTo(courseId);
        List<UserCourse> userCourses = userCourseMapper.selectByExample(userCourseExample);
        if (userCourses.size() != 0) {
            return userCourses.get(0);
        }
        return null;
    }

    public int insertUserCourse(UserCourse userCourse) {
        UserCourseExample userCourseExample = new UserCourseExample();
        UserCourseExample.Criteria criteria = userCourseExample.createCriteria();
        return userCourseMapper.insert(userCourse);
    }

    public UserCourse findUserCourseByOpenIdAndCourseId(String openId, String tradeNo) {
        UserCourseExample userCourseExample = new UserCourseExample();
        UserCourseExample.Criteria criteria = userCourseExample.createCriteria();
        criteria.andOpenidEqualTo(openId).andTradeNoEqualTo(tradeNo);
        List<UserCourse> userCourses = userCourseMapper.selectByExample(userCourseExample);
        if (userCourses.size() != 0) {
            return userCourses.get(0);
        }
        return null;
    }

    public int updataUserCourse(UserCourse userCourse) {
        UserCourseExample userCourseExample = new UserCourseExample();
        UserCourseExample.Criteria criteria = userCourseExample.createCriteria();
        criteria.andCourseIdEqualTo(userCourse.getCourseId()).andOpenidEqualTo(userCourse.getOpenid());
        return userCourseMapper.updateByExampleSelective(userCourse, userCourseExample);

    }

    public Float benefitOfTeacher(Integer id) {
        TeacherIncomeExample teacherIncomeExample = new TeacherIncomeExample();
        TeacherIncomeExample.Criteria criteria = teacherIncomeExample.createCriteria();
        Float income = incomeDao.selectIncomeByTeacherId(id);
        return income;
    }


    public boolean checkIfItIsOpen(Integer courseLevel) {
        ClazzExample clazzExample = new ClazzExample();
        ClazzExample.Criteria criteria = clazzExample.createCriteria();
        criteria.andClazzIdEqualTo(courseLevel).andStatusEqualTo(1);
        List<Clazz> clazzes = clazzMapper.selectByExample(clazzExample);
        return clazzes.size() > 0;
    }


    public int setCourseDown(int clazzId) {
        return courseMapper.updateByClazz(clazzId, 0);
    }

    public int setCourseUp(int clazzId) {
        return courseMapper.updateByClazz(clazzId, 1);
    }


    public int findByCourseName(String courseName) {
        ClazzExample clazzExample = new ClazzExample();
        ClazzExample.Criteria criteria = clazzExample.createCriteria();
        criteria.andClazzEqualTo(courseName);
        List<Clazz> clazzes = clazzMapper.selectByExample(clazzExample);
        return clazzes.get(0).getClazzId();
    }
    /*-----------------------------------------------------------------------后台模块------------------------------------------------------------------*/


}
