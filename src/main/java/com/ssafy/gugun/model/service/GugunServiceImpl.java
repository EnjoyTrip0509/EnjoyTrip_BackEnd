package com.ssafy.gugun.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.gugun.model.GugunDto;
import com.ssafy.gugun.model.mapper.GugunMapper;

@Service
public class GugunServiceImpl implements GugunService {
	private GugunMapper gugunMapper;
	
	public GugunServiceImpl(GugunMapper gugunMapper) {
		super();
		this.gugunMapper = gugunMapper;
	}

	@Override
	public List<GugunDto> findGugunsBySidoCode(int sidoCode) throws Exception {
		return gugunMapper.findGugunsBySidoCode(sidoCode);
	}
}
