T_FILE

-- 파일 입출력
CREATE TABLE T_FILE(
	idx number(10) check (idx > 0) NOT NULL,
	board_idx number(10) check (board_idx > 0) NOT NULL,
	original_file_name varchar2(255) NOT NULL,
	stored_file_path varchar2(500) NOT NULL,
	file_size number(10) check (file_size > 0) NOT NULL,
	creator_id varchar2(50) NOT NULL,
	created_datetime timestamp(0) NOT NULL,
	updator_id varchar2(50) DEFAULT NULL,
	updated_datetime timestamp(0) DEFAULT NULL,
	deleted_yn char(1) DEFAULT 'N' NOT NULL,
	PRIMARY KEY (idx));

-- 파일 입출력 시퀀스 
CREATE SEQUENCE file_idx_seq 
START WITH 1 
INCREMENT BY 1;

COMMENT ON COLUMN T_FILE.idx IS '일련번호';
COMMENT ON COLUMN T_FILE.board_idx IS '게시글 번호';
COMMENT ON COLUMN T_FILE.original_file_name IS '원본 파일 이름';
COMMENT ON COLUMN T_FILE.stored_file_path IS '파일 저장 경로';
COMMENT ON COLUMN T_FILE.file_size IS '파일 크기';
COMMENT ON COLUMN T_FILE.creator_id IS '작성자 아이디';
COMMENT ON COLUMN T_FILE.created_datetime IS '작성시간';
COMMENT ON COLUMN T_FILE.updator_id IS '수정자 아이디';
COMMENT ON COLUMN T_FILE.updated_datetime IS '수정시간';
COMMENT ON COLUMN T_FILE.deleted_yn IS '삭제 여부';