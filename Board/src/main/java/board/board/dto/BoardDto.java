package board.board.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BoardDto {
	private int boardIdx;
	private String title;
	private String contents;
	private int hitCnt;
	private String creatorId;
	private LocalDateTime createDatetime;
	private String updaterId;
	private LocalDateTime updateDatetime;
	
	/**
	 * DTO란? (Data Transfer Object)
	 * 
	 * 애플리케이션 내의 각 계층 간 데이터를 주고받는 데 사용되는 객체이다. 
	 * (각 계층은 view,controller,service,DAO,Database를 의미)
	 * 
	 * lombok라이브러리를 사용하여 (@Data)
	 * getter, setter를 자동으로 생성 해 준다.
	 * 
	 * 
	 */
}
