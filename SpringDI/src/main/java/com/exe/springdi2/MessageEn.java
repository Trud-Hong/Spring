package com.exe.springdi2;

public class MessageEn implements Message{

	public void sayHello(String name) {
		System.out.println("Hello, " + name);
	}
	
}
//implements : 인터페이스에 적힌 규칙을 실제로 구현하는 클래스