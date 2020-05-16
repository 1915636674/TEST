package com.my.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

public class Test {

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement pt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_db",
					         "root", "123");
			String sql = "insert into employee(emp_name,gender,email,d_id) values(?,?,?,?)";
			pt = con.prepareStatement(sql);
			
			for (int i = 1; i <= 100; i++) {
				String name = randomName();
				pt.setString(1, name);
				pt.setString(2, randomGender());
				pt.setString(3, randomEmail(name));
				pt.setInt(4, randomDid());
				
				pt.addBatch();
			}
			pt.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
               if(con!=null)
            	   con.close();
               if(pt!=null)
            	   pt.close();
			} catch (Exception e2) {
			}
		}
	}
	
	public static Random rn = new Random();
	
	//随机生成姓名的方法
	public static String randomName(){
		String names = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int len = names.length();
		String name = "";
		for (int i = 1; i <= 5; i++) {
			int index = rn.nextInt(len);
			name+=names.charAt(index);
		}
		return name;
	}
	//随机生成性别的方法
	public static String randomGender(){
		int num = rn.nextInt(100)+1;
		if (num%2==0) {
			return "M";
		}else {
			return "F";
		}
	}
	//随机生成邮箱的方法
	public static String randomEmail(String name){
		String[] emails = {"@qq.com","@sina.com","@163.com","@192.com","@foxmail.com"};
		int len = emails.length;
		int index = rn.nextInt(len);
		return name+emails[index];
	}
	//随机生成部门编号的方法
	public static int randomDid(){
		int[] ids = {1,2,3,4,5};
		int len = ids.length;
		int index = rn.nextInt(len);
		return ids[index];
	}
}
