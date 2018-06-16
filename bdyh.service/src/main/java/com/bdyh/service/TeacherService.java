package com.bdyh.service;

import java.util.List;

import com.bdyh.entity.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TeacherService {

    public Teacher findTeacherById(Integer teacherId);

    public List<UserCollectTeacherVo> findCollectTeacherOfUser(UserWechat user);

    public UserCollectTeacher findCollectTeacherByTeacherIdAndOpenId(Integer teacherId, String openid);

    public void saveUserCollectTeacher(UserCollectTeacher userCollectTeacher);

    public void deleteUserCollectTeacherByOpenIdAndCourseId(String openid, Integer teacherId);

    public Teacher findTeacherByUsername(String username);

    public List<Teacher> findAllTeacher();

    public void saveTeacher(Teacher teacher);

    public void updateTeacher(Teacher teacher);

    public void deleteTeacherById(Integer teacherId);

    public List<Teacher> findAllTeacherBeenCollected();

    public List<Teacher> findTeacherByProvince(Integer provinceId);

    public List<Teacher> findTeacherByCity(Integer cityId);

    public List<Teacher> findTeacherByDistrict(Integer districtId);

    public List<Teacher> findTeacherByAgent(Integer AgentId);

    public TeacherIncome findTeacherIncome(int courseId, int teacherId);

    public int addTeacherIncome(TeacherIncome teacherIncome);

    public int updateTeacherIncome(TeacherIncome teacherIncome);

    public TeacherIncome findTeacherIncomeByTeacherId(int teacherId);

}
