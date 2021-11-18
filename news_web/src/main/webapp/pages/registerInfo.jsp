<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="service.*,service.impl.*,entity.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//设置字符集编码
request.setCharacterEncoding("utf-8");
response.setContentType("text/html;character=utf-8");

//获取表单提交元素
String user = request.getParameter("user");
String yzm = request.getParameter("yzm");
String pwd = request.getParameter("pwd");

UserService us = new UserServiceImpl();
User use  = us.isExistsUser(user);
if(use != null){
	out.println("此用户名已存在！请重新输入用户名！！");
	//重定向到注册页面
	response.sendRedirect("register.jsp");
}else{
	//注册成功，转发到登录页面
	request.getRequestDispatcher("login.jsp");
}

%>
</body>
</html>