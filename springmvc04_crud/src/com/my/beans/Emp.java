package com.my.beans;
//员工
public class Emp {

	private Integer id;//工号
	
	private String ename;//姓名
	
	private String gender;//性别
	
	private Integer age;//年龄
	
	private String email;//邮箱
	
	private Dept dept;//员工所在部门

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
