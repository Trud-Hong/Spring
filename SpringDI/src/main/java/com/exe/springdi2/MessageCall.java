package com.exe.springdi2;

public class MessageCall {

	public static void main(String[] args) {
		
		System.out.println("1.첫번째 메세지");
		
		MessageEn ob1 = new MessageEn();
		ob1.sayHello("suzi");
		
		MessageKr ob2 = new MessageKr();
		ob2.sayHello("수지");
		
		System.out.println("------------------------------------");
		
		System.out.println("2.두번째 메세지");
		
		Message ms = null;
		
		ms = new MessageEn();//스프링 DI를 사용하면 new MessageEn 생성부분을 스프링에 맡김
								//En or Kr설정만바꿔 변경 가능
		ms.sayHello("inna");
		
		ms = new MessageKr();
		ms.sayHello("인나");
		
		
	}

}
