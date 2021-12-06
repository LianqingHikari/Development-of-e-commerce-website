<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>连清电商网</title>

</head>

<body background="./images/bg_light_blue.png">
<table align="right">
	<tr>
		<td><a href="UserCenter.jsp">用户中心</a></td>
		<td>|</td>
		<td><a href="${pageContext.request.contextPath}/FindCart">购物车</a></td>
	</tr>
</table>
<form action="${pageContext.request.contextPath}/MenuSearch" method="post">
	<table align="center">
		<tr>
			<td><img src="./images/logo_0.png" style="height: 30px;width: 125px;"/></td>
			<td align="center"><input type="text" name="ProductName" value="请输入商品名" style="width: 300px;"></td>
			<td><input type="submit" value="搜索"></td>
		</tr>
		<tr>
			<td></td>
			<td style="color:red">${search_message}</td>
		</tr>
	</table>
</form>
<table align="center"><tr><td>所有商品</td></tr></table>
<table align="center" border="1" style="width: 512px;background-image: url(./images/bg_white.png)" >
	<tr>
		<td style="width: 70%;">商品名称</td>
		<td style="width: 30%;">商品类型</td>
	</tr>
	<c:forEach items="${allproduct}" var="entry">
		<tr>
			<td style="width: 70%;">
				<a href="${pageContext.request.contextPath}/MenuSearch?ProductName=${(entry.getProductName())}">
						${(entry.getProductName())}
				</a>
			</td>
			<td style="width: 30%;">${(entry.getProductType())}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>
