<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <title>管理员中心</title>
</head>

<body>
<legend style="color: blue;font-size: large;">增加商品</legend>
<form action="${pageContext.request.contextPath}/AddProduct" method="post">
    <table align="center">
        <tr>
            <td>商品名称：</td>
            <td><input type="text" name="ProductName"></td>
        </tr>
        <tr>
            <td>商品价格：</td>
            <td><input type="text" name="ProductPrice"></td>
        </tr>
        <tr>
            <td>商品描述：</td>
            <td><input type="text" name="ProductDescription" size="60"></td>
        </tr>
        <tr>
            <td>商品类型：</td>
            <td><input type="text" name="ProductType"></td>
        </tr>
        <tr>
            <td>图片名称：</td>
            <td><input type="text" name="ProductPictureName"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="提交">
                <input type="reset" value="重置">
            </td>
        </tr>
    </table>
    <table align="center">
        ${requestScope["AddProduct_message"]}
    </table>
</form>
</body>
</html>