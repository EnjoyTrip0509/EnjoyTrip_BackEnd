package com.ssafy.plan.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.location.model.LocationDto;
import com.ssafy.location.model.service.LocationService;
import com.ssafy.plan.model.PlanDto;
import com.ssafy.plan.model.service.PlanService;
import com.ssafy.user.model.UserDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/plan")
@Api("Plan 컨트롤러 API V1")
public class PlanController {
	private static final Logger logger = LoggerFactory.getLogger(PlanController.class);
	
	private PlanService planService;
	private LocationService locationService;
	
	@Autowired
	public PlanController(PlanService planService, LocationService locationService) {
		this.planService = planService;
		this.locationService = locationService;
	}
	
	@ApiOperation(value = "여행 계획 목록", notes = "여행 계획의 <big>전체 목록</big>을 반환해 줍니다.")
	@ApiResponses({
		@ApiResponse(code= 200, message = "여행 계획 목록을 불러오는 데 성공했습니다."),
		@ApiResponse(code= 400, message = "여행 계획 목록 페이지가 존재하지 않습니다."),
		@ApiResponse(code= 200, message = "서버 에러가 발생했습니다."),
	})
	@GetMapping
	public ResponseEntity<List<PlanDto>> planList(String userId) throws Exception {
		logger.info("PlanController findPlansByMemberId - userId: {}.", userId);
		
		return ResponseEntity.ok(planService.findPlansByMemberId(userId));
	}

	@ApiOperation(value = "여행 계획 추가", notes = "여행 계획을 추가합니다.")
	@ApiResponses({
		@ApiResponse(code= 200, message = "여행 계획을 추가하는 데 성공했습니다."),
		@ApiResponse(code= 400, message = "여행 계획 추가 페이지가 존재하지 않습니다."),
		@ApiResponse(code= 200, message = "서버 에러가 발생했습니다."),
	})
	@PostMapping
	public ResponseEntity<List<PlanDto>> add(@RequestBody PlanDto plan) throws Exception {
		logger.info("PlanController add - plan :{}.", plan);
		
		planService.addPlan(plan);
		
		return ResponseEntity.ok().build();
	}
	
	@ApiOperation(value = "여행 계획 삭제", notes = "여행 계획을 삭제합니다.")
	@ApiResponses({
		@ApiResponse(code= 200, message = "여행 계획을 삭제하는 데 성공했습니다."),
		@ApiResponse(code= 400, message = "여행 계획 삭제 페이지가 존재하지 않습니다."),
		@ApiResponse(code= 200, message = "서버 에러가 발생했습니다."),
	})
	@DeleteMapping("/{planId}")
	public ResponseEntity<Object> delete(@PathVariable Long planId) throws Exception {
		logger.info("PlanController delete - planId : {}", planId);

		locationService.deleteLocationsByPlanId(planId);		
		planService.deletePlan(planId);
		
		return ResponseEntity.ok().build();
	}
	
	@ApiOperation(value = "여행 계획 상세 정보 조회", notes = "여행 계획의 상세 정보를 반환합니다.")
	@ApiResponses({
		@ApiResponse(code= 200, message = "여행 계획 상세 정보를 불러오는 데 성공했습니다."),
		@ApiResponse(code= 400, message = "여행 계획 상세 정보 페이지가 존재하지 않습니다."),
		@ApiResponse(code= 200, message = "서버 에러가 발생했습니다."),
	})
	@GetMapping("/{planId}")
	public ResponseEntity<PlanDto> view(@PathVariable Long planId) throws Exception {
		logger.info("PlanController view - planId : {}.", planId);
		
		PlanDto plan = planService.findPlanById(planId);
		plan.setLocations(locationService.findLocationsByPlanId(planId));
		
		return ResponseEntity.ok(plan);
	}
	
	@ApiOperation(value = "여행 계획 수정", notes = "여행 계획을 수정합니다.")
	@ApiResponses({
		@ApiResponse(code= 200, message = "여행 계획을 수정하는 데 성공했습니다."),
		@ApiResponse(code= 400, message = "여행 계획 수정 페이지가 존재하지 않습니다."),
		@ApiResponse(code= 200, message = "서버 에러가 발생했습니다."),
	})
	@PutMapping
	public ResponseEntity<PlanDto> update(@RequestBody PlanDto plan) throws Exception {
		logger.info("PlanController update - plan : {}.", plan);
		
		planService.updatePlan(plan);
		for (LocationDto location : plan.getLocations()) {
			locationService.updateLocation(location);
		}
		
		return ResponseEntity.ok(planService.findPlanById(plan.getId()));
	}
	
	@ApiOperation(value = "여행 계획에 장소 추가", notes = "여행 계획에 장소를 추가합니다.")
	@ApiResponses({
		@ApiResponse(code= 200, message = "여행 계획에 장소를 추가하는 데 성공했습니다."),
		@ApiResponse(code= 400, message = "여행 계획에 장소 추가 페이지가 존재하지 않습니다."),
		@ApiResponse(code= 200, message = "서버 에러가 발생했습니다."),
	})
	@PostMapping("/location")
	public ResponseEntity<Object> addLocation(@RequestBody LocationDto location) throws Exception {
		logger.info("PlanController add Location - location : {}.", location);

		locationService.addLocation(location);

		return ResponseEntity.ok().build();
	}
	
	@ApiOperation(value = "장소 삭제", notes = "여행 계획에서 장소를 삭제합니다.")
	@ApiResponses({
		@ApiResponse(code= 200, message = "여행 계획에 장소를 삭제하는 데 성공했습니다."),
		@ApiResponse(code= 400, message = "여행 계획에 장소 삭제 페이지가 존재하지 않습니다."),
		@ApiResponse(code= 200, message = "서버 에러가 발생했습니다."),
	})
	@DeleteMapping("/location/{locationId}")
	public ResponseEntity<Object> deleteLocation(@PathVariable Long locationId) throws Exception {
		logger.info("PlanController delete Location - locationId : {}.", locationId);

		locationService.deleteLocation(locationId);

		return ResponseEntity.ok().build();
	}
}