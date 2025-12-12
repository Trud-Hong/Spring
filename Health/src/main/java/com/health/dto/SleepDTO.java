package com.health.dto;

public class SleepDTO {

	private int sleep_id;
	private int member_no;
	private String record_date;
	private int sleep_hours;
	private String bedtime;
	
	public int getSleep_id() {
		return sleep_id;
	}
	public void setSleep_id(int sleep_id) {
		this.sleep_id = sleep_id;
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
	public int getSleep_hours() {
		return sleep_hours;
	}
	public void setSleep_hours(int sleep_hours) {
		this.sleep_hours = sleep_hours;
	}
	public String getBedtime() {
		return bedtime;
	}
	public void setBedtime(String bedtime) {
		this.bedtime = bedtime;
	}
	
	

}
