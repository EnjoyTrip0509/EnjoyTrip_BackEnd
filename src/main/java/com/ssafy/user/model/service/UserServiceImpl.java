package com.ssafy.user.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.user.model.UserDto;
import com.ssafy.user.model.mapper.UserMapper;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public void join(UserDto user) throws Exception {
		userMapper.join(user);
	}

	@Override
	public UserDto login(UserDto user) throws Exception {
		return userMapper.login(user);
	}

	@Override
	public void modify(UserDto user) throws Exception {
		userMapper.modify(user);
	}

	@Override
	public UserDto getUserInfo(String id) throws Exception {
		return userMapper.getUserInfo(id);
	}

	@Override
	public UserDto findPassword(UserDto user) throws Exception {
		return userMapper.findPassword(user);
	}

	@Override
	public void saveRefreshToken(String id, String refreshToken) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("token", refreshToken);
		
		userMapper.saveRefreshToken(map);
	}

	@Override
	public Object getRefreshToken(String id) throws Exception {
		return userMapper.getRefreshToken(id);
	}

	@Override
	public void deleRefreshToken(String id) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("token", null);
		
		userMapper.deleteRefreshToken(map);
	}

}
