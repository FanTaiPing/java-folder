<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="service.*,service.impl.*,entity.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>获取登录信息</title>
</head>
<body>
<%-- 	<%
	//设置字符集编码
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;character=utf-8");

	//获取表单提交的元素
	String user = request.getParameter("user");
	String pwd = request.getParameter("pwd");

	UserService us = new UserServiceImpl();
	User use = us.login(user, pwd);
	//if(user.equals(use.getUsername())&&pwd.equals(use.getPassword())){
	if (use != null) {
		//登录成功
		//跳转到后台管理系统页面
		request.getRequestDispatcher("welcome.jsp").forward(request, response);
	} else {
		//登录失败，重定向到登录页面
		response.sendRedirect("login.jsp");
	}
	%> --%>

欢迎<%=request.getParameter("username") %>登录
</body>
</html>