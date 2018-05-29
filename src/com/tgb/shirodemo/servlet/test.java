package com.tgb.shirodemo.servlet;

import org.apache.shiro.authz.annotation.RequiresPermissions;



public class test {
    @RequiresPermissions("user:del")
    public void goTo(){
    	System.out.println("user:del");
    }
   
    @RequiresPermissions("user:add")
	public void toTO(){
		System.out.println("user:add");
	}

}
