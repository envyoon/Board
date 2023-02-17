package board.board.service;

import java.util.List;



import board.board.dto.BoardDto;

public interface BoardService {
	
	//게시판 전체 가져오기
	List<BoardDto> selectBoardList() throws Exception;
	
	//게시글 등록
	void insertBoard(BoardDto board) throws Exception;
	
	//게시판 상세 페이지 가져오기
	BoardDto selectBoardDetail(int boardIdx) throws Exception;
	
	//게시판 업데이트 하는 부분
	void updateBoard(BoardDto board) throws Exception;

	//게시판 삭제하는 부분
	void deleteBoard(int boardIdx) throws Exception;
}
