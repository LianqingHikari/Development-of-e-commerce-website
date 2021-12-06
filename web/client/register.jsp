<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>连清电商网注册页面</title>
</head>

<body>
	<legend style="color: blue;font-size: large;">账号注册</legend>
	<form action="${pageContext.request.contextPath}/register" method="post">
		<table align="center">
			<tr>
				<td>账号：</td>
				<td><input type="text" name="UserAccount"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="UserPassword"></td>
			</tr>
			<tr>
				<td>电子邮箱：</td>
				<td><input type="text" name="UserEmail"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="注册">
					<input type="reset" value="重置">
				</td>
			</tr>
		</table>
		<table align="center">
			<tr>
				<td align="center" style="color:red">
					${register_message}
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
