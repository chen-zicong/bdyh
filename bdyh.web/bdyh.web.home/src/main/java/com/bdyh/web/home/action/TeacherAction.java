package com.bdyh.web.home.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.bdyh.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bdyh.entity.UserCollectTeacher;
import com.bdyh.entity.UserCollectTeacherVo;
import com.bdyh.entity.UserWechat;
import com.bdyh.service.TeacherService;

/**
 * 教师的Controller
 * 2018年1月16日
 * @author cxs
 */
@Controller
@RequestMapping(value = "teacher")
public class TeacherAction {
	
	@Autowired
	private TeacherService teacherService;
	
	@GetMapping(value="collectTeacher")
	public String collectTeacher(HttpSession session,Model model){
		//从session范围中取出用户信息
		UserWechat user=(UserWechat)session.getAttribute("user");
		//暂时不使用缓存，或者当用户点击收藏某教师时或取消收藏教师时根据openid删除缓存
		//TODO 使用缓存
		List<UserCollectTeacherVo> userCollectTeacherList=teacherService.findCollectTeacherOfUser(user);
		
		model.addAttribute("userCollectTeacherList", userCollectTeacherList);
		//TODO 跳转到页面前应先判断userCollectCourseList为不为空,如果为空，在页面显示没有符合条件的课程
		return "wechat/lecturer/list";
		
	}
	
	/**
	 * 取消收藏教师
	 * @param session
	 * @throws Exception
	 */
	@RequestMapping(value="cancelCollectTeacher")
	public void cancelCollect(HttpSession session,Integer teacherId) throws Exception{
		//从session范围中取出用户信息
		UserWechat user=(UserWechat)session.getAttribute("user");
		teacherService.deleteUserCollectTeacherByOpenIdAndCourseId(user.getOpenid(),teacherId);
		
		//取消收藏-1
		Teacher teacher=teacherService.findTeacherById(teacherId);
		teacher.setCollectNumber(teacher.getCollectNumber()-1);
		teacherService.updateTeacher(teacher);
	}
	
	/**
	 * 收藏教师
	 * @param session

	 * @throws Exception
	 */
	@RequestMapping(value="collectTeacher")
	public void collectCourse(HttpSession session,Integer teacherId) throws Exception{
		//从session范围中取出用户信息
		UserWechat user=(UserWechat)session.getAttribute("user");
		
		//创建用户收藏课程对象
		UserCollectTeacher userCollectTeacher=new UserCollectTeacher();
		userCollectTeacher.setOpenid(user.getOpenid());
		userCollectTeacher.setTeacherId(teacherId);
		teacherService.saveUserCollectTeacher(userCollectTeacher);
		
		//收藏+1
		Teacher teacher=teacherService.findTeacherById(teacherId);
		teacher.setCollectNumber(teacher.getCollectNumber()+1);
		teacherService.updateTeacher(teacher);
	}
}
