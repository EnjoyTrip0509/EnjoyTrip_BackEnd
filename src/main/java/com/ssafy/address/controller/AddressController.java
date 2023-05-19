package com.ssafy.address.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.gugun.model.GugunDto;
import com.ssafy.gugun.model.service.GugunService;
import com.ssafy.sido.model.SidoDto;
import com.ssafy.sido.model.service.SidoService;

@RestController
@RequestMapping("/address")
public class AddressController {
	private SidoService sidoService;
	private GugunService gugunService;
	
	@Autowired
	public AddressController(SidoService sidoService, GugunService gugunService) {
		this.sidoService = sidoService;
		this.gugunService = gugunService;
	}

	@GetMapping("/sido")
	public ResponseEntity<List<SidoDto>> getSidoList() throws Exception {
		return new ResponseEntity<List<SidoDto>>(sidoService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/sido/{sidoCode}")
	public ResponseEntity<List<GugunDto>> getGugunList(@PathVariable int sidoCode) throws Exception {
		return new ResponseEntity<List<GugunDto>>(gugunService.findGugunsBySidoCode(sidoCode), HttpStatus.OK);
	}
}
