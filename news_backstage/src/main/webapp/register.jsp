<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 公共的css部分 -->
<%@ include file ="publicCss.jsp" %>

		<div id="wrap">
			<div id="top_content">
				<!-- 公共的显示时间部分小脚本和头部部分 -->
					<%@ include file ="publicTime.jsp" %>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						注册
					</h1>
					<form action="${pageContext.request.contextPath }/regServlet" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="username" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									真实姓名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="pwd" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									性别:
								</td>
								<td valign="middle" align="left">
									男
									<input type="radio" class="inputgri" name="sex" value="m" checked="checked"/>
									女
									<input type="radio" class="inputgri" name="sex" value="f"/>
								</td>
							</tr>
							
							<tr>
								<td valign="middle" align="right">
									验证码:
									<a href="javascript:reloadCode();"><img id="checkCode" src="${pageContext.request.contextPath }/ImageServlet" /></a>
									<a href="javascript:reloadCode();">换一张</a>
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="number" />		
								</td>
								<td><span style="color:red">${msg }</span></td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="Submit &raquo;" />
						</p>
					</form>
				</div>
			</div>
			<!-- 公共的底部部分 -->
			<%@ include file="publicFooder.jsp" %>
		</div>
	</body>
		<script>
	 function reloadCode(){
		 var time = new Date().getTime();
		 document.getElementById("checkCode").src="<%=request.getContextPath()%>/ImageServlet?d="+ time;
	 }
	</script>
</html>