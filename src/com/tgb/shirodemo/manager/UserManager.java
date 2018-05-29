package com.tgb.shirodemo.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.tgb.shirodemo.entity.ShiroUser;
import com.tgb.shirodemo.shiroutils.DataSourceUtils;

public class UserManager {
	private ShiroUser user;
	
	//根据用户名查询用户信息
    public ShiroUser getUserByName(String username){
    	 Connection conn=DataSourceUtils.getConnection();
         ResultSet rs=null;
         ShiroUser user=null;
         try{
        	 PreparedStatement pstmt=conn.prepareStatement("select userName,userPsw,roleId from user where userName=?");
        	 pstmt.setString(1, username);
        	 rs=pstmt.executeQuery();
        	 
        	 if(rs.next()){
        		 user=new ShiroUser();
        		 user.setUserName(rs.getString("userName"));
        		 user.setPassWord(rs.getString("userPsw"));
        		 user.setRoleId(rs.getString("roleId"));
        		 System.out.println("姓名:"+rs.getString("userName")+"pwd:"+rs.getString("userPsw")+"roleId"+rs.getString("roleId"));
        	 }
         }catch(Exception e){
        	 e.printStackTrace();
         }
         return user;
    }

	public ShiroUser getUser() {
		return user;
	}
	public void setUser(ShiroUser user) {
		this.user = user;
	}
}
