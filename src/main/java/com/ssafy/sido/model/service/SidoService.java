package com.ssafy.sido.model.service;

import java.util.List;

import com.ssafy.sido.model.SidoDto;

public interface SidoService {
	List<SidoDto> findAll() throws Exception;
}
