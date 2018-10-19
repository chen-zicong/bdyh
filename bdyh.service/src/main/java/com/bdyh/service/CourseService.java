package com.bdyh.service;

import java.util.List;

import com.bdyh.entity.*;

/**
 * 课程的业务层对象接口
 * 2018年1月15日
 *
 * @author cxs
 */
public interface CourseService {

    public List<Course> findRecommandCourse();

    public List<Course> findAllRecommandCourse();

    public Course findCourseById(Integer courseId);

    public List<Course> findCourseByCourseLevel(Integer courseLevel);

    public List<Course> searchCourseExample(Course course);

    public List<UserCourseVo> findCourseOfUser(UserWechat user);

    public List<UserCourseVo> findUnPayCourseOfUser(UserWechat user);

    public List<UserCourseVo> findPayedCourseOfUser(UserWechat user);

    public List<UserCollectCourseVo> findCollectCourseOfUser(UserWechat user);

    public UserCollectCourse findCollectCourseByCourseIdAndOpenId(Integer courseId, String openid);

    public void deleteUserCollectCourseByOpenIdAndCourseId(String openid, Integer courseId);

    public void saveUserCollectCourse(UserCollectCourse userCollectCourse);

    public List<Course> findCourseOfTeacher(Integer teacherId);

    public void updateCourse(Course course);

    public void saveCourse(Course course);

    public void deleteCourseByCourseId(Integer courseId);

    public List<Course> findAllAuditCourse();

    public List<Course> findAllUnAuditCourse();

    public List<Course> findAllCourse();

    public List<Course> findAllCourseBeenCollected();

    public List<Course> findAllCourseBeenFlowed();

    public List<IncomeStatisticsVo> findSoldCourseOfTeacher(Integer teacherId);

    public List<Course> findCollectedCourseOfTeacher(Integer teacherId);

    public List<Course> findFlowedCourseOfTeacher(Integer teacherId);

    public List<Course> findAuditCourseByAgentId(Integer agentId);

    public List<Course> findUnAuditCourseByAgentId(Integer agentId);

    public UserCourse findUserCourseByOpenIdAndCourseId(String openId, Integer courseId);

    public int insertUserCourse(UserCourse userCourse);

    public UserCourse findUserCourseByOpenIdAndCourseId(String openId, String tradeNo);

    public int updataUserCourse(UserCourse userCourse);

    public Float benefitOfTeacher(Integer id);

    public List<Course> findFlowedCourseOfAgent(Integer agentId);

    public List<IncomeStatisticsVo> findSoldCourseOfAgent(Integer agentId);

    public int addOrder(UserOrder userOrder);

    public boolean checkIfItIsOpen(Integer courseLevel);

    public int setCourseDown(int ClazzName);

    public int setCourseUp(int clazzName);

    int findByCourseName(String courseName);

}
