package com.bdyh.web.admin.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.bdyh.common.APIResponse;
import com.bdyh.common.APIResponseX;
import com.bdyh.common.AdminUtil;
import com.bdyh.entity.*;
import com.bdyh.service.BenefitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bdyh.service.CourseService;
import com.bdyh.service.TeacherService;
import com.bdyh.web.admin.shiro.ActiveUser;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统计表
 * 2018年2月28日
 *
 * @author cxs
 */

@Controller
@RequestMapping(value = "statistics")
public class StatisticsAction {

    @Autowired
    private CourseService courseService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private BenefitService benefitService;


    /*--------------------------------------------管理员----------------------------------------------------*/
    @RequestMapping(value = "collectCourseStatistics")
    public String collectCourseStatistics(Model model) {
        List<Course> courseList = courseService.findAllCourseBeenCollected();
        model.addAttribute("courseList", courseList);
        return "statistics/collect-course-statistics";
    }


    @RequestMapping(value = "collectTeacherStatistics")
    public String collectTeacherStatistics(Model model) {
        List<Teacher> teacherList = teacherService.findAllTeacherBeenCollected();
        model.addAttribute("teacherList", teacherList);
        return "statistics/collect-teacher-statistics";
    }

    @RequestMapping(value = "flowCourseStatistics")
    public String flowCourseStatistics(Model model) {
        List<Course> courseList = courseService.findAllCourseBeenFlowed();
        model.addAttribute("courseList", courseList);
        return "statistics/flow-course-statistics";
    }
    /*--------------------------------------------管理员----------------------------------------------------*/

    /*--------------------------------------------教师----------------------------------------------------*/

    /**
     * 调用此方法的只有老师
     *
     * @param session
     * @param model
     * @return
     */

    @RequestMapping(value = "benefitCourseStatisticsTeacher")
    public String benefitCourseStatistics(HttpSession session, Model model) {
        Teacher teacher = (Teacher) AdminUtil.getShiroSessionByKey("userTeacher");
        ActiveUser activeUser = (ActiveUser) session.getAttribute("activeUser");
        List<IncomeStatisticsVo> soldCourseOfTeacher = courseService.findSoldCourseOfTeacher(activeUser.getUserid());
        System.out.println("=======");
        model.addAttribute("courseList", soldCourseOfTeacher);
        return "teacher_statistics/benefit-course-list";
    }

    /**
     * 调用此方法的只有老师
     *
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(value = "flowCourseStatisticsTeacher")
    public String flowCourseStatisticsTeacher(HttpSession session, Model model) {
        ActiveUser activeUser = (ActiveUser) session.getAttribute("activeUser");
        List<Course> courseList = courseService.findFlowedCourseOfTeacher(activeUser.getUserid());
        model.addAttribute("courseList", courseList);
        return "teacher_statistics/flow-course-list";
    }

    /**
     * 调用此方法的只有老师
     *
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(value = "collectCourseStatisticsTeacher")
    public String collectCourseStatisticsTeacher(HttpSession session, Model model) {
        ActiveUser activeUser = (ActiveUser) session.getAttribute("activeUser");
        List<Course> courseList = courseService.findCollectedCourseOfTeacher(activeUser.getUserid());
        model.addAttribute("courseList", courseList);
        return "teacher_statistics/collect-course-list";
    }

    /*--------------------------------------------教师----------------------------------------------------*/
    @RequestMapping(value = "flowCourseStatisticsAgent")
    public String flowCourseStatisticsAgent(HttpSession session, Model model) {
        ActiveUser activeUser = (ActiveUser) session.getAttribute("activeUser");

        List<Course> courseList = courseService.findFlowedCourseOfAgent(activeUser.getUserid());
        model.addAttribute("courseList", courseList);
        return "teacher_statistics/flow-course-list";
    }


    @RequestMapping(value = "benefitCourseStatisticsAgent")
    public String benefitCourseStatisticsAgent(HttpSession session, Model model) {
        ActiveUser activeUser = (ActiveUser) session.getAttribute("activeUser");
        List<IncomeStatisticsVo> soldCourseOfTeacher = courseService.findSoldCourseOfAgent(activeUser.getUserid());
        System.out.println("=======");
        model.addAttribute("courseList", soldCourseOfTeacher);
        return "teacher_statistics/benefit-course-list";
    }

    /*霍获取老师和代理商的收益列表*/
    @RequestMapping("teacherIncomeStatistics")
    @ResponseBody
    public APIResponseX teacherIncomeStatistics() {
        Agent agent = (Agent) AdminUtil.getShiroSessionByKey("userAgent");
        List<AgentStatistics> teachersIncome = benefitService.findTeachersIncome(agent);
//        PageHelper.startPage(pageNun, pageSize);
//        PageInfo<AgentStatistics> agentStatisticsPageInfo = new PageInfo<>(teachersIncome);
        return APIResponseX.success(teachersIncome,teachersIncome.size());
    }

    /*管理员获取所有老师的收益*/
    public APIResponse teacherStatisticsByAdmin() {
        UserAdmin userAdmin = (UserAdmin) AdminUtil.getShiroSessionByKey("userAdmin");

        return null;
    }


    @RequestMapping("teacherIncomeByMonth")
    @ResponseBody
    public  List<List<Object>>  teacherIncomeByMonth(Integer teacherId) {

        List<List<Object>> teacherByMonth = benefitService.findTeacherByMonth(teacherId);

        return teacherByMonth;

    }

    /*根据老师ID 跳转到查看他收入的图表*/
    @RequestMapping("teacherEcharts")
    public String teacherEcharts(Integer teacherId,Model model){
        model.addAttribute("teacherId",teacherId);
            return "benefit/teacher_benefit_echarts";
    }
}
