package com.my.beans;
//Ա��
public class Emp {

	private Integer id;//����
	
	private String ename;//����
	
	private String gender;//�Ա�
	
	private Integer age;//����
	
	private String email;//����
	
	private Dept dept;//Ա�����ڲ���

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public Emp(Integer id, String ename, String gender, Integer age,
			String email, Dept dept) {
		this.id = id;
		this.ename = ename;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.dept = dept;
	}

	public Emp() {
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", ename=" + ename + ", gender=" + gender
				+ ", age=" + age + ", email=" + email + ", dept=" + dept + "]";
	}
	
	
}
