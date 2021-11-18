<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//请求中文编码设置成utf-8   设置服务器编码
request.setCharacterEncoding("utf-8");
//响应页面中文编码设置成utf-8,文件类型为html  设置浏览器端解码
response.setContentType("text/html;charset=utf-8");

//获取表单提交元素
String user = request.getParameter("user");
String password = request.getParameter("pwd");
String passwordOne = request.getParameter("pwdOne");
String[] sex = request.getParameterValues("sex");
String email = request.getParameter("email");
String bornth = request.getParameter("bornth");
String dropDownList[] = request.getParameterValues("question");

out.println("用户名："+ user +"密码："+password+"确认密码："+passwordOne+"性别："+sex+"邮箱："+email+"出生日期："+bornth+"密码找回问题："+dropDownList);

%>
</body>
</html>