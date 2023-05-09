package com.ssafy.gugun.model.service;

import java.util.List;

import com.ssafy.gugun.model.GugunDto;

public interface GugunService {
	List<GugunDto> findGugunsBySidoCode(int sidoCode) throws Exception;
}
