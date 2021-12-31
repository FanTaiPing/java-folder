<%--
  Created by IntelliJ IDEA.
  User: y
  Date: 2021/12/4
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<%--引入公共的css--%>
<%@include file="publicCss.jsp" %>
<body>
<div id="wrap">
    <div id="top_content">
        <%--引入公共的头部--%>
        <%@include file="publicHead.jsp" %>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                update Emp info:
            </h1>
            <form action="${pageContext.request.contextPath}/emp/updateEmp" method="post">
                <table cellpadding="0" cellspacing="0" border="0"
                       class="form_table">
                    <tr>
                        <td valign="middle" align="right">
                            id:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="id" value="${emp.id}" readonly/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            name:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="name" value="${emp.name}"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            age:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="age" value="${emp.age}"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            bir:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="bir" value="<fmt:formatDate value="${emp.bir}" pattern="yyyy/MM/dd"/>"/>

                            <span style="color:red">*生日格式必须是yyyy/MM/dd</span>
                        </td>
                    </tr>
                </table>
                <p>
                    <input type="submit" class="button" value="Confirm" />
                </p>
            </form>
        </div>
    </div>
    <%--引入公共的底部--%>
    <%@include file="publicFoot.jsp" %>
</div>
</body>
</html>
