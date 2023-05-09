package com.ssafy.user.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.user.model.UserDto;
import com.ssafy.user.model.mapper.UserMapper;


@Service
public class UserServiceImpl implements IUserService {
	
	private UserMapper userMapper;
		
	@Autowired
	public UserServiceImpl(UserMapper userMapper) {
		super();
		this.userMapper = userMapper;
	}

	@Override
	public void join(UserDto user) {
		userMapper.join(user);
	}

	@Override
	public UserDto login(UserDto user) {
		return userMapper.login(user);
	}

	@Override
	public void modify(UserDto user) {
		userMapper.modify(user);
	}
	
	@Override
	public UserDto getUserInfo(UserDto user) {
		return userMapper.getUserInfo(user);
	}
	
	@Override
	public UserDto findPassword(UserDto user) {
		return userMapper.findPassword(user);
	}
}
