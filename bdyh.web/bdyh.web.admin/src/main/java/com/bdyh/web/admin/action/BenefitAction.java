package com.bdyh.web.admin.action;

import javax.servlet.http.HttpSession;


import com.bdyh.common.AdminUtil;
import com.bdyh.entity.Benefit;
import com.bdyh.entity.Teacher;
import com.bdyh.service.BenefitService;
import com.bdyh.service.CourseService;
import com.bdyh.web.admin.shiro.ActiveUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="benefit")
public class BenefitAction {
	@Autowired
	private CourseService courseService;
	@Autowired
	private BenefitService benefitService;


	@RequestMapping(value="benefitOfTeacher")
	public String benefitOfTeacher(Model model){

		Teacher teacher = (Teacher) AdminUtil.getShiroSessionByKey("userTeacher");

//		ActiveUser activeUser = (ActiveUser) session.getAttribute("activeUser");
		float income = benefitService.findTeacherAllIncome(teacher);
		System.out.println("=======");
		model.addAttribute("income", income);
		model.addAttribute("teacherId",teacher.getTeacherId());

		return "benefit/teacher_benefit_echarts";
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
}
