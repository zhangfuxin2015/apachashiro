package com.tgb.shirodemo.shiroutils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSourceUtils {
	
	 public static Connection getConnection(){
	    	Connection conn=null;
	    	try{
	    		String driver="com.mysql.jdbc.Driver";
	    	    String url="jdbc:mysql://localhost:3306/shiro";
	    	    String username="root";
	    	    String password="123456";
	    	    Class.forName(driver);
	    	    conn=DriverManager.getConnection(url,username,password);
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	return conn;
	    }
}

