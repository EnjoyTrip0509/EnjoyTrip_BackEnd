package com.ssafy.user.model.service;

import com.ssafy.user.model.UserDto;

public interface UserService {
	void join(UserDto user) throws Exception; 	// 회원 가입
	UserDto login(UserDto user) throws Exception;	// 로그인
	void modify(UserDto user) throws Exception;
	UserDto getUserInfo(String id) throws Exception;
	UserDto findPassword(UserDto user) throws Exception; // 비밀번호 찾기
	
	public void saveRefreshToken(String id, String refreshToken) throws Exception;
	public Object getRefreshToken(String id) throws Exception;
	public void deleRefreshToken(String id) throws Exception;
}
