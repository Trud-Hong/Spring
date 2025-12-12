package com.health.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.mapper.HealthDataMapper;

@Service
public class HealthDataService {

    @Autowired
    private HealthDataMapper mapper;  // final Á¦°Å

    public Map<String, Object> getDayData(int year, int month, int day, int memberNo) {
        return mapper.getDayData(year, month, day, memberNo);
    }
}

