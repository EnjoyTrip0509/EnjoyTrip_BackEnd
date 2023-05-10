package com.ssafy.attraction.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.attraction.model.AttractionDto;
import com.ssafy.attraction.model.mapper.AttractionMapper;

@Service
public class AttractionServiceImpl implements AttractionService {
	private AttractionMapper attractionMapper;
	
	public AttractionServiceImpl(AttractionMapper attractionMapper) {
		super();
		this.attractionMapper = attractionMapper;
	}

	@Override
	public List<AttractionDto> findAttractions(Map<String, Integer> map) throws Exception {
		return attractionMapper.findAttractions(map);
	}

	@Override
	public AttractionDto findAttractionByContentId(String contentId) throws Exception {
		return attractionMapper.findAttractionByContentId(contentId);
	}

}
