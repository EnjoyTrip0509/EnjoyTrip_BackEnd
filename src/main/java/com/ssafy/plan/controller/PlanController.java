package com.ssafy.plan.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.location.model.LocationDto;
import com.ssafy.location.model.service.LocationService;
import com.ssafy.plan.model.PlanDto;
import com.ssafy.plan.model.service.PlanService;

@Controller
@RequestMapping("/plan")
public class PlanController {
	private static final Logger logger = LoggerFactory.getLogger(PlanController.class);
	
	private PlanService planService;
	private LocationService locationService;
	
	@Autowired
	public PlanController(PlanService planService, LocationService locationService) {
		this.planService = planService;
		this.locationService = locationService;
	}
	
	@GetMapping("/list")
	public String list(Model model) throws Exception {
		logger.info("Plan list");
		model.addAttribute("plans", planService.findAll());
		return "plan/planlist";
	}

	@PostMapping("/add")
	public String add(PlanDto planDto) throws Exception {
		logger.info("Plan add {}", planDto);
		
		Long planId = planService.addPlan(planDto);
		List<LocationDto> locations = planDto.getLocations();
		for(LocationDto location : locations) {
			location.setPlanId(planId);
			locationService.addLocation(location);
		}
		
		return "redirect:/plan/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam Long id) throws Exception {
		logger.info("Plan delete {}", id);

		locationService.deleteLocationsByPlanId(id);		
		planService.deletePlan(id);
		
		return "redirect:/plan/list";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam Long id, Model model) throws Exception {
		logger.info("Plan detail {}", id);
		
		PlanDto plan = planService.findPlanById(id);
		plan.setLocations(locationService.findLocationsByPlanId(id));
		
		model.addAttribute("plan", planService.findPlanById(id));
		return "plan/planDetail";
	}
}
