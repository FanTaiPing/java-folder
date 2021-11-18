<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib prefix ="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

<!-- 公共的css部分 -->
<%@ include file ="publicCss.jsp" %>
		<div id="wrap">
			<div id="top_content"> 
				<!-- 公共的显示时间部分小脚本和头部部分 -->
					<%@ include file ="publicTime.jsp" %>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						Welcome!【${sessionScope.user.username }】登录
					</h1>
					
					<div style="float:right;margin:5px">
					<a class="btn btn-primary" href="javascript:void(0);" id="delSelected">删除选中</a>
					</div>
					<form action="${pageContext.request.contextPath }/DelSelectedServlet" method="post" id="form">
					<table class="table">
						<tr class="table_header">
							<td>
								<input type ="checkbox" id="firstCb">
							</td>
							<td>
								ID
							</td>
							<td>
								Title
							</td>
							<td>
								author
							</td>
							<td>
								content
							</td>
							<td>
								create_time
							</td>
							<td>
								update_time
							</td>
							<td>
								sm_img
							</td>
							<td>
								la_img
							</td>
							<td>
								Operation
							</td>
						</tr>
						<%----%>
						<c:forEach items="${requestScope.news.list }" var="news" varStatus="s">
						<tr class="row1">
							<td>
								<input type ="checkbox" name="uid" value="${news.id }">
							</td>
							<td>
								${s.count }
							</td>
							<td>
								${news.title}
							</td>
							<td>
								${news.author}
							</td>
							<td>
								<textarea>${news.content}</textarea>
								
							</td>
							<td>
								${news.createTime}
							</td>
							<td>
								${news.updateTime}
							</td>
							<td>
								<img src="${pageContext.request.contextPath }/img/images/${news.smImg}" style="width:100px;height:70px;display:inline-block;Object-fit:cover"/>
							</td>
							<td>		
								<img src="${pageContext.request.contextPath }/img/images/${news.laImg}" style="width:100px;height:70px;display:inline-block;Object-fit:cover"/>
							</td>
							<td style="vertical-align: middle;" class="text-center">
								<a href="javascript:deleteNews(${news.id})">删除信息</a><br/><br/>
								<a href="${pageContext.request.contextPath }/NewsTypeServlet?id=${news.id}">修改信息</a>
							</td>
							
						</tr>
						</c:forEach>	
					</table>
					</form>
					<!-- 分页部分 -->
					<nav aria-label="Page navigation">
					  <ul class="pagination pagination-lg">
					  <%-- 点击下一页按钮时，如果当前页码小于1，则将其置为1 --%>
					    <c:if test="${requestScope.news.currentPage == 1 }">
					    	<li class="disabled">
						    	<a href="${pageContext.request.contextPath }/NewsEmplistServlet?currentPage=${requestScope.news.currentPage - 1}&rows=5" aria-label="Previous">
						        <span aria-hidden="true">&laquo;</span>
						      	</a>
					    	</li>
					    </c:if>
					    <%-- 点击下一页按钮时，如果当前页不等于1，则将其页码减1 --%>
					    <c:if test="${requestScope.news.currentPage != 1 }">
					    	<li>
					    	<a href="${pageContext.request.contextPath }/NewsEmplistServlet?currentPage=${requestScope.user.currentPage - 1}&rows=5" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					      	</a>
					    	</li>
					    </c:if>
						<%-- 从1开始循环，总的有几页就循环几次，显示页码数字 --%>
					    <c:forEach begin="1" end="${requestScope.news.totalPage }" var ="i">
						    <c:if test="${requestScope.news.currentPage == i }">
							    <li class="active"><a href="${pageContext.request.contextPath }/NewsEmplistServlet?currentPage=${i}&rows=5">${i}</a></li>
							</c:if>
							<c:if test="${requestScope.news.currentPage != i }">
							    <li><a href="${pageContext.request.contextPath }/NewsEmplistServlet?currentPage=${i}&rows=5">${i}</a></li>
						    </c:if>
					    </c:forEach>
					   
						<c:if test="${requestScope.news.currentPage >= requestScope.news.totalPage }">
					    	<li class="disabled">
						    	<a href="${pageContext.request.contextPath }/NewsEmplistServlet?currentPage=${requestScope.news.currentPage}&rows=5" aria-label="Previous">
						        <span aria-hidden="true">&raquo;</span>
						      	</a>
					    	</li>
					    </c:if>
					    <c:if test="${requestScope.news.currentPage < requestScope.news.totalPage }">
					    	<li>
					    	<a href="${pageContext.request.contextPath }/NewsEmplistServlet?currentPage=${requestScope.news.currentPage + 1}&rows=5" aria-label="Previous">
					        <span aria-hidden="true">&raquo;</span>
					      	</a>
					    	</li>
					    </c:if>
					    <li><span style="font-size:18px;margin-left:5px;">共${requestScope.news.totalCount }条记录，共${requestScope.news.totalPage }页</span></li>
					  </ul>
					</nav>

					<p>
						<input type="button" class="button" value="Add User" onclick="javascript:window.location='${pageContext.request.contextPath}/FindNewsTypeAllServlet'"/>
					</p>
				</div>
			</div>
			<!-- 公共的底部部分 -->
			<%@ include file="publicFooder.jsp" %>
		</div>
	</body>
	<script>
	function deleteNews(id){
		//用户安全提示
		if(confirm("您确定要删除吗？")){
			//访问路径
			location.href="${pageContext.request.contextPath }/deleteNewsServlet?id="+id;
		}
	}
	window.onload = function(){
		//给删除选中按钮添加单击事件
		document.getElementById("delSelected").onclick = function(){
			if(confirm("您确定要删除选中条目吗？")){
				var flag = false;
				//判断是否有选中条目
				var cbs = document.getElementsByName("uid");
				for(var i=0;i<cbs.length;i++){
					if(cbs[i].checked){
						//有一个条目选中了
						flag = true;
						break;
					}					
				}
				if(flag){//有条目被选中
					//表单提交
					document.getElementById("form").submit();	
				}
			}
		}
		//1.获取第一个cb
		document.getElementById("firstCb").onclick = function(){
			//2.获取下边列表中所有的cb
			var cbs = document.getElementsByName("uid");
			//3.遍历
			for(var i=0;i<cbs.length;i++){
				//4.设置这些cbs[i]的checked 的状态 = firstCb.checked
				cbs[i].checked = this.checked;
			}
		}
	}
	</script>
</html>