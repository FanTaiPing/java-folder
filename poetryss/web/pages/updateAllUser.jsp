<%--
  Created by IntelliJ IDEA.
  User: y
  Date: 2021/11/15
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>用户信息修改界面</title>
</head>

<body class="mybody">
<%@ include file="publicCss.jsp" %>
<%@ include file="publicJS.jsp"%>
<div class="container-fluid-m">
    <div>
        <p class="p">用户信息修改界面</p>
    </div>
    <form class="row g-3" action="${pageContext.request.contextPath}/UpdateUserServlet?id=${requestScope.user.id}" enctype="multipart/form-data" method="post">
        <div class="col-sm-10">
            <label for="id" class="col-sm-2 col-form-label">编号</label>
            <input type="text" readonly class="form-control" id="id" name="id" value="${requestScope.user.id}">
        </div>
        <div class="col-sm-10">
            <label for="username" class="col-sm-2 col-form-label">姓名</label>
            <input type="text"  class="form-control" id="username" name="username" VALUE="${requestScope.user.username}">
        </div>
        <div class="col-sm-10">
            <label for="password" class="col-sm-2 col-form-label">密码</label>
            <input type="text" class="form-control" id="password" name="password" value="${requestScope.user.password}">
        </div>
        <div class="col-sm-10">
            <div class="mb-1">
                <label for="userImg" class="col-sm-2 col-form-label">头像</label>
                <input type="file" name="userImg" id="userImg" value="${requestScope.user.userImg}">
            </div>
        </div>
        <div class="col-sm-10 button-w">
            <button type="submit" class="btn btn-primary mb-0" value="提交">提交</button>
            <button type="button" class="btn btn-primary mb-0" onclick="javascript:window.location='${pageContext.request.contextPath}/UserServlet'">取消</button>
        </div>
    </form>
</div>
</body>
</html>
