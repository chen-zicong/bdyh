package com.bdyh.web.admin.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bdyh.entity.UserWechat;
import com.bdyh.service.UserWechatService;
/**
 * 管理员查看微信用户
 * 2018年2月2日
 * @author cxs
 */
@Controller
@RequestMapping(value="adminUserWechat")
public class AdminUserWechatAction {
	
	@Autowired
	private UserWechatService userWechatService;
	
	@GetMapping(value="userWechatList")
	public String userWechatList(Model model){
		//查询所有微信用户
		List<UserWechat> userWechatList=userWechatService.findAllUserWechat();
		//传递参数到页面
		model.addAttribute("userWechatList", userWechatList);
		return "user_wechat/user-wechat-list";
	}
	
}
