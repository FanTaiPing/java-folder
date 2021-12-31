<%--
  Created by IntelliJ IDEA.
  User: y
  Date: 2021/12/4
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Title</title>
</head>
<%--引入公共的css--%>
<%@include file="publicCss.jsp"%>
<body>
<div id="wrap">
    <div id="top_content">

        <%--引入公共的头部--%>
        <%@include file="publicHead.jsp" %>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                login
            </h1>
            <form action="${pageContext.request.contextPath}/user/login" method="post">
                <table cellpadding="0" cellspacing="0" border="0"
                       class="form_table">
                    <tr>
                        <td valign="middle" align="right">
                            username:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="username"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            password:
                        </td>
                        <td valign="middle" align="left">
                            <input type="password" class="inputgri" name="password"/>
                        </td>
                    </tr>
                </table>
                <p>
                    <input type="submit" class="button" value="Submit &raquo;"/>
                    <input type="button" class="button" onclick="location.href='./regist.html'" value="Regist &raquo;"/>
                </p>
            </form>
        </div>
    </div>
    <%--引入公共的底部--%>
    <%@include file="publicFoot.jsp" %>
</div>
</body>
</html>
