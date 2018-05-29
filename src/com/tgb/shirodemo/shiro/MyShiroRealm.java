package com.tgb.shirodemo.shiro;

import java.util.Collection;
import java.util.Iterator;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.tgb.shirodemo.entity.Permission;
import com.tgb.shirodemo.entity.ShiroUser;
import com.tgb.shirodemo.manager.PermissionManager;
import com.tgb.shirodemo.manager.UserManager;

public class MyShiroRealm extends AuthorizingRealm {
	//注入的类，真正的去访问数据库
    private UserManager  usermgr;
    private PermissionManager permgr;
    //查询用户的权限信息
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
	ShiroUser user=(ShiroUser)principals.fromRealm(getName()).iterator().next();
	Collection<Permission> cper= permgr.getPermission(user);
	SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
	Iterator<Permission> it=cper.iterator();
	while(it.hasNext()){
		info.addStringPermission(it.next().getPermissionName());
	}
		return info;
	}
    //查询用户的身份信息
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		ShiroUser user=usermgr.getUserByName(token.getPrincipal().toString());
		if(user==null){
			throw new UnknownAccountException();
		}else{
			return new SimpleAuthenticationInfo(user,user.getPassWord(),getName());
		}
	}

	
	public UserManager getUsermgr() {
		return usermgr;
	}

	public void setUsermgr(UserManager usermgr) {
		this.usermgr = usermgr;
	}

	public PermissionManager getPermgr() {
		return permgr;
	}

	public void setPermgr(PermissionManager permgr) {
		this.permgr = permgr;
	}
 
}
