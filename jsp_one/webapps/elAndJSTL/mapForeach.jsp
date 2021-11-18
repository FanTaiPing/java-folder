<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	Map<String, String> map = new HashMap<String, String>(16);
	map.put("tom", "张三");
	map.put("lili", "李四");
	map.put("jack", "王五");
	request.setAttribute("map", map);
	request.setAttribute("date", new Date());
	%>

	<c:forEach items="${requestScope.map }" var="name">
${name.key}
${name.value}<br>
	</c:forEach>
	<br>
	<fmt:formatDate value="${requestScope.date}"
		pattern="yyyy年MM月dd日 HH:mm:ss"></fmt:formatDate>
</body>
</html>