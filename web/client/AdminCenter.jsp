<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>管理员中心</title>

</head>

<body>
<table>
    <tr>
        <td>商品管理：</td>
        <td><a href="AddProduct.jsp">增加商品</a></td>
        <td>|</td>
        <td><a href="DeleteProduct.jsp">删除商品</a></td>
        <td>|</td>
        <td><a href="UpdateProduct.jsp">修改商品信息</a></td>
    </tr>
    <tr>
        <td>商品情况：</td>
        <td><a href="${pageContext.request.contextPath}/ShowSale">销售统计</a></td>
        <td>|</td>
        <td><a href="${pageContext.request.contextPath}/ShowAllProduct">所有商品</a></td>
    </tr>
</table>

<form action="/ShowAllLog">
    <table>
        <tr>
            <td>客户日志：</td>
        </tr>
        <tr>
            <td>
                <input type="text" name="UserAccount" value="请输入用户名称">
                <input type="submit" value="搜索">
            </td>
            <td style="color:red">
                ${ShowAllLog_message}
            </td>
        </tr>
    </table>
</form>

<table>
    <tr>
        <td>
            <a href="login.jsp">注销</a>
        </td>
    </tr>
</table>
</body>
</html>
