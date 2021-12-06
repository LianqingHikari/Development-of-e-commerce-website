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

<table align="center"><tr><td>用户浏览记录</td></tr></table>
<table border="1" width="1024" align="center">
    <tr>
        <td width="20%">
            用户名称：
        </td>
        <td width="30%">
            商品名称：
        </td>
        <td width="50%">
            浏览时间：
        </td>
    </tr>
    <c:forEach items="${lbrowselog}" var="entry">
        <tr>
            <td>${(entry.getUserAccount())}</td>
            <td>${(entry.getProductName())}</td>
            <td>${(entry.getBrowseTime())}</td>
        </tr>
    </c:forEach>
</table>
<table align="center"><tr><td>用户购买记录</td></tr></table>
<table border="1" width="1024" align="center">
    <tr>
        <td width="15%">
            用户名称：
        </td>
        <td width="25%">
            商品名称：
        </td>
        <td width="10%">
            购买数量：
        </td>
        <td width="50%">
            浏览时间：
        </td>
    </tr>
    <c:forEach items="${lbuylog}" var="entry">
        <tr>
            <td>${(entry.getUserAccount())}</td>
            <td>${(entry.getProductName())}</td>
            <td>${(entry.getProductNumber())}</td>
            <td>${(entry.getBrowseTime())}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>