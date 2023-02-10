T_BOARD_DATA

-- 샘플 데이트 쿼리
INSERT INTO STSBOOT.T_BOARD (BOARD_IDX, title, contents, CREATOR_ID, CREATED_DATETIME)
VALUES ( board_idx_seq.NEXTVAL ,'first title', 'first contents', 'admin', sysdate);