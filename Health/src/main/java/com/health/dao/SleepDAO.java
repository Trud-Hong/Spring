package com.health.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.health.dto.SleepDTO;

public class SleepDAO {
	
	private SqlSessionTemplate sessionTemplate;
	
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}

	public void insertData(SleepDTO dto) {
		
		sessionTemplate.insert("com.health.insertData");
	}
	
	// 수면패턴 가져오기
    public SleepDTO getSleep(int member_no) {
    	
    	SleepDTO sleep = sessionTemplate.selectOne("com.health.getReadData",member_no);
    	
    	return sleep;
    	
    }
    
    // 수면시간 추천해주기
    public String getRecommendation(int sleep_hours) {
        if (sleep_hours < 6) {
            return "수면시간이 너무 부족합니다. 7-8시간 수면을 권장합니다.";
        } else if (sleep_hours > 9) {
            return "수면시간이 너무 많습니다. 7-8시간 수면을 권장합니다.";
        } else {
            return "적절한 수면시간입니다! 잘 하고 계시네요.";
        }
    }

}
