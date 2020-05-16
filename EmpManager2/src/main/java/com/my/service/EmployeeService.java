package com.my.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.dao.EmployeeMapper;
import com.my.entitis.Employee;

@Service
public class EmployeeService {
//将employeeMapper注入给EmployeeService作为成员
	@Autowired
	private EmployeeMapper employeeMapper;
	//查询所有员工及员工所在部门的业务方法
	public List<Employee> getAllEmp(){
		return employeeMapper.getAllEmp();
	}
	public void addEmp(Employee employee){
		employeeMapper.addEmp(employee);
	}
	public boolean hasEmp(String empName){
		Integer count = employeeMapper.getEmpCount(empName);
		return count == 0;
	}
	public Employee getEmpById(Integer id){
		return employeeMapper.getEmpById(id);
	}
	public void editEmpById(Employee employee){
		employeeMapper.editEmpById(employee);
	}
	public void delEmpById(Integer id){
		employeeMapper.delEmpById(id);
	}
	public void delEmps(List<Integer> ids){
		employeeMapper.delEmps(ids);
	}
}
