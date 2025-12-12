package com.exe.springmvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/")
	public String home() {
		//반환 타입이 String인 이유 return에 "home"을 사용하여 view폴더에 home.jsp파일을 찾기 위함이다
		return "home";
	}
	
	@RequestMapping(value = "/hello.action")
	public String getHello() {//주소에 hello.action이 오면 메소드 실행
		
		return "hello";//WEB-INF/views/hello.jsp를 열어라
	}
	
}




