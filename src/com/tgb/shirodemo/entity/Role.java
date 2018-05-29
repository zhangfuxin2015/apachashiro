package com.tgb.shirodemo.entity;

import java.util.List;

public class Role {
     private String roleId;
     private String roleName;
     private List<Permission> LPermission;
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public List<Permission> getLPermission() {
		return LPermission;
	}
	public void setLPermission(List<Permission> lPermission) {
		LPermission = lPermission;
	}
}
