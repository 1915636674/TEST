package com.my.beans;
//����
public class Dept {

	private Integer id;//���ű��
	
	private String dname;//��������

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
