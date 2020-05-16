package com.my.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.beans.Dept;
import com.my.beans.Emp;

//Ա��Dao
@Repository
public class EmpDao {
     
	//����ӳ��Ա������
	private static Map<Integer, Emp> empMap;
	
	static{
		empMap = new LinkedHashMap<Integer, Emp>();
		empMap.put(101, new Emp(101, "jack", "male", 21,"jack@qq.com", new Dept(10, "�з���")));
		empMap.put(102, new Emp(102, "rose", "female", 22,"rose@sina.com", new Dept(20, "���Բ�")));
		empMap.put(103, new Emp(103, "allen", "male", 23,"allen@sohu.com", new Dept(30, "Ӫ����")));
		empMap.put(104, new Emp(104, "smith", "female", 24,"smith@sina.com", new Dept(40, "��ά��")));
		empMap.put(105, new Emp(105, "scott", "male", 25,"scott@qq.com", new Dept(10, "�з���")));
	}
	//dao:���ݹ��Ų�ѯԱ��
	public Emp	getEmpById(Integer id){
		return empMap.get(id);
	}
	
	//��ѯ����Ա��
	public Collection<Emp> getAllEmp(){
		return empMap.values(); 
	}
	
	//���ݹ���ɾ��Ա��
	public void delEmpById(Integer id){
		empMap.remove(id);
	}
	
	//��Ӻͱ༭
	private static Integer empId = 106;
	@Autowired
	private DeptDao deptDao;
	public void addOrEdit(Emp emp){
		if(emp.getId() == null){//���
			emp.setId(empId);
			empId++;
		}
		//������ӻ��Ǳ༭����ִ�� 
		Integer deptId = emp.getDept().getId();
		Dept dept = deptDao.getDeptById(deptId);
		emp.setDept(dept);
	    
		Integer id = emp.getId();
		empMap.put(id, emp);
	}
	
	
	
	
	
	
}

