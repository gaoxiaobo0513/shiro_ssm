<%--
  Created by IntelliJ IDEA.
  User: Mr_Gao
  Date: 2017/5/16
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style type="text/css">
    	tr{
    		background-color: lightgrey
    	}
    </style>
</head>
<body>
<div align="center">
<table style="border: 0;margin: 0;padding: 0;border-collapse: collapse;">
    <tr align="center" style="background-color: blue;">
        <th colspan="2">用户登录</th>
    </tr>
    <tr>
        <td>用户名：</td>
        <td><input type="text" name="username" /></td>
    </tr>
    <tr>
        <td>密  码：</td>
        <td><input type="password" name="password"  /></td>
    </tr>
    <tr align="center">
        <td colspan="2"><input type="submit" value="登  录" />&nbsp;&nbsp;&nbsp;<button>注  册</button></td>
    </tr>
</table>
</div>
</body>
</html>
