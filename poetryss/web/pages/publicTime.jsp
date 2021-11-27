<%--
  Created by IntelliJ IDEA.
  User: y
  Date: 2021/11/11
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<body>



<%
    request.setAttribute("date", new Date());
%>
${requestScope.date} <br />



</body>
