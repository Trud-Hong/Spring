package com.health.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.health.dao.MemberDAO;
import com.health.dto.CustomInfo;
import com.health.dto.MemberDTO;
import com.health.util.MyUtil;

@Controller
public class HomeController {
	
	@Autowired
	@Qualifier("MemberDAO")
	MemberDAO member_dao;
	
	@Autowired
	MyUtil myUtil;
	
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main() {
	
		
		return "/health/main";
	}
	
	@RequestMapping(value = "/diet", method = RequestMethod.GET)
	public String diet() {
	
		
		return "/health/diet";
	}
	
	@RequestMapping(value = "/habit", method = RequestMethod.GET)
	public String habit() {
	
		
		return "/health/habit";
	}
	
	@RequestMapping(value = "/exercise", method = RequestMethod.GET)
	public String exercise() {
	
		
		return "/health/exercise";
	}
	
	@RequestMapping(value = "/blood", method = RequestMethod.GET)
	public String blood() {
	
		
		return "/health/blood";
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile() {
	
		
		return "/health/profile";
	}
	
	@RequestMapping(value = "/goal", method = RequestMethod.GET)
	public String goal() {
	
		
		return "/health/goal";
	}
	
	@RequestMapping(value = "/sleep", method = RequestMethod.GET)
	public String sleep() {
	
		
		return "/health/sleep";
	}
	
	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public String review() {
	
		
		return "/health/review";
	}
	
	@RequestMapping(value = "/commu", method = RequestMethod.GET)
	public String commu() {
	
		
		return "/health/commu";
	}

	@RequestMapping(value = "/myPage", method = RequestMethod.GET)
	public String myPage() {
		
		
		return "/health/myPage";
	}
	
	@RequestMapping(value = "/myPageEdit", method = RequestMethod.GET)
	public String myPageEdit() {
		
		
		return "/health/myPageEdit";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
	
		
		return "/health/login";
	}
	
	@RequestMapping(value = "/login_ok.do", method = {RequestMethod.POST})
	public String login_ok(HttpServletRequest req) {
		
		String member_id = req.getParameter("member_id");
		String password = req.getParameter("password");
		
		MemberDTO dto = member_dao.getReadData(member_id);
		
		if(dto==null || (!dto.getPassword().equals(password))) {
			
			req.setAttribute("message", "아이디 또는 패스워드를 정확히 입력하세요");
			
			return "health/login";
		}
		
		HttpSession session = req.getSession();
		
		CustomInfo info = new CustomInfo();
		
		info.setMember_id(dto.getMember_id());
		info.setName(dto.getName());
		
		session.setAttribute("customInfo", info);
		
		return "health/main";
	}
	
	@RequestMapping(value = "/logout.do", method = {RequestMethod.GET})
	public String logout(HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		session.removeAttribute("customInfo");
		session.invalidate();
		
		return "health/main";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
	
		
		return "/health/join";
	}
	
	@RequestMapping(value = "/join_ok.do", method = {RequestMethod.POST})
	public String join_ok(MemberDTO dto,HttpServletRequest req) {
		
		member_dao.insertData(dto);
		
		return "/health/login";
	}
	

	
}
