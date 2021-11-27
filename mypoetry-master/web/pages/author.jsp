<%--
  Created by IntelliJ IDEA.
  User: ljsy
  Date: 2021/11/12
  Time: 下午 9:04
  To change this template use File | Settings | File Templates.
--%>
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
                        <a class="nav-link" href="${pageContext.request.contextPath}/index">首页 <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/dynasty">朝代</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="${pageContext.request.contextPath}/author">作者</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/type">类型</a>
                    </li>
                </ul>
                <form action="${path}/result" class="form-inline my-2 my-lg-0">
                    <input required name="words" class="form-control mr-sm-2" type="search" placeholder="搜索" aria-label="Search">
                    <button class="btn btn-outline-dark my-2 my-sm-0" type="submit">搜索</button>
                </form>
            </div>
        </div>
    </nav>
</header>
<!-- 导航栏结束 -->

<!-- 分类栏 -->
<div class="container vw-50">
    <%--导航条--%>
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a class="" data-toggle="collapse" href="#dynasty" role="button"
                                           aria-expanded="false" aria-controls="collapseExample">
                <%--请求中有朝代则显示朝代名--%>
                <c:if test="${requestScope.dynasty == 0}">所有朝代</c:if>
                <c:if test="${requestScope.dynasty != null}">${requestScope.dynastyList[requestScope.dynasty-1].dynastyName}</c:if>
            </a></li>
            <li class="breadcrumb-item"><a class="" data-toggle="collapse" href="#pinyin" role="button"
                                           aria-expanded="false" aria-controls="collapseExample">
                <%--有拼音则显示当前拼音--%>
                <c:if test="${requestScope.pinyin == null}">所有拼音</c:if>
                <c:if test="${requestScope.pinyin != null}"> ${requestScope.pinyin} </c:if>
            </a></li>
            <li class="breadcrumb-item">作者</li>
        </ol>
    </nav>
    <!-- 朝代列表 -->
    <div class="border collapse show" id="dynasty">
        <div class="d-flex list-group flex-row flex-wrap">
            <c:forEach items="${requestScope.dynastyList}" var="dynasty">
                <a
                        <c:if test="${requestScope.dynasty==dynasty.id}">
                            href="#" class="btn line-btn btn-active"
                        </c:if>
                        <c:if test="${requestScope.dynasty!=dynasty.id}">
                            href="${path}/author?dynasty=${dynasty.id}" class="btn line-btn"
                        </c:if>
                >
                        ${dynasty.dynastyName}
                </a>
            </c:forEach>
        </div>
    </div>

    <!-- 拼音 -->
    <div class="card collapse show" id="pinyin">
        <!-- 拼音列表 -->
        <div class="pinyin d-flex list-group flex-row flex-wrap">
            <c:forEach items="${requestScope.pinyinList}" var="pinyin">
                <a href="${path}/author?dynasty=${requestScope.dynasty}&pinyin=${pinyin}"
                        <c:if test="${pinyin == requestScope.pinyin}"> class="btn line-btn btn-active"</c:if>
                        <c:if test="${pinyin != requestScope.pinyin}"> class="btn line-btn"</c:if>
                >
                        ${pinyin}
                </a>
            </c:forEach>

        </div>
    </div>

    <!-- 作者结果 -->
    <div class="border collapse show" id="author">
        <div class="d-flex list-group flex-row flex-wrap">
            <c:forEach items="${requestScope.authorList}" var="author">
                <a href="${path}/author-details?author=${author.id}" class="btn line-btn">${author.name}</a>
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
                               href="${path}/author?dynasty=${requestScope.dynasty}&pinyin=${requestScope.pinyin}&page=${page.pageNo-1}">
                                上一页
                            </a>
                        </li>
                    </c:if>

                    <li class="page-item"><a class="page-link text-dark">${page.pageNo}/${page.totalPages}</a></li>

                    <c:if test="${page.pageNo==page.totalPages}">
                        <li class="page-item disabled">
                            <a class="page-link" href="#">
                                下一页
                            </a>
                        </li>
                    </c:if>
                    <c:if test="${page.pageNo!=page.totalPages}">
                        <li class="page-item">
                            <a class="page-link text-dark"
                               href="${path}/author?dynasty=${requestScope.dynasty}&pinyin=${requestScope.pinyin}&page=${page.pageNo+1}">
                                下一页
                            </a>
                        </li>
                    </c:if>
                </ul>
            </nav>
        </div>
    </div>
</div>
<!-- 分类栏结束 -->

<%@include file="footer.jsp" %>
</body>
</html>
