package com.ssafy.announcement.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.announcement.model.AnnouncementDto;
import com.ssafy.announcement.model.mapper.AnnouncementMapper;
import com.ssafy.util.PageNavigation;
import com.ssafy.util.SizeConstant;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {
	private AnnouncementMapper announcementMapper;
	
	public AnnouncementServiceImpl(AnnouncementMapper announcementMapper) {
		this.announcementMapper = announcementMapper;
	}

	@Override
	@Transactional
	public void writeAnnouncement(AnnouncementDto announcementDto) throws Exception {
		announcementMapper.writeAnnouncement(announcementDto);
	}

	@Override
	public List<AnnouncementDto> listAnnouncement(Map<String, String> map) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		
		String key = map.get("key");
		if("userid".equals(key))
			key = "a.user_id";
		param.put("key", key == null ? "" : key);

		param.put("word", map.get("word") == null ? "" : map.get("word"));
		
		int pgNo = Integer.parseInt(map.get("pgno") == null || map.get("pgno").equals("")? "1" : map.get("pgno"));
		int start = pgNo * SizeConstant.LIST_SIZE - SizeConstant.LIST_SIZE;
		
		param.put("start", start);
		param.put("listsize", SizeConstant.LIST_SIZE);
		
		return announcementMapper.listAnnouncement(param);
	}

	@Override
	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception {
		PageNavigation pageNavigation = new PageNavigation();

		int naviSize = SizeConstant.NAVIGATION_SIZE;
		int sizePerPage = SizeConstant.LIST_SIZE;
		int currentPage = Integer.parseInt(map.get("pgno") == null || map.get("pgno").equals("")? "1" : map.get("pgno"));

		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		
		Map<String, Object> param = new HashMap<String, Object>();
		String key = map.get("key");
		if ("userid".equals(key))
			key = "user_id";
		param.put("key", key == null ? "" : key);
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		
		int totalCount = announcementMapper.getTotalAnnouncementCount(param);
		pageNavigation.setTotalCount(totalCount);
		
		int totalPageCount = (totalCount - 1) / sizePerPage + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		
		boolean startRange = currentPage <= naviSize;
		pageNavigation.setStartRange(startRange);
		
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();

		return pageNavigation;
	}

	@Override
	public AnnouncementDto getAnnouncement(int articleNo) throws Exception {
		return announcementMapper.getAnnouncement(articleNo);
	}

	@Override
	@Transactional
	public void updateHit(int articleNo) throws Exception {
		announcementMapper.updateHit(articleNo);
	}

	@Override
	@Transactional
	public void modifyAnnouncement(AnnouncementDto announcementDto) throws Exception {
		announcementMapper.modifyAnnouncement(announcementDto);
	}

	@Override
	@Transactional
	public void deleteAnnouncement(int articleNo) throws Exception {
		announcementMapper.deleteAnnouncement(articleNo);
	}
}
