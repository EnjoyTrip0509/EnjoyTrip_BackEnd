package com.ssafy.plan.model;

import java.util.List;

import com.ssafy.location.model.LocationDto;

public class PlanDto {
	private Long id;
	private String title;
	private String memberId;
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
	
	public String getMemberId() {
		return memberId;
	}
	
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	public List<LocationDto> getLocations() {
		return locations;
	}
	
	public void setLocations(List<LocationDto> locations) {
		this.locations = locations;
	}

	@Override
	public String toString() {
		return "PlanDto [id=" + id + ", title=" + title + ", memberId=" + memberId + ", locations=" + locations + "]";
	}
}
