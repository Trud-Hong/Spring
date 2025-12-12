package com.boot.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@RequestMapping("/board")
	@ResponseBody
	//spring boot는 return값을 json형식을 받아야하기때문에 text로 반환해야해서
	//@ResponseBody를 사용한다 
	//따라서 @Controller와 @ResponseBody가 합쳐진 RestController 어노 테이션을 사용한다.
	public String hello() {
		return "안녕하세요 환영합니다";
	}
	
	@RequestMapping("/")
	public String home() {
		return "redirect:/question/list";
	}
}
