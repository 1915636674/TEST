package com.my.dao;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.my.beans.Dept;

/*
 * ����Dao��
 */
@Repository
public class DeptDao {
    //���ű��ӳ�䲿�Ŷ��󣬾�̬��Map�������Գ䵱���ݿ�
	private static Map<Integer, Dept> deptMap;
	
	//��ʼ��Map����
	static{
		deptMap = new LinkedHashMap<Integer,Dept>();
		deptMap.put(10, new Dept(10, "�з���"));
		deptMap.put(20, new Dept(20, "���Բ�"));
		deptMap.put(30, new Dept(30, "Ӫ����"));
		deptMap.put(40, new Dept(40, "��ά��"));
	}
	/*
	 * dao����
	 *���ݲ��ű�Ų�ѯ����
	 */
	public Dept getDeptById(Integer id){
	    return	deptMap.get(id);
	}
	//��ѯ���в���
	public Collection<Dept> getAllDept(){
		return  deptMap.values();
	}
	
	
	


}
