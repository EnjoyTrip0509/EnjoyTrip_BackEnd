package com.ssafy.attraction.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.attraction.model.AttractionDto;

@Mapper
public interface AttractionMapper {
	List<AttractionDto> findAttractions(Map<String, Integer> param) throws SQLException;
	AttractionDto findAttractionByContentId(String contentId) throws SQLException;
}
