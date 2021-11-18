<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<%-- 直接取字符串 --%>
<%
request.setAttribute("usernaem", "赵云");
%>
姓名：${requestScope.username}<br/>


<%-- 取list和map --%>
<%
List list = new ArrayList();
list.add("关羽");
list.add("张飞");
request.setAttribute("list", list);
Map map = new HashMap();
map.put("name", "黄忠");
map.put("nameOne", "马超");
request.setAttribute("map",map);
%>
姓名List:${list[0]}&nbsp;&nbsp;${list[1]}
<br/>姓名Map:${map.name}&nbsp;&nbsp;${map.nameOne}
</body>
</html>