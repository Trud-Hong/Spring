package com.exe.springdi4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ServiceConsumer {
	
	//의존성 주입(Dependency Injection)
	MessageService ms;//= new MyMessageService();
	TimeService ts;
	JobService js;
	
	//생성자 주입
	public ServiceConsumer(MessageService ms) {
		this.ms = ms;
	}
	
	//setter 주입
	public void setTimeService(TimeService ts) {
		this.ts = ts;
	}
	
	public void setJobService(JobService js) {
		this.js = js;
	}
//-----------------------------------------------------------------
	public void consumerService() {
		
		//GenericXmlApplicationContext context =
		//		new GenericXmlApplicationContext("app-context.xml");
		// main에서 이미 context를 통해 주입받았으므로 여기서 new로 다시 만들지 않음
		
		//MessageService ms = 
		//		(MessageService)context.getBean("messageService");
		//���� ������ �Լ��� ���� this
		
		//메세지 출력
		String message = ms.getMessage();
		System.out.println(message);
		
		//시간 출력
		String time = ts.getTimeString();
		System.out.println(time);
		
		js.getJob();
	}
}
