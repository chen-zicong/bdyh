package com.bdyh.web.admin.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转
 * 2018年1月19日
 * @author cxs
 */
@Controller
@RequestMapping(value="redirect")
public class RedirectAction {
	/**
	 * 跳转到首页
	 * @return
	 */
	@PostMapping(value="login")
	public String login(){
		return "index";
	}
	@PostMapping(value="teacherLogin")
	public String teacherLogin(){
		return "index-teacher";
	}
	@PostMapping(value="agentLogin")
	public String agentLogin(){
		return "index-agent";
	}
	/**
	 * 欢迎页
	 * @return
	 */
	@GetMapping(value="welcome")
	public String welcome(){
		return "welcome";
	}
	/**
	 * 意见反馈
	 * @return
	 */
	@GetMapping(value="opinion")
	public String opinion(){
		return "opinion/feedback-list";
	}
	
	/**
	 * 会员管理
	 * @return
	 */
	@GetMapping(value="memberList")
	public String memberList(){
		return "member/member-list";
	}
	
	@GetMapping(value="memberDel")
	public String memberDel(){
		return "member/member-del";
	}
	
	@GetMapping(value="memberAdd")
	public String memberAdd(){
		return "member/member-add";
	}
	
	@GetMapping(value="changePassword")
	public String changePassword(){
		return "member/change-password";
	}
	
	@GetMapping(value="memberShow")
	public String memberShow(){
		return "member/member-show";
	}
	
	/**
	 * 用户管理
	 * @return
	 */
	
	@GetMapping(value="userList")
	public String userList(){
		return "user/user-list";
	}
	
	@GetMapping(value="userAdd")
	public String userAdd(){
		return "user/user-add";
	}
	
	
	@GetMapping(value="userShow")
	public String userShow(){
		return "user/user-show";
	}
	
	@GetMapping(value="userEditPassword")
	public String userEditPassword(){
		return "user/user-password-edit";
	}
	
	/**
	 * 首页轮播图
	 * @return
	 */
	@GetMapping(value="pictureList")
	public String pictureList(){
		return "picture/picture-list";
	}
	@GetMapping(value="pictureAdd")
	public String pictureAdd(){
		return "picture/picture-add";
	}
	
	@GetMapping(value="pictureShow")
	public String pictureShow(){
		return "picture/picture-show";
	}
	
	/**
	 * 课程管理
	 * @return
	 */
	
	@GetMapping(value="courseList")
	public String courseList(){
		return "course/course-list";
	}
	
	/**
	 * 教师管理
	 * @return
	 */
	@GetMapping(value="teacherList")
	public String teacherList(){
		return "teacher/teacher-list";
	}
	
	@GetMapping(value="teacherShow")
	public String teacherShow(){
		return "teacher/teacher-show";
	}
	
	/**
	 * 管理员管理
	 * @return
	 */
	@GetMapping(value="adminRole")
	public String adminRole(){
		return "admin/admin-role";
	}
	@GetMapping(value="adminAdd")
	public String adminAdd(){
		return "admin/admin-add";
	}
	@GetMapping(value="adminList")
	public String adminList(){
		return "admin/admin-list";
	}
	@GetMapping(value="adminPermission")
	public String adminPermission(){
		return "admin/admin-permission";
	}
	@GetMapping(value="adminRoleAdd")
	public String adminRoleAdd(){
		return "admin/admin-role-add";
	}
}
