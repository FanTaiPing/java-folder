<%--
  Created by IntelliJ IDEA.
  User: y
  Date: 2021/11/11
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<body>
<header>
    <div class="row head">
        <p>古诗文后台管理系统</p>
    </div>
</header>


<%
    request.setAttribute("date", new Date());
%>

<div id="header">
    <div>
        <p>
            ${requestScope.date} <br />
        </p>
    </div>
    <div>
        <h1 id="title">
            <a href="${pageContext.request.contextPath }/indexServlet">main</a>
        </h1>
    </div>
</div>
</body>
