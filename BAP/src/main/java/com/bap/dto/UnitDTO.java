package com.bap.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class UnitDTO {

	private String unit_no;
	private String unit_title;
	private Date unit_start;
	private Date unit_end;
	private String unit_content;
	private String unit_status;
	private String mem_id;
	private String pro_num;
	private String pro_name;
	private String mem_name;
	
	
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getUnit_no() {
		return unit_no;
	}
	public void setUnit_no(String unit_no) {
		this.unit_no = unit_no;
	}
	public String getUnit_title() {
		return unit_title;
	}
	public void setUnit_title(String unit_title) {
		this.unit_title = unit_title;
	}
	public Date getUnit_start() {
		return unit_start;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public void setUnit_start(Date unit_start) {
		this.unit_start = unit_start;
	}
	public Date getUnit_end() {
		return unit_end;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public void setUnit_end(Date unit_end) {
		this.unit_end = unit_end;
	}
	public String getUnit_content() {
		return unit_content;
	}
	public void setUnit_content(String unit_content) {
		this.unit_content = unit_content;
	}
	public String getUnit_status() {
		return unit_status;
	}
	public void setUnit_status(String unit_status) {
		this.unit_status = unit_status;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getPro_num() {
		return pro_num;
	}
	public void setPro_num(String pro_num) {
		this.pro_num = pro_num;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	@Override
	public String toString() {
		return "UnitDTO [unit_no=" + unit_no + ", unit_title=" + unit_title + ", unit_start=" + unit_start
				+ ", unit_end=" + unit_end + ", unit_content=" + unit_content + ", unit_status=" + unit_status
				+ ", mem_id=" + mem_id + ", pro_num=" + pro_num + ", pro_name=" + pro_name + ", mem_name=" + mem_name
				+ "]";
	}
	
	
	
}
