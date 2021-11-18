<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>使用EL展示问卷调查</title>
</head>
<body>
	<%
	//设置字符集编码
	request.setCharacterEncoding("utf-8");

	//获得语言集合
	String[] languages = request.getParameterValues("language");
	%>
	你所填写的内容是：
	<br /> 昵称：${param.username }
	<br> 所在城市：${param.city }
	<br> 使用的开发语言有：
	<%
	if(languages !=null){
	for (int i = 0; i < languages.length; i++) {
		if (i > 0) {
			out.println("、");
	}
		//将索引放到请求域中 
	request.setAttribute("i", i);
			
	%>
 ${paramValues.language[i]}

	<%
	}
}
	%>
</body>
</html>