<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setAttribute("date", new Date());
	%>

	<div id="header">
		<div id="rightheader">
			<p>
				${requestScope.date} <br />
			</p>
		</div>
		<div id="topheader">
			<h1 id="title">
				<a href="${pageContext.request.contextPath }/indexServlet">main</a>
			</h1>
		</div>
		<div id="navigation"></div>
	</div>
</body>
</html>