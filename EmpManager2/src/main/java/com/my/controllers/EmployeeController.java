package com.my.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.entitis.Employee;
import com.my.service.EmployeeService;

@Controller
public class EmployeeController {
	//将EmployeeService注入给EmployeeController作为成员
	@Autowired
	private EmployeeService employeeService;
	
	//查询所有员工的请求处理方法，处理的请求是项目/emps
	@RequestMapping("/emps")
	public String emps(@RequestParam(defaultValue="1") Integer pn,Model model){
		PageHelper.startPage(pn,10);
		List<Employee> emps = employeeService.getAllEmp();
		PageInfo pageInfo = new PageInfo(emps,10);
		model.addAttribute("pageInfo", pageInfo);
		return "list";
	}
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	public String addEmp(Employee employee){
		employeeService.addEmp(employee);
		return "redirect:/emps?pn=99999";
	}
	@ResponseBody
	@RequestMapping(value="/hasEmp",method=RequestMethod.POST)
	public String hasEmp(@RequestParam String empName){
		boolean yn = employeeService.hasEmp(empName);
		if(yn){
			return "1";
		}
		return "0";
	}
	@ResponseBody
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	public Employee toEdit(@PathVariable Integer id){
		return employeeService.getEmpById(id);
	}
	@ResponseBody
	@RequestMapping(value="/emp/{empId}",method=RequestMethod.PUT)
	public String edit(Employee employee){
		employeeService.editEmpById(employee);
		return "success";
	}
	@ResponseBody
	@RequestMapping(value="/emp/{ids}",method=RequestMethod.DELETE)
	public String delete(@PathVariable String ids){
		if(!ids.contains("-")){
			int id = Integer.parseInt(ids);
			employeeService.delEmpById(id);
		}
		else{
			String[] idArray = ids.split("-");
			List<Integer> idList = new ArrayList<>();
			for (String idStr : idArray) {
				int id = Integer.parseInt(idStr);
				idList.add(id);
			}
			employeeService.delEmps(idList);
		}
		return "success";
	}
}
