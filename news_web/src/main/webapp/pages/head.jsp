<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,entity.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 导航栏部分 -->
<div class="navbar navbar-default">
	<!-- container为了跟下面内容对齐 -->
	<div class="container">
		<div class="navbar-header">
			<!-- logo -->
			<a class="navbar-brand" href="index.jsp"> </a>
		</div>
		<label for="toggle-checkbox" id="toggle-label"
			class="visible-xs-inline-block">MENU</label> <input class="hidden"
			type="checkbox" id="toggle-checkbox" />
		<!-- 头部导航栏 -->
		<div class="hidden-xs">
			<ul class="nav navbar-nav">

				<%
				List<Nav> nav = (List<Nav>) session.getAttribute("nav");
				for (Nav n : nav) {
					if (n.getId() == 1) {
				%>
				<li class="active"><a
					href="${pageContext.request.contextPath }/pages/index.jsp"><%=n.getName()%></a></li>
				<%
				} else {
				%>

				<li><a href="#"><%=n.getName()%></a></li>

				<%
				}
			}
				%>


			</ul>
			<!-- 登录注册导航栏 -->
			<ul class="nav navbar-nav navbar-right">


				<c:set value="${empty sessionScope.user}" var="isLogin"></c:set>
				<c:if test="${!isLogin }">
					<li><a href=""><span>欢迎${sessionScope.user.username }登录</span></a></li>
					<li><a
						href="${pageContext.request.contextPath }/LogoutServlet">注销</a></li>
				</c:if>
				<c:if test="${isLogin }">
					<li><a
						href="${pageContext.request.contextPath }/pages/login.jsp">登录</a></li>
					<li><a
						href="${pageContext.request.contextPath }/pages/register.jsp">注册</a></li>
				</c:if>

			</ul>
		</div>
	</div>
</div>