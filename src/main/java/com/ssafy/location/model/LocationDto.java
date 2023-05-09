package com.ssafy.location.model;

public class LocationDto {
	private Long id;
	private int planOrder;
	private Long planId;
	private int contentId;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getPlanOrder() {
		return planOrder;
	}
	
	public void setPlanOrder(int planOrder) {
		this.planOrder = planOrder;
	}
	
	public Long getPlanId() {
		return planId;
	}
	
	public void setPlanId(Long planId) {
		this.planId = planId;
	}
	
	public int getContentId() {
		return contentId;
	}
	
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	@Override
	public String toString() {
		return "LocationDto [id=" + id + ", planOrder=" + planOrder + ", planId=" + planId + ", contentId=" + contentId
				+ "]";
	}
}
