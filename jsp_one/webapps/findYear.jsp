<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查找闰年</title>
</head>
<body>
	<!-- 申明 -->
	<%!int count = 0;

	void findYear(int year) {
		//判断是否是闰年
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			count++;
		}
	}
	%>
	<%
	for (int i = 2000; i <= 2013; i++) {
		findYear(i);
	}
	%>
	从2000年到2013年，共有<%=count%>个闰年
	<%-- 计算完清零，否则刷新会累加 --%>
	<%
	count = 0;
	%>

</body>
</html>