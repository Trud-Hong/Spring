package com.boot.board;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class HelloLombok {
	
	private final String name;
	private final int age;
	
	/*
	public static void main(String[] arg) {
		
		//HelloLombok hk = new HelloLombok();
		
		//hk.setName("고윤정");
		//hk.setAge(27);
		
		//오버로딩 생성자를 사용하면 setter를 사용할 수없다.
		//기본 생성자 객체 생성사용 불가능
		HelloLombok hk = new HelloLombok("배수지",30);
		
		System.out.println(hk.getName());
		System.out.println(hk.getAge());
		
		
	}
	*/
}
