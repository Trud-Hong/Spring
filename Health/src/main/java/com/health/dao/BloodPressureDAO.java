package com.health.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.health.dto.BloodPressureDTO;

public class BloodPressureDAO {
	
	private SqlSessionTemplate sessionTemplate;
	
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}
	
	//혈압 입력
	public void insertData(BloodPressureDTO dto) {
		
		sessionTemplate.insert("com.health.bloodPressure.insertData",dto);
	}
	
	//수정할 데이터 가져오기
	public BloodPressureDTO getReadData(int member_no) {
		
		BloodPressureDTO dto = sessionTemplate.selectOne("com.health.bloodPressure.getReadData",member_no);
		
		return dto;
	}
	
	//수정
	public void updateData(BloodPressureDTO dto) {
		
		sessionTemplate.update("com.health.bloodPressure.updateData", dto);
	}
	
	//삭제
	public void deleteData(int member_no) {
		
		sessionTemplate.delete("com.health.bloodPressure.deleteData", member_no);
		
	}

}
