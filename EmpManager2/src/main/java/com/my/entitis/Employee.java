package com.my.entitis;

public class Employee {

	private Integer empId;
	
	private String empName;
	
	private String email;
	
	private String  gender;
	
	private String  dId;
	
	private Department department;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getdId() {
		return dId;
	}

	public void setdId(String dId) {
		this.dId = dId;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", email="
				+ email + ", gender=" + gender + ", dId=" + dId
				+ ", department=" + department + "]";
	}

	public Employee(Integer empId, String empName, String email,
			String gender, String dId, Department department) {
		this.empId = empId;
		this.empName = empName;
		this.email = email;
		this.gender = gender;
		this.dId = dId;
		this.department = department;
	}

	public Employee() {
	}
	
}
