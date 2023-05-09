package com.ssafy.location.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.location.model.LocationDto;

@Mapper
public interface LocationMapper {
	void addLocation(LocationDto locationDto) throws SQLException;
	List<LocationDto> findLocationsByPlanId(Long planId) throws SQLException;
	LocationDto findLocationById(Long id) throws SQLException;
	void deleteLocationsByPlanId(Long planId) throws SQLException;
}
