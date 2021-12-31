<%--
  Created by IntelliJ IDEA.
  User: y
  Date: 2021/12/4
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
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
                Welcome!
            </h1>
            <table class="table">
                <tr class="table_header">
                    <td>
                        ID
                    </td>
                    <td>
                        Name
                    </td>
                    <td>
                        Age
                    </td>
                    <td>
                        Bir
                    </td>
                    <td>
                        Operation
                    </td>
                </tr>
                <c:forEach items="${empList}" var="emp" varStatus="s">
                    <c:if test="${s.count%2 !=0}">
                        <tr style="background-color: #bbb7b7">
                    </c:if>
                    <c:if test="${s.count % 2 ==0}">
                        <tr>
                    </c:if>
                    <td>
                            ${emp.id}
                    </td>
                    <td>
                            ${emp.name}
                    </td>
                    <td>
                            ${emp.age}
                    </td>
                    <td>

                        <fmt:formatDate value="${emp.bir}" pattern="yyyy年MM月dd日"></fmt:formatDate>
                    </td>
                    <td>
                        <a href="javascript:del(${emp.id})">删除</a>&nbsp;
                        <a href="${pageContext.request.contextPath}/emp/updateEmp?id=${emp.id}">修改</a>
                    </td>
                    </tr>
                </c:forEach>
                <script>
                    function del(id) {
                        //用户安全提示
                        if (confirm("您确定要删除id为" + id + "的员工吗？")) {
                            //访问路径
                            location.href = "${pageContext.request.contextPath }/emp/deleteEmp?id=" + id;
                        }
                    }
                </script>
            </table>
            <p>
                <input type="button" class="button" value="Add Employee"
                       onclick="location='${pageContext.request.contextPath}/emp/addEmp'"/>
            </p>
        </div>
    </div>
    <%--引入公共的底部--%>
    <%@include file="publicFoot.jsp" %>
</div>
</body>
</html>
