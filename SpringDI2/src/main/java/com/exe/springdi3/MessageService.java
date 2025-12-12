package com.exe.springdi3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageService {
	
	public void messageService() {
		
		//BeanFactory»ý¼º
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext("app-context.xml");
		
		//Bean °´Ã¼ È¹µæ
		Message ms = (Message) context.getBean("message");
		//Message ms = new MessageKr(); °ú °°´Ù.
		
		ms.sayHello("¹è¼öÁö");
	}
	
	
	
}
