<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
 * @FilePath: /bootstrap-project/news/index.jsp
-->

<!-- <!DOCTYPE html> -->
<html lang="zh-CN">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>新闻</title>
</head>

<body>
	<!-- 公共的css部分 -->
	<%@ include file="publicCSS.jsp"%>
	<!-- 公共的头部导航栏部分 -->
	<%@ include file="head.jsp"%>


	<!-- 中间内容部分 -->
	<div class="container">
		<!-- row样式抵消栅格padding样式 -->
		<div class="row">
			<!-- 左边侧边栏 -->
			<div class="col-sm-2">
				<div class="hidden-xs list-group side-bar">
					<c:if test="${not empty requestScope.newsType }">
						<c:forEach items="${requestScope.newsType }" var="type">
							<c:if test="${type.id ==1 }">
								<a href="#" class="list-group-item active">${type.name }</a>
							</c:if>
							<c:if test="${type.id !=1 }">
								<a href="#" class="list-group-item">${type.name }</a>
							</c:if>
						</c:forEach>
					</c:if>

				</div>
			</div>
			<!-- 中间内容部分 -->
			<div class="col-sm-7">
				<div class="news-list">
					<c:if test="${not empty requestScope.news }">
						<c:forEach items="${requestScope.news }" var="news">
							<div class="news-list-item clearfix">
								<!-- 中间内容图片部分 -->
								<div class="col-xs-5">
									<img
										src="${pageContext.request.contextPath }/image/images/${news.smImg}"
										alt="" />
								</div>
								<!-- 中间内容文字部分 -->
								<div class="col-xs-7">
									<!-- /DetailServlet? -->
									<a class="title"
										href="${pageContext.request.contextPath}/DetailServlet?id=${news.id}">${news.title }</a>
									<div class="info">
										<span><span class="avatar"><img
												src="${pageContext.request.contextPath }/image/images/014sm.jpg"
												alt="作者"></span>${news.author }</span> · <span>66k评论</span> · <span>
												<fmt:formatDate value="${news.updateTime }" pattern="yyyy年MM月dd日"/>
										</span>
									</div>
								</div>
							</div>
						</c:forEach>
					</c:if>
				</div>
			</div>
			<!-- 中间内容右边部分 -->
			<div class="col-sm-3">
				<div class="search-bar">
					<input type="search" name="" id="" class="form-control"
						placeholder="搜一下" />
				</div>
				<div class="side-bar-card flag clearfix">
					<div class="col-xs-5">
						<img
							src="${pageContext.request.contextPath }/image/images/013sm.jpg"
							alt="">
					</div>
					<div class="col-xs-7">
						<div class="text-lg">有害信息举报专区</div>
						<div>联系电话：12377</div>
					</div>
				</div>
				<div class="side-bar-card">
					<div class="card-title">24小时热闻</div>
					<div class="card-body">
						<div class="list">
							<c:forEach items="${requestScope.hotNews }" var="hotNews">
								<div class="item">
									<div class="title"><a href="${pageContext.request.contextPath}/DetailServlet?id=${hotNews.id}">${hotNews.desc }</a></div>
									<div class="desc">15K阅读 1K</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 分页部分 -->	
<nav aria-label="Page navigation" class="text-center">
  <ul class="pagination">
      <li class="disabled"><a href="${pageContext.request.contextPath }/pages/index.jsp?currentSize=${requestScope.page.currentPageNo - 1}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>

    <c:if test="${requestScope.page.currentPageNo<1 }">
    <li class="active"><a href="${pageContext.request.contextPath }/pages/index.jsp?currentSize=1">1<span class="sr-only">(current)</span></a></li>
    <li><a href="${pageContext.request.contextPath }/pages/index.jsp?currentSize=2">2<span class="sr-only"></span></a></li>   
    <li><a href="${pageContext.request.contextPath }/pages/index.jsp?currentSize=3">3<span class="sr-only"></span></a></li>
    </c:if>
    
    <c:if test="${requestScope.page.currentPageNo>=1 && requestScope.page.currentPageNo <= requestScope.page.totalPageCount}">
    <li class="active"><a href="${pageContext.request.contextPath }/pages/index.jsp?currentSize=${requestScope.page.currentPageNo}">${requestScope.page.currentPageNo}<span class="sr-only"></span></a></li>
    <li><a href="${pageContext.request.contextPath }/pages/index.jsp?currentSize=${requestScope.page.currentPageNo+1}">${requestScope.page.currentPageNo+1}<span class="sr-only">(current)</span></a></li>
    <li><a href="${pageContext.request.contextPath }/pages/index.jsp?currentSize=${requestScope.page.currentPageNo +2}">${requestScope.page.currentPageNo + 2}<span class="sr-only"></span></a></li>    
    </c:if>
    
    <c:if test="${requestScope.page.currentPageNo > requestScope.page.totalPageCount }">
    <li><a href="${pageContext.request.contextPath }/pages/index.jsp?currentSize=1">1<span class="sr-only">(current)</span></a></li>
    <li><a href="${pageContext.request.contextPath }/pages/index.jsp?currentSize=${requestScope.page.totalPageCount-2}">${requestScope.page.totalPageCount+1}<span class="sr-only"></span></a></li>       
	<li class="active"><a href="${pageContext.request.contextPath }/pages/index.jsp?currentSize=${requestScope.page.totalPageCount-1}">${requestScope.page.totalPageCount+2}<span class="sr-only"></span></a></li>
    </c:if>
    <li class="disabled"><a href="${pageContext.request.contextPath }/pages/index.jsp?currentSize=${requestScope.page.currentPageNo + 1}" aria-label="Previous"><span aria-hidden="true">&raquo;</span></a></li>    

  </ul>
</nav>



	<!-- 页面底部 -->
	<div class="footer">&copy;2020 华信智原
		(京)-经营性-2017-0020京公网安备1402342342340005号京ICP证03453477777754号</div>
</body>

</html>