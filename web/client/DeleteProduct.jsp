<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <title>管理员中心</title>
</head>

<body>
<legend style="color: blue;font-size: large;">删除商品</legend>
<form action="${pageContext.request.contextPath}/DeleteProduct" method="post">
    <table align="center">
        <tr>
            <td>商品名称：</td>
            <td><input type="text" name="ProductName"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>
    <table align="center">
        ${requestScope["DeleteProduct_message"]}
    </table>
</form>
</body>
</html>