package com.ssafy.mytrip.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.mytrip.model.MyTripDto;
import com.ssafy.mytrip.model.service.IMyTripService;
import com.ssafy.user.model.UserDto;

@Controller
@RequestMapping("/mytrip")
public class MyTripController {
	private IMyTripService myTripService;
	
	
	@Autowired
	public MyTripController(IMyTripService myTripService) {
		super();
		this.myTripService = myTripService;
	}


	@GetMapping("/add")
	public ResponseEntity<?> add(MyTripDto mDto, HttpSession session) {
		UserDto login = (UserDto)session.getAttribute("loginUser");
		mDto.setUser_id(login.getId());
		myTripService.addAttraction(mDto);

		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping("/")
	public String init(Model model, HttpSession session) {
		return "trips/mytrip";
		
	}
	
	@GetMapping("/trips")
	public ResponseEntity<?> trips(Model model, HttpSession session) {
		UserDto login = (UserDto)session.getAttribute("loginUser");
		
		List<MyTripDto> trips = myTripService.getMyTrip(login.getId());
		
		
		return new ResponseEntity<Object>(trips, HttpStatus.OK);
	}
	
}
