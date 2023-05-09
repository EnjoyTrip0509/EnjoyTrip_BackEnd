package com.ssafy.attraction.controller;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.attraction.model.AttractionDto;
import com.ssafy.attraction.model.service.AttractionService;
import com.ssafy.gugun.model.GugunDto;
import com.ssafy.gugun.model.service.GugunService;
import com.ssafy.sido.model.service.SidoService;

@Controller
@RequestMapping("/attraction")
public class AttractionController {
	private AttractionService attractionService;
	private SidoService sidoService;
	private GugunService gugunService;
	private ObjectMapper mapper = new ObjectMapper();
	
	private static final Logger logger = LoggerFactory.getLogger(AttractionController.class);
	@Autowired
	public AttractionController(AttractionService attractionService, SidoService sidoService,
			GugunService gugunService) {
		super();
		this.attractionService = attractionService;
		this.sidoService = sidoService;
		this.gugunService = gugunService;
	}
	
	@GetMapping("/")
	public String home() {
		logger.info("Attraction home");
		
		return "index";
	}

	@GetMapping("/init")
	public String init(Model model) throws Exception {
		logger.info("Attraction init");
		
		model.addAttribute("sidos", sidoService.findAll());
		return "/trips/search";
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<AttractionDto>> search(@RequestParam Map<String, Integer> map, HttpServletResponse response) throws Exception {
		logger.info("Attraction search {}", map);
		
		List<AttractionDto> attractions = attractionService.findAttractions(map);
		logger.info(attractions.get(0).toString());
		
		return new ResponseEntity<List<AttractionDto>>(attractions, HttpStatus.OK);
	}
	
	@GetMapping("/gugun")
	public ResponseEntity<List<GugunDto>> gugun(@RequestParam int sidoCode, HttpServletResponse response) throws NumberFormatException, Exception {
		logger.info("Attraction gugun {}", sidoCode);

		List<GugunDto> guguns = gugunService.findGugunsBySidoCode(sidoCode);
		
		return new ResponseEntity<List<GugunDto>> (guguns, HttpStatus.OK);
	}
	
	@GetMapping("/addMyTrip")
	public void addMyTrip(@RequestParam int contentId) {
		
	}
}
