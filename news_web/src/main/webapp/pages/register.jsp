<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--
 * @Author: your name
 * @Date: 2020-05-25 15:11:40
 * @LastEditTime: 2020-05-25 16:55:46
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
 *                | \_|  ''\---/''  |_/ |
 *                \  .-\__  '-'  ___/-. /
 *              ___'. .'  /--.--\  `. .'___
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
        <h1>注册
            <small>没有账号？<a href="register.jsp">注册</a></small>
        </h1>
        <form action="${pageContext.request.contextPath }/RegServlet" method="POST" onsubmit="return checkForm()">
            <div class="form-group">
                <label>用户名/手机/邮箱</label>
                <input class="form-control" name="username" id="username" onblur="checkUser()" required/>
                <span id ="nameMsg" style="color:red">${msg}</span>
                <input type="hidden" id="url" value="${pageContext.request.contextPath }/">
                
                <!-- 提交到servlet的页面标识 -->
                <input type="hidden" id="flag" name= "flag" value="注册">
            </div>
            <div class="form-group">
                <label>验证码</label>
                <div class="input-group">
                    <input class="form-control" name="yzm" />
                    <div class="input-group-btn">
                        <div class="btn btn-default">
                            获取验证码
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label>密码</label>
                <input type="password" class="form-control" name="password" id="password" required/>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block">注册</button>
            </div>
            <div class="form-group">
                注册华信智原就代表您同意<a href="#">华信服务条款</a>
            </div>
        </form>
    </div>
	<!-- 公共页面底部部分 -->
  	<%@ include file ="footer.jsp"%>
  	<!-- 引入公共的js -->
  	<%@ include file = "publicJS.jsp" %>
	<!-- 引入注册的register.js -->
	<script src = "${pageContext.request.contextPath }/js/register.js"></script>
</body>

</html>