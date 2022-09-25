<%--
  Created by IntelliJ IDEA.
  User: XZR
  Date: 2022/7/24
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>密码修改</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/user.do" method="get">
    ${MESSAGE}
    <div>输入旧密码:<input type="text" name="old_password"></div>
    <div>输入新密码:<input type="text" name="new_password"></div>
    <div>确认新密码:<input type="text" name="new_confirm_password"></div>
    <input type="hidden" name="method" value="pwdModify">
    <div><input type="submit" value="确认"></div>
</form>

</body>
</html>
