<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>计算1-100之间的所有素数之和</title>
</head>
<body>
	<!-- 小脚本 方法一：-->
	1-100之间的所有素数之和为：
	<%
	int sumOne = 0;
	int j;
	for (int i = 2; i <= 100; i++) {
		for (j = 2; j < i; j++) {
			if (i % j == 0) {
		break;
			}
		}
		if (j == i) {
			sumOne += i;
		}
	}
	%>
	<!-- 方法二： -->
	<!-- 方法声明 -->
	<%!public boolean isPrime(int num) {
		boolean flag = false;
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				flag = false;
				break;
			} else {
				flag = true;
			}
		}
		return flag;
	}%>

	<%
	int sum = 2;
	for (int i = 2; i <= 100; i++) {
		if (isPrime(i)) {
			sum += i;
		}
	}
	%>

	<!-- 表达式 -->
	<%=sum%>
	</br> 
	1-100之间的所有素数之和为：
	<%=sumOne%>
</body>
</html>