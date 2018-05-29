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
		//�ռ�ʵ��/ƾ����Ϣ 
		UsernamePasswordToken token=new UsernamePasswordToken(userName,psw);
		
		
		
		//token.setRememberMe(true);
		//���ǿ���ͨ��SecurityUtils�����࣬��ȡ��ǰ���û���Ȼ��ͨ������login�����ύ��֤��
		Subject subject=SecurityUtils.getSubject();
		System.out.println(subject.isPermitted("user:add"));
		if(subject.isPermitted("user:add")){
			System.out.println("�����Ȩ��1");
		}else{
			System.out.println("û�����Ȩ��1");
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
				System.out.println("�����Ȩ��2");
			}else{
				System.out.println("û�����Ȩ��2");
			}
			req.getRequestDispatcher("/Page/main.jsp").forward(req,resp);
		}catch(UnknownAccountException e){
			System.out.println("�û�������");
			req.getRequestDispatcher("/Page/main.jsp").forward(req,resp);
		}catch (IncorrectCredentialsException e) {
			System.out.println("�û����벻��ȷ");
			req.getRequestDispatcher("/Page/main.jsp").forward(req,resp);	
		}		
	}
}
