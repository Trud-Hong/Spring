package com.exe.springdi4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ServiceConsumer {
	
	//어노테이션 의존성 주입(DI)
	
	@Autowired
	@Qualifier("messageService")
	MessageService ms;//= new MyMessageService();
	
	@Autowired
	TimeService ts;
	
	@Autowired
	JobService js;
	
//-----------------------------------------------------------------
	public void consumerService() {
		
		//생성자 의존성 주입
		String message = ms.getMessage();
		System.out.println(message);
		
		//메소드 의존성 주입
		String time = ts.getTimeString();
		System.out.println(time);
		
		js.getJob();
	}
}
