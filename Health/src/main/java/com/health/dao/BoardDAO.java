package com.health.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.health.dto.AdminDTO;
import com.health.dto.BoardDTO;

public class BoardDAO {
	
	//의존성 주입
	private SqlSessionTemplate sessionTemplate;
	
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}
	
	//삽입
	public void insertData(BoardDTO dto) {
		
		sessionTemplate.insert("com.health.board.insertData",dto);
		
	}
	
	//num으로 조회한 한 개의 데이터
	public AdminDTO getReadData(int board_id) {
		
		AdminDTO dto = sessionTemplate.selectOne("com.health.board.getReadData", board_id);
		
		return dto;
	}
	
	
	//수정
	public void updateData(BoardDTO dto) {
		
		sessionTemplate.update("com.health.board.updateData",dto);
		
	}
	
	
	//삭제
	public void deleteData(int board_id) {
		
		sessionTemplate.delete("com.health.board.deleteData",board_id);
		
	}
	
}
