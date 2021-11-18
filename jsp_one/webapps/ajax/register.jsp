<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户注册页面</title>
</head>
<body>
<form action="#" method="post">
用户名：<input name="reusername" id="reusername">
<input type = "hidden" id = "url" value="${pageContext.request.contextPath}">
<span style="color:red" id ="msgOne"></span><br>
密码：<input type="password" id ="password" name ="password">
<span style="color:red" id ="msgTwo"></span><br>
<input type="submit" value="注册">

</form>
</body>

<script src="../js/jquery.min.js"></script>
<script>
var urlPath = $("#url").val();
$("#reusername").blur(function(){
	var username = $("#reusername").val();
 htmlobj= $.ajax({url:urlPath + "/RegiServlet?reusername=" + username,async:false});
 //回调函数
      $("#msgOne").html(htmlobj.responseText);
});
</script>
</html>