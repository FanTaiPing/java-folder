<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图片上传</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/FileUploadServlet" method="post" enctype="multipart/form-data">
姓名：<input name ="name"><br/>
选择图片：<input name="ufile" type="file"><br/>
<input type="submit" value="提交">

</form>
</body>
</html>