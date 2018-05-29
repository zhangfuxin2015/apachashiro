package com.tgb.shirodemo.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import com.tgb.shirodemo.entity.Permission;
import com.tgb.shirodemo.entity.ShiroUser;
import com.tgb.shirodemo.shiroutils.DataSourceUtils;

public class PermissionManager {
    public Collection<Permission> getPermission(ShiroUser user){
    	Connection conn=DataSourceUtils.getConnection();
        ResultSet rs=null;
        Permission per=null;
        Collection<Permission> cPer=new ArrayList<Permission>();
        
        try{
        	//根据用户对应的角色id,查询permission的id集合
       	 PreparedStatement pstmt=conn.prepareStatement("select permissionId from rolepermission where roleId=?");
       	 pstmt.setString(1, user.getRoleId());
       	 rs=pstmt.executeQuery();
       	 
       	 while(rs.next()){
       		 ResultSet rsper=null;
       		 pstmt=conn.prepareStatement("select permissionId,permissionName,permissionDesc from permission where permissionId=?");
       		 pstmt.setString(1, rs.getString("permissionId"));
          	 rsper=pstmt.executeQuery();
          	 
          	 //取得权限信息
          	 while(rsper.next()){
		          	 per=new Permission();
		          	 per.setPermissionId(rsper.getString("permissionId"));
		          	 per.setPermissionName(rsper.getString("permissionName"));
		          	 per.setPermissionDec(rsper.getString("permissionDesc"));
		          	 
		          	 cPer.add(per);
          	 }
       	 }
        }catch(Exception e){
       	 e.printStackTrace();
        }
        return cPer;
    }
}
