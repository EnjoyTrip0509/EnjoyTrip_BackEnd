package com.ssafy.location.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.location.model.LocationDto;
import com.ssafy.location.model.mapper.LocationMapper;

@Service
public class LocationServiceImpl implements LocationService {
	private LocationMapper locationMapper;
	
	@Autowired
	public LocationServiceImpl(LocationMapper locationMapper) {
		this.locationMapper = locationMapper;
	}

	@Override
	public void addLocation(LocationDto locationDto) throws Exception {
		locationMapper.addLocation(locationDto);
	}

	@Override
	public List<LocationDto> findLocationsByPlanId(Long planId) throws Exception {
		return locationMapper.findLocationsByPlanId(planId);
	}

	@Override
	public LocationDto findLocationById(Long id) throws Exception {
		return locationMapper.findLocationById(id);
	}

	@Override
	public void deleteLocationsByPlanId(Long planId) throws Exception {
		locationMapper.deleteLocationsByPlanId(planId);
	}
}
