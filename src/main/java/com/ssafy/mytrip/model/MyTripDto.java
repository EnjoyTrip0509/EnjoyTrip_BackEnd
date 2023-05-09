package com.ssafy.mytrip.model;

public class MyTripDto {
	private int content_id;
	private String user_id;
	private String title;
	private String firstImage;
	private double latitude;
	private double longitude;
	
	public MyTripDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyTripDto(int content_id, String user_id) {
		super();
		this.content_id = content_id;
		this.user_id = user_id;
	}
	public int getContent_id() {
		return content_id;
	}
	public void setContent_id(int content_id) {
		this.content_id = content_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstImage() {
		return firstImage;
	}
	public void setFirstImage(String firstImage) {
		this.firstImage = firstImage;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	@Override
	public String toString() {
		return "MyTripDto [content_id=" + content_id + ", user_id=" + user_id + "]";
	}	
}
