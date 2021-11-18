<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>输出当前日期和时间</title>
</head>
<body>
你好，今天是
<!--小脚本-->
<%
SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
String time = format.format(new Date());
%>
<!--表达式-->
<%=time%>
</body>
</html>