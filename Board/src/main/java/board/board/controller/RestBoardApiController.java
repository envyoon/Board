package board.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import board.board.dto.BoardDto;
import board.board.service.BoardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description ="게시판 REST API")
@RestController
public class RestBoardApiController {
	
	@Autowired
	private BoardService boardService;
	
	@ApiOperation(value = "게시글 목록 조회")
	@GetMapping(value="/api/board")
	public List<BoardDto> openBoardList() throws Exception{
		return boardService.selectBoardList();
	}
	
	@ApiOperation(value = "게시글 작성")
	@PostMapping(value="/api/board/write")
	public void insertBoard(@RequestBody BoardDto board) throws Exception{
		boardService.insertBoard(board);
	}
	
	@ApiOperation(value = "게시글 상세 내용 조회")
	@GetMapping(value="/api/board/{boardIdx}")
	public BoardDto openBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception{
		
		return boardService.selectBoardDetail(boardIdx);
	}
	
	@ApiOperation(value = "게시글 상세 내용 수정")
	@PutMapping(value="/api/board/{boardIdx}")
	public String updateBoard(@RequestBody BoardDto board) throws Exception{
		boardService.updateBoard(board);
		return "redirect:/board";
	}
	
	@ApiOperation(value = "게시글 삭제")
	@DeleteMapping(value="/api/board/{boardIdx}")
	public String deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception{
		boardService.deleteBoard(boardIdx);
		return "redirect:/board";
	}
}
