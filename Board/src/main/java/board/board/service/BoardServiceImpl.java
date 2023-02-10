package board.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.board.dto.BoardDto;
import board.board.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper boardMapper;
	
	//게시판 전체 가져오기
	@Override
	public List<BoardDto> selectBoardList() throws Exception{
		return boardMapper.selectBoardList();
	}
	
	//게시글 제작하는 것
	@Override
	public void insertBoard(BoardDto board) throws Exception{
		boardMapper.insertBoard(board);
	}
	
	//게시판 상세 페이지 가져오기
	@Override
	public BoardDto selectBoardDetail(int boardIdx) throws Exception{
		// 조회수 증가시키는 부분
		boardMapper.updateHitCount(boardIdx);
		
		//게시판 상세 페이지 가져오는 부분
		BoardDto board = boardMapper.selectBoardDetail(boardIdx);
		
		return board;
	}
	
	//게시판 업데이트
	@Override
	public void updateBoard(BoardDto board) throws Exception {
		boardMapper.updateBoard(board);
	}

	//게시판 삭제
	@Override
	public void deleteBoard(int boardIdx) throws Exception {
		boardMapper.deleteBoard(boardIdx);
	}
}
