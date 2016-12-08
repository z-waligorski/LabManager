package com.z_waligorski.spring.dao;

import java.util.List;

import com.z_waligorski.spring.model.Reagent;

public interface ReagentDAO {
	
	public void addReagent(Reagent reagent);
	public void updateReagent(int id, Reagent reagent);
	public void deleteReagent(int reagentId);
	public Reagent getReagent(int reagentId);
	public List<Reagent> getAllReagents();
	
}