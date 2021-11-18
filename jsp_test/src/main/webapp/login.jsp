<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录页面</title>
</head>
<style>
.container{
width:600px;
margin:auto;
}
#title{
font-size:22px;
color:skyblue;
}
 table{
 text-align:center;
 }
</style>
<body>
<div class="container">
<form action="loginInfo.jsp" method="post">
<table>
<tr>
<td id="title">请填写你的登录信息</td>
</tr>

<tr>
<td></td>
</tr>
<tr>
<td></td>
</tr>
<tr>
<td></td>
</tr>

<tr>
<td><label for="user">用户名：</label><input name="user" id="user"></td>
</tr>

<tr>
<td><label for="password">密码：</label><input type="password" name="pwd" id="password"></td>
</tr>

<tr>
<td><label for="yzm">验证码：</label><input type="text" name="yzm" id="yzm"></td>
</tr>

<tr>
<td><input type="submit" value="提交">&nbsp;&nbsp;&nbsp;<input type="button" value="取消"></td>
</tr>


</table>
</form>
</div>
</body>
</html>