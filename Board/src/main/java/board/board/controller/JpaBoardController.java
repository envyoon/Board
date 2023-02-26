package board.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import board.board.entity.BoardEntity;
import board.board.service.JpaBoardService;

@RestController
public class JpaBoardController {
	
	@Autowired
	private JpaBoardService jpaBoardService;
	
	@GetMapping(value="/jpa/board")
	public ModelAndView openBoardList(ModelMap model) throws Exception{
		ModelAndView mv = new ModelAndView("/board/jpaBoardList");
		
		List<BoardEntity> list = jpaBoardService.selectBoardList();
		mv.addObject("list", list);
		
		return mv;
	}
	
	@GetMapping(value="/jpa/board/write")
	public String openBoardWrite() throws Exception{
		return "/board/jpaBoardWrite";
	}
	
	@PostMapping(value="/jpa/board/write")
	public String writeBoard(BoardEntity board) throws Exception{
		jpaBoardService.saveBoard(board);
		return "redirect:/jpa/board";
	}
	
	@GetMapping(value="/jpa/board/{boardIdx}")
	public ModelAndView openBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception{
		ModelAndView mv = new ModelAndView("/board/jpaBoardDetail");
		
		BoardEntity board = jpaBoardService.selectBoardDetail(boardIdx);
		mv.addObject("board", board);
		
		return mv;
	}
	
	@PutMapping(value="/jpa/board/{boardIdx}")
	public String updateBoard(BoardEntity board) throws Exception{
		jpaBoardService.saveBoard(board);
		return "redirect:/jpa/board";
	}
	
	@DeleteMapping(value="/jpa/board/{boardIdx}")
	public String deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception{
		jpaBoardService.deleteBoard(boardIdx);
		return "redirect:/jpa/board";
	}
	
}
