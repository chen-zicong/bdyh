package com.bdyh.web.home.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.bdyh.entity.*;
import com.bdyh.service.*;
import org.apache.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.bdyh.web.wechat.utils.WechatUtil;

import net.sf.json.JSONObject;
/**
 * 用户的接口
 * 2018年1月7日
 * @author cxs
 */
@Controller
@RequestMapping(value = "user")
public class UserAction {
	
	@Autowired
	private WeAccessService weAccessService;
	@Autowired
	private UserService userService;
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
	
	
	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;
	
	private static final String GET_ACCESS_TOKEN_URL="https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	private static final String REFRESH_TOKEN="https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
	private static final String GET_USERINFO="https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	private static final String CHECK_USE="https://api.weixin.qq.com/sns/auth?access_token=ACCESS_TOKEN&openid=OPENID";
	/**
	 * 在这里调用接口获取网页授权的access_token(不同于普通的access_token)
	 * 接口调用请求说明
	 * http请求方式: GET
	 * https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
	 * 刷新accesstoken
	 * https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN
	 * 获取用户
	 * https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN
	 * 检查accesstoken是否可用
	 * https://api.weixin.qq.com/sns/auth?access_token=ACCESS_TOKEN&openid=OPENID
	 * @throws IOException 
	 * @throws ParseException
	 */
	@SuppressWarnings("null")
	@GetMapping(value = "getUser")
	public ModelAndView getAccess_token(HttpSession session,String code,String state) throws Exception{
		ModelAndView modelAndView=new ModelAndView();
		String returnString="wechat/home";

		String url=GET_ACCESS_TOKEN_URL.replace("APPID",WechatUtil.APPID).replace("SECRET", WechatUtil.APPSECRET).replace("CODE", code);
		JSONObject jsonObject=WechatUtil.doGetStr(url);
		if(jsonObject!=null&&!jsonObject.has("errcode")){
			//这里检查accesstoken是否有效
			String checkUrl=CHECK_USE.replace("ACCESS_TOKEN", jsonObject.getString("access_token")).replace("OPENID", jsonObject.getString("openid"));
			JSONObject jsonObject4=WechatUtil.doGetStr(checkUrl);
			
			JSONObject jsonObject2=null;
			if("ok".equals(jsonObject4.getString("errmsg"))){
				//有效不刷新
				jsonObject2=jsonObject;
			}else{
				//无效刷新
				String refreshUrl=REFRESH_TOKEN.replace("APPID", WechatUtil.APPID).replace("REFRESH_TOKEN", jsonObject.getString("refresh_token"));
				jsonObject2=WechatUtil.doGetStr(refreshUrl);
			}
			if(jsonObject2!=null&&!jsonObject2.has("errcode")){
				//查询数据库是否存在，存在则不保存
				if(weAccessService.findWeAccessByOpenid(jsonObject2.getString("openid"))==null){
					WeAccess weAccess=new WeAccess();
					weAccess.setOpenId(jsonObject2.getString("openid"));
					weAccess.setAccessToken(jsonObject2.getString("access_token"));
					weAccess.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
					//TODO 保存数据库WeAccess
					weAccessService.saveWeAccess(weAccess);
				}
				String GetUserInfoUrl=GET_USERINFO.replace("ACCESS_TOKEN", jsonObject2.getString("access_token")).replace("OPENID", jsonObject2.getString("openid"));
				JSONObject jsonObject3=WechatUtil.doGetStr(GetUserInfoUrl);
				//查询数据库是否存在，存在则不保存
				UserWechat userWechat=userService.findUserWechatByOpenid(jsonObject3.getString("openid"));
				if(userWechat==null){
					userWechat=new UserWechat();
					userWechat.setOpenid(jsonObject3.getString("openid"));
					userWechat.setNickname(jsonObject3.getString("nickname"));
					userWechat.setSex(jsonObject3.getInt("sex"));
					userWechat.setLanguage(jsonObject3.getString("language"));
					userWechat.setCity(jsonObject3.getString("city"));
					userWechat.setProvince(jsonObject3.getString("province"));
					userWechat.setCountry(jsonObject3.getString("country"));
					userWechat.setHeadimgurl(jsonObject3.getString("headimgurl"));
					
					//默认注册时候是普通用户
					userWechat.setRegisterTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
					userWechat.setVip(0);
					//TODO 保存之前应该根据openid去查询是否已经默认注册
					userService.saveUser(userWechat);
				}
				//将用户保存至session
				session.setAttribute("user", userWechat);
				System.out.println(jsonObject3);
				
				//这里跳转首页前查询推荐的课程
				//TODO 考虑改成子查询，不使用mybatis的分页插件

				List<Course> courseList=courseService.findRecommandCourse();
				//生成首页静态页面
				/*Configuration configuration = freeMarkerConfigurer.getConfiguration();
				//获取模板
				Template template = configuration.getTemplate("html/home.html");
				//创建数据集
				Map data = new HashMap<>();
				data.put("courseList", courseList);
				//使用监听器获取相对路径
				String filePath=System.getProperty("path.webapp");
				//生成html的路径
				Writer out = new FileWriter(new File(filePath+"\\WEB-INF\\views\\wechat\\home.html"));
				//生成html
				template.process(data, out);
				out.close();*/
				
				//TODO 取出轮播图片，home_picture表中status为1的图片，图片是后台管理员维护的，status为发布状态
				List<HomePicture> homePictureList=pictureService.findHomePictureRelease();
				modelAndView.addObject("homePictureList", homePictureList);
				//不使用freemarker生成html，使用jsp
				modelAndView.addObject("courseList", courseList);

				//取出已经开通的年级的列表。
				List<Clazz> clazzList =clazzService.findClazzByStatus();
				modelAndView.addObject("clazzList", clazzList);
				
			}else{
				returnString="wechat/error";
			}
		}else{
			returnString="wechat/error";
		}
		modelAndView.setViewName(returnString);
		return modelAndView;
	}
	
	
	@GetMapping(value = "userCenter")
	public String userCenter(HttpSession session,Model model) throws Exception{
		//从session取出当前user
		/*UserWechat user=(UserWechat) session.getAttribute("user");*/
		/*//生成个人中心静态页面
		Configuration configuration = freeMarkerConfigurer.getConfiguration();
		//获取模板
		Template template = configuration.getTemplate("html/person/center.html");
		//创建数据集
		Map data = new HashMap<>();
		data.put("user", user);
		//使用监听器获取相对路径
		String filePath=System.getProperty("path.webapp");
		Writer out = new FileWriter(new File(filePath+"\\WEB-INF\\views\\wechat\\person\\center.html"));
		//生成html
		template.process(data, out);
		out.close();*/
		//返回结果，结果是个人中心页面
		/*UserWechat user=(UserWechat) session.getAttribute("user");
		model.addAttribute("user", user);*/
		return "wechat/person/center";
	}
}
