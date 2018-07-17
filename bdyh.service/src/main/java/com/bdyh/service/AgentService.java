package com.bdyh.service;

import java.util.List;

import com.bdyh.common.APIResponse;
import com.bdyh.entity.Agent;
import com.bdyh.entity.AgentDivide;
import com.bdyh.entity.Teacher;

public interface AgentService {

	public Agent findAgentByUsername(String username);

	public List<Agent> findAllAgent();

	public Agent findAgentById(Integer agentId);

	public void updateAgent(Agent agent);

	public void saveAgent(Agent agent);

	public void deleteAgentById(Integer agentId);

	List<Teacher> agentTeacher(String agentId);

	List<AgentDivide> divide(List<Teacher> teachers, Agent agent);

	APIResponse setDivide(Integer teacher,Agent agent,Integer divideNum);


}
