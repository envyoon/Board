package board.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import board.board.dto.BoardDto;

@Mapper
public interface BoardMapper {
	
	//게시판 전체 가져오기
	List<BoardDto> selectBoardList() throws Exception;
	
	//게시글 등록
	void insertBoard(BoardDto board) throws Exception;
	
	//게시글 조회수 증가
	void updateHitCount(int boardIdx) throws Exception;
	
	//상세 게시글 가져오기
	BoardDto selectBoardDetail(int boardIdx) throws Exception;
	
	//게시글 수정
	void updateBoard(BoardDto board) throws Exception;
	
	//게시글 삭제
	void deleteBoard(int boardIdx) throws Exception;
	
	
}
