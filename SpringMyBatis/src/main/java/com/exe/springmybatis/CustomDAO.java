package com.exe.springmybatis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;

public class CustomDAO {
	
	//의존성 주입
	private SqlSessionTemplate sessionTemplate;
	
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}
	
	/*
		1. Spring 컨테이너가 app-context.xml 또는 Java 설정을 읽는다
		     ↓
		2. <bean id="sessionTemplate" class="org.mybatis.spring.SqlSessionTemplate" ... /> 를 보고
		     SqlSessionTemplate 객체를 생성한다
		     ↓
		3. <bean id="customDAO" class="com.exe.springmybatis.CustomDAO">
		       <property name="sessionTemplate" ref="sessionTemplate"/>
		   </bean>
		   를 보고...
		     ↓
		4. CustomDAO 객체를 생성한 후
		     setSessionTemplate(sessionTemplate 객체)를 자동으로 호출한다
		     ↓
		5. CustomDAO 내부의 sessionTemplate 필드에 MyBatis 연동용 SqlSessionTemplate가 주입됨
		     ↓
		6. 이제 CustomDAO는 sessionTemplate.insert(...) 등 MyBatis 기능을 사용할 수 있게 됨	 
			  
	 */
	//-------------------------------------------------------------------------------------
	
	public void insertData(CustomDTO dto) {
		
		sessionTemplate.insert("com.custom.insert",dto);
	}
	
	public void updateData(CustomDTO dto) {
		
		sessionTemplate.update("com.custom.update",dto);
	}
	
	public void deleteData(int id) {
		
		sessionTemplate.delete("com.custom.delete",id);
	}
	
	public List<CustomDTO> getLists(){
		
		List<CustomDTO> lists = sessionTemplate.selectList("com.custom.list");
		
		return lists;
	}
	
	public CustomDTO getReadData(int id){
		
		CustomDTO dto = sessionTemplate.selectOne("com.custom.listOne",id);
		
		return dto;
	}
	
}
