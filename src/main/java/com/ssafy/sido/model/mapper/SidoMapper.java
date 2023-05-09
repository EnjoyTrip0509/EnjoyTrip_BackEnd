package com.ssafy.sido.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.sido.model.SidoDto;

@Mapper
public interface SidoMapper {
	List<SidoDto> findAll() throws SQLException;
}
