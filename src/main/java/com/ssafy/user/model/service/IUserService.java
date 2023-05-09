package com.ssafy.user.model.service;

import com.ssafy.user.model.UserDto;

public interface IUserService {
	void join(UserDto user); 	// 회원 가입
	UserDto login(UserDto user);	// 로그인
	void modify(UserDto user);
	UserDto getUserInfo(UserDto user);
	UserDto findPassword(UserDto user);	//비밀번호 찾기
}
