<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <title>购物车</title>
</head>

<body>
<legend style="color: blue;font-size: large;">购物车</legend>

<table border="1" width="1024" align="center">
    <tr>
        <td width="50%">
            商品名称：
        </td>
        <td width="30%">
            商品价格：
        </td>
        <td width="20%">
            商品数量：
        </td>
    </tr>
    <c:forEach items="${lcart}" var="entry">
        <tr>
            <td>${(entry.getProductName())}</td>
            <td><fmt:formatNumber value="${(entry.getProductPrice())}"/>￥</td>
            <td>${(entry.getProductNumber())}</td>
        </tr>
    </c:forEach>
</table>
<form action="${pageContext.request.contextPath}/DeleteCart">
    <table width="1024" align="center">
        <tr>
            <td align="left">
                <input type="text" value="请输入需要删除的商品" name="ProductName">
                <input type="submit" value="确认删除">
            </td>
            <td align="right">
                商品总价：<fmt:formatNumber value="${TotalPrice}"/>￥
            </td>
        </tr>
    </table>
</form>
<table width="1024" align="center">
    <tr>
        <td align="right">
            <a href="/PayCart">结算</a>
        </td>
    </tr>
</table>
</body>
</html>