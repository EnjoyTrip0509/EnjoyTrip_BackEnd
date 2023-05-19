package com.ssafy.review.controller;

import java.util.List;

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

import com.ssafy.review.model.ReviewDto;
import com.ssafy.review.model.service.ReviewService;

@RestController
@RequestMapping("/review")
public class ReveiwController {
	@Autowired
	private ReviewService reviewService;
	
	@PostMapping
	public ResponseEntity<Object> add(@RequestBody ReviewDto reviewDto) throws Exception {
		reviewService.addReview(reviewDto);
		return ResponseEntity.ok().build(); 
	}
	
	@PutMapping
	public ResponseEntity<ReviewDto> modify(@RequestBody ReviewDto reviewDto) throws Exception {
		reviewService.modifyReview(reviewDto);
		return ResponseEntity.ok(reviewService.getReview(reviewDto.getArticleNo()));
	}
	
	@GetMapping("/{articleNo}")
	public ResponseEntity<ReviewDto> view(@PathVariable int articleNo) throws Exception {
		return ResponseEntity.ok(reviewService.getReview(articleNo));
	}
	
	@DeleteMapping("/{articleNo}")
	public ResponseEntity<Object> delete(@PathVariable int articleNo) throws Exception {
		reviewService.deleteReview(articleNo);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<ReviewDto>> findAll() throws Exception {
		return ResponseEntity.ok(reviewService.findAll());
	}
	
	@GetMapping("/list/user/{userId}")
	public ResponseEntity<List<ReviewDto>> findReviewsByUserId(@PathVariable String userId) throws Exception {
		return ResponseEntity.ok(reviewService.findReviewsByUserId(userId));
	}
	
	@GetMapping("/list/content/{contentId}")
	public ResponseEntity<List<ReviewDto>> findReviewsByContentId(@PathVariable int contentId) throws Exception {
		return ResponseEntity.ok(reviewService.findReviewsByContentId(contentId));
	}
}
