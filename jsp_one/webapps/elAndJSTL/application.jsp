<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application统计网站访问次数</title>
</head>
<body>
<%
Integer count = (Integer)application.getAttribute("count");
if(count != null){
	count+=1;
}else{
	count =1;
}
application.setAttribute("count", count);

%>
<!-- 页面显示 -->
<%
Integer i = (Integer) application.getAttribute("count");
out.println("您好，你是第" + i + "位访问本网站的用户！！" );
%>
</body>
</html>