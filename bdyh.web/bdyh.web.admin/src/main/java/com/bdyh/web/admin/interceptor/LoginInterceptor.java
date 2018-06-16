package com.bdyh.web.admin.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/**
 * 登录认证的拦截器，只放行登录页面和匿名访问页面
 * @author cxs
 *
 */

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//获取请求的url
		String url = request.getRequestURI();
		//判断url是否是公开 地址
		//这里公开地址是登陆提交的地址
		if(url.indexOf("admin/login")>=0){
			//如果进行登陆提交，放行
			return true;
		}
		//验证码
		if(url.indexOf("kaptcha/getKaptchaImage")>=0){
			return true;
		}
		
		
		if(SecurityUtils.getSubject().isAuthenticated()){
			return true;
		}
		//执行这里表示用户身份需要认证，跳转登陆页面
		request.getRequestDispatcher("/WEB-INF/jsp/login/login.jsp").forward(request, response);
		
		//return true表示放行
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
