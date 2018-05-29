<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form action="money" method="post">
      <shiro:guest>我是游客</shiro:guest> 
      3213
      <shiro:user>我是用户</shiro:user>
      <shiro:hasPermission name="user:zfx">
              <input type="submit" value="我要500万">
      </shiro:hasPermission> 	
      <shiro:hasPermission name="user:add">
              <input type="submit" value="add">
      </shiro:hasPermission> 
    </form>
</body>
</html>