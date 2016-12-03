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
				<form action="/login" method="post"id="loginform">
					<legend>登陆系统</legend>
					<div class="form-group">
						<label>帐号</label>
						<input type="text" class="form-control" id = "username"name="username" value="${value }"/>
					</div>
					<div class="form-group">
						<label>密码</label>
						<input type="password" class="form-control" name="password"/>
					</div>
					<div class="checkbox">
						<label>
							<input type="checkbox" id="saveUsername" name="check"/> 保存账户
						</label>
					</div>
					<button type="button" class="btn btn-info" id="login">登录</button>
					<%-- <% if(message != null){ %>
						<div class="alert alert-danger"> <%= message %></div>
					<% } %> --%>
					<c:if test="${ not empty message}">
						<div class="alert alert-danger"> ${message }</div>
					</c:if>
				</form>
			</div>
		</div>
	</div>
	
	 <script src="/static/js/jquery-1.11.3.min.js"></script>
	<script src="/static/js/jquery.cookie.js"></script>
	<script>
		$(function(){
			
			
			//每次进来就获取
			/* $("#username").val($.cookie("username")); */
			
			//怎么保存帐户名，1创建点击复选框cookie。每次进来获取一下，获取到就直接填入，获取不到就算了
			$("#login").click(function(){
				//判断复选框是否选中,在jquery里面没有是否选中复选框，所以需要先转换成原生js
			/* 	if($("#saveUsername")[0].checked){
					$.cookie('username',$("#username").val(),{expires:7,path:"/"});
				} */
				$("#loginform").submit();
				
			});
			
			
		}); 
	
	</script>
</body>
</html>