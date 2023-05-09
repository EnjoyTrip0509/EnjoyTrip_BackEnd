package com.ssafy.mytrip.model.service;

import java.util.List;

import com.ssafy.mytrip.model.MyTripDto;
import com.ssafy.sido.model.SidoDto;

public interface IMyTripService {
	void addAttraction(MyTripDto mdto);
	List<MyTripDto> getMyTrip(String id);
}
