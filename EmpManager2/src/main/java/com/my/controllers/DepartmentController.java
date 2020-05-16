package com.my.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.entitis.Department;
import com.my.service.DepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	@ResponseBody
	@RequestMapping("/depts")
	public List<Department> depts(){
		return departmentService.getAllDept();
	}
}
