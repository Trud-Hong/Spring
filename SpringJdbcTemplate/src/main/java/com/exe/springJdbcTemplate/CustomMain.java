package com.exe.springJdbcTemplate;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CustomMain {

	public static void main(String[] args) {
		
		//객체 생성
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext("app-context.xml");
		
		//app-context.xml에 있는 객체를 가져오는 것
		//CustomDAO dao = (CustomDAO)context.getBean("customDAO");
		
		CustomDAO2 dao = (CustomDAO2)context.getBean("customDAO2");
		
		CustomDTO dto;
		
		//insert
		dto = new CustomDTO();
		dto.setId(333);
		dto.setName("전소민");
		dto.setAge(31);
		
		dao.insertData(dto);
		
		System.out.println("insert 완료!");
		
		/*
		//select
		List<CustomDTO> lists = dao.getLists();
		
		for(CustomDTO vo : lists) {
			System.out.printf("%d %s %d\n",vo.getId(),vo.getName(),vo.getAge());
		}
		
		System.out.println("select 완료!");
		
		
		//oneSelect
		dto = dao.getReadData(222);
		
		if(dto!=null) {
			System.out.printf("%d %s %d\n",dto.getId(),dto.getName(),dto.getAge());
		}
		System.out.println("oneSelect 완료!");
		
		//update
		dto = new CustomDTO();
		dto.setId(111);
		dto.setName("서예징");
		dto.setAge(35);
		
		dao.updateData(dto);
		
		System.out.println("update 완료!");
		
		//delete
		dao.deleteData(333);
		
		System.out.println("delete 완료!");
		*/
	}
	
}
