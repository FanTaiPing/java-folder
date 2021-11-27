<%--
  Created by IntelliJ IDEA.
  User: ljsy
  Date: 2021/11/11
  Time: 上午 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="head.jsp" %>
<c:set value="${requestScope.page}" var="page"/>
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
                        <a class="nav-link active" href="${pageContext.request.contextPath}/index">首页 <span
                                class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/dynasty">朝代</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/author">作者</a>
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

<!-- 搜索结果 -->
<div class="container vw-50">

    <!-- 搜索结果导航条 -->
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item collapse-btn"><a
                    href="${path}/result?words=${requestScope.words}">搜索"${requestScope.words}"</a></li>
            <c:if test="${requestScope.author!=null}">
                <li class="breadcrumb-item collapse-btn"><a href="${path}/result?author=${requestScope.author}">搜索作者</a>
                </li>
            </c:if>
            <c:if test="${requestScope.title!=null}">
                <li class="breadcrumb-item collapse-btn"><a href="${path}/result?title=${requestScope.title}">搜索标题</a>
                </li>
            </c:if>
            <c:if test="${requestScope.content!=null}">
                <li class="breadcrumb-item collapse-btn"><a
                        href="${path}/result?content=${requestScope.content}">搜索内容</a>
                </li>
            </c:if>
        </ol>
    </nav>

    <!-- 搜索结果 -->
    <div class="collapse show" id="search">

        <c:if test="${requestScope.authorList==null&&requestScope.titlePoetryList==null&&requestScope.contentPoetryList==null}">
            <div class="h-50">
                <div class="alert alert-secondary">
                    踏破铁鞋无觅处, 什么东西都没有......
                </div>
            </div>
        </c:if>

        <!-- 三个作者结果 -->
        <c:if test="${requestScope.authorList!=null}">
            <c:forEach items="${requestScope.authorList}" var="author">
                <div class="bd-callout">
                    <h5><a href="${path}/author-details?author=${author.id}">${author.name}</a></h5>
                    <p>${author.lifeTime}</p>
                </div>
            </c:forEach>
            <%--作者不为空, 是作者搜索结果--%>
            <c:if test="${requestScope.author==null}">
                <div class="alert alert-secondary ">
                    <a href="${path}/result?author=${requestScope.words}">更多作者搜索结果...</a>
                </div>
            </c:if>
            <%--分页--%>
            <c:if test="${requestScope.author!=null}">
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
                                   href="${path}/author?dynasty=${requestScope.dynasty}&page=${page.pageNo-1}">
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
                                   href="${path}/author?dynasty=${requestScope.dynasty}&page=${page.pageNo+1}">
                                    下一页
                                </a>
                            </li>
                        </c:if>
                    </ul>
                </nav>
            </c:if>
        </c:if>

        <!-- 三个标题结果 -->
        <c:if test="${requestScope.titlePoetryList!=null}">
            <c:forEach items="${requestScope.titlePoetryList}" var="poetry">
                <div class="card">
                    <div class="card-body">
                        <h3><a class="card-title text-dark"
                               href="${path}/poetry?poetry=${poetry.id}">${poetry.title}</a></h3>
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
            <%--标题不为空, 是标题搜索结果--%>
            <c:if test="${requestScope.title==null}">
                <div class="alert alert-secondary ">
                    <a href="${path}/result?title=${requestScope.words}">更多诗词标题搜索结果...</a>
                </div>
            </c:if>
            <%--分页--%>
            <c:if test="${requestScope.title!=null}">
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
                                   href="${path}/result?title=${requestScope.title}&page=${page.pageNo-1}">
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
                                   href="${path}/result?title=${requestScope.title}&page=${page.pageNo+1}">
                                    下一页
                                </a>
                            </li>
                        </c:if>
                    </ul>
                </nav>
            </c:if>
        </c:if>

        <!-- 三个内容结果 -->
        <c:if test="${requestScope.contentPoetryList!=null}">
            <c:forEach items="${requestScope.contentPoetryList}" var="poetry">
                <div class="card">
                    <div class="card-body">
                        <h3><a class="card-title text-dark"
                               href="${path}/poetry?poetry=${poetry.id}">${poetry.title}</a></h3>
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
            <%--内容不为空, 是内容搜索结果--%>
            <c:if test="${requestScope.content==null}">
                <div class="alert alert-secondary ">
                    <a href="${path}/result?content=${requestScope.words}">更多诗词内容搜索结果...</a>
                </div>
            </c:if>
        </c:if>

        <%--分页--%>
        <c:if test="${requestScope.content!=null}">
            <%--分页--%>
            <nav aria-label="Page navigation example ">
                <ul class="pagination justify-content-end">

                    <c:if test="${page.pageNo==1}">
                        <li class="page-item disabled">
                            <a class="page-link " href="#">
                                上一页
                            </a>
                        </li>
                    </c:if>
                    <c:if test="${page.pageNo!=1}">
                        <li class="page-item">
                            <a class="page-link text-dark"
                               href="${path}/result?content=${requestScope.content}&page=${page.pageNo-1}">
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
                               href="${path}/result?content=${requestScope.content}&page=${page.pageNo+1}">
                                下一页
                            </a>
                        </li>
                    </c:if>
                </ul>
            </nav>
        </c:if>
    </div>
</div>
<!-- 搜索结果结束 -->

<%@include file="footer.jsp" %>
</body>
</html>
