<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录成功页面</title>
</head>
<body>
<h1>您好：
<%=request.getParameter("username")%>!
欢迎您登录成功！</h1>

</body>
</html>