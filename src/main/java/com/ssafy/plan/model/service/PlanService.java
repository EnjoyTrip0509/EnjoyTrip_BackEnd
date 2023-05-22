package com.ssafy.plan.model.service;

import java.util.List;

import com.ssafy.plan.model.PlanDto;

public interface PlanService {
	Long addPlan(PlanDto planDto) throws Exception;
	void deletePlan(Long id) throws Exception;
	void updatePlan(PlanDto planDto) throws Exception;
	PlanDto findPlanById(Long id) throws Exception;
	List<PlanDto> findPlansByUserId(String userId) throws Exception;
	List<PlanDto> findAll() throws Exception;
}
