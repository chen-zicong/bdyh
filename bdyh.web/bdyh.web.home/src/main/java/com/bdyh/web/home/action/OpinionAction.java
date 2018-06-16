package com.bdyh.web.home.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bdyh.entity.UserOpinion;
import com.bdyh.entity.UserWechat;
import com.bdyh.service.OpinionService;

@Controller
@RequestMapping(value="opinion")
public class OpinionAction {

	@Autowired
	private OpinionService opinionService;
	
	
	/**
	 * 跳转到编辑意见反馈页面
	 * @param session
	 * @param model
	 * @return
	 */
	@GetMapping(value="writeOpinion")
	public String writeOpinion(){
		return "wechat/opinion/opinion";
	}
	
	/*@GetMapping(value="submitOpinion/{opinion}")*/
	@RequestMapping("submitOpinion")
	public String submitOpinion(HttpSession session,/*@PathVariable("opinion") */String opinion) throws Exception{
		//从session范围中取出用户信息
		UserWechat user=(UserWechat)session.getAttribute("user");
		UserOpinion userOpinion=new UserOpinion();
		userOpinion.setOpenid(user.getOpenid());
		userOpinion.setOpinion(opinion);
		
		//增加时间
		userOpinion.setFeedbackTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		opinionService.saveOpinion(userOpinion);
		return "redirect:/user/userCenter";
	}
}
