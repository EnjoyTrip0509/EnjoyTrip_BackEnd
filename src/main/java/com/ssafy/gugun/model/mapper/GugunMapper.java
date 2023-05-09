package com.ssafy.gugun.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.gugun.model.GugunDto;

@Mapper
public interface GugunMapper {
	List<GugunDto> findGugunsBySidoCode(int sidoCode) throws SQLException;
}
