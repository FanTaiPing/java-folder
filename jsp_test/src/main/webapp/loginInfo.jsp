<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,java.text.*,entity.DBUtils,util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
//请求中文编码设置为utf-8  设置服务器编码
request.setCharacterEncoding("utf-8");
//响应页面中文编码设置成utf-8，文件类型是html   设置浏览器端解码
response.setContentType("text/html;charset=utf-8");

//获取表单提交元素
//获取用户名
String user = request.getParameter("user");

//获取密码
String password = request.getParameter("pwd");

//获取验证码
String yzm = request.getParameter("yzm");
DBHelper db = new DBHelper();

out.println("用户名："+user);
out.println("密码："+password);
out.println("验证码："+yzm);


%>
</body>
</html>