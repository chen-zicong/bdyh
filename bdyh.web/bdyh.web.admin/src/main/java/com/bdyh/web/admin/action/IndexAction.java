package com.bdyh.web.admin.action;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bdyh.web.admin.shiro.ActiveUser;

/**
 * 
 * 2018年1月19日
 * @author cxs
 */
@Controller
public class IndexAction {

	
	
	@RequestMapping("/index")
	public String index(HttpSession session){
		Subject subject = SecurityUtils.getSubject();
		if(subject.isAuthenticated()){
			ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
			session.setAttribute("activeUser", activeUser);
		}
		return "index";
	}
}
