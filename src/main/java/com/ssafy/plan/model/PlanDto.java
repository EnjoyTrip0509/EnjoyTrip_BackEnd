package com.ssafy.plan.model;

import java.util.List;

import com.ssafy.location.model.LocationDto;

public class PlanDto {
	private Long id;
	private String title;
	private String userId;
	private String startDate;
	private String endDate;
	private List<LocationDto> locations;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getStartDate() {
		return startDate;
	}
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public String getEndDate() {
		return endDate;
	}
	
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public List<LocationDto> getLocations() {
		return locations;
	}
	
	public void setLocations(List<LocationDto> locations) {
		this.locations = locations;
	}

	@Override
	public String toString() {
		return "PlanDto [id=" + id + ", title=" + title + ", userId=" + userId + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", locations=" + locations + "]";
	}
}
