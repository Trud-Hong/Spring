package com.exe.springdi3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageService {
	
	public void messageService() {
		
		//BeanFactory����
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext("app-context.xml");
		
		//Bean ��ü ȹ��
		Message ms = (Message) context.getBean("message");
		//Message ms = new MessageKr(); �� ����.
		
		//스프링이 XML을 보고 객체를 대신 생성해준다.
		//어떤 객체를 만들지는 app-context.xml 파일에서 결정
		
		ms.sayHello("수지");
	}
	
	
	
}
