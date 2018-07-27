package com.bdyh.web.admin.shiro;

import java.util.List;

import com.bdyh.entity.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bdyh.service.AgentService;
import com.bdyh.service.TeacherService;
import com.bdyh.service.UserAdminPrivilegeService;
import com.bdyh.service.UserAdminRoleService;
import com.bdyh.service.UserAdminService;

@Controller
public class ShiroAuthorizingRealmAction extends AuthorizingRealm{

	@Autowired
	private UserAdminService userAdminService;
	
	@Autowired
	private AgentService agentService;
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private UserAdminRoleService userAdminRoleService;
	
	@Autowired
	private UserAdminPrivilegeService userAdminPrivilegeService;
	
	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用,负责在应用程序中决定用户的访问控制的方法 
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		/*AdminStatistics adminInfo = (AdminStatistics) principals.getPrimaryPrincipal(); // 获取用户名
		Map<String, Set<String>> resourceMap=adminService.selectResourceMapByRoleId(adminInfo.getAdRoleId());
		Set<String> privilegeSet=null;
		if(resourceMap!=null){
			 privilegeSet = resourceMap.get("privileges");
		}
		Set<String> roleSet=new HashSet<String>();
		roleSet.add(String.valueOf(adminInfo.getAdRoleId()));
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roleSet);// 角色
        authorizationInfo.setStringPermissions(privilegeSet);// 权限
        return authorizationInfo;*/
		return null;
	}
	
	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		// TODO Auto-generated method stub
		/*AdminStatistics user = tokenToUser((UsernamePasswordToken) authcToken);
    	user=adminService.selectByAccount(user.getAdAccount());*/
		CustomLoginToken customToken=(CustomLoginToken)authcToken;
		String password=null;
		ActiveUser activeUser=null;
		
		
		
		if("admin".equals(customToken.getLoginType())){
			UserAdmin userAdmin=userAdminService.findUserAdminByUsername(customToken.getUsername());
			if(userAdmin==null){
				return null;
			}
			password=userAdmin.getPassword();
			activeUser=new ActiveUser();
			activeUser.setUserid(userAdmin.getUserId());
			activeUser.setUsername(userAdmin.getUsername());
			activeUser.setNickname(userAdmin.getNickname());
			activeUser.setLoginTime(userAdmin.getLoginTime());
			activeUser.setLoginNumber(userAdmin.getLoginNumber());
			activeUser.setPassword(password);
			activeUser.setRole("admin");
			activeUser.setDistrictId(userAdmin.getDistrictId());
			activeUser.setRoleId(userAdmin.getRoleId());
			//根据用户的role_id取出相应的角色
			UserAdminRole userAdminRole=userAdminRoleService.findUserAdminRoleByRoleId(activeUser.getRoleId());
			//根据userAdminRole.getRolePowers()取出相应菜单
			List<UserAdminPrivilegeVo> menuList=userAdminPrivilegeService.findMenuListByRolePowers(userAdminRole.getRolePowers());
			activeUser.setMenuList(menuList);
			
		}else if("agent".equals(customToken.getLoginType())){
			Agent agent=agentService.findAgentByUsername(customToken.getUsername());
			if(agent==null){
				return null;
			}
			password=agent.getPassword();
			activeUser=new ActiveUser();
			activeUser.setUserid(agent.getAgentId());
			activeUser.setUsername(agent.getUsername());
			activeUser.setNickname(agent.getNickname());
			activeUser.setLoginTime(agent.getLoginTime());
			activeUser.setLoginNumber(agent.getLoginNumber());
			activeUser.setPassword(password);
			
			activeUser.setRole("agent");
			activeUser.setDistrictId(agent.getDistrictId());
			
			activeUser.setRoleId(agent.getRoleId());
			//根据用户的role_id取出相应的角色
			UserAdminRole userAdminRole=userAdminRoleService.findUserAdminRoleByRoleId(activeUser.getRoleId());
			//根据userAdminRole.getRolePowers()取出相应菜单
			List<UserAdminPrivilegeVo> menuList=userAdminPrivilegeService.findMenuListByRolePowers(userAdminRole.getRolePowers());
			activeUser.setMenuList(menuList);
			
		}else if("teacher".equals(customToken.getLoginType())){
			Teacher teacher=teacherService.findTeacherByUsername(customToken.getUsername());
			if(teacher==null){
				return null;
			}
			password=teacher.getPassword();
			activeUser=new ActiveUser();
			activeUser.setUserid(teacher.getTeacherId());
			activeUser.setUsername(teacher.getUsername());
			activeUser.setNickname(teacher.getTeacherName());
			activeUser.setLoginTime(teacher.getLoginTime());
			activeUser.setLoginNumber(teacher.getLoginNumber());
			activeUser.setPassword(password);
			activeUser.setRole("teacher");
			activeUser.setDistrictId(teacher.getDistrictId());
			
			activeUser.setRoleId(teacher.getRoleId());
			//根据用户的role_id取出相应的角色
			UserAdminRole userAdminRole=userAdminRoleService.findUserAdminRoleByRoleId(activeUser.getRoleId());
			//根据userAdminRole.getRolePowers()取出相应菜单
			List<UserAdminPrivilegeVo> menuList=userAdminPrivilegeService.findMenuListByRolePowers(userAdminRole.getRolePowers());
			activeUser.setMenuList(menuList);
		}
        // 设置session  
        //Session session = SecurityUtils.getSubject().getSession();  
        //session.setAttribute(ShiroAuthorizingRealmAction.SESSION_USER_KEY, ui);
        //当前 Realm 的 name  
        String realmName = this.getName();
        System.out.println("realmName>>"+realmName);
        return new SimpleAuthenticationInfo(activeUser,password,realmName);
        
	}
	
	/**
	 * 清除所有shiro的缓存
	 */
	public void clearCached() {
		PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
		super.clearCache(principals);
	}
}
