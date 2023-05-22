package com.ssafy.plan.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.attraction.model.service.AttractionService;
import com.ssafy.location.model.LocationDto;
import com.ssafy.location.model.service.LocationService;
import com.ssafy.plan.model.PlanDto;
import com.ssafy.plan.model.service.PlanService;
import com.ssafy.user.jwt.JwtServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/plan")
@Api("Plan 컨트롤러 API V1")
public class PlanController {
	private static final Logger logger = LoggerFactory.getLogger(PlanController.class);
	
	@Autowired
	private PlanService planService;
	@Autowired
	private LocationService locationService;
	@Autowired
	private AttractionService attractionService;
	@Autowired
	private JwtServiceImpl jwtService;
	
	@ApiOperation(value = "여행 계획 목록", notes = "여행 계획의 <big>전체 목록</big>을 반환해 줍니다.")
	@ApiResponses({
		@ApiResponse(code= 200, message = "여행 계획 목록을 불러오는 데 성공했습니다."),
		@ApiResponse(code= 400, message = "여행 계획 목록 페이지가 존재하지 않습니다."),
		@ApiResponse(code= 200, message = "서버 에러가 발생했습니다."),
	})
	@GetMapping("/{userid}")
	public ResponseEntity<List<PlanDto>> planList(@PathVariable("userid") String userId, HttpServletRequest request) throws Exception {
		logger.info("PlanController findPlansByMemberId - userId: {}.", userId);

		if (jwtService.checkToken(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰");
			
			try {
				return new ResponseEntity<List<PlanDto>>(planService.findPlansByUserId(userId), HttpStatus.ACCEPTED);
			} catch (Exception e) {
				logger.error("정보조회 실패 : {}", e);
				return new ResponseEntity<List<PlanDto>> (HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			logger.info("사용 불가능한 토큰");
			return new ResponseEntity<List<PlanDto>> (HttpStatus.UNAUTHORIZED);
		}
	}

	@ApiOperation(value = "여행 계획 추가", notes = "여행 계획을 추가합니다.")
	@ApiResponses({
		@ApiResponse(code= 200, message = "여행 계획을 추가하는 데 성공했습니다."),
		@ApiResponse(code= 400, message = "여행 계획 추가 페이지가 존재하지 않습니다."),
		@ApiResponse(code= 200, message = "서버 에러가 발생했습니다."),
	})
	@PostMapping
	public ResponseEntity<Object> add(@RequestBody PlanDto plan, HttpServletRequest request) throws Exception {
		logger.info("PlanController add - plan :{}.", plan);
		
		if (jwtService.checkToken(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰");
			
			try {
				planService.addPlan(plan);
				return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
			} catch (Exception e) {
				logger.error("정보조회 실패 : {}", e);
				return new ResponseEntity<Object> (HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			logger.info("사용 불가능한 토큰");
			return new ResponseEntity<Object> (HttpStatus.UNAUTHORIZED);
		}
	}
	
	@ApiOperation(value = "여행 계획 삭제", notes = "여행 계획을 삭제합니다.")
	@ApiResponses({
		@ApiResponse(code= 200, message = "여행 계획을 삭제하는 데 성공했습니다."),
		@ApiResponse(code= 400, message = "여행 계획 삭제 페이지가 존재하지 않습니다."),
		@ApiResponse(code= 200, message = "서버 에러가 발생했습니다."),
	})
	@DeleteMapping("/{planId}")
	public ResponseEntity<Object> delete(@PathVariable Long planId, HttpServletRequest request) throws Exception {
		logger.info("PlanController delete - planId : {}", planId);

		if (jwtService.checkToken(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰");
			
			try {
				locationService.deleteLocationsByPlanId(planId);		
				planService.deletePlan(planId);
				
				return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
			} catch (Exception e) {
				logger.error("정보조회 실패 : {}", e);
				return new ResponseEntity<Object> (HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			logger.info("사용 불가능한 토큰");
			return new ResponseEntity<Object> (HttpStatus.UNAUTHORIZED);
		}
	}
	
	@ApiOperation(value = "여행 계획 상세 정보 조회", notes = "여행 계획의 상세 정보를 반환합니다.")
	@ApiResponses({
		@ApiResponse(code= 200, message = "여행 계획 상세 정보를 불러오는 데 성공했습니다."),
		@ApiResponse(code= 400, message = "여행 계획 상세 정보 페이지가 존재하지 않습니다."),
		@ApiResponse(code= 200, message = "서버 에러가 발생했습니다."),
	})
	@GetMapping("/view/{planId}")
	public ResponseEntity<PlanDto> view(@PathVariable Long planId, HttpServletRequest request) throws Exception {
		logger.info("PlanController view - planId : {}.", planId);
		
		if (jwtService.checkToken(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰");
			
			try {
				PlanDto plan = planService.findPlanById(planId);
				plan.setLocations(locationService.findLocationsByPlanId(planId));
				
				return new ResponseEntity<PlanDto>(plan, HttpStatus.ACCEPTED);
			} catch (Exception e) {
				logger.error("정보조회 실패 : {}", e);
				return new ResponseEntity<PlanDto> (HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			logger.info("사용 불가능한 토큰");
			return new ResponseEntity<PlanDto> (HttpStatus.UNAUTHORIZED);
		}
	}
	
	@ApiOperation(value = "여행 계획 일별 정보 조회", notes = "여행 계획의 일별 상세 정보를 반환합니다.")
	@ApiResponses({
		@ApiResponse(code= 200, message = "여행 계획 일별 상세 정보를 불러오는 데 성공했습니다."),
		@ApiResponse(code= 400, message = "여행 계획 일별 상세 정보 페이지가 존재하지 않습니다."),
		@ApiResponse(code= 200, message = "서버 에러가 발생했습니다."),
	})
	@GetMapping("/view/{planId}/{day}")
	public ResponseEntity<List<LocationDto>> view(@PathVariable Long planId, @PathVariable Integer day, HttpServletRequest request) throws Exception {
		logger.info("PlanController view - planId : {}, day: {}.", planId, day);

		if (jwtService.checkToken(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰");
			
			try {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("planId", planId);
				map.put("day", day);
				
				List<LocationDto> locations = locationService.findLocationsByPlanIdAndDay(map);
				for(LocationDto location : locations) {
					location.setAttraction(attractionService.findAttractionByContentId(location.getContentId()));
				}
				
				return new ResponseEntity<List<LocationDto>>(locations, HttpStatus.ACCEPTED);
			} catch (Exception e) {
				logger.error("정보조회 실패 : {}", e);
				return new ResponseEntity<List<LocationDto>> (HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			logger.info("사용 불가능한 토큰");
			return new ResponseEntity<List<LocationDto>> (HttpStatus.UNAUTHORIZED);
		}
	}
	
	@ApiOperation(value = "여행 계획 수정", notes = "여행 계획을 수정합니다.")
	@ApiResponses({
		@ApiResponse(code= 200, message = "여행 계획을 수정하는 데 성공했습니다."),
		@ApiResponse(code= 400, message = "여행 계획 수정 페이지가 존재하지 않습니다."),
		@ApiResponse(code= 200, message = "서버 에러가 발생했습니다."),
	})
	@PutMapping
	public ResponseEntity<PlanDto> update(@RequestBody PlanDto plan, HttpServletRequest request) throws Exception {
		logger.info("PlanController update - plan : {}.", plan);
		
		if (jwtService.checkToken(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰");
			
			try {
				planService.updatePlan(plan);
				for (LocationDto location : plan.getLocations()) {
					locationService.updateLocation(location);
				}
				
				return new ResponseEntity<PlanDto>(planService.findPlanById(plan.getId()), HttpStatus.ACCEPTED);
			} catch (Exception e) {
				logger.error("정보조회 실패 : {}", e);
				return new ResponseEntity<PlanDto> (HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			logger.info("사용 불가능한 토큰");
			return new ResponseEntity<PlanDto> (HttpStatus.UNAUTHORIZED);
		}
	}
	
	@ApiOperation(value = "여행 계획에 장소 추가", notes = "여행 계획에 장소를 추가합니다.")
	@ApiResponses({
		@ApiResponse(code= 200, message = "여행 계획에 장소를 추가하는 데 성공했습니다."),
		@ApiResponse(code= 400, message = "여행 계획에 장소 추가 페이지가 존재하지 않습니다."),
		@ApiResponse(code= 200, message = "서버 에러가 발생했습니다."),
	})
	@PostMapping("/location")
	public ResponseEntity<Object> addLocation(@RequestBody LocationDto location, HttpServletRequest request) throws Exception {
		logger.info("PlanController add Location - location : {}.", location);
		
		if (jwtService.checkToken(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰");
			
			try {
				locationService.addLocation(location);
				
				return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
			} catch (Exception e) {
				logger.error("정보조회 실패 : {}", e);
				return new ResponseEntity<Object> (HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			logger.info("사용 불가능한 토큰");
			return new ResponseEntity<Object> (HttpStatus.UNAUTHORIZED);
		}
	}
	
	@ApiOperation(value = "장소 삭제", notes = "여행 계획에서 장소를 삭제합니다.")
	@ApiResponses({
		@ApiResponse(code= 200, message = "여행 계획에 장소를 삭제하는 데 성공했습니다."),
		@ApiResponse(code= 400, message = "여행 계획에 장소 삭제 페이지가 존재하지 않습니다."),
		@ApiResponse(code= 200, message = "서버 에러가 발생했습니다."),
	})
	@DeleteMapping("/location/{locationId}")
	public ResponseEntity<Object> deleteLocation(@PathVariable Long locationId, HttpServletRequest request) throws Exception {
		logger.info("PlanController delete Location - locationId : {}.", locationId);

		if (jwtService.checkToken(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰");
			
			try {
				locationService.deleteLocation(locationId);
				
				return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
			} catch (Exception e) {
				logger.error("정보조회 실패 : {}", e);
				return new ResponseEntity<Object> (HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			logger.info("사용 불가능한 토큰");
			return new ResponseEntity<Object> (HttpStatus.UNAUTHORIZED);
		}
	}
}