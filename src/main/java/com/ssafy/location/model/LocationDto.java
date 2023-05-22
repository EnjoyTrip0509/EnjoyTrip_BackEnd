package com.ssafy.location.model;

import com.ssafy.attraction.model.AttractionDto;

public class LocationDto {
	private Long id;
	private int contentId;
	private int day;
	private int order;
	private Long planId;
	AttractionDto attraction;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getContentId() {
		return contentId;
	}
	
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	
	public int getDay() {
		return day;
	}
	
	public void setDay(int day) {
		this.day = day;
	}
	
	public int getOrder() {
		return order;
	}
	
	public void setOrder(int order) {
		this.order = order;
	}
	
	public Long getPlanId() {
		return planId;
	}
	
	public void setPlanId(Long planId) {
		this.planId = planId;
	}
	
	public AttractionDto getAttraction() {
		return attraction;
	}
	
	public void setAttraction(AttractionDto attraction) {
		this.attraction = attraction;
	}

	@Override
	public String toString() {
		return "LocationDto [id=" + id + ", contentId=" + contentId + ", day=" + day + ", order=" + order + ", planId="
				+ planId + ", attraction=" + attraction + "]";
	}
}
