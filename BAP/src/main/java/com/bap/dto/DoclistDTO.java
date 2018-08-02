package com.bap.dto;

import java.util.Date;

public class DoclistDTO {
	
	private Integer doc_no;
	private String doc_title;
	private String mem_id;
	private String mem_name;
	private String mem_rank;
	private Date doc_date;
	private Integer pro_num;
	private String pro_name;
	
	public Integer getDoc_no() {
		return doc_no;
	}
	public void setDoc_no(Integer doc_no) {
		this.doc_no = doc_no;
	}
	public String getDoc_title() {
		return doc_title;
	}
	public void setDoc_title(String doc_title) {
		this.doc_title = doc_title;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_rank() {
		return mem_rank;
	}
	public void setMem_rank(String mem_rank) {
		this.mem_rank = mem_rank;
	}
	public Date getDoc_date() {
		return doc_date;
	}
	public void setDoc_date(Date doc_date) {
		this.doc_date = doc_date;
	}
	public Integer getPro_num() {
		return pro_num;
	}
	public void setPro_num(Integer pro_num) {
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
		return "DoclistDTO [doc_no=" + doc_no + ", doc_title=" + doc_title + ", mem_id=" + mem_id + ", mem_name="
				+ mem_name + ", mem_rank=" + mem_rank + ", doc_date=" + doc_date + ", pro_num=" + pro_num
				+ ", pro_name=" + pro_name + "]";
	}
	
	
	
	

}
