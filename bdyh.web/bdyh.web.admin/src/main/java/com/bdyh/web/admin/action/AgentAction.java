package com.bdyh.web.admin.action;

import com.bdyh.common.APIResponse;
import com.bdyh.common.AdminUtil;
import com.bdyh.entity.Agent;
import com.bdyh.entity.AgentDivide;
import com.bdyh.entity.Teacher;
import com.bdyh.service.AgentService;
import com.bdyh.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

/**
 * 代理商
 */

@Controller
@RequestMapping("agent")
public class AgentAction {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private AgentService agentService;

    @RequestMapping("/divide")
    public String divide(Model model) {
        Agent agent = (Agent) AdminUtil.getShiroSessionByKey("userAgent");
        List<Teacher> teachers = teacherService.findTeacherByAgent(agent.getAgentId());
        List<AgentDivide> divide = agentService.divide(teachers, agent);
        model.addAttribute("divide", divide);
        return "benefit/divide";

    }

    @RequestMapping("/setDivide")
    @ResponseBody
    public APIResponse setDivide(int teacherId, int divideNum) {
        Agent agent = (Agent) AdminUtil.getShiroSessionByKey("userAgent");
        return agentService.setDivide(teacherId, agent, divideNum);


    }

    //批量删除代理商
    //因为代理商关联到老师，所以谨慎。
    @RequestMapping("AgentBatchDeletion")
    @ResponseBody
    public APIResponse AgentBatchDeletion(List<Integer> agentIds) {
        int i = agentService.AgentBatchDeletion(agentIds);
        if (i > 0) {
            return APIResponse.success();
        } else {
            return APIResponse.fail("删除失败");
        }
    }
}
