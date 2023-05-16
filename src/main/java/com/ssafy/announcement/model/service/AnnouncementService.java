package com.ssafy.announcement.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.announcement.model.AnnouncementDto;
import com.ssafy.util.PageNavigation;

public interface AnnouncementService {
	void writeAnnouncement(AnnouncementDto announcementDto) throws Exception;

	List<AnnouncementDto> listAnnouncement() throws Exception;

	PageNavigation makePageNavigation(Map<String, String> map) throws Exception;
	
	AnnouncementDto getAnnouncement(int articleNo) throws Exception;

	void updateHit(int articleNo) throws Exception;

	void modifyAnnouncement(AnnouncementDto announcementDto) throws Exception;

	void deleteAnnouncement(int articleNo) throws Exception;
}
