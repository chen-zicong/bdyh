package com.bdyh.web.admin.action;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bdyh.common.MD5.MD5Util;
import com.bdyh.entity.Agent;
import com.bdyh.entity.City;
import com.bdyh.entity.District;
import com.bdyh.entity.Province;
import com.bdyh.service.AgentService;
import com.bdyh.service.CityService;
import com.bdyh.service.DistrictService;
import com.bdyh.service.ProvinceService;
import com.bdyh.service.TeacherService;
import com.bdyh.service.UserAdminService;


/**
 * 管理员管理代理
 * 2018年2月6日
 * @author cxs
 */
@Controller
@RequestMapping(value="adminAgent")
public class AdminAgentAction {
	
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private DistrictService districtService;
	@Autowired
	private AgentService agentService;
	@Autowired
	private UserAdminService userAdminService;
	@Autowired
	private CityService cityService;
	@Autowired
	private ProvinceService provinceService;
	/**
	 * 所有代理商
	 * @param model
	 * @return
	 */
	@RequestMapping(value="agentList")
	public String agentList(Model model){
		//查询所有教师
		List<Agent> agentList=agentService.findAllAgent();
		
		model.addAttribute("agentList", agentList);
		return "agent/agent-list";
	}
	
	/**
	 * 添加代理商页面
	 * @return
	 */
	@RequestMapping(value="agentAddPage")
	public String agentAddPage(){
		return "agent/agent-add";
	}
	
	/**
	 * 查看教师
	 * @param model
	 * @param
	 * @return
	 */
	@GetMapping(value="agentShow/{agentId}")
	public String agentShow(Model model,@PathVariable("agentId") Integer agentId){
		//查询
		Agent agent=agentService.findAgentById(agentId);
		//传递
		model.addAttribute("agent", agent);
		//跳转
		return "agent/agent-show";
	}
	
	
	/**
	 * 跳转到修改教师信息页面
	 * @param model
	 * @param
	 * @return
	 */
	@RequestMapping(value="agentEditPage/{agentId}")
	public String agentEditPage(Model model,@PathVariable("agentId") Integer agentId){
		Agent agent=agentService.findAgentById(agentId);
		model.addAttribute("agent", agent);
		return "agent/agent-edit";
	}
	
	/**
	 * 代理商信息修改
	 * @param district
	 * @param response
	 * @param request
	 */
	@PostMapping(value="agentEdit")
	public void agentEdit(Agent agent,String district,HttpServletResponse response,HttpServletRequest request){
		
		PrintWriter out=null;
		try{
			out=response.getWriter();
			
			Agent existAgent=agentService.findAgentById(agent.getAgentId());
			
			if(!existAgent.getUsername().equals(agent.getUsername())){
				
				//先根据教师的username查询teacher，user_admin，agent表看是否已存在用户，避免重复
				if(teacherService.findTeacherByUsername(agent.getUsername())!=null){
					//已存在向客户端输出3
					out.write("{\"status\":3}");
					return;
				}
				if(agentService.findAgentByUsername(agent.getUsername())!=null){
					//已存在向客户端输出3
					out.write("{\"status\":3}");
					return;
				}
				if(userAdminService.findUserAdminByUsername(agent.getUsername())!=null){
					//已存在向客户端输出3
					out.write("{\"status\":3}");
					return;
				}
				//账户
				existAgent.setUsername(agent.getUsername());
			}
			
			MultipartFile items =  ((MultipartHttpServletRequest) request).getFile("image");
			if(items.getOriginalFilename()==null||"".equals(items.getOriginalFilename())){
				out.write("{\"status\":-1}");
				return;
			}
			
			//windows上传图片D:\nginx\html\home\teacherImg
			//linux上传图片/usr\local\nginx\html\home\teacherImg
			//课程的图片
			File picture = null;
			String date=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			//String path = "D:/nginx/html/home/teacherImg";
			String path = "/usr/local/nginx/html/home/agentImg/";
//			File dir = new File(path);
//			if(!dir.exists()){
//				dir.mkdirs();
//			}
			
			//文件后缀名
			String fileName = items.getOriginalFilename();
			int i =fileName.lastIndexOf(".");
			String suffix=fileName.substring(i, fileName.length());
			picture=new File(path,"agent"+date+suffix);
			
			
			//开始上传
			items.transferTo(picture);
			System.out.println(picture.getName());
			//设置访问权限
			Runtime.getRuntime().exec("chmod 755 " + path+picture.getName());
			
			
			//完善代理商
			existAgent.setAgentImg(picture.getName());
			existAgent.setNickname(agent.getNickname());
			existAgent.setSex(agent.getSex());
			existAgent.setTelephone(agent.getTelephone());
			existAgent.setEmail(agent.getEmail());
			existAgent.setAgentLevel(agent.getAgentLevel());
			existAgent.setAgentIntro(agent.getAgentIntro());
			
			//完善代理商信息
			//1根据district查询出区域的id，如果查询不到向客户端输出暂未开通该区域
			//截取区域,strs[2]是区域
			String[] strs=district.split("-");
			District esixtDistrict=districtService.findDistrictByName(strs[2]);
			City existCity=cityService.findCityByName(strs[1]);
			Province existProvince=provinceService.findProvinceByName(strs[0]);
			
			
			//如果esixtDistrict为空，向客户端输出2
			if(esixtDistrict==null || existCity==null || existProvince==null){
				out.write("{\"status\":2}");
				return;
			}
			
			//为代理商完善区域信息,包括省市区
			agent.setDistrictId(esixtDistrict.getDistrictId());
			agent.setCityId(existCity.getCityId());
			agent.setProvinceId(existProvince.getProvinceId());
			
			//修改记录
			agentService.updateAgent(existAgent);
			
			//修改成功，向客户端输出1
			out.write("{\"status\":1}");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 管理员添加代理商
	 * @param
	 * @param district
	 * @param response
	 * @param request
	 */
	@RequestMapping(value="agentAdd")
	public void agentAdd(Agent agent,String district,HttpServletResponse response,HttpServletRequest request){
		
		PrintWriter out=null;
		try{
			out=response.getWriter();
			
			//先根据教师的username查询teacher，user_admin，agent表看是否已存在用户，避免重复
			
			if(teacherService.findTeacherByUsername(agent.getUsername())!=null){
				//已存在向客户端输出3
				out.write("{\"status\":3}");
				return;
			}
			if(agentService.findAgentByUsername(agent.getUsername())!=null){
				//已存在向客户端输出3
				out.write("{\"status\":3}");
				return;
			}
			if(userAdminService.findUserAdminByUsername(agent.getUsername())!=null){
				//已存在向客户端输出3
				out.write("{\"status\":3}");
				return;
			}
			
			MultipartFile items =  ((MultipartHttpServletRequest) request).getFile("image");
			if(items.getOriginalFilename()==null||"".equals(items.getOriginalFilename())){
				out.write("{\"status\":-1}");
				return;
			}
			
			//windows上传图片D:\nginx\html\home\agentImg
			//linux上传图片/usr\local\nginx\html\home\agentImg
			//课程的图片
			File picture = null;
			String date=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			//String path = "D:/nginx/html/home/agentImg";
			String path = "/usr/local/nginx/html/home/agentImg/";
//		//	String path = "D:\\bdyh\\agentImg";
//			File dir = new File(path);
//			if(!dir.exists()){
//				dir.mkdirs();
//			}
			
			//文件后缀名
			String fileName = items.getOriginalFilename();
			int i =fileName.lastIndexOf(".");
			String suffix=fileName.substring(i, fileName.length());
			picture=new File(path+"/","agent"+date+suffix);
			
			
			//开始上传
			items.transferTo(picture);
			System.out.println(picture.getName());
			//设置访问权限
		Runtime.getRuntime().exec("chmod 755 " + path+picture.getName());
			
			
			//完善代理商信息
			//1根据district查询出区域的id，如果查询不到向客户端输出暂未开通该区域
			//截取区域,strs[2]是区域
			String[] strs=district.split("-");
			District esixtDistrict=districtService.findDistrictByName(strs[2]);
			City existCity=cityService.findCityByName(strs[1]);
			Province existProvince=provinceService.findProvinceByName(strs[0]);
			
			
			//如果esixtDistrict为空，向客户端输出2
			if(esixtDistrict==null || existCity==null || existProvince==null){
				out.write("{\"status\":2}");
				return;
			}
			
			//代理商照片
			agent.setAgentImg(picture.getName());
			
			//为代理商完善区域信息
			agent.setDistrictId(esixtDistrict.getDistrictId());
			agent.setCityId(existCity.getCityId());
			agent.setProvinceId(existProvince.getProvinceId());
			
			//完善注册时间
			agent.setJoinTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			//激活状态
			agent.setStatus(1);
			//密码加密
			String password=agent.getPassword();
			agent.setPassword(new MD5Util().getMD5ofStr(password));
			//登录次数，初始化为0
			agent.setLoginNumber(0);
			//设置该用户的角色,登录时候才能拿到菜单,代理商的role是2
			agent.setRoleId(2);
			
			//保存记录
			agentService.saveAgent(agent);
			
			//添加成功，向客户端输出1
			out.write("{\"status\":1}");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@PostMapping(value="agentDelete")
	public void agentDelete(HttpServletResponse response,Integer agentId){
		PrintWriter out=null;
		
		try{
			out=response.getWriter();
			agentService.deleteAgentById(agentId);
			//删除成功，向客户端输出1
			out.write("{\"status\":1}");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 跳转到修改密码页面
	 * @param model
	 * @param agentId
	 * @return
	 */
	@RequestMapping(value="changePasswordPage/{agentId}")
	public String changePasswordPage(Model model,@PathVariable("agentId") Integer agentId){
		//把teacher带到修改页面
		Agent agent=agentService.findAgentById(agentId);
		model.addAttribute("agent", agent);
		return "agent/change-password";
	}
	/**
	 * 管理员修改代理商密码
	 * @param response
	 * @param agentId
	 * @param newpassword
	 */
	@PostMapping(value="changePassword")
	public void changePassword(HttpServletResponse response,Integer agentId,String newpassword){
		PrintWriter out=null;
		
		try{
			out=response.getWriter();
			Agent agent=agentService.findAgentById(agentId);
			//加密
			agent.setPassword(new MD5Util().getMD5ofStr(newpassword));
			agentService.updateAgent(agent);
			
			//修改成功，向客户端输出1
			out.write("{\"status\":1}");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * 管理员停用代理商
	 * @param agentId
	 * @param response
	 */
	@PostMapping(value="agentStop")
	public void agentStop(Integer agentId,HttpServletResponse response){
		PrintWriter out=null;
		try{
			out=response.getWriter();
			Agent agent=agentService.findAgentById(agentId);
			agent.setStatus(0);
			agentService.updateAgent(agent);
			out.write("{\"status\":1}");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 管理员启用代理商
	 * @param agentId
	 * @param response
	 */
	@PostMapping(value="agentStart")
	public void agentStart(Integer agentId,HttpServletResponse response){
		PrintWriter out=null;
		try{
			out=response.getWriter();
			Agent agent=agentService.findAgentById(agentId);
			agent.setStatus(1);
			agentService.updateAgent(agent);
			out.write("{\"status\":1}");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
