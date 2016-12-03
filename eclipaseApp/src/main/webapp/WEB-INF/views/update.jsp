<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%><!-- 导入jstl标签指令 -->
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<form action="/add" method="post">
					<legend>书籍添加</legend>
					<div class="form-group">
						<label>书名</label>
						<input type="text" class="form-control" name = "name" value="${name }"/>
					</div>
					<div class="form-group">
						<label>作者</label>
						<input type="text" class="form-control" name = "auther" value="${auther }"/>
					</div>
					<div class="form-group">
						<label>编号</label>
						<input type="text" class="form-control" name = "isbn" value="${isbn }"/>
					</div>
					<div class="form-group">
						<label>总量</label>
						<input type="text" class="form-control" name = "total" value="${total }"/>
					</div>
					<button class="btn btn-success">添加</button>
					 <c:if test="${not empty message }">
						<div class="alert alert-danger">${message }</div>
					</c:if> 
				</form>
			</div>
		</div>
	</div>
</body>
</html>