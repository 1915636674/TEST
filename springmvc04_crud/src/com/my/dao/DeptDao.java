package com.my.dao;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.my.beans.Dept;

/*
 * 部门Dao类
 */
@Repository
public class DeptDao {
    //部门编号映射部门对象，静态的Map集合属性充当数据库
	private static Map<Integer, Dept> deptMap;
	
	//初始化Map集合
	static{
		deptMap = new LinkedHashMap<Integer,Dept>();
		deptMap.put(10, new Dept(10, "研发部"));
		deptMap.put(20, new Dept(20, "测试部"));
		deptMap.put(30, new Dept(30, "营销部"));
		deptMap.put(40, new Dept(40, "运维部"));
	}
	/*
	 * dao方法
	 *根据部门编号查询部门
	 */
	public Dept getDeptById(Integer id){
	    return	deptMap.get(id);
	}
	//查询所有部门
	public Collection<Dept> getAllDept(){
		return  deptMap.values();
	}
	
	
	


}
