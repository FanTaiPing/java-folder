<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax验证用户名</title>
</head>
<body>
	<form action="#" method="post">
		<label>用户名；</label><input name="username" id="username" onblur="check()"> 
		<input type="hidden" value="${pageContext.request.contextPath}/" id="url"/> 
		<span id="msg" style="color: red;"></span><br> 
		密码：<input type="password" id="password" name="password"/><br> 
		<input type="submit" value="登录"/>
	</form>
</body>
<script src="${pageContext.request.contextPath }/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath }/js/axios.min.js"></script>
<script>
function check(){
	let url = document.getElementById("url").value;
	let username = document.getElementById("username").value;
	//原生js的取标签方法
	//let msg = document.getElementById("msg");
	let msg = $("#msg");
axios.get(url+"AjaxServlet?username=" + username)
  .then(function (response) {
	  //原生js的接收回调函数方法
	  //msg.innerHTML=response.data;
	  msg.html(response.data);
  })
  .catch(function (error) {
    alert(err);
  });
};

</script>

</html>