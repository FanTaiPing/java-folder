<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<body>
<%
Cookie[] cookies = request.getCookies();

if(cookies !=null){
	for(int i=0;i<cookies.length;i++){
		if("username".equals(cookies[i].getName())){
			//五分钟之内登陆过
			response.sendRedirect("welcome.jsp");			
		}
	}
}

%>
<form action="${pageContext.request.contextPath }/LoginServlet" method="post">
用户名：<input name="username"><br/>
密码：<input name = "password" type="password">

<input type="submit" value="登录">


</form>
</body>
</html>