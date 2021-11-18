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
					
					<%-- <form class="form-inline" action="${pageContext.request.contextPath }/emplistServlet" method="post">
					  <div class="form-group">
					    <label for="exampleInputName2">ID</label>
					    <input type="text" class="form-control" id="exampleInputName2" name="id">
					  </div>
					  <div class="form-group">
					    <label for="exampleInputEmail2">Name</label>
					    <input type="text" class="form-control" id="exampleInputEmail2" name="name">
					  </div>
					  <button type=submit class="btn btn-default">Search</button>
					</form> --%>
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
								Name
							</td>
							<td>
								password
							</td>
							<td>
								Operation
							</td>
						</tr>
						<%----%>
						<c:forEach items="${requestScope.user.list }" var="users" varStatus="s">
						<tr class="row1">
							<td>
								<input type ="checkbox" name="uid" value="${users.id }">
							</td>
							<td>
								${s.count }
							</td>
							<td>
								${users.username }
							</td>
							<td>
								${users.password }
							</td>
							<td>
								<a href="javascript:deleteUser(${users.id})">删除信息</a>&nbsp;<a href="${pageContext.request.contextPath }/updateEmpServlet?id=${users.id}">修改信息</a>
							</td>
							
						</tr>
						</c:forEach>	
					</table>
					</form>
					<!-- 分页部分 -->
					<nav aria-label="Page navigation">
					  <ul class="pagination pagination-lg">
					  <%-- 点击下一页按钮时，如果当前页码小于1，则将其置为1 --%>
					    <c:if test="${requestScope.user.currentPage == 1 }">
					    	<li class="disabled">
						    	<a href="${pageContext.request.contextPath }/emplistServlet?currentPage=${requestScope.user.currentPage - 1}&rows=5" aria-label="Previous">
						        <span aria-hidden="true">&laquo;</span>
						      	</a>
					    	</li>
					    </c:if>
					    <%-- 点击下一页按钮时，如果当前页不等于1，则将其页码减1 --%>
					    <c:if test="${requestScope.user.currentPage != 1 }">
					    	<li>
					    	<a href="${pageContext.request.contextPath }/emplistServlet?currentPage=${requestScope.user.currentPage - 1}&rows=5" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					      	</a>
					    	</li>
					    </c:if>
						<%-- 从1开始循环，总的有几页就循环几次，显示页码数字 --%>
					    <c:forEach begin="1" end="${requestScope.user.totalPage }" var ="i">
						    <c:if test="${requestScope.user.currentPage == i }">
							    <li class="active"><a href="${pageContext.request.contextPath }/emplistServlet?currentPage=${i}&rows=5">${i}</a></li>
							</c:if>
							<c:if test="${requestScope.user.currentPage != i }">
							    <li><a href="${pageContext.request.contextPath }/emplistServlet?currentPage=${i}&rows=5">${i}</a></li>
						    </c:if>
					    </c:forEach>
					   
						<c:if test="${requestScope.user.currentPage >= requestScope.user.totalPage }">
					    	<li class="disabled">
						    	<a href="${pageContext.request.contextPath }/emplistServlet?currentPage=${requestScope.user.currentPage}&rows=5" aria-label="Previous">
						        <span aria-hidden="true">&raquo;</span>
						      	</a>
					    	</li>
					    </c:if>
					    <c:if test="${requestScope.user.currentPage < requestScope.user.totalPage }">
					    	<li>
					    	<a href="${pageContext.request.contextPath }/emplistServlet?currentPage=${requestScope.user.currentPage + 1}&rows=5" aria-label="Previous">
					        <span aria-hidden="true">&raquo;</span>
					      	</a>
					    	</li>
					    </c:if>
					    <li><span style="font-size:18px;margin-left:5px;">共${requestScope.user.totalCount }条记录，共${requestScope.user.totalPage }页</span></li>
					  </ul>
					</nav>

					<p>
						<input type="button" class="button" value="Add User" onclick="javascript:window.location='addEmp.jsp'"/>
					</p>
				</div>
			</div>
			<!-- 公共的底部部分 -->
			<%@ include file="publicFooder.jsp" %>
		</div>
	</body>
	<script>
	function deleteUser(id){
		//用户安全提示
		if(confirm("您确定要删除吗？")){
			//访问路径
			location.href="${pageContext.request.contextPath }/deleteServlet?id="+id;
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