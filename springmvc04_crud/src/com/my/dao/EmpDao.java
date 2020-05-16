package com.my.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.beans.Dept;
import com.my.beans.Emp;

//员工Dao
@Repository
public class EmpDao {
     
	//工号映射员工对象
	private static Map<Integer, Emp> empMap;
	
	static{
		empMap = new LinkedHashMap<Integer, Emp>();
		empMap.put(101, new Emp(101, "jack", "male", 21,"jack@qq.com", new Dept(10, "研发部")));
		empMap.put(102, new Emp(102, "rose", "female", 22,"rose@sina.com", new Dept(20, "测试部")));
		empMap.put(103, new Emp(103, "allen", "male", 23,"allen@sohu.com", new Dept(30, "营销部")));
		empMap.put(104, new Emp(104, "smith", "female", 24,"smith@sina.com", new Dept(40, "运维部")));
		empMap.put(105, new Emp(105, "scott", "male", 25,"scott@qq.com", new Dept(10, "研发部")));
	}
	//dao:根据工号查询员工
	public Emp	getEmpById(Integer id){
		return empMap.get(id);
	}
	
	//查询所有员工
	public Collection<Emp> getAllEmp(){
		return empMap.values(); 
	}
	
	//根据工号删除员工
	public void delEmpById(Integer id){
		empMap.remove(id);
	}
	
	//添加和编辑
	private static Integer empId = 106;
	@Autowired
	private DeptDao deptDao;
	public void addOrEdit(Emp emp){
		if(emp.getId() == null){//添加
			emp.setId(empId);
			empId++;
		}
		//无论添加或是编辑都会执行 
		Integer deptId = emp.getDept().getId();
		Dept dept = deptDao.getDeptById(deptId);
		emp.setDept(dept);
	    
		Integer id = emp.getId();
		empMap.put(id, emp);
	}
	
	
	
	
	
	
}

