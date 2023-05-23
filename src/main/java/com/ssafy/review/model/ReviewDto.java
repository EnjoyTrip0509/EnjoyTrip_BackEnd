package com.ssafy.review.model;

public class ReviewDto {
	private int articleNo;
	private int contentId;
	private long planId;
	private String subject;
	private String content;
	private String userId;
	private String userName;
	private int hit;
	private String registerTime;
	
	public int getArticleNo() {
		return articleNo;
	}
	
	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}
	
	public int getContentId() {
		return contentId;
	}
	
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	
	public long getPlanId() {
		return planId;
	}
	
	public void setPlanId(long planId) {
		this.planId = planId;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
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
		return "ReviewDto [articleNo=" + articleNo + ", contentId=" + contentId + ", planId=" + planId + ", subject="
				+ subject + ", content=" + content + ", userId=" + userId + ", userName=" + userName + ", hit=" + hit
				+ ", registerTime=" + registerTime + "]";
	}
}
