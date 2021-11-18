<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>获取登录信息</title>
</head>
<body>
<%
//设置字符集编码
request.setCharacterEncoding("utf-8");
response.setContentType("text/html;character=UTF-8");

//取表单提交过来的元素的值
String username = request.getParameter("username");
String pwd = request.getParameter("pwd");

//模拟数据库根据用户名和密码查询用户
if("sa".equals(username)&&"sa".equals(pwd)){
	//登录成功
	//重定向到欢迎页面
	//response.sendRedirect("welcome.jsp");
	
	//转发到欢迎页面
	request.getRequestDispatcher("welcome.jsp").forward(request,response);
	
}else{
	//登录失败
	response.sendRedirect("login.jsp");
}


%>
</body>
</html>