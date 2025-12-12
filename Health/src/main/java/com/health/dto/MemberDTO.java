package com.health.dto;

public class MemberDTO {
	
	private int member_no;
	private String member_id;
	private String password;
	private String name;
	private String birth;
	private String gender;
	private int height;
	private int weight;
	//bmi 자료형 double로 수정
	private double bmi;
	private String goal;
	private String join_date;
	
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	//bmi 반환값 double로 수정
	public double getBmi() {
		return bmi;
	}
	//bmi 인수 double로 수정
	public void setBmi(double bmi) {
		this.bmi = bmi;
	}
	//여기까지
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	public String getJoin_date() {
		return join_date;
	}
	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}
	
	
	

}
