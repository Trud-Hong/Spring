package com.health.dto;

public class HabitDTO {
	
	private int habit_id;
	private int member_no;
	private String record_date;
	private String breakfast;
	private String breakfast_time;
	private String lunch;
	private String lunch_time;
	private String dinner;
	private String dinner_time;
	
	public int getHabit_id() {
		return habit_id;
	}
	public void setHabit_id(int habit_id) {
		this.habit_id = habit_id;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public String getRecord_date() {
		return record_date;
	}
	public void setRecord_date(String record_date) {
		this.record_date = record_date;
	}
	public String getBreakfast() {
		return breakfast;
	}
	public void setBreakfast(String breakfast) {
		this.breakfast = breakfast;
	}
	public String getBreakfast_time() {
		return breakfast_time;
	}
	public void setBreakfast_time(String breakfast_time) {
		this.breakfast_time = breakfast_time;
	}
	public String getLunch() {
		return lunch;
	}
	public void setLunch(String lunch) {
		this.lunch = lunch;
	}
	public String getLunch_time() {
		return lunch_time;
	}
	public void setLunch_time(String lunch_time) {
		this.lunch_time = lunch_time;
	}
	public String getDinner() {
		return dinner;
	}
	public void setDinner(String dinner) {
		this.dinner = dinner;
	}
	public String getDinner_time() {
		return dinner_time;
	}
	public void setDinner_time(String dinner_time) {
		this.dinner_time = dinner_time;
	}
	
	

}
