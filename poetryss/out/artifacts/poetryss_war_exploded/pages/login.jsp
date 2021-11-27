<%--
  Created by IntelliJ IDEA.
  User: y
  Date: 2021/11/10
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--引入公共的css--%>
<%@ include file="publicCss.jsp"%>
<%--引入公共的js--%>
<%@ include file="publicJS.jsp"%>
<!-- 头部 end -->
<section id="login_wrap">
    <div class="fullscreen-bg" style="background: url(../images/login.jpg) no-repeat;height: 935px;">

    </div>
    <div class="login-box">
        <div class="title">
            <img src="images/login.jfif" alt="">
            <span>欢迎登录古诗文后台管理系统</span>
        </div>
        <div class="login_inner">


            <form id="loginForm" action="${pageContext.request.contextPath}/LoginServlet" method="post" accept-charset="utf-8">
<%--                <!--登录错误提示消息-->--%>
<%--                <div id="errorMsg" class="alert alert-danger">--%>
<%--                    <input type="hidden" name="errorMsg" value="${errorMsg}">--%>
<%--                </div>--%>
                <input type="hidden" name="action" value="login"/>
                <input name="username" type="text" placeholder="请输入账号" autocomplete="off">
                <input name="password" type="text" placeholder="请输入密码" autocomplete="off">
                <div class="submit_btn">
                    <button type="submit">登录</button>
                </div>
            </form>
        </div>
    </div>
</section>
<!--引入尾部-->
<div id="footer"></div>
</body>
</html>
