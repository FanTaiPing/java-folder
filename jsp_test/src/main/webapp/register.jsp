<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户注册页面</title>
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
 text-align:left;
 }
</style>
<body>
<div class="container">
<form action="registerInfo.jsp" method ="post">
<table>
<tr>
<td>
请输入用户注册信息
</td>
</tr>

<tr>
<td>
<label for="user">用户名：</label>
<input type="text" id="user" name="user">
</td>
</tr>

<tr>
<td>
<label for="pwd">密码：</label>
<input type="password" id="pwd" name="pwd">
</td>
</tr>

<tr>
<td>
<label for="pwdOne">确认密码：</label>
<input type="password" id="pwdOne" name="pwdOne">
</td>
</tr>

<tr>
<td>
<label for="sex">性别：</label>
<input type="radio" id="sex" name="sex" checked>男
<input type="radio" id="sex" name="sex">女<br>
</td>
</tr>

<tr>
<td>
<label for="email">邮箱：</label>
<input type="text" id="email" name="email">
</td>
</tr>

<tr>
<td>
<label for="born">出生日期：</label>
<input type="text" id="born" name="bornth">
</td>
</tr>


<tr>
<td>
<label for="question">密码找回提问：</label>
<select name="question" id="question">
<option value="" selected>你的小学是？</option>
<option value="">你的生日是？</option>
<option value="">你的手机号码是？</option>
</select>
</td>
</tr>

<tr>
<td>
<input type="submit" value="提交">
<input type="button" value="取消">
</td>
</tr>

</table>
</form>

</div>
</body>
</html>