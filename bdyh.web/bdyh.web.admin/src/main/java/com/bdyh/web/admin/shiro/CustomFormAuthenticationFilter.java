package com.bdyh.web.admin.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import com.google.code.kaptcha.Constants;

/**
 * 验证用户名密码之前先验证验证码,自定义的shiro过滤器
 * 重写FormAuthenticationFilter类增加loginType属性
 * 2018年1月14日
 * @author cxs
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter{
	
	public static final String DEFAULT_LOGIN_TYPE_PARAM = "loginType";
    private String loginTypeParamName = DEFAULT_LOGIN_TYPE_PARAM;
	
	//原FormAuthenticationFilter的认证方法
	/*@Override
	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws Exception {
		//在这里进行验证码的校验
		
		//从session获取正确验证码
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpSession session =httpServletRequest.getSession();
		//取出session的验证码（正确的验证码）
		String capText = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		
		//取出页面的验证码
		//输入的验证和session中的验证进行对比 
		String authCode = httpServletRequest.getParameter("authCode");
		if(authCode !=null && capText !=null && !capText.equalsIgnoreCase(authCode)){
			//如果校验失败，将验证码错误失败信息，通过shiroLoginFailure设置到request中
			httpServletRequest.setAttribute("shiroLoginFailure", "authCodeError");
			//拒绝访问，不再校验账号和密码 
			return true; 
		}
		return super.onAccessDenied(request, response);
	}*/

    /**
     * 重写该方法,为了将loginType参数保存到token中
     *
     * @param request  请求
     * @param response 响应
     * @return
     */
    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
        String username = getUsername(request);
        String password = getPassword(request);
        String loginType = getLoginType(request);
        return createToken(username, password, request, response, loginType);
    }
    
    private AuthenticationToken createToken(String username, String password, ServletRequest request, ServletResponse response, String loginType) {
        boolean rememberMe = isRememberMe(request);
        String host = getHost(request);
        return createToken(username, password, rememberMe, host, loginType);
    }
    
    private AuthenticationToken createToken(String username, String password, boolean rememberMe, String host, String loginType) {
        return new CustomLoginToken(username, password,false,loginType);
    }
    
    private String getLoginType(ServletRequest request) {
        return WebUtils.getCleanParam(request, getLoginTypeParamName());
    }

	public String getLoginTypeParamName() {
		return loginTypeParamName;
	}


	public void setLoginTypeParamName(String loginTypeParamName) {
		this.loginTypeParamName = loginTypeParamName;
	}


	public static String getDefaultLoginTypeParam() {
		return DEFAULT_LOGIN_TYPE_PARAM;
	}
    
    
}
