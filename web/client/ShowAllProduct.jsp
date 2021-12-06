<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <title>管理员中心</title>
</head>

<body>
<legend style="color: blue;font-size: large;">商品统计</legend>

<table border="1" width="1024" align="center">
    <tr>
        <td width="20%">
            商品名称：
        </td>
        <td width="15%">
            商品价格：
        </td>
        <td width="10%">
            商品图片：
        </td>
        <td width="10%">
            商品类型：
        </td>
        <td width="45%">
            商品描述：
        </td>
    </tr>
    <c:forEach items="${lproduct}" var="entry">
        <tr>
            <td>${(entry.getProductName())}</td>
            <td><fmt:formatNumber value="${(entry.getProductPrice())}"/>￥</td>
            <td>${(entry.getProductPictureName())}</td>
            <td>${(entry.getProductType())}</td>
            <td>${(entry.getProductDescription())}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>