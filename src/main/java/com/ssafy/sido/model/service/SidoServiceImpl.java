package com.ssafy.sido.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.sido.model.SidoDto;
import com.ssafy.sido.model.mapper.SidoMapper;

@Service
public class SidoServiceImpl implements SidoService {
	private SidoMapper sidoMapper;
	
	public SidoServiceImpl(SidoMapper sidoMapper) {
		this.sidoMapper = sidoMapper;
	}

	@Override
	public List<SidoDto> findAll() throws Exception {
		return sidoMapper.findAll();
	}
}
