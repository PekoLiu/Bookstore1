<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登陆</title>
</head>
<body>
	<form action="user" method="post">
        <input type="hidden" name="method" value="login"><br/>
                   用户名:<input type="text" name="username"><br/>
                   密码:<input type="password" name="password"><br/>
        <input type="submit" value="登录"><a href="register.jsp">跳转到注册</a>${msg }
    </form>
</body>
</html>