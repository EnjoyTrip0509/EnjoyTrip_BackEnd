package com.ssafy.announcement.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.announcement.model.AnnouncementDto;

@Mapper
public interface AnnouncementMapper {
	void writeAnnouncement(AnnouncementDto announcementDto) throws SQLException;

	List<AnnouncementDto> listAnnouncement(Map<String, Object> param) throws SQLException;

	int getTotalAnnouncementCount(Map<String, Object> param) throws SQLException;

	AnnouncementDto getAnnouncement(int articleNo) throws SQLException;

	void updateHit(int articleNo) throws SQLException;

	void modifyAnnouncement(AnnouncementDto announcementDto) throws SQLException;

	void deleteAnnouncement(int articleNo) throws SQLException;
}
