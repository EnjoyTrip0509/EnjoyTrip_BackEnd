package com.ssafy.attraction.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.attraction.model.AttractionDto;
import com.ssafy.attraction.model.mapper.AttractionMapper;

@Service
public class AttractionServiceImpl implements AttractionService {
	@Autowired
	private AttractionMapper attractionMapper;

	@Override
	public List<AttractionDto> findAttractions(Map<String, Integer> map) throws Exception {
		return attractionMapper.findAttractions(map);
	}

	@Override
	public AttractionDto findAttractionByContentId(int contentId) throws Exception {
		return attractionMapper.findAttractionByContentId(contentId);
	}
	
	@Override
	public List<AttractionDto> findHotPlace() throws Exception {
		return attractionMapper.findHotPlace();
	}
}
