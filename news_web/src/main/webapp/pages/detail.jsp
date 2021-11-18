<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
	import="service.*,service.impl.*,java.util.*,entity.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: ljsy
  Date: 2021/9/29
  Time: 上午 10:23
  To change this template use File | Settings | File Templates.
--%>
<html lang="zh-CN">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>新闻详情页</title>
</head>

<body>
	<!-- 公共的css部分 -->
	<%@ include file="publicCSS.jsp"%>
	<%--导入导航栏导入--%>
	<%@ include file="head.jsp"%>

<%-- 	<%
	NewsService newsService = new NewsServiceImpl();
	NewsTypeService newsTypeService = new NewsTypeServiceImpl();
	//将string类型强转为int	
	int id = Integer.parseInt(request.getParameter("id"));
	List<News> newsId = newsService.findDetail(id);

	request.setAttribute("newsId", newsId);
	
	if(request.getAttribute("news") ==null){
		List<News> news = newsService.findAll();
		request.setAttribute("news",news);	
	}else{
		request.removeAttribute("news");
	}
	

	if(request.getAttribute("newsTypeName") ==null){
		
		List<NewsType> newsTypeName = newsTypeService.findTypeId(id);
		request.setAttribute("newsTypeName",newsTypeName);	
		
	}else{
		request.removeAttribute("newsTypeName");
	}
	%> --%>

	<!-- 中间内容部分 -->
	<div class="container">
		<div class="col-md-8">
			<c:forEach items="${requestScope.newsId}" var="newsId">
				<h1 class="news-title">${newsId.title }</h1>
				<div class="news-status">
					25K阅读 ·65分钟前发布
					<c:forEach items="${requestScope.newsTypeName}" var ="newsTypeName">
					<div class="label label-default">${newsId.author }</div>
					<div class="label label-default">${newsTypeName.name }</div>
					</c:forEach>					
				</div>

				<div class="news-content">
					<div>${newsId.content }</div>
					<img
						src="${pageContext.request.contextPath }/image/images/${newsId.laImg}"
						alt="">
				</div>

			</c:forEach>
		</div>
		<!-- 右边侧边栏 -->
		<div class="col-md-4">
			<div class="side-bar-card">
				<div class="card-title">相关推荐</div>
				<div class="card-body">
					<div class="list">
						<c:forEach items="${requestScope.hotNews }" var="hotNews">
							<div class="item clearfix">
								<div class="col-xs-5 no-padding-h">
									<img
										src="${pageContext.request.contextPath }/image/images/${hotNews.smImg}"
										alt="自定义图片">
								</div>
								<div class="col-xs-7">
									<div class="title"><a href="${pageContext.request.contextPath}/DetailServlet?id=${hotNews.id}">${hotNews.desc }</a></div>
									<div class="desc">15K阅读 66分钟前发布</div>
								</div>
							</div>


						</c:forEach>


						<!-- <div class="item clearfix">
							<div class="col-xs-5 no-padding-h">
								<img src="https://dummyimage.com/1000x700/666/ccc" alt="自定义图片">
							</div>
							<div class="col-xs-7">
								<div class="title">eveniet animi mollitia ipsum</div>
								<div class="desc">15K阅读 66分钟前发布</div>
							</div>
						</div>
						<div class="item clearfix">
							<div class="col-xs-5 no-padding-h">
								<img src="https://dummyimage.com/1000x700/666/ccc" alt="自定义图片">
							</div>
							<div class="col-xs-7">
								<div class="title">eveniet animi mollitia ipsum</div>
								<div class="desc">15K阅读 66分钟前发布</div>
							</div>
						</div>
						<div class="item clearfix">
							<div class="col-xs-5 no-padding-h">
								<img src="https://dummyimage.com/1000x700/666/ccc" alt="自定义图片">
							</div>
							<div class="col-xs-7">
								<div class="title">eveniet animi mollitia ipsum</div>
								<div class="desc">15K阅读 66分钟前发布</div>
							</div>
						</div>
						<div class="item clearfix">
							<div class="col-xs-5 no-padding-h">
								<img src="https://dummyimage.com/1000x700/666/ccc" alt="自定义图片">
							</div>
							<div class="col-xs-7">
								<div class="title">eveniet animi mollitia ipsum</div>
								<div class="desc">15K阅读 66分钟前发布</div>
							</div>
						</div>
						<div class="item clearfix">
							<div class="col-xs-5 no-padding-h">
								<img src="https://dummyimage.com/1000x700/666/ccc" alt="自定义图片">
							</div>
							<div class="col-xs-7">
								<div class="title">eveniet animi mollitia ipsum</div>
								<div class="desc">15K阅读 66分钟前发布</div>
							</div>
						</div> -->


					</div>
				</div>
			</div>
			<div class="side-bar-card">
				<div class="card-title">24小时热闻</div>
				<div class="card-body">
					<div class="list">
						<c:forEach items="${requestScope.hotNews }" var="hotNews">
							<div class="item">
								<div class="title"><a href="${pageContext.request.contextPath}/DetailServlet?id=${hotNews.id}">${hotNews.title }</a></div>
								<div class="desc">15K阅读 1K</div>
							</div>

						</c:forEach>


						<!-- <div class="item">
							<div class="title">Lorem ipsum dolor sit amet consectetur
								adipisicing elit.</div>
							<div class="desc">15K阅读 1K</div>
						</div>
						<div class="item">
							<div class="title">Lorem ipsum dolor sit amet consectetur
								adipisicing elit.</div>
							<div class="desc">15K阅读 1K</div>
						</div>
						<div class="item">
							<div class="title">Lorem ipsum dolor sit amet consectetur
								adipisicing elit.</div>
							<div class="desc">15K阅读 1K</div>
						</div>
						<div class="item">
							<div class="title">Lorem ipsum dolor sit amet consectetur
								adipisicing elit.</div>
							<div class="desc">15K阅读 1K</div>
						</div>
						<div class="item">
							<div class="title">Lorem ipsum dolor sit amet consectetur
								adipisicing elit.</div>
							<div class="desc">15K阅读 1K</div>
						</div>
						<div class="item">
							<div class="title">Lorem ipsum dolor sit amet consectetur
								adipisicing elit.</div>
							<div class="desc">15K阅读 1K</div>
						</div>
						<div class="item">
							<div class="title">Lorem ipsum dolor sit amet consectetur
								adipisicing elit.</div>
							<div class="desc">15K阅读 1K</div>
						</div>
						<div class="item">
							<div class="title">Lorem ipsum dolor sit amet consectetur
								adipisicing elit.</div>
							<div class="desc">15K阅读 1K</div>
						</div>
						<div class="item">
							<div class="title">Lorem ipsum dolor sit amet consectetur
								adipisicing elit.</div>
							<div class="desc">15K阅读 1K</div>
						</div> -->
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>

</html>