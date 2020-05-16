package com.my.dao;

import java.util.List;

import com.my.entitis.Employee;

//员工mapper接口
public interface EmployeeMapper {
	
	//查询所有员工及其所在部门的信息
	public List<Employee> getAllEmp();
	public void addEmp(Employee employee);
	public Integer getEmpCount(String empName);
	public Employee getEmpById(Integer id);
	public void editEmpById(Employee employee);
	public void delEmpById(Integer id);
	public void delEmps(List<Integer> ids);
}
