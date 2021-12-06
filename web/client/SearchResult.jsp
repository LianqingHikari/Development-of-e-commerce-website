<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.math.BigDecimal" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <title>商品搜索结果</title>
</head>

<body>
<legend style="color: blue;font-size: large;">商品搜索结果</legend>
<table align="center" width="512" height="256" border="1" style="table-layout: fixed">
    <tr width="100%" height="100%">
        <td width="50%" height="50%">
            <% String Path = "images/"+ request.getSession().getAttribute("ProductPictureName"); %>
            <img style="width:248px;height:256px;" src=<%=Path %> />
        </td>
        <td width="50%" height="50%">
            <table border="1" align="" width="100%" height="100%" style="table-layout: fixed">
                <tr><td height="10%">商品名称：${ProductName}</td></tr>
                <tr><td height="10%">商品价格：<fmt:formatNumber value="${ProductPrice}"/></td></tr>
                <tr><td height="10%">商品类型：${ProductType}</td></tr>
                <tr><td height="10%">商品已售：${ProductSale}</td></tr>
                <tr><td height="60%"  valign="top" style="word-wrap: break-word;">商品描述：<br />${ProductDescription}</td></tr>
            </table>
        </td>
    </tr>
</table>
<form action="${pageContext.request.contextPath}/AddCart">
    <table align="center">
        <tr>
            <td>
                <input type="text" name="ProductNumber" value="请输入需要购买的数量">
                <input type="submit"  value="加入购物车">
            </td>
        </tr>
    </table>
    <table align="center">
        ${AddCart_message}
    </table>
</form>
</body>
</html>