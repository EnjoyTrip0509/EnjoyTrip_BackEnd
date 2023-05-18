package com.ssafy.review.model.service;

import java.util.List;

import com.ssafy.review.model.ReviewDto;

public interface ReviewService {
	public void addReview(ReviewDto reviewDto) throws Exception;
	public void modifyReview(ReviewDto reviewDto) throws Exception;
	public ReviewDto getReview(int articleNo) throws Exception;
	public void deleteReview(int articleNo) throws Exception;
	
	public List<ReviewDto> findAll() throws Exception;
	public List<ReviewDto> findReviewsByUserId(String userId) throws Exception;
	public List<ReviewDto> findReviewsByContentId(int contentId) throws Exception;
	
	public void updateHit(int articleNo) throws Exception;
}
