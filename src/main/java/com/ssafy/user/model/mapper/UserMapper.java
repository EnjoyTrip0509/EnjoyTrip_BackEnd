package com.ssafy.user.model.mapper;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.user.model.UserDto;

@Mapper
public interface UserMapper {
	void join(UserDto user) throws SQLException;
	UserDto login(UserDto user) throws SQLException;
	void modify(UserDto user) throws SQLException;
	UserDto getUserInfo(String id) throws SQLException;
	UserDto findPassword(UserDto user) throws SQLException;	//비밀번호 찾기
	int checkIdDuplicate(String id) throws SQLException;
	void delete(String id) throws SQLException;
	
	public void saveRefreshToken(Map<String, String> map) throws SQLException;
	public Object getRefreshToken(String id) throws SQLException;
	public void deleteRefreshToken(Map<String, String> map) throws SQLException;
}
