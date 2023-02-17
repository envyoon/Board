package board.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import board.board.dto.BoardDto;
import board.board.service.BoardService;

@Controller
public class RestBoardController {
	
	private Logger log = org.slf4j.LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BoardService boardService;
	
	//게시판 전체 가져오는 Controller
	@RequestMapping(value="/board", method=RequestMethod.GET)
	public ModelAndView openBoardList() throws Exception{
		log.debug("openBoardList");
		
		ModelAndView mv = new ModelAndView("/board/restBoardList");
		
		List<BoardDto> list = boardService.selectBoardList();
		mv.addObject("list",list);
		
		return mv;
	}
	
	
	//게시판 작성 페이지 가져오는 부분
	@RequestMapping(value="/board/write", method=RequestMethod.GET)
	public String openBoardWrite() throws Exception{
		return "/board/restBoardWrite";
	}
	
	
	//게시판 작성 했을때 보내는 부분
	@RequestMapping(value="/board/write", method=RequestMethod.POST)
	public String insertBoard(BoardDto board) throws Exception{
		boardService.insertBoard(board);
		
		return "redirect:/board";
	}
	
	//게시판 상세 화면 가져오는 부분
	@RequestMapping(value="/board/{boardIdx}", method=RequestMethod.GET)
	public ModelAndView openBoardDetail(@PathVariable("boardIdx") int boardIdx, ModelMap model) throws Exception{
		ModelAndView mv = new ModelAndView("/board/restBoardDetail");
		
		BoardDto board = boardService.selectBoardDetail(boardIdx);
		mv.addObject("board", board);
		
		return mv;
	}
	
	//게시판 업데이트 시 호출하는 부분
	@RequestMapping(value="/board/{boardIdx}", method=RequestMethod.PUT)
	public String updateBoard(BoardDto board) throws Exception{
		boardService.updateBoard(board);
		return "redirect:/board";
	}
	
	//게시판 삭제 시 사용하는 부분
	@RequestMapping(value="/board/{boardIdx}", method=RequestMethod.DELETE)
	public String deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception{
		boardService.deleteBoard(boardIdx);
		return "redirect:/board";
	}
	
	
}
