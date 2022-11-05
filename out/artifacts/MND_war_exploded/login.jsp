<%--
  Created by IntelliJ IDEA.
  User: XZR
  Date: 2022/4/4
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link type="text/css" rel="stylesheet" href="/css/login.css">
</head>
<body>

<div id="login">
    <form action="${pageContext.request.contextPath}/login" method="get" id="form-login">
        <div class="info">${MESSAGE}</div>
        <div>
            <span class="text">邮箱:</span>
            <span class="text-input"><input type="text" name="email"></span>
        </div>
        <div>
            <span class="text">密码:</span>
            <span class="text-input"><input type="text" name="password"></span>
        </div>
        <span><input type="submit" value="登录"></span>
        <span><a href="/toSignin">注册</a></span>
    </form>
</div>

</body>
</html>
