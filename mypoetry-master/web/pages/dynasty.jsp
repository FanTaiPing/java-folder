<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ljsy
  Date: 2021/11/12
  Time: 下午 9:04
  To change this template use File | Settings | File Templates.
--%>
<%--显示朝代列表或朝代详情--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="head.jsp" %>
<body>
<c:set value="${requestScope.page}" var="page"/>
<c:set value="${pageContext.request.contextPath}" var="path"/>
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
                        <a class="nav-link active" href="${pageContext.request.contextPath}/dynasty">朝代</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/author">作者</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/type">类型</a>
                    </li>
                </ul>
                <form action="${path}/result" class="form-inline my-2 my-lg-0">
                    <input required name="words"  class="form-control mr-sm-2" type="search" placeholder="搜索" aria-label="Search">
                    <button class="btn btn-outline-dark my-2 my-sm-0" type="submit">搜索</button>
                </form>
            </div>
        </div>
    </nav>
</header>
<!-- 导航栏结束 -->

<!-- 分类栏 -->
<div class="container vw-50">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a class="" data-toggle="collapse" href="#dynasty" role="button"
                                           aria-expanded="false" aria-controls="collapseExample">所有朝代</a></li>
            <c:if test="${requestScope.dynasty!=null}">
                <li class="breadcrumb-item"><a href="${path}/dynasty?dynasty=${requestScope.dynasty.id}" >
                        ${requestScope.dynasty.dynastyName}
                </a></li>
            </c:if>
        </ol>
    </nav>

    <!-- 朝代列表 -->
    <div class="border collapse show" id="dynasty">
        <div class="d-flex list-group flex-row flex-wrap">
            <c:forEach items="${requestScope.dynastyList}" var="dynasty" >
                <a
                        <c:if test="${requestScope.dynasty.id==dynasty.id}">
                            href="#" class="btn line-btn btn-active"
                        </c:if>
                        <c:if test="${requestScope.dynasty.id!=dynasty.id}">
                            href="${path}/dynasty?dynasty=${dynasty.id}" class="btn line-btn"
                        </c:if>
                        >
                        ${dynasty.dynastyName}
                </a>
            </c:forEach>
        </div>
    </div>
</div>
<!-- 分类栏结束 -->

<!-- 展示朝代和诗词-->
<div class="container vw-50">
    <!-- 显示朝代详情 -->
    <c:if test="${requestScope.dynasty != null}">
        <div class="bd-callout">
            <h5>${requestScope.dynasty.dynastyName}</h5>
            <c:forEach items="${requestScope.dynasty.describe}" var="desc">
                <p>${desc}</p>
            </c:forEach>
        </div>
    </c:if>
    <!-- 开始展示诗词 -->
    <c:forEach items="${requestScope.poetryList}" var="poetry">
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
                    <a class="page-link text-dark"
                       href="${path}/dynasty?dynasty=${requestScope.dynasty.id}&page=${page.pageNo-1}">
                        上一页
                    </a>
                </li>
            </c:if>

            <c:if test="${page.pageNo<page.totalPages}">
                <li class="page-item"><a class="page-link text-dark">${page.pageNo}/...</a></li>
            </c:if>

            <c:if test="${page.pageNo==page.totalPages}">
                <li class="page-item"><a class="page-link text-dark">${page.pageNo}/${page.pageNo}</a></li>
                <li class="page-item disabled">
                    <a class="page-link" href="#">
                        下一页
                    </a>
                </li>
            </c:if>
            <c:if test="${page.pageNo!=page.totalPages}">
                <li class="page-item">
                    <a class="page-link text-dark"
                       href="${path}/dynasty?dynasty=${requestScope.dynasty.id}&page=${page.pageNo+1}">
                        下一页
                    </a>
                </li>
            </c:if>
        </ul>
    </nav>
</div>
<!-- 展示朝代和诗词结束 -->

<%@include file="footer.jsp" %>
</body>
</html>