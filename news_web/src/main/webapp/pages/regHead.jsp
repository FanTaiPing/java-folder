<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!-- 导航栏 -->
    <div class="navbar navbar-default">
        <!-- container为了跟下面内容对齐 -->
        <div class="container">
            <div class="navbar-header">
                <!-- logo -->
                <a class="navbar-brand" href="index.jsp">
                </a>
            </div>
            <label for="toggle-checkbox" id="toggle-label" class="visible-xs-inline-block">MENU</label>            <input class="hidden" type="checkbox" id="toggle-checkbox" />
            <!-- 头部导航栏 -->
            <div class="hidden-xs">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="index.jsp">首页</a></li>
                    <li><a href="#">国内</a></li>
                    <li><a href="#">国际</a></li>
                    <li><a href="#">数读</a></li>
                    <li><a href="#">社会</a></li>
                    <li><a href="#">联系我们</a></li>
                </ul>
                <!-- 登录注册导航栏 -->
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="login.jsp">登录</a></li>
                    <li><a href="register.jsp">注册</a></li>
                </ul>
            </div>
        </div>
    </div>

</body>
</html>