package com.ssafy.review.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.review.model.ReviewDto;
import com.ssafy.review.model.mapper.ReviewMapper;

@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	private ReviewMapper reviewMapper;
	
	@Override
	public void addReview(ReviewDto reviewDto) throws Exception {
		reviewMapper.addReview(reviewDto);
	}

	@Override
	public void modifyReview(ReviewDto reviewDto) throws Exception{
		reviewMapper.modifyReview(reviewDto);
	}

	@Override
	public ReviewDto getReview(int articleNo) throws Exception{
		return reviewMapper.getReview(articleNo);
	}

	@Override
	public void deleteReview(int articleNo) throws Exception{
		reviewMapper.deleteReview(articleNo);
	}

	@Override
	public List<ReviewDto> findAll() throws Exception{
		return reviewMapper.findAll();
	}

	@Override
	public List<ReviewDto> findReviewsByUserId(String userId) throws Exception{
		return reviewMapper.findReviewsByUserId(userId);
	}

	@Override
	public List<ReviewDto> findReviewsByContentId(int contentId) throws Exception{
		return reviewMapper.findReviewsByContentId(contentId);
	}

	@Override
	public void updateHit(int articleNo) throws Exception {
		reviewMapper.updateHit(articleNo);
	}
}
