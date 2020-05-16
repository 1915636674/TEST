package com.my.handlers;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.my.beans.Dept;
import com.my.beans.Emp;
import com.my.dao.DeptDao;
import com.my.dao.EmpDao;

@Controller
public class EmpHandler {

	@Autowired
	private EmpDao empDao;
	@Autowired
	private DeptDao deptDao;
	/*
	 * 请求处理方法
	 */
	//查询所有员工
	@RequestMapping(value="/emps",method=RequestMethod.GET)
	public String all(Model model){
		
		Collection<Emp> emps = empDao.getAllEmp();
		model.addAttribute("emps", emps);
		
		return "list"; 
	}
	//到达添加员工页面的方法
	@RequestMapping(value="/emp",method=RequestMethod.GET)
	public String toAdd(Model model){
		//给性别单选按钮组装数据源
		Map<String,String> genderMap = new LinkedHashMap<String, String>();
		genderMap.put("male","男");
		genderMap.put("female","女");
		model.addAttribute("genderMap", genderMap);
		
		//给部门下拉框组装数据源 
		Collection<Dept> depts = deptDao.getAllDept();
		model.addAttribute("depts", depts);
		
		//给表单提供绑定的Javabean,蒙圈了
		Emp emp = new Emp();
		model.addAttribute("emp", emp);
		return "input";
	}
	//添加员工
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	public String add(Emp emp){
		empDao.addOrEdit(emp);
		//重定向全查
		return "redirect:/emps";
	} 
	//删除员工
	@RequestMapping(value="/emp/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable Integer id){
		empDao.delEmpById(id);
		
		//重定向请求全查
		return "redirect:/emps";
	}
	//到达被编辑页面
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	public String toEdit(@PathVariable Integer id,Model model){
		//根据工号查询被编辑员工的原始信息
		Emp emp = empDao.getEmpById(id);
		model.addAttribute("emp",emp);
		//给性别单选按钮组装数据
		Map<String,String> genderMap = new LinkedHashMap<>();
		genderMap.put("male","男");
		genderMap.put("female","女");
		model.addAttribute("genderMap", genderMap);
		
		//给部门下拉框组装数据
		Collection<Dept> depts = deptDao.getAllDept();
		model.addAttribute("depts",depts);
		
		return "input";
	}
	/*
	 * 是在edit()方法之前执行的方法:
	 * 1>@ModelAttribute表示preEdit()方法会在所以有的请求处理方法执行之前被执行
	 * 2>就先根据请求参数id查询出被编辑员工的原始信息并保存到model中
	 * 总之该方法执行完之后model中就保存了一个被编辑员工原始信息的Emp对象叫emp
	 */
	@ModelAttribute
	public void preEdit(@RequestParam(required=false) Integer id,Model model){
		if(id!=null){//编辑执行该方法
			//根据工号查询员工的原始信息
			Emp emp = empDao.getEmpById(id);
			//将封装了员工原始信息的Emp对象保存到model中
			model.addAttribute("emp", emp);
		}
	}
	//编辑员工
	@RequestMapping(value="/emp",method=RequestMethod.PUT)
	public String edit(Emp emp){
		
        empDao.addOrEdit(emp);	
        //重定向全查
		return "redirect:/emps";
		
	}
}
