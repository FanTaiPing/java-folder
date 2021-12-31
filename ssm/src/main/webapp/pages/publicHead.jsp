<%--
  Created by IntelliJ IDEA.
  User: y
  Date: 2021/12/4
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" import="java.util.*" %>
<%--通用标签库--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--日期格式标签库--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    request.setAttribute("date", new Date());
%>
<div id="header">
    <div id="rightheader">
        <p>
            <fmt:formatDate value="${requestScope.date}" pattern="yyyy年MM月dd日 HH:mm:ss"></fmt:formatDate>
            <br />
        </p>
    </div>
    <div id="topheader">
        <h1 id="title">
            <a href="#">main</a>
        </h1>
    </div>
    <div id="navigation">
    </div>
</div>
