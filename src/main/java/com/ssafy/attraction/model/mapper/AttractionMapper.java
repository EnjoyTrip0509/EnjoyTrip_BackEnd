package com.ssafy.attraction.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.attraction.model.AttractionDto;

@Mapper
public interface AttractionMapper {
	List<AttractionDto> findAttractions(Map<String, Integer> param) throws SQLException;
	AttractionDto findAttractionByContentId(int contentId) throws SQLException;
	List<AttractionDto> findHotPlace() throws SQLException;
	int getResultCount(Map<String, Integer> map) throws SQLException;
}
