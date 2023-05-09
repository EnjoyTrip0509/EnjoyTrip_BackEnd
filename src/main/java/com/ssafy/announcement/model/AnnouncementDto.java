package com.ssafy.announcement.model;

public class AnnouncementDto {
	private int articleNo;
	private String subject;
	private String userId;
	private String userName;
	private String content;
	private int hit;
	private String registerTime;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public int getArticleNo() {
		return articleNo;
	}
	
	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public int getHit() {
		return hit;
	}
	
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	public String getRegisterTime() {
		return registerTime;
	}
	
	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	@Override
	public String toString() {
		return "AnnouncementDto [articleNo=" + articleNo + ", subject=" + subject + ", userId=" + userId + ", userName=" + userName + ", content="
				+ content + ", hit=" + hit + ", registerTime=" + registerTime + "]";
	}
}
