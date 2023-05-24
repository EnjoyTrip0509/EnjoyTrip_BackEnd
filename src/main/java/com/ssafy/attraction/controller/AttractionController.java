package com.ssafy.attraction.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.attraction.model.AttractionDto;
import com.ssafy.attraction.model.service.AttractionService;

@RestController
@RequestMapping("/attraction")
public class AttractionController {
	@Autowired
	private AttractionService attractionService;

	@PostMapping("/search")
	public ResponseEntity<List<AttractionDto>> search(@RequestBody Map<String, Integer> map) throws Exception {
		return new ResponseEntity<List<AttractionDto>>(attractionService.findAttractions(map), HttpStatus.OK);
	}
	
	@PostMapping("/search/count")
	public ResponseEntity<Integer> getResultCount(@RequestBody Map<String, Integer> map) throws Exception {
		return new ResponseEntity<Integer>(attractionService.getResultCount(map), HttpStatus.OK);
	}
	
	@GetMapping("/{contentId}")
	public ResponseEntity<AttractionDto> getAttraction(@PathVariable int contentId) throws Exception {
		return ResponseEntity.ok(attractionService.findAttractionByContentId(contentId));
	}
	
	@GetMapping("/hotplace")
	public ResponseEntity<List<AttractionDto>> getHotPlace() throws Exception {
		return ResponseEntity.ok(attractionService.findHotPlace());
	}
}
