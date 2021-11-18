<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>邮箱登录信息显示</title>
</head>
<body>
<%
//设置字符集编码
request.setCharacterEncoding("utf-8");
response.setContentType("text/html;character=UTF-8");

//获取表单提交过来的元素值
String user = request.getParameter("username");
String pwd = request.getParameter("pwd");

//模拟数据库根据用户名和密码查询用户
if("lucky".equals(user)&&"123456".equals(pwd)){
	//登录成功
	//转发到欢迎页面
	request.getRequestDispatcher("emailWelcome.jsp").forward(request,response);
}else{
	//登录失败重定向到登录页面
	response.sendRedirect("emailLogin.jsp");
}


%>
</body>
</html>