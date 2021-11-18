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
		<label>用户名；</label><input name="username" id="username"> <input
			type="hidden" value="${pageContext.request.contextPath}/" id="url">
		<span id="msg" style="color: red;"></span><br> 密码：<input
			type="password" id="password" name="password"><br> <input
			type="submit" value="登录">
	</form>
</body>

<!-- <script>

var urlPath = document.getElementById("url").value;
function check(){
	var username = document.getElementById("username").value;
	var xmlhttp;
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
	xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
	xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function(data) {
	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
		//正确的回调函数
		document.getElementById("msg").innerHTML = xmlhttp.responseText;
		
	}else{
		//发生异常错误的回调函数
		console.log();
	}
	}
	var url =urlPath + "/AjaxServlet?username=" + username;
	xmlhttp.open("GET", url, true);
	xmlhttp.send();
} 
</script>-->
<!-- <script>
var urlPath = $("#url").val();
$("#reusername").blur(function(){
	var username = $("#reusername").val();
 htmlobj= $.ajax({url:urlPath + "/RegiServlet?reusername=" + username,async:false});
 //回调函数
      $("#msg").html(htmlobj.responseText);
}); -->
<script src="${pageContext.request.contextPath }/js/jquery-2.1.4.min.js"></script>
<script>
	$().ready(function() {
		//用户名文本框失去焦点
		$("#username").blur(function() {
			var url = $("#url").val();
			let username = $("#username").val();
			let msg = $("#msg");
			//取动态地址url
			//使用get传值
			$.get(url + "AjaxServlet", {
				//key:value (paramName : paramValue)
				username : username
				//正确的回调函数
			}, function(data) {
				//msg.style.color ="red";
				msg.css("color", "red");
				msg.html(data);
				//错误的回调函数
			});
		});
	});
</script>

</html>