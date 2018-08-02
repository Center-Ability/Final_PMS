package com.bap.domain;

import java.util.Date;

public class UnitVO {
		
	private int unit_no;
	private String unit_title;
	private String mem_id;
	private Date unit_start;
	private Date unit_end;
	private String  unit_content;
	private int unit_status;
	private int pro_num;
	private int unit_per;
	
	public int getUnit_no() {
		return unit_no;
	}
	public void setUnit_no(int unit_no) {
		this.unit_no = unit_no;
	}
	public String getUnit_title() {
		return unit_title;
	}
	public void setUnit_title(String unit_title) {
		this.unit_title = unit_title;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public Date getUnit_start() {
		return unit_start;
	}
	public void setUnit_start(Date unit_start) {
		this.unit_start = unit_start;
	}
	public Date getUnit_end() {
		return unit_end;
	}
	public void setUnit_end(Date unit_end) {
		this.unit_end = unit_end;
	}
	public String getUnit_content() {
		return unit_content;
	}
	public void setUnit_content(String unit_content) {
		this.unit_content = unit_content;
	}
	public int getUnit_status() {
		return unit_status;
	}
	public void setUnit_status(int unit_status) {
		this.unit_status = unit_status;
	}
	public int getPro_num() {
		return pro_num;
	}
	public void setPro_num(int pro_num) {
		this.pro_num = pro_num;
	}
	public int getUnit_per() {
		return unit_per;
	}
	public void setUnit_per(int unit_per) {
		this.unit_per = unit_per;
	}
	
	@Override
	public String toString() {
		return "UnitVO [unit_no=" + unit_no + ", unit_title=" + unit_title + ", mem_id=" + mem_id + ", unit_start="
				+ unit_start + ", unit_end=" + unit_end + ", unit_content=" + unit_content + ", unit_status="
				+ unit_status + ", pro_num=" + pro_num + ", unit_per=" + unit_per + "]";
	}
	
}
