T_BOARD

CREATE TABLE STSBOOT.T_BOARD (
	BOARD_IDX NUMBER,
	TITLE VARCHAR2(300),
	CONTENTS VARCHAR2(3000),
	HIT_CNT NUMBER DEFAULT 0,
	CREATED_DATETIME DATE,
	CREATOR_ID VARCHAR2(50),
	UPDATED_DATETIME DATE,
	UPDATER_ID VARCHAR2(50),
	DELETED_YN CHAR(1) DEFAULT 'N'
);
COMMENT ON COLUMN STSBOOT.T_BOARD.BOARD_IDX IS '글 번호';
COMMENT ON COLUMN STSBOOT.T_BOARD.TITLE IS '제목';
COMMENT ON COLUMN STSBOOT.T_BOARD.CONTENTS IS '내용';
COMMENT ON COLUMN STSBOOT.T_BOARD.HIT_CNT IS '조회수';
COMMENT ON COLUMN STSBOOT.T_BOARD.CREATED_DATETIME IS '작성시간';
COMMENT ON COLUMN STSBOOT.T_BOARD.CREATOR_ID IS '작성자';
COMMENT ON COLUMN STSBOOT.T_BOARD.UPDATED_DATETIME IS '수정시간';
COMMENT ON COLUMN STSBOOT.T_BOARD.UPDATER_ID IS '수정자';
COMMENT ON COLUMN STSBOOT.T_BOARD.DELETED_YN IS '삭제 여부';



-- 시퀀스 제작 쿼리
CREATE SEQUENCE stsboot.board_idx_seq
	INCREMENT BY 1
	START WITH 1
	MINVALUE 1
	MAXVALUE 999999;

