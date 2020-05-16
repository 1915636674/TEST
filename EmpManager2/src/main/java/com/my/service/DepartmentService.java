package com.my.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.dao.DepartmentMapper;
import com.my.entitis.Department;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentMapper departmentMapper;
	public List<Department> getAllDept(){
		return departmentMapper.getAllDept();
	}
}
