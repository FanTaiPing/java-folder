<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
</head>
<style>
.container {
	width: 800px;
	margin: 20px auto;
}
</style>
<body>
	<div class="container">
		<form action="reginfo.jsp" method="post">
			<table style="text-align: left;">
				<tr>
					<td>请输入注册信息</td>
				</tr>
				<tr>
					<td><label>用户名</label> <input name="username"></td>
				</tr>
				<tr>
					<td><label>密码:&nbsp;&nbsp;</label> <input type="password"
						name="pwd"></td>
				</tr>
				<tr>

					<td><label>信息来源:</label><br> <input type="checkbox"
						name="channel" value="报刊">报刊 <input type="checkbox"
						name="channel" value="网络">网络 <input type="checkbox"
						name="channel" value="朋友推荐">朋友推荐 <input type="checkbox"
						name="channel" value="电视">电视</td>
				</tr>

				<tr>
					<td><label for="sex">性别：</label> <input type="radio" id="sex"
						name="sex" checked>男 <input type="radio" id="sex"
						name="sex">女<br></td>
				</tr>

				<tr>
					<td><select
						name="season" id="season">
							<option value="春季" selected>春季</option>
							<option value="夏季">夏季</option>
							<option value="秋季">秋季</option>
							<option value="冬季">冬季</option>
					</select></td>
				</tr>

				<tr>
					<td><input type="submit" value="提交" /> <input type="button"
						value="取消" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>