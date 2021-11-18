<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入标准标签库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	session.setAttribute("user", "admin");
	%>
	<%-- 使用set设置一个boolean来区分是否登录 --%>

	<c:set var="isLogin" value="${empty user}"></c:set>
	<c:if test="${isLogin }">
		<c:out value="对象不为空！"></c:out>
	</c:if>
	<c:if test="${!isLogin }">
		<c:out value="对象为空！！"></c:out>
	</c:if>
</body>
</html>