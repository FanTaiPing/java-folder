<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>问卷调查</title>
</head>
<body>
<form action="investigationEl.jsp" method="POST">
昵称:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="username"><br>
所在城市:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name= "city"><br>
你所使用的开发语言:<input type="checkbox" name ="language" value="JAVA">Java
<input type="checkbox" name ="language" value="C">C
<input type="checkbox" name ="language" value="C++">C++
<input type="checkbox" name ="language" value="PHP">PHP
<input type="checkbox" name ="language" value="ASP">ASP<br><br>
<input type ="submit" value="提交">
</form>
</body>
</html>