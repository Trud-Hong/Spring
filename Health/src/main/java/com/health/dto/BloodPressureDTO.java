package com.health.dto;

public class BloodPressureDTO {
	
	private int bp_id;
	private int member_no;
	private String record_date;
	private String bp_level;
	private int bp_high;
	private int bp_low;
	
	

	public int getBp_high() {
		return bp_high;
	}
	public void setBp_high(int bp_high) {
		this.bp_high = bp_high;
	}
	public int getBp_low() {
		return bp_low;
	}
	public void setBp_low(int bp_low) {
		this.bp_low = bp_low;
	}
	public int getBp_id() {
		return bp_id;
	}
	public void setBp_id(int bp_id) {
		this.bp_id = bp_id;
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
	public String getBp_level() {
		return bp_level;
	}
	public void setBp_level(String bp_level) {
		this.bp_level = bp_level;
	}
	
	

}
