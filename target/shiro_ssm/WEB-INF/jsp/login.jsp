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
</head>
<body>
<div> ${error}</div>
<form action="${pageContext.request.contextPath}/login" method="post">
	<table>
	    <tr>
	        <td colspan="2">用户登录</td>
	    </tr>
	    <tr>
	        <td>用户名：</td>
	        <td><input type="text" name="username" /></td>
	    </tr>
	    <tr>
	        <td>密  码：</td>
	        <td><input type="password" name="password"  /></td>
	    </tr>
	    <tr>
	        <td><input type="submit" value="登  录" /></td>
	        <td><button>注  册</button></td>
	    </tr>
	</table>
</form>
</body>
</html>
