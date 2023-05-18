package com.ssafy.user.controller;

import java.util.HashMap;
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

import com.ssafy.user.jwt.JwtServiceImpl;
import com.ssafy.user.model.UserDto;
import com.ssafy.user.model.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	public static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtServiceImpl jwtService;
	
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody UserDto userDto){
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		
		try {
			UserDto loginUser = userService.login(userDto);
			
			if (loginUser != null) {
				String accessToken = jwtService.createAccessToken("userid", loginUser.getId());
				String refreshToken = jwtService.createRefreshToken("userid", loginUser.getId());
				
				userService.saveRefreshToken(userDto.getId(), refreshToken);
				
				logger.debug("로그인 accessToken 정보 : {}", accessToken);
				logger.debug("로그인 refreshToken 정보 : {}", refreshToken);

				resultMap.put("userInfo", loginUser);
				resultMap.put("access-token", accessToken);
				resultMap.put("refresh-token", refreshToken);
				resultMap.put("message", "success");
				status = HttpStatus.ACCEPTED;
			} else {
				resultMap.put("message", "fail");
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			logger.error("로그인 실패 : {}", e);
			
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@GetMapping("/checkId/{userid}")
	public ResponseEntity<Object> checkIdDuplicate(@PathVariable("userid") String id) throws Exception {
		return ResponseEntity.ok(userService.checkIdDuplicate(id));
	}
	
	@PostMapping("/join")
	public ResponseEntity<Map<String, Object>> join(@RequestBody UserDto user) {
		logger.info("User join: {}", user);
		
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		
		try {
			userService.join(user);
			
			resultMap.put("message", "success");
			status = HttpStatus.ACCEPTED;
		} catch (Exception e) {
			logger.error("회원가입 실패 : {}", e);
			
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@GetMapping("/logout/{userid}")
	public ResponseEntity<Map<String, Object>> logout(@PathVariable("userid") String id) {
		logger.info("User logout: {}", id);
		
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		
		try {
			userService.deleRefreshToken(id);
			
			resultMap.put("message", "success");
			status = HttpStatus.ACCEPTED;
		} catch (Exception e) {
			logger.error("로그아웃 실패 : {}", e);
			
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@GetMapping("/info/{userid}")
	public ResponseEntity<Map<String, Object>> getInfo(@PathVariable("userid") String id, HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		
		if (jwtService.checkToken(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰");
			
			try {
				UserDto userDto = userService.getUserInfo(id);
				
				resultMap.put("userInfo", userDto);
				resultMap.put("message", "success");
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				logger.error("정보조회 실패 : {}", e);
				
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			logger.info("사용 불가능한 토큰");
			
			resultMap.put("message", "fail");
			status = HttpStatus.UNAUTHORIZED;
		}
		
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@PutMapping("/modify")
	public ResponseEntity<Map<String, Object>> modify(@RequestBody UserDto userDto, HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		
		if (jwtService.checkToken(request.getHeader("access-token"))) {
			try {
				userService.modify(userDto);
				
				resultMap.put("userInfo", userService.getUserInfo(userDto.getId()));
				resultMap.put("message", "success");
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				logger.info("사용자 정보 수정 실패: {}", e);

				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			logger.info("사용 불가능한 토큰");
			
			resultMap.put("message", "fail");
			status = HttpStatus.UNAUTHORIZED;
		}
		
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@DeleteMapping("/delete/{userid}")
	public ResponseEntity<Map<String, Object>> delete(@PathVariable("userid") String id, HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		
		if (jwtService.checkToken(request.getHeader("access-token"))) {
			try {
				userService.delete(id);

				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				logger.info("회원 탈퇴 실패: {}", e);

				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			logger.info("사용 불가능한 토큰");
			
			resultMap.put("message", "fail");
			status = HttpStatus.UNAUTHORIZED;
		}
		
		return new ResponseEntity<Map<String,Object>>(resultMap, status);
	}
	
	@PostMapping("/refresh")
	public ResponseEntity<?> refreshToken(@RequestBody UserDto userDto, HttpServletRequest request)
			throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		String token = request.getHeader("refresh-token");
		
		logger.debug("token : {}, userDto : {}", token, userDto);
		
		if (jwtService.checkToken(token)) {
			if (token.equals(userService.getRefreshToken(userDto.getId()))) {
				String accessToken = jwtService.createAccessToken("userid", userDto.getId());
				
				logger.debug("token : {}", accessToken);

				resultMap.put("access-token", accessToken);
				resultMap.put("message", "success");
				status = HttpStatus.ACCEPTED;
			}
		} else {
			logger.debug("refreshToken 사용 불가");
			
			status = HttpStatus.UNAUTHORIZED;
		}
		
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@GetMapping("/password")
	public ResponseEntity<?> password(UserDto user) throws Exception {
		UserDto password = userService.findPassword(user);
		return new ResponseEntity<UserDto>(password, HttpStatus.OK);
	}
	
}
