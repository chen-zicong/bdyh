package com.bdyh.web.admin.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bdyh.dao.ClazzMapper;
import com.bdyh.entity.Clazz;
import com.bdyh.entity.Teacher;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bdyh.common.MD5.MD5Util;
import com.bdyh.common.exception.CustomException;
import com.bdyh.entity.Agent;
import com.bdyh.entity.UserAdmin;
import com.bdyh.service.AgentService;
import com.bdyh.service.TeacherService;
import com.bdyh.service.UserAdminService;
import com.bdyh.web.admin.shiro.ActiveUser;
import com.bdyh.web.admin.shiro.CustomLoginToken;
import com.bdyh.web.admin.shiro.ShiroAuthorizingRealmAction;
import com.google.code.kaptcha.Constants;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 登录
 * 2018年1月27日
 * @author cxs
 */

@Controller
@RequestMapping(value="admin")
public class LoginAction {
	
	@Autowired
	private UserAdminService userAdminService;
	
	@Autowired
	private AgentService agentService;
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private ShiroAuthorizingRealmAction myRealm;

	@Autowired
	private ClazzMapper clazzMapper;
	
	/*-------------------------------------------------------------------不使用-------------------------------------------------------------------------*/

	@RequestMapping("test")
    @ResponseBody
	public List<Clazz> test(){
		return  clazzMapper.selectAll();
	}
	/**
	 * 教师平台登录
	 * @param session
	 * @param authCode
	 * @param username
	 * @param password
	 * @return
	 */
	@PostMapping(value="teacherLogin")
	public String teacherLogin(HttpSession session,String authCode,String username,String password) throws Exception{
		String capText=(String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		if(capText.equalsIgnoreCase(authCode)){
			Teacher teacher=teacherService.findTeacherByUsername(username);
			if(teacher==null){
				throw new CustomException("账户不存在");
			}else{
				if(!new MD5Util().getMD5ofStr(password).equals(teacher.getPassword())){
					throw new CustomException("密码不正确");
					
				}
				//保存用户信息至session
				session.setAttribute("user", teacher);
			}
		}else{
			throw new CustomException("验证码有误");
		}
		return "index-teacher";
	}
	
	/**
	 * 代理商平台登录
	 * @param session
	 * @param authCode
	 * @param username
	 * @param password
	 * @return
	 */
	@PostMapping(value="agentLogin")
	public String agentLogin(HttpSession session,String authCode,String username,String password) throws Exception{
		String capText=(String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		if(capText.equalsIgnoreCase(authCode)){
			Agent agent=agentService.findAgentByUsername(username);
			if(agent==null){
				throw new CustomException("账户不存在");
			}else{
				if(!new MD5Util().getMD5ofStr(password).equals(agent.getPassword())){
					throw new CustomException("密码不正确");
				}
				//保存用户信息至session
				session.setAttribute("user", agent);
			}
		}else{
			throw new CustomException("验证码有误");
		}
		return "index-agent";
	}
	
	/*-------------------------------------------------------------------不使用-------------------------------------------------------------------------*/
	
	
	/**
	 * 退出登录
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("logout")
	public void logout(HttpServletRequest request,HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
        try {
        	SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());//重新登录前注销4
        	myRealm.clearCached();
        	//SecurityUtils.getSubject().logout();
			//清除session，在退出登录或是重新登录的地方都要清除
			request.getSession().invalidate();
			out.write("{\"status\":1}");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
	
	
	/**
	 * 跳转到登录页面
	 * @return
	 */
	@RequestMapping(value ="/toLogin")
	public String login() {
        /**
         * 此方法貌似被LoginInterceptor拦截，不执行
         */
		if (SecurityUtils.getSubject().isAuthenticated()) {//用户已通过认证则通过
            return "redirect:index";
        }
        return "login/login";
    }
	
	/**
	 * 验证码验证
	 * @param request
	 * @return
	 */
	public boolean VerifyCodeUtil(HttpServletRequest request){
		String code=request.getParameter("authCode"); 
		String original =(String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
		if (!StringUtils.isEmpty(code)) {
            if (code.equalsIgnoreCase(original)) {
            	return true;
            }
        }
		return false;
	}
	
	/**
	 * 后台登录
	 * @param activeUser
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/login",method = RequestMethod.POST)
    public void Login(ActiveUser activeUser,HttpServletRequest request,
    		HttpServletResponse response,HttpSession session) throws IOException {
		PrintWriter out=response.getWriter();


        boolean checkCode=VerifyCodeUtil(request);//验证码校验
//        if(!checkCode){
//        	out.write("{\"status\":2}");
//        	return;
//        }
        if (StringUtils.isBlank(activeUser.getUsername())) {
            throw new RuntimeException("用户名不能为空");
        }
        if (StringUtils.isBlank(activeUser.getPassword())) {
            throw new RuntimeException("密码不能为空");
        }
        
        if("admin".equals(activeUser.getLoginType())){
        	UserAdmin userAdmin=userAdminService.findUserAdminByUsername(activeUser.getUsername());

        	if (userAdmin == null) {
            	out.write("{\"status\":0}");//用户不存在
            	return;
            }
            if (!new MD5Util().getMD5ofStr(activeUser.getPassword()).equals(userAdmin.getPassword())) {
            	out.write("{\"status\":-1}");
            	return;
            }
            
            if (userAdmin.getStatus()==0) {
            	out.write("{\"status\":-2}");
            	return;
            }
            
            SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());
            myRealm.clearCached();
            //清除session，在退出登录或是重新登录的地方都要清除
			request.getSession().invalidate();
            
			CustomLoginToken token = new CustomLoginToken(userAdmin.getUsername(),userAdmin.getPassword(),false,activeUser.getLoginType());//封装门令
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
            try {
            	System.out.println(subject.isAuthenticated());
    			subject.login(token);
    			out.write("{\"status\":1}");//登录成功返回
    			
    			userAdmin.setLoginNumber(userAdmin.getLoginNumber()+1);
    			userAdmin.setLoginTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    			userAdminService.updateUserAdmin(userAdmin);
                //添加管理员对象到session
                subject.getSession().setAttribute("userAdmin",userAdmin);
    		} catch (AuthenticationException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }else if("agent".equals(activeUser.getLoginType())){
        	Agent agent=agentService.findAgentByUsername(activeUser.getUsername());

        	if (agent == null) {
            	out.write("{\"status\":0}");//用户不存在
            	return;
            }
            if (!new MD5Util().getMD5ofStr(activeUser.getPassword()).equals(agent.getPassword())) {
            	out.write("{\"status\":-1}");
            	return;
            }
            
            if (agent.getStatus()==0) {
            	out.write("{\"status\":-2}");
            	return;
            }
            
            SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());
            myRealm.clearCached();
            //清除session，在退出登录或是重新登录的地方都要清除
			request.getSession().invalidate();
            
            CustomLoginToken token = new CustomLoginToken(agent.getUsername(),agent.getPassword(),false,activeUser.getLoginType());//封装门令
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
            try {
            	System.out.println(subject.isAuthenticated());
    			subject.login(token);
    			out.write("{\"status\":1}");//登录成功返回
    			
    			agent.setLoginNumber(agent.getLoginNumber()+1);
    			agent.setLoginTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    			agentService.updateAgent(agent);
                //添加代理对象到session
               subject.getSession().setAttribute("userAgent",agent);
             //   request.getSession().setAttribute("userAgent",agent);
    			
    			
    		} catch (AuthenticationException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }else{
        	Teacher teacher=teacherService.findTeacherByUsername(activeUser.getUsername());

        	if (teacher == null) {
            	out.write("{\"status\":0}");//用户不存在
            	return;
            }
            if (!new MD5Util().getMD5ofStr(activeUser.getPassword()).equals(teacher.getPassword())) {
            	out.write("{\"status\":-1}");
            	return;
            }
            
            if (teacher.getStatus()==0) {
            	out.write("{\"status\":-2}");
            	return;
            }
            
            SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());
            myRealm.clearCached();
            //清除session，在退出登录或是重新登录的地方都要清除
			request.getSession().invalidate();
            CustomLoginToken token = new CustomLoginToken(teacher.getUsername(),teacher.getPassword(),false,activeUser.getLoginType());//封装门令
            Subject subject = SecurityUtils.getSubject();
            
            try {
    			subject.login(token);
    			out.write("{\"status\":1}");//登录成功返回
    			
    			teacher.setLoginNumber(teacher.getLoginNumber()+1);
    			teacher.setLoginTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    			teacherService.updateTeacher(teacher);
                //添加老师对象到Session
                subject.getSession().setAttribute("userTeacher",teacher);
    			
    		} catch (AuthenticationException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }


        
    }
	
	
	
	
	/**
	 * 跳转到登录页面
	 * @return
	 * @throws Exception
	 */
	/*@RequestMapping(value="login")
	public String login(HttpServletRequest request,@PathVariable("role") String role) throws Exception{
		//如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		
		//根据shiro返回的异常类路径判断，抛出指定异常信息
		if(exceptionClassName!=null){
			if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
				//最终会抛给异常处理器
				throw new CustomException("账号不存在");
			} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
				throw new CustomException("用户名/密码错误");
			} else if("authCodeError".equals(exceptionClassName)){
				throw new CustomException("验证码错误 ");
			}else {
				throw new Exception();//最终在异常处理器生成未知错误
			}
		}
		//这里检查是否已经登录成功，成功的话直接转到主页
		
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser=(ActiveUser)subject.getPrincipal();
		if(activeUser!=null){
			if("admin".equals(activeUser.getRole())){
				return "index";
			}
			if("agent".equals(activeUser.getRole())){
				return "index-agent";
			}
			if("teacher".equals(activeUser.getRole())){
				return "index-teacher";
			}
		}
		
		if(SecurityUtils.getSubject().getPrincipal()!=null){
			ActiveUser activeUser=(ActiveUser)SecurityUtils.getSubject().getPrincipal();
			System.out.println(activeUser);
			return "index";
		}
		
		//此方法不处理登陆成功（认证成功），shiro认证成功会自动跳转到上一个请求路径
		//登陆失败跳转到登录页面
		return "login/login";
	}*/
}		
