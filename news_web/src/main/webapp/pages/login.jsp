<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--
 * @Author: your name
 * @Date: 2020-05-25 15:11:40
 * @LastEditTime: 2020-05-25 16:55:39
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /bootstrap-project/news/login.html
-->
<!--
 *                        _oo0oo_
 *                       o8888888o
 *                       88" . "88
 *                       (| -_- |)
 *                       0\  =  /0
 *                     ___/`---'\___
 *                   .' \\|     |// '.
 *                  / \\|||  :  |||// \
 *                 / _||||| -:- |||||- \
 *                |   | \\\  - /// |   |
 *| \_|  ''\---/''  |_/ |
 *                \  .-\__  '-'  ___/-. /
 *                              ___'. .'  /--.--\  `. .'___
 *           ."" '<  `.___\_<|>_/___.' >' "".
 *          | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 *          \  \ `_.   \_ __\ /__ _/   .-` /  /
 *      =====`-.____`.___ \_____/___.-`___.-'=====
 *                        `=---='
 * 
 * 
 *      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 
 *            佛祖保佑       永不宕机     永无BUG
 -->

<!--
    
 * @Author: wx
 * @Date: 2020-05-23 14:27:34
 * @LastEditTime: 2020-05-23 14:47:12
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /bootstrap-project/news/index.html
-->


<html lang="zh-CN">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>新闻</title>
</head>

<body>
	<!-- 公共的css部分 -->
	<%@ include file ="publicCSS.jsp"%>
    <!-- 公共导航栏部分 -->
    <%@ include file ="head.jsp"%>
    
    <!-- 中间内容部分 -->
    <div class="container container-small">
        <h1>登录
            <small>没有账号？<a href="${pageContext.request.contextPath}/pages/register.jsp">注册</a></small>
        </h1>
        <form action="${pageContext.request.contextPath }/loginServlet" method="POST" onsubmit ="return checkLogin()">
            <div class="form-group">
                <label>用户名/手机/邮箱</label>
                <input class="form-control" name="username" id ="username" onblur="check()" value="${requestScope.username}" required/>
                <span id = "nameMsg">${msg}</span>
                <input type="hidden" value ="${pageContext.request.contextPath }/" id="url">
                <span id="msg"></span>
                <input type ="hidden" id ="flag" name="flag" value="登录">
            </div>
            <div class="form-group">
                <label>密码</label>
                <input type="password" class="form-control" name="password" id="password" required/>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block">登录</button>
            </div>
            <div class="form-group">
                <a href="#">忘记密码?</a>
            </div>
        </form>
    </div>

  	<!-- 公共页面底部部分 -->
  	<%@ include file ="footer.jsp"%>
  	<!-- 引入公共的js -->
  	<%@ include file ="publicJS.jsp" %>
  	<!-- 引入登录的login.js -->
  	<script src="${pageContext.request.contextPath }/js/login.js"></script>
</body>

</html>