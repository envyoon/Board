package board.board.dto;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="BoardDto : 게시글 내용", description="게시글 내용")
@Data
public class BoardDto {
	@ApiModelProperty(value="게시글 번호")
	private int boardIdx;
	
	@ApiModelProperty(value="게시글 제목")
	private String title;
	
	@ApiModelProperty(value="게시글 내용")
	private String contents;
	
	@ApiModelProperty(value="조회수")
	private int hitCnt;
	
	@ApiModelProperty(value="작성자 아이디")
	private String creatorId;
	
	@ApiModelProperty(value="작성시간")
	private LocalDateTime createdDatetime;
	
	@ApiModelProperty(value="수정자 아이디")
	private String updaterId;
	
	@ApiModelProperty(value="수정시간")
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
