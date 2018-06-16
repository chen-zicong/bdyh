package com.bdyh.web.admin.shiro;


import com.bdyh.entity.Teacher;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.bdyh.entity.Agent;
import com.bdyh.entity.UserAdmin;
import com.bdyh.service.UserAdminService;
import com.bdyh.service.AgentService;
import com.bdyh.service.TeacherService;

/**
 * 自定义的realm，注入到shiro
 * 用户的认证和授权
 * 2018年1月14日
 * @author cxs
 */
public class CustomRealm extends AuthorizingRealm{
	
	@Autowired
	private UserAdminService userAdminService;
	
	@Autowired
	private AgentService agentService;
	
	@Autowired
	private TeacherService teacherService;
	
	// 设置realm的名称
	@Override
	public void setName(String name) {
		super.setName("customRealm");
	}
	
	/**
	 * 认证的方法
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// token是用户输入的用户名和密码 
		// 第一步从token中取出用户名
		
		CustomLoginToken customToken=(CustomLoginToken)token;
		String password=null;
		ActiveUser activeUser=new ActiveUser();
		
		if("admin".equals(customToken.getLoginType())){
			UserAdmin userAdmin=userAdminService.findUserAdminByUsername(customToken.getUsername());
			if(userAdmin==null){
				return null;
			}
			password=userAdmin.getPassword();
			activeUser.setUserid(userAdmin.getUserId());
			activeUser.setUsername(userAdmin.getUsername());
			activeUser.setNickname(userAdmin.getNickname());
			activeUser.setLoginTime(userAdmin.getLoginTime());
			activeUser.setLoginNumber(userAdmin.getLoginNumber());
			activeUser.setRole("admin");
		}else if("agent".equals(customToken.getLoginType())){
			Agent agent=agentService.findAgentByUsername(customToken.getUsername());
			if(agent==null){
				return null;
			}
			password=agent.getPassword();
			activeUser.setUserid(agent.getAgentId());
			activeUser.setUsername(agent.getUsername());
			activeUser.setNickname(agent.getNickname());
			activeUser.setLoginTime(agent.getLoginTime());
			activeUser.setLoginNumber(agent.getLoginNumber());
			activeUser.setRole("agent");
		}else if("teacher".equals(customToken.getLoginType())){
			Teacher teacher=teacherService.findTeacherByUsername(customToken.getUsername());
			if(teacher==null){
				return null;
			}
			password=teacher.getPassword();
			activeUser.setUserid(teacher.getTeacherId());
			activeUser.setUsername(teacher.getUsername());
			activeUser.setNickname(teacher.getTeacherName());
			activeUser.setLoginTime(teacher.getLoginTime());
			activeUser.setLoginNumber(teacher.getLoginNumber());
			activeUser.setRole("teacher");
		}
		
		// 第二步：根据用户输入的username从数据库查询
		/*User user = null;
		try {
			user = userService.findUserByUsername(username);
		} catch (Exception e1) {
			e1.printStackTrace();
		}*/

		// 如果查询不到返回null
		/*if(user==null){//
			return null;
		}*/
		// 从数据库查询到密码
		/*String password = user.getPassword();*/
		

		// 如果查询到返回认证信息AuthenticationInfo
		//activeUser就是用户身份信息
		/*ActiveUser activeUser = new ActiveUser();
		
		activeUser.setId(user.getId());
		activeUser.setUsername(user.getUsername());
		activeUser.setTruename(user.getTruename());
		activeUser.setCusid(user.getCusid());
		activeUser.setIsroot(user.getIsroot());*/
		

		//将activeUser设置simpleAuthenticationInfo
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
				activeUser, password, this.getName());
		
		return simpleAuthenticationInfo;
		//return null;
	}
	/**
	 * 授权的方法
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}
}
