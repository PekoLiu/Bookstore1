<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
</head>
<body>
   <form action="user" method="post">
        <input type="hidden" name="method" value="register"><br/>
                   用户名:<input type="text" name="username"><br/>
                   密码:<input type="password" name="password"><br/>
        <input type="submit" value="注册"><a href="login.jsp">跳转到登录</a>${msg }
    </form>
</body>
</html>