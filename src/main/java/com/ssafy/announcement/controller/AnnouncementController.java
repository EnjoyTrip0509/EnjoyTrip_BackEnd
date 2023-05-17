package com.ssafy.announcement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.announcement.model.AnnouncementDto;
import com.ssafy.announcement.model.service.AnnouncementService;

@RestController
@RequestMapping("/announce")
public class AnnouncementController {
	private final Logger logger = LoggerFactory.getLogger(AnnouncementController.class);
	
	private AnnouncementService announcementService;

	public AnnouncementController(AnnouncementService announcementService) {
		this.announcementService = announcementService;
	}

	@GetMapping
	public ResponseEntity<List<AnnouncementDto>> list() throws Exception {
		logger.info("list ");

		return ResponseEntity.ok(announcementService.listAnnouncement());
	}
	
	@PostMapping
	public ResponseEntity<Object> write(@RequestBody AnnouncementDto announcementDto) throws Exception {
		logger.info("Announce write announcementDto {}", announcementDto);
		
		announcementService.writeAnnouncement(announcementDto);

		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{articleNo}")
	public ResponseEntity<AnnouncementDto> view(@PathVariable int articleNo) throws Exception {
		logger.info("Announce view articleNo : {}.", articleNo);

		announcementService.updateHit(articleNo);

		return ResponseEntity.ok(announcementService.getAnnouncement(articleNo));
	}

	@PutMapping
	public ResponseEntity<Object> modify(@RequestBody AnnouncementDto announcementDto) throws Exception {
		logger.info("Announce modify announcementDto : {}.", announcementDto);
		
		announcementService.modifyAnnouncement(announcementDto);
		
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{articleNo}")
	public ResponseEntity<Object> delete(@PathVariable int articleNo) throws Exception {
		logger.info("Announce delete articleNo : {}", articleNo);
		
		announcementService.deleteAnnouncement(articleNo);
		
		return ResponseEntity.ok().build();
	}
}
