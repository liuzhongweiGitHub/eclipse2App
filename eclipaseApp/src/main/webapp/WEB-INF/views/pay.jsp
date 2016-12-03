<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
	<form action="/pay" method="post">
		<input type="text" name="money" />
		<input type="hidden" name="token" value="${requestScope.token }"/><!-- 这里获取token需要指定存储空间。request有，session也有 -->
		<button>支付</button>
	</form>
</body>
</html>