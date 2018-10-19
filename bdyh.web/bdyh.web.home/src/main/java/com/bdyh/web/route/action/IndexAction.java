package com.bdyh.web.route.action;

import java.util.List;

import com.bdyh.entity.Clazz;
import com.bdyh.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/**
 * 跳转到首页的控制器
 * 2018年1月13日
 * @author cxs
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bdyh.entity.Course;
import com.bdyh.entity.HomePicture;
import com.bdyh.service.CourseService;
import com.bdyh.service.PictureService;
@Controller
public class IndexAction {
	
	@Autowired
	private CourseService courseService;

	@Autowired
	private ClazzService clazzService;
	
	/**
	 * 
	 * 2018年2月7日
	 * @author cxs
	 */
	@Autowired
	private PictureService pictureService;
	
	@GetMapping(value="index")
	public ModelAndView index(){
		ModelAndView modelAndView=new ModelAndView();
		//这里跳转首页前查询推荐的课程
		List<Course> courseList=courseService.findRecommandCourse();
		modelAndView.addObject("courseList", courseList);
		
		//TODO 取出轮播图片，home_picture表中status为1的图片，图片是后台管理员维护的，status为发布状态
		List<HomePicture> homePictureList=pictureService.findHomePictureRelease();
		modelAndView.addObject("homePictureList", homePictureList);
		//取出已经开通的年级的列表。
		List<Clazz> clazzList =clazzService.findClazzByStatus();
		modelAndView.addObject("clazzList", clazzList);
		modelAndView.setViewName("wechat/home");
		return modelAndView;
	}
}
