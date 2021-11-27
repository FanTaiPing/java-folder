<%--
  Created by IntelliJ IDEA.
  User: y
  Date: 2021/11/8
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<html>

<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<head>
    <title>后台管理系统首页</title>
</head>

<body>

<%--引入公共的css--%>
<%@include file="publicCss.jsp"%>


<div class="container-fluid">
    <header>
        <div class="row head">
            <p>古诗文后台管理系统</p>
        </div>
    </header>
    <div class="container-fluid border-bottom py-3">
        <div class="row flex-nowrap d-flex align-items-center justify-content-between">
            <div class="col-auto d-flex p-3 time">
                <%--公共时间部分--%>
                <%@include file="publicTime.jsp"%>
            </div>
            <div class="col-auto d-flex justify-content-center align-items-center w-75">
                <form action="" class="me-4 w-75">
                    <div class="row pt-3 w-75">
                        <table>
                            <tr>
                                <td><label>条件一</label></td>
                                <td><input type="text" class="form-control search_input" placeholder="搜索..."></td>
                                <td><label>条件二</label></td>
                                <td><input type="text" class="form-control search_input" placeholder="搜索..."></td>
                                <td><label>条件三</label></td>
                                <td><input type="text" class="form-control search_input" placeholder="搜索..."></td>
                                <td>
                                    <button class="btn-info btn-info-select">查询</button>
                                </td>
                            </tr>
                        </table>
                    </div>
                </form>

                <div class="dropdown text-lg-end">
                    <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle"
                       id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                        <img src="${pageContext.request.contextPath}/images/${sessionScope.user.userImg}" alt="用户名头像"
                             class="rootImage rounded-circle">
                    </a>
                    <ul id="showul" class="dropdown-menu text-small" aria-labelledby="dropdownUser1">
                        <li><a href="${pageContext.request.contextPath}/UpdateUserServlet?id=${sessionScope.user.id}" class="dropdown-item">修改个人信息</a>
                        </li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a href="${pageContext.request.contextPath}/LoginOutServlet" class="dropdown-item">登出</a>
                        </li>
                    </ul>
                </div>
                <span class="user">欢迎<span class="span_root">${sessionScope.user.username}</span>登录</span><a class="reg_a" href="${pageContext.request.contextPath}/pages/register.jsp">&nbsp;&nbsp;&nbsp;注册</a></span>
            </div>
        </div>
    </div>
    <div class="container-fluid gap-3 d-grid">

        <div class="row">
            <div class="col-2 bg-light border rounded-3 left_list">
                <div class="accordion accordion-flush" id="accordionFlushExample">
                    <div class="accordion-item">
                        <h2 class="accordion-header" id="flush-headingOne">
                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                    data-bs-target="#flush-collapseOne" aria-expanded="false"
                                    aria-controls="flush-collapseOne">
                                用户管理
                            </button>
                        </h2>
                        <div id="flush-collapseOne" class="accordion-collapse collapse"
                             aria-labelledby="flush-headingOne" data-bs-parent="#accordionFlushExample">
                            <div class="accordion-body" id="user-one-show"
                                 onclick="javascript:window.location='${pageContext.request.contextPath }/UserServlet?currentPage=1&rows=10'">
                                <a href="${pageContext.request.contextPath }/UserServlet?currentPage=1&rows=10">用户信息列表</a>
                            </div>
                        </div>
                    </div>
                    <div class="accordion-item">
                        <h2 class="accordion-header" id="flush-headingTwo">
                            <button id="author" class="accordion-button collapsed" type="button"
                                    data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo" aria-expanded="false"
                                    aria-controls="flush-collapseTwo">
                                作者管理
                            </button>
                        </h2>
                        <div id="flush-collapseTwo" class="accordion-collapse collapse"
                             aria-labelledby="flush-headingTwo" data-bs-parent="#accordionFlushExample">
                            <div class="accordion-body" id="author-two-show"
                                 onclick="javascript:window.location='${pageContext.request.contextPath }/AuthorServlet?currentPage=1&rows=10'">
                                <a href="${pageContext.request.contextPath }/AuthorServlet?currentPage=1&rows=10">作者信息列表</a>
                            </div>
                        </div>
                    </div>
                    <div class="accordion-item">
                        <h2 class="accordion-header" id="flush-headingThree">
                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                    data-bs-target="#flush-collapseThree" aria-expanded="false"
                                    aria-controls="flush-collapseThree">
                                朝代管理
                            </button>
                        </h2>
                        <div id="flush-collapseThree" class="accordion-collapse collapse"
                             aria-labelledby="flush-headingThree" data-bs-parent="#accordionFlushExample">
                            <div class="accordion-body" id="dynasty-three-show"
                                 onclick="javascript:window.location='${pageContext.request.contextPath }/DynastyServlet?currentPage=1&rows=10'">
                                <a
                                        href="${pageContext.request.contextPath }/DynastyServlet?currentPage=1&rows=10">朝代信息列表</a>
                            </div>
                        </div>
                    </div>
                    <div class="accordion-item">
                        <h2 class="accordion-header" id="flush-headingFour">
                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                    data-bs-target="#flush-collapseFour" aria-expanded="false"
                                    aria-controls="flush-collapseFour">
                                诗词类型管理
                            </button>
                        </h2>
                        <div id="flush-collapseFour" class="accordion-collapse collapse"
                             aria-labelledby="flush-headingFour" data-bs-parent="#accordionFlushExample">
                            <div class="accordion-body" id="type-four-show"
                                 onclick="javascript:window.location='${pageContext.request.contextPath }/TypeServlet?currentPage=1&rows=10'">
                                <a
                                        href="${pageContext.request.contextPath }/TypeServlet?currentPage=1&rows=10">诗词类型信息列表</a>
                            </div>
                        </div>
                    </div>
                    <div class="accordion-item">
                        <h2 class="accordion-header" id="flush-headingFive">
                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                    data-bs-target="#flush-collapseFive" aria-expanded="false"
                                    aria-controls="flush-collapseFive">
                                古诗管理
                            </button>
                        </h2>
                        <div id="flush-collapseFive" class="accordion-collapse collapse"
                             aria-labelledby="flush-headingFive" data-bs-parent="#accordionFlushExample">
                            <div class="accordion-body" id="poetry-five-show"
                                 onclick="javascript:window.location='${pageContext.request.contextPath }/PoetryServlet?currentPage=1&rows=5'">
                                <a
                                        href="${pageContext.request.contextPath }/PoetryServlet?currentPage=1&rows=5">古诗信息列表</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-10 border rounded-3 bg-light">
                <div id="user-one" class="user-one">
                    <table class="form-show">
                        <tr>
                            <td style="text-align: left;">用户信息显示界面</td>
                            <td>

                            </td>

                        </tr>
                    </table>
                    <form action="${pageContext.request.contextPath }/DelSelectedServlet" method="post" id="form">
                    <table class="table table-bordered">
                        <tr>
                            <th><input type ="checkbox" id="firstCb"></th>
                            <th>编号</th>
                            <th>用户名</th>
                            <th>密码</th>
                            <th>用户头像</th>
                            <th style="width: 430px;text-align: center">
                            <a class="btn btn-primary" href="javascript:void(0);" id="delSelected">删除选中</a>
                            </th>
                        </tr>
                        <c:forEach items="${requestScope.pageBeanUser.list}" var="pageBeanUser">
                        <tr>
                            <td><input type ="checkbox" name="uid" value="${pageBeanUser.id }"></td>
                            <td>${pageBeanUser.id}</td>
                            <td>${pageBeanUser.username}</td>

                            <td>${pageBeanUser.password}</td>
                            <td>
                                <img class="root_img"
                                     src="${pageContext.request.contextPath}/images/${pageBeanUser.userImg}">
                            </td>
                            <td>
                                <a class="btn btn-info btn_btn" href="${pageContext.request.contextPath}/FindUserByIdServlet?id=${pageBeanUser.id}">修改信息</a>
                                <a class="btn btn-info btn_btn" href="javascript:deletePoetry(${pageBeanUser.id})">删除信息</a>
                            </td>
                        </tr>
                        </c:forEach>
                    </table>
                    </form>
                    </form>
                    <script charset="gb2312" type="text/javascript" language="javascript">
                        function deletePoetry(id) {
                            // 用户安全提示
                            if (confirm("您确定要删除吗？")) {
                                //访问路径
                                location.href = "${pageContext.request.contextPath}/DeleteUserByIdServlet?id=" + id;
                            }
                        }
                        // window.onload = function () {
                        //     //给删除选中按钮添加单击事件
                        //     document.getElementById("delSelected").onclick = function () {
                        //         if (confirm("您确定要删除选中条目吗？")) {
                        //             var flag = false;
                        //             //判断是否有选中条目
                        //             var cbs = document.getElementsByName("uid");
                        //             for (var i = 0; i < cbs.length; i++) {
                        //                 if (cbs[i].checked) {
                        //                     //有一个条目选中了
                        //                     flag = true;
                        //                     break;
                        //                 }
                        //             }
                        //             if (flag) {//有条目被选中
                        //                 //表单提交
                        //                 document.getElementById("form").submit();
                        //             }
                        //         }
                        //     }
                        //     //1.获取第一个cb
                        //     document.getElementById("firstCb").onclick = function () {
                        //         //2.获取下边列表中所有的cb
                        //         var cbs = document.getElementsByName("uid");
                        //         //3.遍历
                        //         for (var i = 0; i < cbs.length; i++) {
                        //             //4.设置这些cbs[i]的checked 的状态 = firstCb.checked
                        //             cbs[i].checked = this.checked;
                        //         }
                        //     }
                        // }
                    </script>
                    <%--分页部分--%>
                    <nav aria-label="Page navigation example">
                        <ul class="pagination pagination-lg">
                            <%--点击下一页按钮时，如果当前页码小于1，则将其置为1 --%>
                            <c:if test="${requestScope.pageBeanUser.currentPage == 1 }">
                                <li class="page-item disabled">
                                    <a class="page-link"
                                       href="${pageContext.request.contextPath }/UserServlet?currentPage=${requestScope.pageBeanUser.currentPage - 1}&rows=10"
                                       aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <%--点击下一页按钮时，如果当前页不等于1，则将其页码减1--%>
                            <c:if test="${requestScope.pageBeanUser.currentPage != 1 }">
                                <li>
                                    <a class="page-link"
                                       href="${pageContext.request.contextPath }/UserServlet?currentPage=${requestScope.pageBeanUser.currentPage - 1}&rows=10"
                                       aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                            </c:if>
                                <li>
                                    <a class="page-link"
                                       href="${pageContext.request.contextPath }/UserServlet?currentPage=1&rows=5"
                                       aria-label="Previous">
                                        <span aria-hidden="true">首页</span>
                                    </a>
                                </li>
                            <%--从1开始循环，总的有几页就循环几次，显示页码数字--%>
                            <c:forEach begin="2" end="${requestScope.pageBeanUser.totalPage }" var="i">
                                <c:if test="${requestScope.pageBeanUser.currentPage == i }">
                                    <li class="page-item active">
                                        <a class="page-link"
                                           href="${pageContext.request.contextPath }/UserServlet?currentPage=${i}&rows=10">${i}</a>
                                    </li>
                                </c:if>
                                <c:if test="${requestScope.pageBeanUser.currentPage != i }">
                                    <li class="page-item">
                                        <a class="page-link"
                                           href="${pageContext.request.contextPath }/UserServlet?currentPage=${i}&rows=10">${i}</a>
                                    </li>
                                </c:if>
                            </c:forEach>

                            <c:if test="${requestScope.pageBeanUser.currentPage >= requestScope.pageBeanUser.totalPage }">
                                <li class="disabled">
                                    <a class="page-link"
                                       href="${pageContext.request.contextPath }/UserServlet?currentPage=${requestScope.pageBeanUser.currentPage}&rows=10"
                                       aria-label="Previous">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <c:if test="${requestScope.pageBeanUser.currentPage < requestScope.pageBeanUser.totalPage }">
                                <li>
                                    <a class="page-link"
                                       href="${pageContext.request.contextPath }/UserServlet?currentPage=${requestScope.pageBeanUser.currentPage + 1}&rows=10"
                                       aria-label="Previous">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <li class="page-item"><span class="totalCount">共${requestScope.pageBeanUser.totalCount }条记录，共${requestScope.pageBeanUser.totalPage }页</span>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <footer>

    </footer>
</div>
</body>
<%--引入公共的js--%>
<%@include file="publicJS.jsp"%>
</html>
