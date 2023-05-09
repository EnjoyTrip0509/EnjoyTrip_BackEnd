package com.ssafy.announcement.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.announcement.model.AnnouncementDto;
import com.ssafy.announcement.model.service.AnnouncementService;
import com.ssafy.user.model.UserDto;
import com.ssafy.util.PageNavigation;

@Controller
@RequestMapping("/announce")
public class AnnouncementController {
	private final Logger logger = LoggerFactory.getLogger(AnnouncementController.class);
	
	private AnnouncementService announcementService;

	public AnnouncementController(AnnouncementService announcementService) {
		this.announcementService = announcementService;
	}

	@GetMapping("/list")
	public ModelAndView list(@RequestParam Map<String, String> map) throws Exception {
		logger.info("list parameter pgno : {}", map.get("pgno"));
		
		ModelAndView mav = new ModelAndView();
		
		List<AnnouncementDto> list = announcementService.listAnnouncement(map);
		PageNavigation pageNavigation = announcementService.makePageNavigation(map);
		
		mav.addObject("announcements", list);
		mav.addObject("navigation", pageNavigation);
		mav.addObject("pgno", map.get("pgno"));
		mav.addObject("key", map.get("key"));
		mav.addObject("word", map.get("word"));
		mav.setViewName("announcement/list");
		
		return mav;
	}
	
	@GetMapping("/write")
	public String write(@RequestParam Map<String, String> map, Model model) {
		logger.info("Announce write parameter {}", map);
		
		model.addAttribute("pgno", map.get("pgno"));
		model.addAttribute("key", map.get("key"));
		model.addAttribute("word", map.get("word"));
		
		return "announcement/write";
	}
	
	@PostMapping("/write")
	public String write(AnnouncementDto announcementDto, RedirectAttributes redirectAttributes, HttpSession session) throws Exception {
		logger.info("Announce write announcementDto {}", announcementDto);
		
		UserDto user = (UserDto)session.getAttribute("loginUser");
		announcementDto.setUserId(user.getId());
		announcementService.writeAnnouncement(announcementDto);
		
		redirectAttributes.addAttribute("pgno", "1");
		redirectAttributes.addAttribute("key", "");
		redirectAttributes.addAttribute("word", "");
		
		return "redirect:/announce/list";
	}
	
	@GetMapping("/view")
	public String view(@RequestParam("articleno") int articleNo, @RequestParam Map<String, String> map, Model model) throws Exception {
		logger.info("Announce view articleNo : {}. map : {}", articleNo);
		
		AnnouncementDto announcementDto = announcementService.getAnnouncement(articleNo);
		announcementService.updateHit(articleNo);
		
		model.addAttribute("announcement", announcementDto);
		model.addAttribute("pgno", map.get("pgno"));
		model.addAttribute("key", map.get("key"));
		model.addAttribute("word", map.get("word"));
		
		return "announcement/view";
	}

	@GetMapping("/modify")
	public String modify(@RequestParam("articleno") int articleNo, @RequestParam Map<String, String> map, Model model) throws Exception {
		logger.info("Announce modify articleNo : {}", articleNo);
		
		AnnouncementDto announcementDto = announcementService.getAnnouncement(articleNo);
		model.addAttribute("announcement", announcementDto);
		model.addAttribute("pgno", map.get("pgno"));
		model.addAttribute("key", map.get("key"));
		model.addAttribute("word", map.get("word"));
		
		return "announcement/modify";
	}
	
	@PostMapping("/modify")
	public String modify(AnnouncementDto announcementDto, @RequestParam Map<String, String> map, RedirectAttributes redirectAttributes) throws Exception {
		logger.info("Announce modify announcementDto : {}", announcementDto);
		
		announcementService.modifyAnnouncement(announcementDto);
		redirectAttributes.addAttribute("articleno", announcementDto.getArticleNo());
		redirectAttributes.addAttribute("pgno", map.get("pgno"));
		redirectAttributes.addAttribute("key", map.get("key"));
		redirectAttributes.addAttribute("word", map.get("word"));
		
		return "redirect:/announce/view";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("articleno") int articleNo, @RequestParam Map<String, String> map, RedirectAttributes redirectAttributes) throws Exception {
		logger.info("Announce delete articleNo : {}", articleNo);
		
		announcementService.deleteAnnouncement(articleNo);
		redirectAttributes.addAttribute("pgno", map.get("pgno"));
		redirectAttributes.addAttribute("key", map.get("key"));
		redirectAttributes.addAttribute("word", map.get("word"));
		
		return "redirect:/announce/list";
	}
}
