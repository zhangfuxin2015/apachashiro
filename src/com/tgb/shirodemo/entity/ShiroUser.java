package com.tgb.shirodemo.entity;

import java.io.Serializable;

public  class ShiroUser implements Serializable {
	 private static final long serialVersionUID = -1373760761780840081L;
     public String userName;
     public String passWord;
     public String roleId;
     public String getRoleId() {
 		return roleId;
 	}
 	public void setRoleId(String roleId) {
 		this.roleId = roleId;
 	}
 	public String getUserName() {
 		return userName;
 	}
 	public void setUserName(String userName) {
 		this.userName = userName;
 	}
 	public String getPassWord() {
 		return passWord;
 	}
 	public void setPassWord(String passWord) {
 		this.passWord = passWord;
 	}

}
