package com.ssafy.mytrip.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.mytrip.model.MyTripDto;
import com.ssafy.mytrip.model.mapper.MyTripMapper;

@Service
public class MyTripServiceImpl implements IMyTripService {

	private MyTripMapper myTripMapper;
	
	@Autowired
	public MyTripServiceImpl(MyTripMapper myTripMapper) {
		super();
		this.myTripMapper = myTripMapper;
	}

	@Override
	public void addAttraction(MyTripDto mdto) {
		myTripMapper.addAttraction(mdto);
	}

	@Override
	public List<MyTripDto> getMyTrip(String id) {
		return myTripMapper.getMyTrip(id);
	}
}
