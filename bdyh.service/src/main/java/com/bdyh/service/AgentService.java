package com.bdyh.service;

import java.util.List;

import com.bdyh.entity.Agent;

public interface AgentService {

	public Agent findAgentByUsername(String username);

	public List<Agent> findAllAgent();

	public Agent findAgentById(Integer agentId);

	public void updateAgent(Agent agent);

	public void saveAgent(Agent agent);

	public void deleteAgentById(Integer agentId);

}
