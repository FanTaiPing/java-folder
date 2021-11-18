<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录页面</title>
</head>
<body>
<form action="emailLoginInfo.jsp" method="post">
<label>用户名：</label>
<input name="username"><br/>
<label>密码：</label>
<input type="password" name="pwd"><br/>
<input type="submit" value="提交">
<input type="button" value="取消">
</form>
</body>
</html>