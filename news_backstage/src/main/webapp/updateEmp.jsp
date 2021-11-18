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
						update Emp info:
					</h1>
					<form action="${pageContext.request.contextPath }/UpdateServlet?id=${requestScope.user.id}" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">							
							<tr>
								<td valign="middle" align="right">
									id:
								</td>
								<td valign="middle" align="left">
									${requestScope.user.id }
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									name:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" value="${requestScope.user.username }"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									password:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="pwd" value="${requestScope.user.password }"/>
								</td>
							</tr>
							
						</table>
						<p>
							<input type="submit" class="button" value="update" />
						</p>
					</form>
				</div>
			</div>
			<!-- 公共的底部部分 -->
			<%@ include file="publicFooder.jsp" %>
		</div>
	</body>
</html>