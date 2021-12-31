<%--
  Created by IntelliJ IDEA.
  User: y
  Date: 2021/12/8
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%--通用标签库--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<h1>文件上传</h1>
<form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="img">
    <input type="file" name="img">
    <input type="submit" value="文件上传">

</form>

<h1>文件下载</h1>
<ul>
    <li>aa.txt<a href="${pageContext.request.contextPath}/download?fileName=aa.txt&openStyle=inline">在线打开</a>aa.txt<a
            href="${pageContext.request.contextPath}/download?fileName=aa.txt&openStyle=attachment">附件下载</a></li>
    <li>dd.exe<a href="${pageContext.request.contextPath}/download?fileName=dd.exe&openStyle=inline">在线打开</a>dd.exe<a
            href="${pageContext.request.contextPath}/download?fileName=dd.exe&openStyle=attachment">附件下载</a></li>
</ul>
</body>
</html>
