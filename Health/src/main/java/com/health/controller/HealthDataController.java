package com.health.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.health.service.HealthDataService;

@Controller
@RequestMapping("/api")
public class HealthDataController {
	//Å×½ºÆ®
    @Autowired
    private HealthDataService service;

    @RequestMapping(value = "/daydata", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map<String, Object> getDayData(
        @RequestParam int year,
        @RequestParam int month,
        @RequestParam int day,
        @RequestParam int memberNo
    ) {
        Map<String, Object> data = service.getDayData(year, month, day, memberNo);
        
        if (data == null) {
            Map<String, Object> emptyData = new HashMap<String, Object>();
            emptyData.put("bp", "");
            emptyData.put("sleep", "");
            emptyData.put("exercise", "");
            emptyData.put("diet", "");
            emptyData.put("condition", "");
            return emptyData;
        }
        return data;
    }
}
