package com.ssafy.mytrip.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.mytrip.model.MyTripDto;

@Mapper
public interface MyTripMapper {
	void addAttraction(MyTripDto mdto);
	List<MyTripDto> getMyTrip(String id);
}
