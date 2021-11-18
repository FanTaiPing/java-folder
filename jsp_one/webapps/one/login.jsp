<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录界面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/SessionServlet" method="post">
<!-- <form action="${pageContext.request.contextPath}/RegServlet" method="post"> -->
<label>用户名：</label><input name="username" id="username" onblur="checkUser()"><input type="hidden" id ="url" value="${pageContext.request.contextPath }/"><input type="hidden" id ="flag" name ="flag" value="登录"><span id="msg"></span><br>
<label>密码：&nbsp;&nbsp;&nbsp;</label><input type="password" name="pwd"><br>
<input type="submit" value="登录">

</form>
</body>
<script src ="${pageContext.request.contextPath }/js/register.js"></script>
<script src ="${pageContext.request.contextPath }/js/axios.min.js"></script>
</html>