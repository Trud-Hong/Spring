package com.exe.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("test.controller")//��������� �̸��� �־� �浹�� ���ϱ�
public class TestController {
	/*
	@RequestMapping(value = "/test/param.action", 
			method = RequestMethod.GET)
	public String processRequest() {//�޼ҵ� �̸��� ū������ �����ʴ´�.
		
		System.out.println("get����� Request");
		
		return "paramResult";//paramResult.jsp�� �������̵�
	}
	
	@RequestMapping(value = "/test/param.action",
			method = RequestMethod.POST)
	public String processPosetRequest() {
		
		System.out.println("post����� Request");
		
		return "paramResult";
	}
	*/
	//���� �� �޼ҵ� ��ġ��
	@RequestMapping(value = "/test/param.action",
			method = {RequestMethod.POST,RequestMethod.GET})
	public String processPosetRequest(PersonDTO dto,String name,
			HttpServletRequest request) {
		
		System.out.println("get/post����� Request");
		
		System.out.println(name);
		System.out.println(dto.getPhone());
		System.out.println(request.getParameter("phone"));
		
		System.out.println(dto);
		System.out.println("name: " + dto.getName());
		System.out.println("phone: " + dto.getPhone());
		System.out.println("email: " + dto.getEmail());
		
		return "paramResult";
	}
	
	@RequestMapping(value = "/test/mav.action",
			method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView mavRequest(PersonDTO dto) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("dto", dto);//model ("key",value)
		mav.setViewName("paramResult");//view
		
		return mav;
		
	}
	
	@RequestMapping(value = "/test/redirect.action",
			method = {RequestMethod.GET,RequestMethod.POST})
	public String mavRedirectRequest() {
		
		return "redirect:/";
		//return "redirect:/hello.action";
		//return "hello";
	}
	
	@RequestMapping(value = "/practice/mvp.action",
			method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView mavPractice(PersonDTO dto) {
		
		ModelAndView mvp = new ModelAndView();
		
		mvp.addObject("dto",dto);
		mvp.setViewName("practice");
		
		return mvp;
	}
}
