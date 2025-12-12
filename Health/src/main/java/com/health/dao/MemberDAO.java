package com.health.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;

import com.health.dto.MemberDTO;

public class MemberDAO {
	
	//의존성 주입
	private SqlSessionTemplate sessionTemplate;
	
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}

	public void insertData(MemberDTO dto) {
		
		//bmi 계산식 추가
		double bmi = dto.getWeight() / (dto.getHeight() * dto.getHeight()) * 10000;
		
		dto.setBmi(bmi);
		//여기까지
		
		sessionTemplate.insert("com.health.member.insertData",dto);
	}

	public MemberDTO getReadData(String member_id) {

		MemberDTO dto = sessionTemplate.selectOne("com.health.member.getReadData",member_id);
		
		return dto;
	}
	
	//updated/수정
	public void updateData(MemberDTO dto) {
		
		sessionTemplate.update("com.health.member.updateData", dto);
	}
	
	//삭제
	public void deleteData(int num) {
		
		sessionTemplate.delete("com.health.member.deleteData",num);
		
	}

	

}
