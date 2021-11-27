<%--
  Created by IntelliJ IDEA.
  User: y
  Date: 2021/11/15
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>诗词添加界面</title>
</head>
<body>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
    <%--    <script type="text/javascript" src="${pageContext.request.contextPath}/js/baseTool.js"></script>--%>
    <%--    <script type="text/javascript" src="${pageContext.request.contextPath}/js/alert.js"></script>--%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/alert.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/register.css"/>
</head>
<body class="mybody">
<%@include file="publicCss.jsp"%>
<%@include file="publicJS.jsp"%>
<div class="container-fluid-m">
    <div>
        <p class="p">诗词添加界面</p>
    </div>
    <form class="row g-3" id="updatePoetryForm" action=“${pageContext.request.contextPath}/AddPoetryServlet”
          method="post">
        <div class="col-sm-10">
            <label for="title" class="col-sm-2 col-form-label">标题</label>
            <input type="text" class="form-control" id="title" name="title">
        </div>
        <div class="col-sm-10">
            <label for="author" class="col-sm-2 col-form-label">作者</label>
            <input type="text" class="form-control" id="author" name="author">
        </div>
        <div class="col-sm-10">
            <div class="mb-1">
                <label for="content" class="col-sm-2 col-form-label">内容</label>
                <textarea class="form-control" id="content" name="content" rows="3"></textarea>
            </div>
        </div>
        <div class="col-sm-10">
            <div class="mb-0">
                <label for="translate" class="col-sm-2 col-form-label">诗词翻译</label>
                <textarea class="form-control" id="translate" name="translate" rows="3"></textarea>
            </div>
        </div>
        <div class="col-sm-10">
            <div class="mb-0">
                <label for="translate_res" class="col-sm-3 col-form-label">诗词翻译来源</label>
                <textarea class="form-control" id="translate_res" name="translate_res" rows="3"></textarea>
            </div>
        </div>
        <div class="col-sm-10">
            <div class="mb-0">
                <label for="notes" class="col-sm-2 col-form-label">诗词注释</label>
                <textarea class="form-control" id="notes" name="notes" rows="3"></textarea>
            </div>
        </div>
        <div class="col-sm-10">
            <div class="mb-0">
                <label for="appreciation" class="col-sm-2 col-form-label">诗词解析</label>
                <textarea class="form-control" id="appreciation" name="appreciation" rows="3"></textarea>
            </div>
        </div>
        <div class="col-sm-10">
            <div class="mb-0">
                <label for="appreciation_res" class="col-sm-3 col-form-label">诗词解析来源</label>
                <textarea class="form-control" id="appreciation_res" name="appreciation_res" rows="3"></textarea>
            </div>
        </div>
        <div class="col-sm-10">
            <label for="type" class="col-sm-2 col-form-label">诗词类型</label>
            <input type="type" class="form-control" id="type">
        </div>
        <div class="col-sm-10 button-w">
            <button type="submit" class="btn btn-primary mb-0">提交</button>
            <button type="button" class="btn btn-primary mb-0"
                    onclick="javascript:window.location='${pageContext.request.contextPath}/PoetryServlet'">取消
            </button>
        </div>
    </form>
</div>
</body>
</html>
