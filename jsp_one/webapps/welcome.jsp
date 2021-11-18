<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

<%

if(session.getAttribute("username") == null){
	response.sendRedirect("one/login.jsp");
}
%>
欢迎${sessionScope.username}登录
</body>
</html>