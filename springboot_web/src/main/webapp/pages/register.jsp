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
                注册
            </h1>
            <form action="login.html" method="post">
                <table cellpadding="0" cellspacing="0" border="0"
                       class="form_table">
                    <tr>
                        <td valign="middle" align="right">
                            用户名:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="username" />
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            真实姓名:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="name" />
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            密码:
                        </td>
                        <td valign="middle" align="left">
                            <input type="password" class="inputgri" name="pwd" />
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            性别:
                        </td>
                        <td valign="middle" align="left">
                            男
                            <input type="radio" class="inputgri" name="sex" value="m" checked="checked"/>
                            女
                            <input type="radio" class="inputgri" name="sex" value="f"/>
                        </td>
                    </tr>

                    <tr>
                        <td valign="middle" align="right">
                            验证码:
                            <img id="num" src="image" />
                            <a href="javascript:;" onclick="document.getElementById('num').src = 'image?'+(new Date()).getTime()">换一张</a>
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="number" />
                        </td>
                    </tr>
                </table>
                <p>
                    <input type="submit" class="button" value="Submit &raquo;" />
                </p>
            </form>
        </div>
    </div>
    <%--引入公共的底部--%>
    <%@include file="publicFoot.jsp" %>
</div>
</body>
</html>
