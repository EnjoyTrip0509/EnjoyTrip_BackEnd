package com.ssafy.review.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.review.model.ReviewDto;

@Mapper
public interface ReviewMapper {
	public void addReview(ReviewDto reviewDto) throws SQLException;
	public void modifyReview(ReviewDto reviewDto) throws SQLException;
	public ReviewDto getReview(int articleNo) throws SQLException;
	public void deleteReview(int articleNo) throws SQLException;
	public List<ReviewDto> findAll() throws SQLException;
	public List<ReviewDto> findReviewsByUserId(String userId) throws SQLException;
	public List<ReviewDto> findReviewsByContentId(int contentId) throws SQLException;
	public void updateHit(int articleNo) throws SQLException;
}
