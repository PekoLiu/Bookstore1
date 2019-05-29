<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript">
	function del(bid){
		var bool = confirm("确定删除？");
		if(bool){
			location.href="book?method=del&bid=" + bid;
		}
	}
</script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   欢迎你，${user }<br>
   <table width="500px" border="1" cellspacing="0" cellpadding="3">
   		<tr>
	   		<td>编号</td>
	   		<td>书名</td>
	   		<td>作者</td>
	   		<td>价格</td>
	   		<td>操作</td>
   		</tr>
   		<c:forEach items="${books }" var="book">
   			<tr>
   				<td>${book.bid }</td>
   				<td>${book.bname }</td>
   				<td>${book.author }</td>
   				<td>${book.price }</td>
   				<td><a herf="#" onclick="del(${book.bid })">删除</a></td>
   			</tr>
   		</c:forEach>
   </table>
</body>
</html>