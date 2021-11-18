<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<%
//请求中文编码设置成utf-8  设置服务器端编码
request.setCharacterEncoding("utf-8");
//响应页面中文编码设置成UTF-8,文件类型是HTML  设置浏览器端解码
response.setContentType("text/html;charset=utf-8");
//获取表单提交的元素

//获取用户名
String username = request.getParameter("username");
//获取密码
String pwd = request.getParameter("pwd");
//获取复选框的内容
String[] channel = request.getParameterValues("channel");

out.println("用户名："+username);
out.println("密码："+pwd);
out.println("性别："+request.getParameter("sex"));
out.println("季节："+request.getParameter("season"));
out.println("信息来源：");
for(String str:channel){
	out.println(str+"\t");	
}
%>
</body>
</html>