package com.bdyh.web.home.action;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.xml.registry.infomodel.User;

import com.bdyh.dao.UserOrderMapper;
import com.bdyh.entity.*;
import com.bdyh.service.*;
import com.bdyh.wechat.pay.utils.WXPayUtil;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.bdyh.common.redis.RedisCacheUtil;
import com.bdyh.web.home.utils.CourseLevelUtil;

/**
 * 课程控制器
 * 2018年1月12日
 *
 * @author cxs
 */
@Controller
@RequestMapping(value = "course")
public class CourseAction {

    @Autowired
    private RedisCacheUtil<Object> redisCache;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Autowired
    private CourseService courseService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private VideoService videoService;

    @Autowired
    private UserTrackService userTrackService;

    @Autowired
    private DistrictService districtService;

    @Autowired
    private OrderService orderService;


    /**
     * 查询所有推荐的课程
     *
     * @return
     */
    @GetMapping(value = "moreLesson")
    public String moreLesson(Model model) throws Exception {
        List<Course> courseList = null;
        //先在缓存查询所有推荐课程，如果没有找到，再去数据库查询
        courseList = redisCache.getCacheList("courseListRecommand");
        if (courseList.size() == 0) {
            //查询所有推荐课程并保存在缓存
            courseList = courseService.findAllRecommandCourse();
            redisCache.setCacheList("courseListRecommand", courseList);
        }
		
		/*Configuration configuration = freeMarkerConfigurer.getConfiguration();
		//获取模板
		Template template = configuration.getTemplate("html/course/list.html");
		//创建数据集
		Map data = new HashMap<>();
		data.put("courseList", courseList);
		//使用监听器获取相对路径
		String filePath=System.getProperty("path.webapp");
		Writer out = new FileWriter(new File(filePath+"\\WEB-INF\\views\\wechat\\course\\list.html"));
		//生成html
		template.process(data, out);
		out.close();*/

        model.addAttribute("courseList", courseList);
        return "wechat/course/list";
    }

    /**
     * 跳转到播放视频页面
     *
     * @return
     * @throws Exception
     */


    @GetMapping(value = "courseDetails/{courseId}")
    public String courseDetails(HttpSession session, Model model, @PathVariable("courseId") Integer courseId) throws Exception {
        Course course = null;
        Teacher teacher = null;
        UserWechat user = (UserWechat) session.getAttribute("user");

		/*RedisCacheUtil<Course> redisCacheUtil1=new RedisCacheUtil<Course>();
		RedisCacheUtil<Teacher> redisCacheUtil2=new RedisCacheUtil<Teacher>();
		//根据courseId保存课程对象，下次需要时候直接根据courseId在缓存中找
		course=redisCacheUtil1.getCacheObject(courseId+"");
		if(course==null){
			//在缓存没找到对象则去数据库查
			course=courseService.findCourseById(courseId);
			//根据courseId保存课程对象到redis中
			redisCacheUtil1.setCacheObject(courseId+"", course);
		}
		//根据teacherId保存教师对象，下次需要时候直接根据teacherId在缓存中找
		teacher=redisCacheUtil2.getCacheObject(course.getTeacherId()+"");
		if(teacher==null){
			//在缓存没找到对象则去数据库查
			teacher=teacherService.findTeacherById(course.getTeacherId());
			//根据teacherId保存课程对象到redis中
			redisCacheUtil2.setCacheObject(teacher.getTeacherId()+"", teacher);
		}*/


        /**
         * 找到已经购买了的课程
         */
        course = courseService.findCourseById(courseId);
        teacher = teacherService.findTeacherById(course.getTeacherId());
        List<Video> videoList = videoService.findVideoByCourseId(courseId);
        List<UserOrder> userOrdersPay = orderService.findBoughtByOpenIdandCourseId(user.getOpenid(), courseId);
        List<UserOrder> userOrdersUnPay = orderService.findUnBoughtByOpenIdandCourseId(user.getOpenid(), courseId);


        List<Video> boughtVideo = null;
        if (userOrdersPay.size() > 0) {
            for (UserOrder order : userOrdersPay) {
                List<Integer> videosId = orderService.findOrderDetailByOrderId(order.getOrderId());
                boughtVideo = videoService.findBoughtVideo(videosId);

            }
        }


        List<Video> unboughtVide = null;
        if (userOrdersUnPay.size() > 0) {
            for (UserOrder order : userOrdersUnPay) {
                List<Integer> videosId = orderService.findOrderDetailByOrderId(order.getOrderId());
                unboughtVide = videoService.findBoughtVideo(videosId);

            }
        }

        List<VideosVo> videosVoList = new ArrayList<>();
        VideosVo videosVo = null;
        for (Video video : videoList) {
            videosVo = new VideosVo();
            BeanUtils.copyProperties(video, videosVo);
            videosVo.setPaystatus(0);
            for (Video payVideo : boughtVideo) {
                if (payVideo.getCourseId().equals(payVideo.getCourseId())) {
                    videosVo.setPaystatus(1);
                    break;
                }
            }
            for (Video unpayVide : unboughtVide) {
                if (unpayVide.getCourseId().equals(unpayVide.getCourseId())) {
                    videosVo.setPaystatus(-1);
                    break;
                }
            }
            videosVoList.add(videosVo);
        }


        //使用freemarker生成播放视频的静态页面
		/*Configuration configuration = freeMarkerConfigurer.getConfiguration();
		//获取模板
		Template template = configuration.getTemplate("html/course/details.html");
		//创建数据集
		Map data = new HashMap<>();
		data.put("course", course);
		data.put("teacher", teacher);
		//使用监听器获取相对路径
		String filePath=System.getProperty("path.webapp");
		Writer out = new FileWriter(new File(filePath+"\\WEB-INF\\views\\wechat\\course\\details.html"));
		//生成html
		template.process(data, out);
		out.close();*/
        //返回结果，结果是播放视频页面

        //TODO 使用缓存查询，先前使用缓存出了问题
        model.addAttribute("course", course);
        model.addAttribute("teacher", teacher);
         model.addAttribute("videoList",videosVoList);


        //当用户点击了某课程，加入用户的足迹中
        //从session范围中取出用户信息
        //插入足迹的时候应该判断是否有course_id已存在，如果存在则覆盖，查询出来的课程顺序应该是按日期从新到老排序
        UserTrack userTrack = userTrackService.findUserTrackByCourseIdAndOpenId(courseId, user.getOpenid());
        if (userTrack == null) {
            userTrack = new UserTrack();
            userTrack.setOpenid(user.getOpenid());
            userTrack.setCourseId(courseId);
            userTrack.setTrackTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            userTrackService.saveUserTrack(userTrack);

            //保存或者更新之后应该把course表的flow_number加1,这里有个约定，同个用户只能贡献一个浏览量
            course.setFlowNumber(course.getFlowNumber() + 1);
            courseService.updateCourse(course);

        } else {
            userTrack.setTrackTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            userTrackService.updateUserTrack(userTrack);
        }


        //跳转到视频播放页面时候应该根据openid和course_id查询是否存在记录，
        //如果有记录说明该用户收藏了改课程，则要显示红心，数据库的表为user_collect_course
        UserCollectCourse userCollectCourse = courseService.findCollectCourseByCourseIdAndOpenId(courseId, user.getOpenid());
        if (userCollectCourse != null) {
            //表示该课程被收藏
            model.addAttribute("courseCollect", 1);
        }

        //跳转到视频播放页面时候应该根据openid和teacher_id查询是否存在记录，
        //如果有记录说明该用户收藏了该教师，则要显示红心，数据库的表为user_collect_teacher
        UserCollectTeacher userCollectTeacher = teacherService.findCollectTeacherByTeacherIdAndOpenId(teacher.getTeacherId(), user.getOpenid());
        if (userCollectTeacher != null) {
            //表示该教师被收藏
            model.addAttribute("teacherCollect", 1);
        }


        return "wechat/course/details";
    }


    /**
     * 根据不同年级查询相应的课程
     *
     * @param model
     * @param courseLevel
     * @return
     * @throws Exception
     */
    @GetMapping(value = "lessonListLevel/{level}")
    public String lessonListLevel(Model model, @PathVariable("level") Integer courseLevel) throws Exception {
        //先在缓存查询所有相应年级的课程，如果没有找到，再去数据库查询
        List<Course> courseList = null;

        //TODO 修改
		/*courseList=redisCache.getCacheList("courseListLevel"+courseLevel);
		if(courseList.size()==0){
			
			redisCache.setCacheList("courseListLevel"+courseLevel, courseList);
		}*/
        courseList = courseService.findCourseByCourseLevel(courseLevel);
        model.addAttribute("courseList", courseList);
        return "wechat/course/list";
    }

    /**
     * 根据条件搜索相应的课程
     *
     * @return
     * @throws Exception
     */
    /*@GetMapping(value="searchCourse/{courseName}")*/
    @RequestMapping("searchCourse")
    public String searchCourse(Model model, String courseName, String districtName/*区域*/, String courseLevel, String courseType) throws Exception {


        //由于查询的不确定性，这里不使用缓存
        Course course = new Course();

        if (courseLevel != null && !"".equals(courseLevel)) {
            int level = CourseLevelUtil.getCourseLevel(courseLevel);
            course.setCourseLevel(level);
        }

        if (courseType != null && !"".equals(courseType)) {
            course.setCourseType(courseType);
        }

        if (courseName != null && !"".equals(courseName)) {
            course.setCourseName(courseName);
        }

        //根据区域district查询出district_id
        District district = null;
        if (districtName != null && !"".equals(districtName)) {
            district = districtService.findDistrictByName(districtName);
            course.setDistrictId(district.getDistrictId());
        }

        List<Course> courseList = courseService.searchCourseExample(course);
        model.addAttribute("courseList", courseList);


        return "wechat/course/searchList";
    }

    @GetMapping(value = "myCourse")
    public String myCourse(HttpSession session, Model model) throws Exception {
        //从session范围中取出用户信息
        UserWechat user = (UserWechat) session.getAttribute("user");
        //根据用户的openid取出属于用户的课程

        List<UserCourseVo> userCourseList = redisCache.getCacheList("userCourseList" + user.getOpenid());
        if (userCourseList.size() == 0) {
            userCourseList = courseService.findCourseOfUser(user);
            //将查询结果存放至redis，key是userCourseList+openid
            //redisCache.setCacheList("userCourseList"+user.getOpenid(), userCourseList);
        }

        //根据用户的openid取出属于用户的待付款的课程，不使用缓存,考虑做成当用户付款之后删除缓存数据的做法
        //TODO 修改加入缓存
        List<UserCourseVo> userCourseListUnPay = courseService.findUnPayCourseOfUser(user);
        //根据用户的openid取出属于用户的已付款的课程，不使用缓存,考虑做成当用户付款之后删除缓存数据的做法
        //TODO 修改加入缓存
        List<UserCourseVo> userCourseListPayed = courseService.findPayedCourseOfUser(user);

        model.addAttribute("userCourseList", userCourseList);
        model.addAttribute("userCourseListUnPay", userCourseListUnPay);
        model.addAttribute("userCourseListPayed", userCourseListPayed);
        return "wechat/course/myCourse";
    }

    @GetMapping(value = "collectCourse")
    public String collectCourse(HttpSession session, Model model) {
        //从session范围中取出用户信息
        UserWechat user = (UserWechat) session.getAttribute("user");
        //暂时不使用缓存，或者当用户点击收藏某课程时或取消收藏课程时根据openid删除缓存
        //TODO 使用缓存
        List<UserCollectCourseVo> userCollectCourseList = courseService.findCollectCourseOfUser(user);

        model.addAttribute("userCollectCourseList", userCollectCourseList);
        //TODO 跳转到页面前应先判断userCollectCourseList为不为空,如果为空，在页面显示没有符合条件的课程
        return "wechat/collect-course/list";
    }

    @GetMapping(value = "myTrack")
    public String myTrack(HttpSession session, Model model) {
        //从session范围中取出用户信息
        UserWechat user = (UserWechat) session.getAttribute("user");
        //这里不使用缓存
        List<UserTrackVo> userTrackList = userTrackService.findUserTrack(user);
        model.addAttribute("userTrackList", userTrackList);
        return "wechat/foot-print/list";
    }

    /**
     * 取消收藏课程
     *
     * @param session
     * @param courseId
     * @throws Exception
     */
    @RequestMapping(value = "cancelCollectCourse")
    public void cancelCollect(HttpSession session,/*@PathVariable("courseId") */Integer courseId) throws Exception {
        //从session范围中取出用户信息
        UserWechat user = (UserWechat) session.getAttribute("user");
        courseService.deleteUserCollectCourseByOpenIdAndCourseId(user.getOpenid(), courseId);

        //取消收藏-1
        Course course = courseService.findCourseById(courseId);
        course.setCollectNumber(course.getCollectNumber() - 1);
        courseService.updateCourse(course);
    }

    /**
     * 收藏课程
     *
     * @param session
     * @param courseId
     * @throws Exception
     */
    @RequestMapping(value = "collectCourse")
    public void collectCourse(HttpSession session,/*@PathVariable("courseId") */Integer courseId) throws Exception {
        //从session范围中取出用户信息
        UserWechat user = (UserWechat) session.getAttribute("user");
        //创建用户收藏课程对象
        UserCollectCourse userCollectCourse = new UserCollectCourse();
        userCollectCourse.setOpenid(user.getOpenid());
        userCollectCourse.setCourseId(courseId);
        courseService.saveUserCollectCourse(userCollectCourse);

        //收藏+1
        Course course = courseService.findCourseById(courseId);
        course.setCollectNumber(course.getCollectNumber() + 1);
        courseService.updateCourse(course);
    }

    @RequestMapping(value = "selectCourse")
    public void selectCourse() {
        System.out.println(13);
    }


    @GetMapping(value = "allCourse")
    public String allCourse(Model model) throws Exception {
        //先在缓存查询所有相应年级的课程，如果没有找到，再去数据库查询
        List<Course> courseList = null;

        //TODO 修改
		/*courseList=redisCache.getCacheList("courseListLevel"+courseLevel);
		if(courseList.size()==0){
			
			redisCache.setCacheList("courseListLevel"+courseLevel, courseList);
		}*/
        courseList = courseService.findAllAuditCourse();
        model.addAttribute("courseList", courseList);
        return "wechat/course/list";
    }

    /**
     * @param courseId
     * @param coursePrice
     * @param session
     * @return
     */

    @GetMapping(value = "checkPay")
    public String checkPay(int courseId, String coursePrice, HttpSession session) {
        UserWechat user = (UserWechat) session.getAttribute("user");
        String openid = user.getOpenid();
        //	String openid = "ofiiht1Kqdf7iZWWh9nPX6Ef2iCY";
        //根据openid和课程号查询该用户是否购买了这个课程
        UserCourse userCourse = courseService.findUserCourseByOpenIdAndCourseId(openid, courseId);

        if (userCourse == null) {
            userCourse = new UserCourse();
            userCourse.setCourseId(courseId);
            //userCourse.setOpenid("ofiiht1Kqdf7iZWWh9nPX6Ef2iCY");
            userCourse.setOpenid(openid);
            userCourse.setTradeNo(WXPayUtil.generateNonceStr());
            //0为等待支付
            userCourse.setPay(0);
            courseService.insertUserCourse(userCourse);
            return "redirect:/routeW/orderPage?coursePrice=" + coursePrice + "&tradeNo=" + userCourse.getTradeNo() + "&courseId=" + userCourse.getCourseId();
        }
        if (userCourse.getPay() == 0) {
            return "redirect:/routeW/orderPage?coursePrice=" + coursePrice + "&tradeNo=" + userCourse.getTradeNo() + "&courseId=" + userCourse.getCourseId();

        }
        return "redirect:/course/courseDetails/" + courseId;


    }


}
