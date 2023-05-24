package com.ssafy.attraction.model.service;

import java.util.HashMap;
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
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("sidoCode", map.get("sidoCode"));
		params.put("gugunCode", map.get("gugunCode"));
		params.put("contentTypeId", map.get("contentTypeId"));
		
		int start = (map.get("pageNo") - 1) * 9;
		
		params.put("start", start);
		
		return attractionMapper.findAttractions(params);
	}

	@Override
	public AttractionDto findAttractionByContentId(int contentId) throws Exception {
		return attractionMapper.findAttractionByContentId(contentId);
	}
	
	@Override
	public List<AttractionDto> findHotPlace() throws Exception {
		return attractionMapper.findHotPlace();
	}

	@Override
	public int getResultCount(Map<String, Integer> map) throws Exception {
		return attractionMapper.getResultCount(map);
	}
}
