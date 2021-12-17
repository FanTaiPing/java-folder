<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,entity.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>使用foreach进行表格的隔行变色效果</title>
</head>
<body>
	<%
	List<User> list = new ArrayList();
	list.add(new User(1, "张三", "123456"));
	list.add(new User(2, "张四", "123456"));
	list.add(new User(3, "张五", "123456"));
	list.add(new User(4, "张六", "123456"));

	request.setAttribute("list", list);
	%>
	<table border="1" width="800px" ; align="center">
		<tr>
			<th>编号</th>
			<th>id</th>
			<th>姓名</th>
			<th>密码</th>
		</tr>
		<c:forEach items="${list}" var="user" varStatus="s">
			<c:if test="${s.count %2 ==0 }">
				<tr style="background-color: red">
					<%--<td>${s.count}</td>
					<td>${user.id }</td>
					<td>${user.username }</td>
					<td>${user.password }</td> --%>
			</c:if>
			<c:if test="${s.count % 2 !=0 }">
				<tr style="background-color: green">
			</c:if>
			<td>${s.count}</td>
			<td>${user.id }</td>
			<td>${user.username }</td>
			<td>${user.password }</td>
		</c:forEach>
	</table>
</body>
</html>