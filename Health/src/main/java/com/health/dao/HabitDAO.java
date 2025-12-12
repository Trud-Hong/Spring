package com.health.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.health.dto.AdminDTO;
import com.health.dto.ExerciseDTO;
import com.health.dto.HabitDTO;

public class HabitDAO {

	//의존성 주입
	private SqlSessionTemplate sessionTemplate;
	
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}
	
	//삽입
	public void insertData(HabitDTO dto) {
		
		sessionTemplate.insert("com.health.habit.insertData",dto);
		
	}
	
	//num으로 조회한 한 개의 데이터
	public AdminDTO getReadData(int habit_id) {
		
		AdminDTO dto = sessionTemplate.selectOne("com.health.habit.getReadData", habit_id);
		
		return dto;
	}
	
	
	//수정
	public void updateData(HabitDTO dto) {
		
		sessionTemplate.update("com.health.habit.updateData",dto);
		
	}
	
	
	//삭제
	public void deleteData(int habit_id) {
		
		sessionTemplate.delete("com.health.habit.deleteData",habit_id);
		
	}
	
}
