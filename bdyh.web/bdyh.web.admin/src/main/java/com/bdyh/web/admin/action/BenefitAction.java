package com.bdyh.web.admin.action;

import javax.servlet.http.HttpSession;


import com.bdyh.service.CourseService;
import com.bdyh.web.admin.shiro.ActiveUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
	@RequestMapping(value="benefit")
public class BenefitAction {
	@Autowired
	private CourseService courseService;


	@RequestMapping(value="benefitOfTeacher")
	public String benefitOfTeacher(HttpSession session ,Model model){

	//	Teacher teacher = (Teacher) AdminUtil.getShiroSessionByKey("userTeacher");

		ActiveUser activeUser = (ActiveUser) session.getAttribute("activeUser");
		Float income = courseService.benefitOfTeacher(activeUser.getUserid());
		System.out.println("=======");
		model.addAttribute("income", income);

		return "benefit/benefit";
	}
	
	/**
	 * 课程收益详情
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="courseBenefit")
	public String courseBenefit(HttpSession session,Model model){
		return "benefit/course-benefit";
	}

	@RequestMapping(value="statisticalOfTeacher")
	public String benefitOfTeacher(){
		//TODO
		return "benefit/benefit_teacher";
	}
}

