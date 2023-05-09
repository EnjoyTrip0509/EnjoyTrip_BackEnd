package com.ssafy.user.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.user.model.UserDto;

@Mapper
public interface UserMapper {
	void join(UserDto user);
	UserDto login(UserDto user);
	void modify(UserDto user);
	UserDto getUserInfo(UserDto user);
	UserDto findPassword(UserDto user);	//비밀번호 찾기
}
