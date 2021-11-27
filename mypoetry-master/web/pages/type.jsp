<%--
  Created by IntelliJ IDEA.
  User: ljsy
  Date: 2021/11/11
  Time: 上午 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="head.jsp" %>
<c:set value="${requestScope.typePage}" var="typePage"/>
<c:set value="${requestScope.poetryPage}" var="poetryPage"/>
<c:set value="${requestScope.type}" var="nowType"/>
<c:set value="${pageContext.request.contextPath}" var="path"/>
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
                        <a class="nav-link" href="${pageContext.request.contextPath}/index">首页 <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/dynasty">朝代</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/author">作者</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link active" href="${pageContext.request.contextPath}/type">类型</a>
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

<!-- 类型 -->
<div class="container vw-50">
    <%--导航条--%>
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a class="" data-toggle="collapse" href="#type" role="button"
                                            aria-expanded="false" aria-controls="collapseExample">所有类型
            </a></li>
            <c:if test="${nowType!=null}">
                <li class="breadcrumb-item"><a href="${path}/type?type=${nowType.id}&tp=${typePage.pageNo}" >
                        ${nowType.typeName}
                </a></li>
            </c:if>
        </ol>
    </nav>

    <!-- 类型列表 -->
    <div
            <c:if test="${nowType != null}">class="border collapse "</c:if>
            <c:if test="${nowType == null}">class="border collapse show"</c:if>
            id="type">
        <div class="d-flex list-group flex-row flex-wrap">
            <c:forEach items="${requestScope.typeList}" var="type">
                <a
                        <c:if test="${nowType.id==type.id}">
                            href="#" class="btn line-btn btn-active"
                        </c:if>
                        <c:if test="${nowType.id!=type.id}">
                            href="${path}/type?type=${type.id}&tp=${typePage.pageNo}" class="btn line-btn"
                        </c:if>
                >
                        ${type.typeName}
                </a>
            </c:forEach>
        </div>
        <%--类型分页--%>
        <nav aria-label="Page navigation example ">
            <ul class="pagination justify-content-end">

                <c:if test="${typePage.pageNo==1}">
                    <li class="page-item disabled">
                        <a class="page-link" href="#">
                            上一页
                        </a>
                    </li>
                </c:if>
                <c:if test="${typePage.pageNo!=1}">
                    <li class="page-item">
                        <a class="page-link text-dark"
                           href="${path}/type?tp=${typePage.pageNo-1}">
                            上一页
                        </a>
                    </li>
                </c:if>

                <li class="page-item"><a class="page-link text-dark">${typePage.pageNo}/${typePage.totalPages}</a></li>

                <c:if test="${typePage.pageNo==typePage.totalPages}">
                    <li class="page-item disabled">
                        <a class="page-link" href="#">
                            下一页
                        </a>
                    </li>
                </c:if>
                <c:if test="${typePage.pageNo!=typePage.totalPages}">
                    <li class="page-item">
                        <a class="page-link text-dark"
                           href="${path}/type?tp=${typePage.pageNo+1}">
                            下一页
                        </a>
                    </li>
                </c:if>
            </ul>
        </nav>
    </div>

</div>
<!-- 类型结束 -->
<c:if test="${nowType!=null}">
    <!-- 展示诗词 -->
    <div class="container vw-50">
        <!-- 开始展示诗词 -->
        <c:forEach items="${requestScope.poetryList}" var="poetry">
            <div class="card">
                <div class="card-body">
                        <%--标题--%>
                    <h3><a class="card-title text-dark" href="${path}/poetry?poetry=${poetry.id}">${poetry.title}</a></h3>
                    <p>
                            <%--朝代 --%>
                        <a class="card-subtitle mb-2 text-muted" href="${path}/dynasty?dynasty=${poetry.author.dynasty.id}">
                            [${poetry.author.dynasty.dynastyName}]
                        </a>
                            <%--作者--%>
                        <a class="card-subtitle mb-2 text-muted" href="${path}/author-details?author=${poetry.author.id}">
                                ${poetry.author.name}
                        </a>
                    </p>
                        <%--诗句--%>
                    <c:forEach items="${poetry.content}" var="varse">
                        <p class="card-text">${varse}</p>
                    </c:forEach>
                </div>
            </div>

        </c:forEach>
            <%--诗词分页--%>
        <nav aria-label="Page navigation example ">
            <ul class="pagination justify-content-end">

                <c:if test="${poetryPage.pageNo==1}">
                    <li class="page-item disabled">
                        <a class="page-link" href="#">
                            上一页
                        </a>
                    </li>
                </c:if>
                <c:if test="${poetryPage.pageNo!=1}">
                    <li class="page-item">
                        <a class="page-link text-dark"
                           href="${path}/type?type=${nowType.id}&tp=${typePage.pageNo}&pp=${poetryPage.pageNo-1}">
                            上一页
                        </a>
                    </li>
                </c:if>

                <c:if test="${poetryPage.pageNo<poetryPage.totalPages}">
                    <li class="page-item"><a class="page-link text-dark">${poetryPage.pageNo}/...</a></li>
                </c:if>

                <c:if test="${poetryPage.pageNo==poetryPage.totalPages}">
                    <li class="page-item"><a class="page-link text-dark">${poetryPage.pageNo}/${poetryPage.pageNo}</a></li>
                    <li class="page-item disabled">
                        <a class="page-link" href="#">
                            下一页
                        </a>
                    </li>
                </c:if>
                <c:if test="${poetryPage.pageNo!=poetryPage.totalPages}">
                    <li class="page-item">
                        <a class="page-link text-dark"
                           href="${path}/type?type=${nowType.id}&tp=${typePage.pageNo}&pp=${poetryPage.pageNo+1}">
                            下一页
                        </a>
                    </li>
                </c:if>
            </ul>
        </nav>
    </div>
    <!-- 展示诗词结束 -->
</c:if>
<%@include file="footer.jsp" %>
</body>
</html>
