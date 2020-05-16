package com.my.beans;
//部门
public class Dept {

	private Integer id;//部门编号
	
	private String dname;//部门名称

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Dept(Integer id, String dname) {
		this.id = id;
		this.dname = dname;
	}

	public Dept() {
	
	}
	@Override
	public String toString() {
		return "Dept [id=" + id + ", dname=" + dname + "]";
	}
	
	
}
