package com.ssafy.board.controller;

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

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.service.BoardService;

@RestController
@RequestMapping("/board")
public class BoardController {
	private final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	private BoardService boardService;

	public BoardController(BoardService boardService) {
		super();
		this.boardService = boardService;
	}
	
	@GetMapping()
	public ResponseEntity<List<BoardDto>> list() throws Exception {
		logger.info("Board list");
		
		return ResponseEntity.ok(boardService.listArticle());
	}
	
	@GetMapping("/{articleNo}")
	public ResponseEntity<BoardDto> view(@PathVariable int articleNo) throws Exception {
		logger.info("view articleNo : {}", articleNo);
		
		boardService.updateHit(articleNo);

		return ResponseEntity.ok(boardService.getArticle(articleNo));
	}
	
	@PostMapping
	public ResponseEntity<Object> write(@RequestBody BoardDto boardDto) throws Exception {
		logger.info("Board write boardDto: {}", boardDto);
		
		boardService.writeArticle(boardDto);

		return ResponseEntity.ok().build();
	}
	
	@PutMapping
	public ResponseEntity<Object> modify(@RequestBody BoardDto boardDto) throws Exception {
		logger.info("Board modify boardDto : {}", boardDto);
		
		boardService.modifyArticle(boardDto);
		
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{articleNo}")
	public ResponseEntity<Object> delete(@PathVariable int articleNo) throws Exception {
		logger.info("Announce delete articleNo : {}", articleNo);
		
		boardService.deleteArticle(articleNo);
		
		return ResponseEntity.ok().build();
	}
}
