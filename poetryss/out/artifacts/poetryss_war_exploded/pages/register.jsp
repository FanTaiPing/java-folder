<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link rel="shortcut icon" href="/favicon.ico" />
    <link rel="bookmark" href="/favicon.ico" type="image/x-icon"/>
    <!-- 设置缓存 -->
    <!-- 设定网页的到期时间  -->
    <meta http-equiv="Expires" content="-1">
    <!-- 清除缓存（再访问这个网站要重新下载！） -->
    <meta http-equiv="Cache-Control" content="no-cache">
    <!-- 禁止浏览器从本地机的缓存中调阅页面内容，访问者将无法脱机浏览 -->
    <meta http-equiv="Pragma" content="no-cache">

    <!-- author用于定义网页作者 -->
    <meta name="author" content="aicoder.com">
    <!-- 就是当点击网页添加至主屏幕功能时，会在主屏幕上生成一个图标。点击该图标会进入webapp功能。就是模拟本地应用的模式来浏览web页面。 -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <!-- 当启动webapp功能时，显示手机信号、时间、电池的顶部导航栏的颜色。默认值为default（白色），可以定为black（黑色）和black-translucent（灰色半透明）。这个主要是根据实际的页面设计的主体色为搭配来进行设置。 -->
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <!-- 添加到主屏幕后，app全屏显示 -->
    <meta content="yes" name="apple-touch-fullscreen" />

    <!-- 默认设备会自动识别任何可能是电话和邮箱的字符串。设置telephone=no可以禁用这项功能。 -->
    <meta content="telephone=no,email=no" name="format-detection" />

    <!-- UC浏览器私有 -->
    <!-- 全屏模式 -->
    <meta name="full-screen" content="yes">
    <!-- 应用模式 -->
    <meta name="browsermode" content="application">

    <!-- QQ浏览器私有 -->
    <!-- 全屏模式 -->
    <meta name="x5-fullscreen" content="true">
    <!-- 应用模式 -->
    <meta name="x5-page-mode" content="app">
    <meta name="App-Config" content="fullscreen=yes,useHistoryState=yes,transition=yes" />
    <title>注册页面</title>
</head>
<body>
<form id="registerForm" class="form-inline" action="${pageContext.request.contextPath}/registerUserServlet" method="post">
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
                <span>欢迎使用古诗文后台管理系统</span>
            </div>
            <div class="login_inner">
                    <input type="hidden" name="action" value="register"/>
                    <input name="username" id="username" type="text" placeholder="请输入账号" required>
                    <input name="password" id="password" type="text" placeholder="请输入密码" autocomplete="off" required>
                    <div class="submit_btn">
                        <button type="submit">注册</button>
                    </div>
            </div>
        </div>
    </section>
    <!--引入尾部-->
    <div id="footer"></div>
</form>
</body>
</html>