package com.tgb.shirodemo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String userName=req.getParameter("userName");
		String psw=req.getParameter("password");
		//收集实体/凭据信息 
		UsernamePasswordToken token=new UsernamePasswordToken(userName,psw);
		
		
		
		//token.setRememberMe(true);
		//我们可以通过SecurityUtils工具类，获取当前的用户，然后通过调用login方法提交认证。
		Subject subject=SecurityUtils.getSubject();
		System.out.println(subject.isPermitted("user:add"));
		if(subject.isPermitted("user:add")){
			System.out.println("有这个权限1");
		}else{
			System.out.println("没有这个权限1");
		}
		if (subject.hasRole("user")) {  
			System.out.println("user++++++++++++++++++++++++++++++++++++");
		}else{
			System.out.println("bushi1+++++++++++++++++++++++++++++++++++++++");
		}
		try{
			subject.login(token);
			System.out.println(subject.isPermitted("user:add"));
			if(subject.isPermitted("user:add23323")){
				System.out.println("有这个权限2");
			}else{
				System.out.println("没有这个权限2");
			}
			req.getRequestDispatcher("/Page/main.jsp").forward(req,resp);
		}catch(UnknownAccountException e){
			System.out.println("用户不存在");
			req.getRequestDispatcher("/Page/main.jsp").forward(req,resp);
		}catch (IncorrectCredentialsException e) {
			System.out.println("用户密码不正确");
			req.getRequestDispatcher("/Page/main.jsp").forward(req,resp);	
		}		
	}
}
