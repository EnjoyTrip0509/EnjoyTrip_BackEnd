package com.ssafy.plan.model.service;

import java.util.List;

import com.ssafy.plan.model.PlanDto;

public interface PlanService {
	Long addPlan(PlanDto planDto) throws Exception;
	void deletePlan(Long id) throws Exception;
	PlanDto findPlanById(Long id) throws Exception;
	List<PlanDto> findPlansByMemberId(String memberId) throws Exception;
	List<PlanDto> findAll() throws Exception;
}
