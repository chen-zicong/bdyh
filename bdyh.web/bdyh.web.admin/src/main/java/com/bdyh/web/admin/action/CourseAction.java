package com.bdyh.web.admin.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bdyh.common.APIResponse;
import com.bdyh.entity.Teacher;
import com.bdyh.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bdyh.common.redis.RedisCacheUtil;
import com.bdyh.entity.Course;
import com.bdyh.entity.Video;
import com.bdyh.service.CourseService;
import com.bdyh.service.VideoService;
import com.bdyh.web.admin.shiro.ActiveUser;

/**
 * 2018年1月31日
 *
 * @author cxs
 */
@Controller
@RequestMapping(value = "course")
public class CourseAction {

    @Autowired
    private CourseService courseService;

    @Autowired
    private VideoService videoService;

    @Autowired
    private RedisCacheUtil<Object> redisCache;

    @Autowired
    private DistrictService districtService;

    /**
     * 调用此方法的是教师
     *
     * @param session
     * @return
     */
    @RequestMapping("myCourse")
    public String myCourse(HttpSession session, Model model) {
        //取出当前用户，该用户                                                                                                                                                                                                           是教师
        ActiveUser activeUser = (ActiveUser) session.getAttribute("activeUser");
        //userid就是教师的唯一标识，可根据该id查询course列表
        Integer teacherId = activeUser.getUserid();
        //从缓存查询属于教师的课程
		/*List<Course> courseList=redisCache.getCacheList("courseOfTeacher"+teacherId);
		if(courseList==null||courseList.size()==0){
			courseList=courseService.findCourseOfTeacher(teacherId);
			redisCache.setCacheList("courseOfTeacher"+teacherId, courseList);
		}*/

        List<Course> courseList = courseService.findCourseOfTeacher(teacherId);

        model.addAttribute("courseList", courseList);
        return "course/course-list";
    }


    @GetMapping(value = "courseVideo/{courseId}")
    public String courseVideo(Model model, @PathVariable("courseId") Integer courseId) {
        //根据课程的唯一标识查询所属课程的视频
        System.out.println(courseId);
        //TODO 使用缓存
        List<Video> videoList = videoService.findVideoByCourseId(courseId);
        //这里加入的参数主要是为了后面上传视频时候的标识
        model.addAttribute("courseId", courseId);
        model.addAttribute("videoList", videoList);
        return "course/course-show";
    }

    /**
     * 跳转到修改课程详情页面
     *
     * @return
     */
    @GetMapping(value = "courseEditPage/{courseId}")
    public String courseEditPage(Model model, @PathVariable("courseId") Integer courseId) {

        //根据传过来的courseId查询课程
        Course course = courseService.findCourseById(courseId);
        model.addAttribute("course", course);
        return "course/course-edit";
    }

    /**
     * 添加课程页面不应该有上传图片的功能，因为无法获取courseId
     * 所以分成两个页面做，要上传课程图片只能在修改页面，目的是减少服务器硬盘浪费
     *
     * @return
     */
    @GetMapping(value = "courseAddPage")
    public String courseAddPage() {
        return "course/course-add";
    }

    /**
     * 跳转到修改页面
     *
     * @param course
     */
    @GetMapping(value = "courseEdit")
    public void courseEdit(Course course) {

    }

    /**
     * 为课程上传图片，存放位置应该是nginx服务器里面的路径
     * <p>
     * 上传位置应该是D:\nginx-1.12.2\html\home\demo
     * 而且该项目的tomcat服务器跟nginx放在同一目录下
     * 同名文件会覆盖
     *
     * @param file
     * @param request
     * @param response
     * @throws IOException
     * @throws IllegalStateException
     */
    @RequestMapping(value = "uploadPicture/{courseId}")
    /*@ResponseBody*/
    public void uploadPicture(MultipartFile file, HttpServletRequest request, HttpServletResponse response, @PathVariable("courseId") Integer courseId) throws IllegalStateException, IOException {
        //课程的图片
        File picture = null;

        //获取tomcat所在的目录
        System.out.println(System.getProperty("catalina.base"));
        String path = System.getProperty("catalina.base");

        //TODO 这两个字符串应该配置起来
        //必须存在该文件夹结构，不然会报错，这里确定是存在该结构的
        String newPath = path.replace("tomcat8-2", "nginx/html/home/courseImg");

        //获取文件名
        //文件名必须是以couseId和courseType为标识的，比如课程的courseId是1，且courseType为语文，那么图片的名字为yuwen1
        String fileName = file.getOriginalFilename();
        int i = fileName.lastIndexOf(".");
        //文件后缀名
        String suffix = fileName.substring(i, fileName.length());
        String newFileName = "course" + courseId + suffix;
        //fileName=ChineseToPinyinUtil.getPinyin(courseType)+courseId;
        //文件名为course+courseId
        picture = new File(newPath + "/", newFileName);

        //开始上传
        file.transferTo(picture);
        //上传成功之后需要更新数据库,主要是更新后缀名
        //当后缀名不一致时才需要更新


        //查询出该课程然后更新
        Course course = courseService.findCourseById(courseId);
        //文件后缀名
        String courseImgSuffix = null;
        if (course.getCourseImg() != null) {
            courseImgSuffix = course.getCourseImg().substring(course.getCourseImg().lastIndexOf("."), course.getCourseImg().length());
        }

        if (!suffix.equalsIgnoreCase(courseImgSuffix)) {
            String newCourseName = newFileName;
            course.setCourseImg(newCourseName);
            //更新数据库
            courseService.updateCourse(course);
        }
        System.out.println(fileName + "上传成功");
    }

    /**
     * 修改course
     *
     * @param course
     * @param response
     * @param request
     * @throws IOException
     */
    @PostMapping(value = "courseUpdate")
    public void courseUpdate(Course course, HttpServletResponse response, HttpServletRequest request) throws IOException {
        PrintWriter out = response.getWriter();
        //由于表单的course对象很多字段为空，不能直接更新
        //查询出该课程然后更新
        Course oldCourse = courseService.findCourseById(course.getCourseId());

        //上传图片D:\nginx\html\home\courseImg
        MultipartFile items = ((MultipartHttpServletRequest) request).getFile("image");
        if (items.getOriginalFilename() == null || "".equals(items.getOriginalFilename())) {
            out.write("{\"status\":-1}");
            return;
        }

        //windows上传图片D:\nginx\html\home\courseImg
        //linux上传图片/usr\local\nginx\html\home\courseImg
        //课程的图片
        File picture = null;
        String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        //String path = "D:/nginx/html/home/courseImg";
        String path = "/usr/local/nginx/html/home/courseImg/";
		/*File dir = new File(path);
		if(!dir.exists()){
			dir.mkdirs();
		}*/

        //文件后缀名
        String fileName = items.getOriginalFilename();
        int i = fileName.lastIndexOf(".");
        String suffix = fileName.substring(i, fileName.length());
        picture = new File(path, "course" + date + suffix);


        //开始上传
        items.transferTo(picture);
        System.out.println(picture.getName());
        //设置访问权限
        Runtime.getRuntime().exec("chmod 755 " + path + picture.getName());


        if (course.getCourseName() != null && !"".equals(course.getCourseName())) {
            oldCourse.setCourseName(course.getCourseName());
        }
        if (course.getCourseType() != null && !"".equals(course.getCourseType())) {
            oldCourse.setCourseType(course.getCourseType());
        }
        if (course.getCourseLevel() != null) {
            oldCourse.setCourseLevel(course.getCourseLevel());
        }
        if (course.getCourseDifficulty() != null) {
            oldCourse.setCourseDifficulty(course.getCourseDifficulty());
        }
        if (course.getLessionNum() != null) {
            oldCourse.setLessionNum(course.getLessionNum());
        }
        if (course.getCoursePrice() != null) {
            oldCourse.setCoursePrice(course.getCoursePrice());
        }
        if (course.getCourseDesc() != null && !"".equals(course.getCourseDesc())) {
            oldCourse.setCourseDesc(course.getCourseDesc());
        }

        //照理说修改之后应该把status修改为1，待审核
        oldCourse.setStatus(1);
        oldCourse.setCourseImg(picture.getName());
        courseService.updateCourse(oldCourse);

        out.write("{\"status\":1}");
    }

    /**
     * 教师添加 课程
     *
     * @param course
     * @param response
     * @param request
     */
    @PostMapping(value = "courseAdd")
    public void courseAdd(Course course, HttpServletResponse response, HttpServletRequest request, HttpSession session) {
        Teacher teacher = (Teacher) session.getAttribute("userTeacher");
        PrintWriter out = null;

        try {
            out = response.getWriter();

            //上传图片D:\nginx\html\home\courseImg
            MultipartFile items = ((MultipartHttpServletRequest) request).getFile("image");
            if (items.getOriginalFilename() == null || "".equals(items.getOriginalFilename())) {
                out.write("{\"status\":-1}");
                return;
            }

            //windows上传图片D:\nginx\html\home\courseImg
            //linux上传图片/usr\local\nginx\html\home\courseImg
            //课程的图片
            File picture = null;
            String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            //String path = "D:/nginx/html/home/courseImg";
            String path = "/usr/local/nginx/html/home/courseImg/";
			/*File dir = new File(path);
			if(!dir.exists()){
				dir.mkdirs();
			}*/

            //文件后缀名
            String fileName = items.getOriginalFilename();
            int i = fileName.lastIndexOf(".");
            String suffix = fileName.substring(i, fileName.length());
            picture = new File(path, "course" + date + suffix);


            //开始上传
            items.transferTo(picture);
            System.out.println(picture.getName());
            //设置访问权限
            Runtime.getRuntime().exec("chmod 755 " + path + picture.getName());


            /**
             * 完善课程信息
             */
            //取出当前教师
            ActiveUser activeUser = (ActiveUser) request.getSession().getAttribute("activeUser");
            //教师id
            course.setTeacherId(activeUser.getUserid());
            //非推荐课程
            course.setCourseRecommend(0);
            //区域id,districtId

            int cityId = districtService.findCityByProvince(activeUser.getDistrictId());

            course.setDistrictId(cityId);
            course.setCourseImg(picture.getName());
            course.setFlowNumber(0);
            course.setStatus(0);
            course.setLessionNum(0);
            course.setCoursePrice(0.0);
            course.setCollectNumber(0);
            course.setBenefit(0.0);
            //是描述跟介绍一样，字段多了不想删
            course.setCourseIntro(course.getCourseDesc());
            //课程所属的代理商
            course.setAgentId(teacher.getAgentId());
            //保存记录
            courseService.saveCourse(course);
            out.write("{\"status\":1}");
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    /**
     * 课程下架
     *
     * @param courseId
     * @param response
     */
    @GetMapping(value = "courseLayDown")
    public void courseLayDown(Integer courseId, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
            //根据courseId查询课程对象
            Course course = courseService.findCourseById(courseId);
            //下架课程，把course表的status置为0
            course.setStatus(0);
            //跟新数据库，并删除redis缓存
            courseService.updateCourse(course);
            //操作成功，向客户端输出1
            out.write("{\"status\":1}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 课程申请上线
     *
     * @param courseId
     * @param response
     */
    @GetMapping(value = "courseLayUp")
    public void courseLayUp(Integer courseId, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
            //根据courseId查询课程对象
            Course course = courseService.findCourseById(courseId);
            //申请课程上线，把course表的status置为1
            course.setStatus(1);
            //跟新数据库，并删除redis缓存
            courseService.updateCourse(course);
            //操作成功，向客户端输出1
            out.write("{\"status\":1}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除课程，考虑删除所有属于该课程的视频，
     *
     * @param courseId
     * @param response
     */

    @GetMapping(value = "courseDelete")
    public void courseDelete(Integer courseId, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
            //跟新数据库，并删除redis缓存
            courseService.deleteCourseByCourseId(courseId);


            //TODO 删除硬盘上的视频文件

            //操作成功，向客户端输出1
            out.write("{\"status\":1}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("batchDeleteCourse")
    @ResponseBody
    @Transactional
    public APIResponse batchDeleteCourse(int[] coursesId) {


        for (int courseId : coursesId) {
            courseService.deleteCourseByCourseId(courseId);
        }
        return APIResponse.success();
    }
}
