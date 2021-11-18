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
					<form action="${pageContext.request.contextPath }/UpNewsShowServlet?id=${requestScope.newsId.id}" method="post" enctype="multipart/form-data" name="myform">
						<table cellpadding="0" cellspacing="0" border="0" class="form_table">							
							<tr>
								<td valign="middle" align="right">
									id:
								</td>
								<td valign="middle" align="left">
									${requestScope.newsId.id }
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									title:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="title" value="${requestScope.newsId.title }"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									author:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="author" value="${requestScope.newsId.author }"/>
								</td>
							</tr>
							<tr>					
								<td valign="middle" align="right">
									content:
								</td>
								<td valign="middle" align="left">
								<textarea name="content">${requestScope.newsId.content }</textarea>
								</td>
							</tr>
							<tr>							
								<td valign="middle" align="right">
									smImg:
								</td>
								<td valign="middle" align="left">
								
									<input type="file" class="inputgri" name="smImg" value="${requestScope.newsId.smImg }"/>
								</td>
							</tr>
							<tr>								
								<td valign="middle" align="right">
									laImg:
								</td>
								<td valign="middle" align="left">
									<input type="file" class="inputgri" name="laImg" value="${requestScope.newsId.laImg }"/>
								</td>
							</tr>
							<tr>								
								<td valign="middle" align="right">
									typeId:
								</td>
								<td valign="middle" align="left">
									<select name="typeId">									
									<c:forEach items="${requestScope.newsType}" var ="nt">									
									<option value="${nt.id }">${nt.name}</option>									
									</c:forEach>
									</select>
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