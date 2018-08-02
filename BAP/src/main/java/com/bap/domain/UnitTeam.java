package com.bap.domain;

public class UnitTeam {

	private String pro_num;
	private String mem_id;
	private String mem_name;
	private String pro_name;
	
	public String getPro_num() {
		return pro_num;
	}
	public void setPro_num(String pro_num) {
		this.pro_num = pro_num;
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
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	
	@Override
	public String toString() {
		return "UnitTeamList [pro_num=" + pro_num + ", mem_id=" + mem_id + ", mem_name=" + mem_name + ", pro_name="
				+ pro_name + "]";
	}
	
	
}
