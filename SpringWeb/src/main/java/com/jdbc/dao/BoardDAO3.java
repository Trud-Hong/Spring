package com.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.jdbc.dto.BoardDTO1;

public class BoardDAO3 {
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int getMaxNum() {
		
		int maxNum = 0;
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("select nvl(max(num),0) from board");
		
		maxNum = jdbcTemplate.queryForInt(sql.toString());
		
		return maxNum;
	}
	
	public void insertData(BoardDTO1 dto) {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("insert into board (num,name,pwd,email,subject,content,ipAddr,hitCount,created) ");
		sql.append("values (?,?,?,?,?,?,?,0,sysdate)");
		
		jdbcTemplate.update(sql.toString(),
				dto.getNum(),dto.getName(),dto.getPwd(),dto.getEmil(),
				dto.getSubject(),dto.getContent(),dto.getIpAddr());
	}
	
	public int getDataCount(String searchKey, String searchValue) {
		
		int totalCount = 0;
		
		StringBuilder sql = new StringBuilder();
		
		searchValue = "%" + searchValue + "%";
		
		sql.append("select nvl(count(*),0 from board ")
		.append("where " + searchKey + " like ?");
		
		totalCount = jdbcTemplate.queryForInt(sql.toString(),searchValue);
		
		return totalCount;
	}

}
