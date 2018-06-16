package com.bdyh.web.admin.action;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bdyh.common.AdminUtil;
import com.bdyh.entity.*;
import com.bdyh.service.*;
import com.bdyh.web.admin.shiro.ActiveUser;
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

/**
 * 教师管理
 * 2018年2月2日
 *
 * @author cxs
 */
@Controller
@RequestMapping(value = "teacher")
public class TeacherAction {

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
     * 查询所有教师
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "teacherList")
    public String teacherList(Model model) {
        List<Teacher> teacherList = new ArrayList<>();
        ActiveUser user = (ActiveUser) AdminUtil.getShiroSessionByKey("activeUser");
        if (user == null) {
            //TODO 异常处理
        }
        String role = user.getRole();
        if (role.equals("admin")) {
            //查询所有教师
        teacherList = teacherService.findAllTeacher();
        } else if (role.equals("agent")) {
//            //按代理商等级查找老师，只能查找在他地区之下的老师
//            Agent agent = (Agent) session.getAttribute("userAgent");
//            int agentLevel = agent.getAgentLevel();
//            if(agentLevel==1){
//                Integer provinceId = agent.getProvinceId();
//                teacherList = teacherService.findTeacherByProvince(provinceId);
//            }else if(agentLevel==2){
//                Integer cityId = agent.getCityId();
//                teacherList = teacherService.findTeacherByCity(cityId);
//            }else if(agentLevel ==3){
//                Integer districtId = agent.getDistrictId();
//                teacherList = teacherService.findTeacherByDistrict(districtId);
//            }else {
//                //TODO E
//            }
             //另一种方法，根据老师所属的代理商去查询
               Agent agent = (Agent)AdminUtil.getShiroSessionByKey("userAgent");
            Integer agentId = agent.getAgentId();
            teacherList = teacherService.findTeacherByAgent(agentId);

        }else {
            //TODO 异常处理
        }
        model.addAttribute("teacherList", teacherList);
        return "teacher/teacher-list";
    }

    /**
     * 弹出添加教师页面
     *
     * @return
     */
    @GetMapping(value = "teacherAddPage")
    public String teacherAddPage() {
        return "teacher/teacher-add";
    }

    /**
     * 管理员添加教师
     *
     * @param teacher
     * @param district
     * @param response
     * @param request
     */
    @RequestMapping(value = "teacherAdd")
    public void teacherAdd(Teacher teacher, String district, HttpServletResponse response, HttpServletRequest request) {
        Agent agent = (Agent)AdminUtil.getShiroSessionByKey("userAgent");
        PrintWriter out = null;
        try {
            out = response.getWriter();

            //先根据教师的username查询teacher，user_admin，agent表看是否已存在用户，避免重复

            if (teacherService.findTeacherByUsername(teacher.getUsername()) != null) {
                //已存在向客户端输出3
                out.write("{\"status\":3}");
                return;
            }
            if (agentService.findAgentByUsername(teacher.getUsername()) != null) {
                //已存在向客户端输出3
                out.write("{\"status\":3}");
                return;
            }
            if (userAdminService.findUserAdminByUsername(teacher.getUsername()) != null) {
                //已存在向客户端输出3
                out.write("{\"status\":3}");
                return;
            }

            MultipartFile items = ((MultipartHttpServletRequest) request).getFile("image");
            if (items.getOriginalFilename() == null || "".equals(items.getOriginalFilename())) {
                out.write("{\"status\":-1}");
                return;
            }

            //windows上传图片D:\nginx\html\home\teacherImg
            //linux上传图片/usr\local\nginx\html\home\teacherImg
            //课程的图片
            File picture = null;
            String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            //String path = "D:/nginx/html/home/teacherImg";
            String path = "/usr/local/nginx/html/home/teacherImg/";
			/*File dir = new File(path);
			if(!dir.exists()){
				dir.mkdirs();
			}*/

            //文件后缀名
            String fileName = items.getOriginalFilename();
            int i = fileName.lastIndexOf(".");
            String suffix = fileName.substring(i, fileName.length());
            picture = new File(path, "teacher" + date + suffix);


            //开始上传
            items.transferTo(picture);
            System.out.println(picture.getName());
            //设置访问权限
            Runtime.getRuntime().exec("chmod 755 " + path + picture.getName());

            //完善教师信息
            //1根据district查询出区域的id，如果查询不到向客户端输出暂未开通该区域
            //截取区域,strs[2]是区域
            String[] strs = district.split("-");
            District esixtDistrict = districtService.findDistrictByName(strs[2]);
            City existCity = cityService.findCityByName(strs[1]);
            Province existProvince = provinceService.findProvinceByName(strs[0]);


            //如果esixtDistrict为空，向客户端输出2
            if (esixtDistrict == null || existCity == null || existProvince == null) {
                out.write("{\"status\":2}");
                return;
            }

            //教师照片路径
            teacher.setTeacherImg(picture.getName());
            //为教师完善区域信息
            teacher.setDistrictId(esixtDistrict.getDistrictId());
            teacher.setCityId(existCity.getCityId());
            teacher.setProvinceId(existProvince.getProvinceId());
            //完善注册时间
            teacher.setJoinTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            //激活状态
            teacher.setStatus(1);
            //密码加密
            String password = teacher.getPassword();
            teacher.setPassword(new MD5Util().getMD5ofStr(password));
            //登录次数，初始化为0
            teacher.setLoginNumber(0);
            //设置该用户的角色,登录时候才能拿到菜单,教师的role是1
            teacher.setRoleId(1);
            //收藏记录为0
            teacher.setCollectNumber(0);
            //所属的代理商
            teacher.setAgentId(agent.getAgentId());
            //保存记录
            teacherService.saveTeacher(teacher);
            //添加成功，向客户端输出1
            out.write("{\"status\":1}");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 查看教师
     *
     * @param model
     * @param teacherId
     * @return
     */
    @GetMapping(value = "teacherShow/{teacherId}")
    public String teacherShow(Model model, @PathVariable("teacherId") Integer teacherId) {
        //查询
        Teacher teacher = teacherService.findTeacherById(teacherId);
        //传递
        model.addAttribute("teacher", teacher);
        //跳转
        return "teacher/teacher-show";
    }

    /**
     * 管理员停用教师
     *
     * @param teacherId
     * @param response
     */
    @PostMapping(value = "teacherStop")
    public void teacherStop(Integer teacherId, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
            Teacher teacher = teacherService.findTeacherById(teacherId);
            teacher.setStatus(0);
            teacherService.updateTeacher(teacher);
            out.write("{\"status\":1}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 管理员启用教师
     *
     * @param teacherId
     * @param response
     */
    @PostMapping(value = "teacherStart")
    public void teacherStart(Integer teacherId, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
            Teacher teacher = teacherService.findTeacherById(teacherId);
            teacher.setStatus(1);
            teacherService.updateTeacher(teacher);
            out.write("{\"status\":1}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 跳转到修改教师信息页面
     *
     * @param model
     * @param teacherId
     * @return
     */
    @RequestMapping(value = "teacherEditPage/{teacherId}")
    public String teacherEditPage(Model model, @PathVariable("teacherId") Integer teacherId) {
        Teacher teacher = teacherService.findTeacherById(teacherId);
        model.addAttribute("teacher", teacher);
        return "teacher/teacher-edit";
    }

    /**
     * 教师信息修改
     *
     * @param teacher
     * @param district
     * @param response
     * @param request
     */
    @PostMapping(value = "teacherEdit")
    public void teacherEdit(Teacher teacher, String district, HttpServletResponse response, HttpServletRequest request) {

        PrintWriter out = null;
        try {
            out = response.getWriter();

            Teacher existTeacher = teacherService.findTeacherById(teacher.getTeacherId());
            if (!existTeacher.getUsername().equals(teacher.getUsername())) {

                //先根据教师的username查询teacher，user_admin，agent表看是否已存在用户，避免重复
                if (teacherService.findTeacherByUsername(teacher.getUsername()) != null) {
                    //已存在向客户端输出3
                    out.write("{\"status\":3}");
                    return;
                }
                if (agentService.findAgentByUsername(teacher.getUsername()) != null) {
                    //已存在向客户端输出3
                    out.write("{\"status\":3}");
                    return;
                }
                if (userAdminService.findUserAdminByUsername(teacher.getUsername()) != null) {
                    //已存在向客户端输出3
                    out.write("{\"status\":3}");
                    return;
                }
                //账户
                existTeacher.setUsername(teacher.getUsername());
            }

            MultipartFile items = ((MultipartHttpServletRequest) request).getFile("image");
            if (items.getOriginalFilename() == null || "".equals(items.getOriginalFilename())) {
                out.write("{\"status\":-1}");
                return;
            }

            //windows上传图片D:\nginx\html\home\teacherImg
            //linux上传图片/usr\local\nginx\html\home\teacherImg
            //课程的图片
            File picture = null;
            String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            //String path = "D:/nginx/html/home/teacherImg";
            String path = "/usr/local/nginx/html/home/teacherImg/";
			/*File dir = new File(path);
			if(!dir.exists()){
				dir.mkdirs();
			}*/

            //文件后缀名
            String fileName = items.getOriginalFilename();
            int i = fileName.lastIndexOf(".");
            String suffix = fileName.substring(i, fileName.length());
            picture = new File(path, "teacher" + date + suffix);


            //开始上传
            items.transferTo(picture);
            System.out.println(picture.getName());
            //设置访问权限
            Runtime.getRuntime().exec("chmod 755 " + path + picture.getName());


            //完善教师信息
            existTeacher.setTeacherImg(picture.getName());
            existTeacher.setTeacherName(teacher.getTeacherName());
            existTeacher.setSex(teacher.getSex());
            existTeacher.setTelephone(teacher.getTelephone());
            existTeacher.setEmail(teacher.getEmail());
            existTeacher.setMajor(teacher.getMajor());
            existTeacher.setTeacherIntro(teacher.getTeacherIntro());

            //1根据district查询出区域的id，如果查询不到向客户端输出暂未开通该区域
            //截取区域,strs[2]是区域
            String[] strs = district.split("-");
            District esixtDistrict = districtService.findDistrictByName(strs[2]);
            City existCity = cityService.findCityByName(strs[1]);
            Province existProvince = provinceService.findProvinceByName(strs[0]);


            //如果esixtDistrict为空，向客户端输出2
            if (esixtDistrict == null || existCity == null || existProvince == null) {
                out.write("{\"status\":2}");
                return;
            }

            //为教师完善区域信息
            existTeacher.setDistrictId(esixtDistrict.getDistrictId());
            existTeacher.setProvinceId(existProvince.getProvinceId());
            existTeacher.setCityId(existCity.getCityId());

            //修改记录
            teacherService.updateTeacher(existTeacher);

            //修改成功，向客户端输出1
            out.write("{\"status\":1}");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 跳转到修改密码页面
     *
     * @param model
     * @param teacherId
     * @return
     */
    @RequestMapping(value = "changePasswordPage/{teacherId}")
    public String changePasswordPage(Model model, @PathVariable("teacherId") Integer teacherId) {
        //把teacher带到修改页面
        Teacher teacher = teacherService.findTeacherById(teacherId);
        model.addAttribute("teacher", teacher);
        return "teacher/change-password";
    }

    /**
     * 管理员修改教师密码
     *
     * @param response
     * @param teacherId
     * @param newpassword
     */
    @PostMapping(value = "changePassword")
    public void changePassword(HttpServletResponse response, Integer teacherId, String newpassword) {
        PrintWriter out = null;

        try {
            out = response.getWriter();
            Teacher teacher = teacherService.findTeacherById(teacherId);
            //加密
            teacher.setPassword(new MD5Util().getMD5ofStr(newpassword));
            teacherService.updateTeacher(teacher);

            //修改成功，向客户端输出1
            out.write("{\"status\":1}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @PostMapping(value = "teacherDelete")
    public void teacherDelete(HttpServletResponse response, Integer teacherId) {
        PrintWriter out = null;

        try {
            out = response.getWriter();
            teacherService.deleteTeacherById(teacherId);
            //删除成功，向客户端输出1
            out.write("{\"status\":1}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
