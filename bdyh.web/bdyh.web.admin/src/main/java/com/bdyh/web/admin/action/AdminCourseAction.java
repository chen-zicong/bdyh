package com.bdyh.web.admin.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;


import com.bdyh.common.AdminUtil;
import com.bdyh.entity.Agent;
import com.bdyh.web.admin.shiro.ActiveUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bdyh.entity.Course;
import com.bdyh.entity.Video;
import com.bdyh.service.CourseService;
import com.bdyh.service.VideoService;


/**
 * 管理员课程管理
 * 2018年2月2日
 *
 * @author cxs
 */
@Controller
@RequestMapping(value = "adminCourse")
public class AdminCourseAction {

    @Autowired
    private CourseService courseService;

    @Autowired
    private VideoService videoService;


    /**
     * 所有已审核的课程
     *
     * @param model
     * @return
     */
    @GetMapping(value = "auditCourse")
    public String auditCourse(Model model) {
        List<Course> courseList = new ArrayList<>();
        ActiveUser user =(ActiveUser)AdminUtil.getShiroSessionByKey("activeUser");
        String role = user.getRole();
        if (role.equals("agent")) {
            Agent agent = (Agent) AdminUtil.getShiroSessionByKey("userAgent");
            courseList = courseService.findAuditCourseByAgentId(agent.getAgentId());

        } else {

            //查询所有已审核的课程
            courseList = courseService.findAllAuditCourse();
        }
        //传递参数到页面
        model.addAttribute("courseList", courseList);
        return "admin_course/admin-course-list";
    }

    /**
     * 所有未审核的课程
     *
     * @param model
     * @return
     */
    @GetMapping(value = "unAuditCourse")
    public String unAuditCourse(Model model) {

        List<Course> courseList = new ArrayList<>();
        ActiveUser user = (ActiveUser) AdminUtil.getShiroSessionByKey("activeUser");
        String role = user.getRole();
        if (role.equals("agent")) {
            Agent agent = (Agent) AdminUtil.getShiroSessionByKey("userAgent");
            courseList = courseService.findUnAuditCourseByAgentId(agent.getAgentId());

        } else {
            courseList = courseService.findAllUnAuditCourse();
        }
        //传递参数到页面
        model.addAttribute("courseList", courseList);
        return "admin_course/admin-course-list";
    }

    /**
     * 课程上线
     *
     * @param courseId
     * @param response
     */
    @PostMapping(value = "courseStart")
    public void courseStart(Integer courseId, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
            Course course = courseService.findCourseById(courseId);
            course.setStatus(2);
            courseService.updateCourse(course);
            //操作成功，向客户端输出1
            out.write("{\"status\":1}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 课程下线，调整为待审核状态
     *
     * @param courseId
     * @param response
     */
    @PostMapping(value = "courseStop")
    public void courseStop(Integer courseId, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
            Course course = courseService.findCourseById(courseId);
            course.setStatus(1);
            courseService.updateCourse(course);
            //操作成功，向客户端输出1
            out.write("{\"status\":1}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @GetMapping(value = "courseVideo/{courseId}")
    public String courseVideo(Model model, @PathVariable("courseId") Integer courseId) {
        //根据课程的唯一标识查询所属课程的视频
        System.out.println(courseId);
        //TODO 使用缓存
        List<Video> videoList = videoService.findVideoByCourseId(courseId);
        //这里加入的参数主要是为了后面上传视频时候的标识
        model.addAttribute("videoList", videoList);
        return "admin_course/admin-course-show";
    }
}
