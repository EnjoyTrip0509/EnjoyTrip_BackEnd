package com.ssafy.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.user.model.UserDto;
import com.ssafy.user.model.service.UserServiceImpl;


import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private UserServiceImpl userService;
	
	@Autowired
	public UserController(UserServiceImpl userService) {
		this.userService = userService;
	}

	@PostMapping("/join")
	public String join(UserDto user) throws Exception {
		userService.join(user);
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(UserDto user, HttpSession session, Model model) throws Exception {
		UserDto login = userService.login(user);
		if (login != null) {
			session.setAttribute("loginUser", login);
			model.addAttribute("login", true);
		} else {
			model.addAttribute("login", false);
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/userinfo")
	public ResponseEntity<?> userInfo(HttpSession session) throws Exception {
		UserDto login = (UserDto)session.getAttribute("loginUser");
		UserDto currentUser = userService.getUserInfo(login);
		
		return new ResponseEntity<UserDto>(currentUser, HttpStatus.OK);
	}
	
	@PostMapping("/modify")
	public String modify(UserDto user) throws Exception {
		userService.modify(user);
		return "redirect:/";
	}
	
	@GetMapping("/password")
	public ResponseEntity<?> password(UserDto user) throws Exception {
		UserDto password = userService.findPassword(user);
		return new ResponseEntity<UserDto>(password, HttpStatus.OK);
	}
	
}
