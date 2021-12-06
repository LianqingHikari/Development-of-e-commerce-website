<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <title>管理员中心</title>
</head>

<body>
<legend style="color: blue;font-size: large;">销售统计</legend>

<table border="1" width="512" align="center">
    <tr>
        <td width="70%">
            商品名称：
        </td>
        <td width="30%">
            商品销售量：
        </td>
    </tr>
    <c:forEach items="${lproduct}" var="entry">
        <tr>
            <td>${(entry.getProductName())}</td>
            <td>${(entry.getProductSale())}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>