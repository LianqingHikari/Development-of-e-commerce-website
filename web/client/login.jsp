<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

	<title>连清电商网登录页面</title>
</head>

<body background="./images/bg1.png" style="background-size:cover;background-attachment: fixed;" >
<form action="${pageContext.request.contextPath}/login" method="post">
	<table style="height: 25%;"><tr><td></td></tr></table>
	<table align="center"><tr><td><img src="./images/logo_0.png" style="height: 78px;width: 270px;"/></td></tr></table>
	<table align="center" style="background-image: url(./images/bg3.png);height: 150px;width: 270px;" >
		<tr align="center">
			<td>账号：</td>
			<td><input type="text" name="UserAccount"></td>
		</tr>
		<tr align="center">
			<td>密码：</td>
			<td><input type="password" name="UserPassword"></td>
		</tr>
		<tr>
			<td></td>
			<td style="color:red;font-size: small">${login_message}</td>
		</tr>
		<tr align="center">
			<td><a href="register.jsp">注册账号</a></td>
			<td colspan="2" align="center">
				<input type="submit" value="登录">
				<input type="reset" value="重置">
			</td>
		</tr>
	</table>
</form>
</body>
</html>
