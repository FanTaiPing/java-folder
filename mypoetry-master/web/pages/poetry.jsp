<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ljsy
  Date: 2021/11/13
  Time: 下午 2:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set value="${requestScope.page}" var="page"/>
<c:set value="${pageContext.request.contextPath}" var="path"/>
<c:set value="${requestScope.poetry}" var="showPoetry"/>
<html>
<%@include file="head.jsp" %>
<body>

<!-- 导航栏 -->
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-sm">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/index">古诗词网</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/index">首页 <span
                                class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/dynasty">朝代</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="${pageContext.request.contextPath}/author">作者</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/type">类型</a>
                    </li>
                </ul>
                <form action="${path}/result" class="form-inline my-2 my-lg-0">
                    <input  required name="words"  class="form-control mr-sm-2" type="search" placeholder="搜索" aria-label="Search">
                    <button class="btn btn-outline-dark my-2 my-sm-0" type="submit">搜索</button>
                </form>
            </div>
        </div>
    </nav>
</header>
<!-- 导航栏结束 -->

<!-- 展示诗词 -->
<div class="container vw-50 full-poetry">
    <%--导航条--%>
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a
                    href="${pageContext.request.contextPath}/author?dynasty=${showPoetry.author.dynasty.id}">${showPoetry.author.dynasty.dynastyName}</a>
            </li>
            <li class="breadcrumb-item">
                <a href="${pageContext.request.contextPath}/author-details?author=${showPoetry.author.id}">
                    ${showPoetry.author.name}
                </a>
            </li>
            <li class="breadcrumb-item">
                <a href="${pageContext.request.contextPath}/poetry?poetry=${showPoetry.id}">
                    ${showPoetry.title.split("/")[0]}
                </a>
            </li>
            <c:if test="${page.pageNo>1}">
                <li class="breadcrumb-item text-muted">相似推荐 第${page.pageNo}页</li>
            </c:if>
        </ol>
    </nav>

    <c:if test="${page.pageNo == 1}">
        <div class="card">
            <div class="card-body">
                <h3><span class="card-title text-dark">${showPoetry.title}</span></h3>
                <p>
                    <a class="card-subtitle mb-2 text-muted"
                       href="${path}/dynasty?dynasty=${showPoetry.author.dynasty.id}">[${showPoetry.author.dynasty.dynastyName}]</a>
                    <a class="card-subtitle mb-2 text-muted"
                       href="${pageContext.request.contextPath}/author-details?author=${showPoetry.author.id}">${showPoetry.author.name}</a>
                </p>
                    <%--诗句--%>
                <c:forEach items="${showPoetry.content}" var="varse">
                    <p class="card-text">${varse}</p>
                </c:forEach>
            </div>
                <%--注释等--%>
            <div class="card-footer">
                <button class="btn card-link explanation-btn btn-active">注释</button>
                <button class="btn card-link explanation-btn">翻译</button>
                <button class="btn card-link explanation-btn">赏析</button>
                <button class="btn card-link explanation-btn">作者</button>
                <div class=" explanation">
                    <!-- 注释 -->
                    <div class="show notes">
                        <c:forEach items="${showPoetry.notes}" var="note">
                            <p>${note}</p>
                        </c:forEach>
                    </div>
                    <!-- 翻译 -->
                    <div class="hide translate">
                        <c:forEach items="${showPoetry.translate}" var="translate">
                            <p>${translate}</p>
                        </c:forEach>
                        <c:forEach items="${showPoetry.translateRes}" var="translateRes">
                            <p class="res text-muted">${translateRes}</p>
                        </c:forEach>
                    </div>
                    <!-- 赏析 -->
                    <div class="hide appreciation">
                        <c:forEach items="${showPoetry.appreciation}" var="appr">
                            <p>${appr}</p>
                        </c:forEach>
                    </div>
                    <!-- 作者介绍 -->
                    <div class="hide author">
                        <p>${showPoetry.author.lifeTime}</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="alert alert-secondary m-top-lg">
            与"${showPoetry.title.split("/")[0]}"相似的诗词
        </div>
    </c:if>
    <%--同类型诗词--%>
    <c:forEach items="${requestScope.list}" var="poetry">
        <div class="card">
            <div class="card-body">
                <h3><a class="card-title text-dark" href="${path}/poetry?poetry=${poetry.id}">${poetry.title}</a></h3>
                <p>
                    <a class="card-subtitle mb-2 text-muted"
                       href="${path}/dynasty?dynasty=${poetry.author.dynasty.id}">[${poetry.author.dynasty.dynastyName}]</a>
                    <a class="card-subtitle mb-2 text-muted"
                       href="${path}/author-details?author=${poetry.author.id}">${poetry.author.name}</a>
                </p>
                    <%--诗句--%>
                <c:forEach items="${poetry.content}" var="varse">
                    <p class="card-text">${varse}</p>
                </c:forEach>
            </div>
        </div>
    </c:forEach>
    <%--分页--%>
    <nav aria-label="Page navigation example ">
        <ul class="pagination justify-content-end">
            <c:if test="${page.pageNo==1}">
                <li class="page-item disabled">
                    <a class="page-link" href="#">
                        上一页
                    </a>
                </li>
            </c:if>
            <c:if test="${page.pageNo!=1}">
                <li class="page-item">
                    <a class="page-link text-dark" href="${path}/poetry?poetry=${showPoetry.id}&page=${page.pageNo-1}">
                        上一页
                    </a>
                </li>
            </c:if>

            <li class="page-item"><a class="page-link text-dark">${page.pageNo}/${page.totalPages}</a></li>

            <c:if test="${page.pageNo==page.totalPages}">
                <li class="page-item disabled"><a class="page-link" href="#">下一页</a></li>
            </c:if>
            <c:if test="${page.pageNo!=page.totalPages}">
                <li class="page-item"><a class="page-link text-dark"
                                         href="${path}/poetry?poetry=${showPoetry.id}&page=${page.pageNo+1}">下一页</a>
                </li>
            </c:if></ul>
    </nav>
</div>
<!-- 展示诗词结束 -->

<%@include file="footer.jsp" %>
</body>
</html>
