package com.bdyh.web.admin.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bdyh.entity.UserOpinionVo;
import com.bdyh.service.OpinionService;
/**
 * 用户反馈意见
 * 2018年2月3日
 * @author cxs
 */
@Controller
@RequestMapping(value="userOpinion")
public class UserOpinionAction {
	
	
	@Autowired
	private OpinionService opinionService;
	
	
	
	/**
	 * 用户反馈列表
	 * @param model
	 * @return
	 */
	@GetMapping(value="opinionList")
	public String opinionList(Model model){
		
		//查询所有用户反馈,查询opinion表时也需要查询userWechat表
		List<UserOpinionVo> userOpinionList=opinionService.findAllOpinionOfUsers();
		
		model.addAttribute("userOpinionList", userOpinionList);
		return "opinion/feedback-list";
	}
	
	@GetMapping(value="userOpinionDelete")
	public void userOpinionDelete(Integer uoid,HttpServletResponse response){
		PrintWriter out=null;
		try{
			out=response.getWriter();
			opinionService.deleteUserOpinionById(uoid);
			//操作成功，向客户端输出1
			out.write("{\"status\":1}");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
