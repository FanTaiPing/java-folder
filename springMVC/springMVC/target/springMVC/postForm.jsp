<%--
  Created by IntelliJ IDEA.
  User: y
  Date: 2021/12/3
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/param/paramUser" method="post">
    <input name="id" value="3"/>
    <input name="age" value="24">
    <input type="submit" value="提交">
</form>
</body>
</html>
