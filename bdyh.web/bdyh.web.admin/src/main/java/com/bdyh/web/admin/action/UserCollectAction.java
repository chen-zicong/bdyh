package com.bdyh.web.admin.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bdyh.entity.UserCollectCourseVo;
import com.bdyh.entity.UserCollectTeacherVo;
import com.bdyh.service.UserCollectService;
/**
 * 管理员管理
 * 用户收藏记录
 * 2018年2月3日
 * @author cxs
 */
@Controller
@RequestMapping(value="userCollect")
public class UserCollectAction {

	@Autowired
	private UserCollectService userCollectService;
	
	@GetMapping(value="userCollectCourse")
	public String userCollectCourse(Model model){
		//查询所有用户收藏的课程
		List<UserCollectCourseVo> userCollectCourseList=userCollectService.findAllUserCollectCourse();
		//传递参数到页面
		model.addAttribute("userCollectCourseList", userCollectCourseList);
		return "user_collect/user-collect-course-list";
	}
	
	@GetMapping(value="userCollectTeacher")
	public String userCollectTeacher(Model model){
		//查询所有用户收藏的讲师
		List<UserCollectTeacherVo> userCollectTeacherList=userCollectService.findAllUserCollectTeacher();
		//传递参数到页面
		model.addAttribute("userCollectTeacherList", userCollectTeacherList);
		return "user_collect/user-collect-teacher-list";
	}
}
