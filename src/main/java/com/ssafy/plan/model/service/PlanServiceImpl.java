package com.ssafy.plan.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.plan.model.PlanDto;
import com.ssafy.plan.model.mapper.PlanMapper;

@Service
public class PlanServiceImpl implements PlanService {
	private PlanMapper planMapper;
	
	public PlanServiceImpl(PlanMapper planMapper) {
		this.planMapper = planMapper;
	}

	@Override
	public Long addPlan(PlanDto planDto) throws Exception {
		return planMapper.addPlan(planDto);
	}

	@Override
	public void deletePlan(Long id) throws Exception {
		planMapper.deletePlan(id);
	}

	@Override
	public PlanDto findPlanById(Long id) throws Exception {
		return planMapper.findPlanById(id);
	}

	@Override
	public List<PlanDto> findPlansByMemberId(String memberId) throws Exception {
		return planMapper.findPlansByMemberId(memberId);
	}

	@Override
	public List<PlanDto> findAll() throws Exception {
		return planMapper.findAll();
	}

}
