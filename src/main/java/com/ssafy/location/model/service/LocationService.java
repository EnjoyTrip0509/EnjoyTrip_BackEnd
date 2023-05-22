package com.ssafy.location.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.location.model.LocationDto;

public interface LocationService {
	void addLocation(LocationDto locationDto) throws Exception;
	void deleteLocation(Long id) throws Exception;
	void updateLocation(LocationDto locationDto) throws Exception;
	LocationDto findLocationById(Long id) throws Exception;
	List<LocationDto> findLocationsByPlanId(Long planId) throws Exception;
	void deleteLocationsByPlanId(Long planId) throws Exception;
	List<LocationDto> findLocationsByPlanIdAndDay(Map<String, Object> map) throws Exception;
}
