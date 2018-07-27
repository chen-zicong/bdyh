package com.bdyh.web.admin.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.bdyh.common.APIResponse;
import com.bdyh.common.APIResponseX;
import com.bdyh.common.AdminUtil;
import com.bdyh.common.Util;
import com.bdyh.entity.*;
import com.bdyh.service.AgentService;
import com.bdyh.service.BenefitService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
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

    @Autowired
    private AgentService agentService;


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

    /*获取老师和代理商的收益列表*/
    @RequestMapping("teacherIncomeStatistics")
    public String teacherIncomeStatistics(Model model) {
        Agent agent = (Agent) AdminUtil.getShiroSessionByKey("userAgent");
        List<AgentStatistics> teachersIncome = benefitService.findTeachersIncome(agent);
        model.addAttribute("incomes", teachersIncome);
        return "benefit/agentperson_benefit";
    }

    /*管理员获取所有老师的收益*/
    @RequestMapping("teacherIncomeStatisticsForAdmin")
    public APIResponse teacherStatisticsByAdmin(Model model) {

        List<Agent> agents = agentService.findAllAgent();
        List<AgentStatistics> agentStatistics = new ArrayList<>();
        for (Agent agent : agents) {
            List<AgentStatistics> teachersIncome = benefitService.findTeachersIncome(agent);
            agentStatistics.addAll(teachersIncome);
        }
        model.addAttribute("incomes", agentStatistics);

        return null;
    }

    /*管理员获取所有代理商的收益信息*/
    @RequestMapping("agentAllBenefit")
    @ResponseBody
    public String agentAllBenefit(Model model) {
        List<Agent> agents = agentService.findAllAgent();
        List<AdminStatistics> adminStatistics = new ArrayList<>();
        for (Agent agent : agents) {
           AdminStatistics agentIncome = benefitService.findAgentIncome(agent);
            adminStatistics.add(agentIncome);
        }
        model.addAttribute("agentIncome", adminStatistics);
        return "";
    }


    //获取老师每个时间段获取的收入的JSON数据
    @RequestMapping("teacherIncomeByTime")
    @ResponseBody
    public List<List<Object>> teacherIncomeByTime(Integer teacherId) {
        List<List<Object>> teacherByMonth = benefitService.findTeacherByMonth(teacherId);
        return teacherByMonth;

    }

    //获取代理商每个时间段获取的收入的JSON数据
    @RequestMapping("agentIncomeByTime")
    @ResponseBody
    public List<List<Object>> agentIncomeByTime(Integer agentId) {
        return benefitService.agentIncomeByTime(agentId);
    }

    /*根据老师ID 跳转到查看他收入的图表*/
    @RequestMapping("teacherEcharts")
    public String teacherEcharts(Integer teacherId, Model model) {
        model.addAttribute("teacherId", teacherId);
        return "benefit/agent_teacher_benefit_echarts";
    }


    /**
     * 老师查看全部收入
     *
     * @param model
     * @return
     */
    @RequestMapping("teacherIncome")
    public String teacher(Model model) {
        Teacher teacherUser = (Teacher) AdminUtil.getShiroSessionByKey("teacherUser");
        float teacherAllIncome = benefitService.findTeacherAllIncome(teacherUser);
        model.addAttribute("Income", teacherAllIncome);
        model.addAttribute("teacherId", teacherUser.getTeacherId());
        //老师的收入查看界面
        return "";

    }
}
