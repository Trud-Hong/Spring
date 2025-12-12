package com.health.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.health.dto.AdminDTO;
import com.health.dto.ExerciseDTO;

public class ExerciseDAO {
	
	//의존성 주입
	private SqlSessionTemplate sessionTemplate;
	
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}
	
	//삽입
	public void insertData(ExerciseDTO dto) {
		
		sessionTemplate.insert("com.health.exercise.insertData",dto);
		
	}
	
	//num으로 조회한 한 개의 데이터
	public AdminDTO getReadData(int ex_id) {
		
		AdminDTO dto = sessionTemplate.selectOne("com.health.exercise.getReadData", ex_id);
		
		return dto;
	}
	
	
	//수정
	public void updateData(ExerciseDTO dto) {
		
		sessionTemplate.update("com.health.exercise.updateData",dto);
		
	}
	
	
	//삭제
	public void deleteData(int ex_id) {
		
		sessionTemplate.delete("com.health.exercise.deleteData",ex_id);
		
	}
	
}
