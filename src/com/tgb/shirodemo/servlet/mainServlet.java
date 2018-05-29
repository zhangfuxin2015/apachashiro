package com.tgb.shirodemo.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


public class mainServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 11L;
	private test t;
	public test getT() {
		return t;
	}
	public void setT(test t) {
		this.t = t;
	}
	
	@RequiresPermissions("account:create")  
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//从context中的依赖关系取得spring管理的bean
		ServletContext servletContext=this.getServletContext();
		WebApplicationContext context=WebApplicationContextUtils.getWebApplicationContext(servletContext);
		t=(test)context.getBean("tt");
		Subject subject=SecurityUtils.getSubject();
		System.out.println(subject.isPermitted("account:create")+"123123213");
		//t=new test();
		t.toTO();
		t.goTo();
	}
	
}
