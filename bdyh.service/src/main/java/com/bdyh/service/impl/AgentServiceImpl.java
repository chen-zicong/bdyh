package com.bdyh.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bdyh.common.APIResponse;
import com.bdyh.dao.AgentDivideMapper;
import com.bdyh.entity.AgentDivide;
import com.bdyh.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdyh.dao.AgentMapper;
import com.bdyh.entity.Agent;
import com.bdyh.entity.AgentExample;
import com.bdyh.service.AgentService;

@Service
public class AgentServiceImpl implements AgentService {

    @Autowired
    private AgentMapper agentMapper;

    @Autowired
    private AgentDivideMapper agentDivideMapper;

    /*-------------------------------------------------------------------后台模块-------------------------------------------------------------------------*/

    /**
     * 根据用户名查询代理商
     */
    @Override
    public Agent findAgentByUsername(String username) {
        AgentExample agentExample = new AgentExample();
        AgentExample.Criteria criteria = agentExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<Agent> agentList = agentMapper.selectByExample(agentExample);
        if (agentList != null && agentList.size() > 0) {
            return agentList.get(0);
        }
        return null;
    }

    /**
     * 所有代理
     */
    @Override
    public List<Agent> findAllAgent() {
        AgentExample agentExample = new AgentExample();
        AgentExample.Criteria criteria = agentExample.createCriteria();
        criteria.andAgentIdIsNotNull();
        return agentMapper.selectByExample(agentExample);
    }

    /**
     * 根据唯一标识查询代理商
     */
    @Override
    public Agent findAgentById(Integer agentId) {
        return agentMapper.selectByPrimaryKey(agentId);
    }

    /**
     * 更新
     */
    @Override
    public void updateAgent(Agent agent) {
        agentMapper.updateByPrimaryKey(agent);
    }

    /**
     * 保存
     */
    @Override
    public void saveAgent(Agent agent) {
        agentMapper.insert(agent);
    }

    /**
     * 删除代理
     */
    @Override
    public void deleteAgentById(Integer agentId) {
        agentMapper.deleteByPrimaryKey(agentId);
    }

    @Override
    public List<Teacher> agentTeacher(String agentId) {

        return null;
    }

    @Override
    public List<AgentDivide> divide(List<Teacher> teachers,Agent agent) {
        AgentDivide divide;
        List<AgentDivide> divides= new ArrayList<>();
        for (Teacher teacher : teachers) {
            divide = agentDivideMapper.findOne(agent.getAgentId(), teacher.getTeacherId());
            if(divide==null) {
                divide = new AgentDivide();
                divide.setTeacherId(teacher.getTeacherId());
                divide.setAgentId(agent.getAgentId());
                divide.setAgentName(agent.getUsername());
                divide.setDivide(60);
                divide.setTeacherName(teacher.getTeacherName());
                agentDivideMapper.insert(divide);
            }
            divides.add(divide);
        }
        return divides;

    }

    @Override
    public APIResponse setDivide(Integer teacherId,Agent agent,Integer divideNum) {
        AgentDivide divide = agentDivideMapper.findOne(agent.getAgentId(), teacherId);
        if(divide==null){
            divide = new AgentDivide();
            divide.setTeacherId(teacherId);
            divide.setAgentId(agent.getAgentId());
            divide.setAgentName(agent.getUsername());
            divide.setDivide(divideNum);
            agentDivideMapper.insert(divide);
            return  APIResponse.success();
        }
        divide.setDivide(divideNum);
        return APIResponse.success();

    }

}
