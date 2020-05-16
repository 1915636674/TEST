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
	 * ��������
	 */
	//��ѯ����Ա��
	@RequestMapping(value="/emps",method=RequestMethod.GET)
	public String all(Model model){
		
		Collection<Emp> emps = empDao.getAllEmp();
		model.addAttribute("emps", emps);
		
		return "list"; 
	}
	//�������Ա��ҳ��ķ���
	@RequestMapping(value="/emp",method=RequestMethod.GET)
	public String toAdd(Model model){
		//���Ա�ѡ��ť��װ����Դ
		Map<String,String> genderMap = new LinkedHashMap<String, String>();
		genderMap.put("male","��");
		genderMap.put("female","Ů");
		model.addAttribute("genderMap", genderMap);
		
		//��������������װ����Դ 
		Collection<Dept> depts = deptDao.getAllDept();
		model.addAttribute("depts", depts);
		
		//�����ṩ�󶨵�Javabean,��Ȧ��
		Emp emp = new Emp();
		model.addAttribute("emp", emp);
		return "input";
	}
	//���Ա��
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	public String add(Emp emp){
		empDao.addOrEdit(emp);
		//�ض���ȫ��
		return "redirect:/emps";
	} 
	//ɾ��Ա��
	@RequestMapping(value="/emp/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable Integer id){
		empDao.delEmpById(id);
		
		//�ض�������ȫ��
		return "redirect:/emps";
	}
	//���ﱻ�༭ҳ��
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	public String toEdit(@PathVariable Integer id,Model model){
		//���ݹ��Ų�ѯ���༭Ա����ԭʼ��Ϣ
		Emp emp = empDao.getEmpById(id);
		model.addAttribute("emp",emp);
		//���Ա�ѡ��ť��װ����
		Map<String,String> genderMap = new LinkedHashMap<>();
		genderMap.put("male","��");
		genderMap.put("female","Ů");
		model.addAttribute("genderMap", genderMap);
		
		//��������������װ����
		Collection<Dept> depts = deptDao.getAllDept();
		model.addAttribute("depts",depts);
		
		return "input";
	}
	/*
	 * ����edit()����֮ǰִ�еķ���:
	 * 1>@ModelAttribute��ʾpreEdit()�������������е���������ִ��֮ǰ��ִ��
	 * 2>���ȸ����������id��ѯ�����༭Ա����ԭʼ��Ϣ�����浽model��
	 * ��֮�÷���ִ����֮��model�оͱ�����һ�����༭Ա��ԭʼ��Ϣ��Emp�����emp
	 */
	@ModelAttribute
	public void preEdit(@RequestParam(required=false) Integer id,Model model){
		if(id!=null){//�༭ִ�и÷���
			//���ݹ��Ų�ѯԱ����ԭʼ��Ϣ
			Emp emp = empDao.getEmpById(id);
			//����װ��Ա��ԭʼ��Ϣ��Emp���󱣴浽model��
			model.addAttribute("emp", emp);
		}
	}
	//�༭Ա��
	@RequestMapping(value="/emp",method=RequestMethod.PUT)
	public String edit(Emp emp){
		
        empDao.addOrEdit(emp);	
        //�ض���ȫ��
		return "redirect:/emps";
		
	}
}
