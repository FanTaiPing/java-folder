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
						login
					</h1>
					<form action="${pageContext.request.contextPath }/LoginServlet" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									username:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" />
								</td>
								<td><span>${msg}</span></td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									password:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="pwd" />
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="Submit &raquo;" />
							<input type="button" class="button" onclick="javascript:window.location.href='${pageContext.request.contextPath}/register.jsp'" value="Regist &raquo;" />
						</p>
					</form>
				</div>
			</div>
			<!-- 公共的底部部分 -->
			<%@ include file="publicFooder.jsp" %>
		</div>
	</body>

</html>