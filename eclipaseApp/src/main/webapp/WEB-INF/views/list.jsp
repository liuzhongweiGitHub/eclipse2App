
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
		<a href="/add" class="btn btn-info">添加书籍</a>
		<a href="/logout" class="btn btn-info">安全退出</a>
		<table class="table">
			<thead>
				<tr>
					<th>书名</th>
					<th>作者</th>
					<th>编码</th>
					<th>总量</th>
					<th>现有数量</th>
				</tr>	
			</thead>
			<tbody>
				<c:if test="${empty page.item }"><%-- 、没有获取到数据 --%>
					<tr>
						<td>暂无数据</td>
					</tr>
				</c:if>
				<c:forEach items="${page.item }" var="book">
					<tr>
						<td>${book.name }</td>
						<td>${book.auther}</td>
						<td>${book.isbn }</td>
						<td>${book.total }</td>
						<td>${book.nownum }</td>
						<td><a href="javascript:;" rel="${book.id}" class="update">修改</a></td>
						<td><a href="javascript:;" rel="${book.id}" class="del">删除</a></td>
					</tr>
			    </c:forEach>
			</tbody>
		</table>
		<%-- <nav>最上或最后一页时，让其不能点击首页和上一页.disabled禁止点击
			<ul class="pagination pull-right">
		  		<c:choose>
				  	<c:when test="${page.pageNo == 1 }">这里是从服务器响应过来的page，所以在构造方法里面已经对pageNo的值进行约束了，>=1，所以这里只用约束=1情况就行，或者直接》1  	  
					    <li class="disabled"><a href="/list?p=1">首页</a></li>
					    <li class="disabled"><a href="/list?p=${page.pageNo-1 }">上一页</a></li>
					  
					</c:when>	
					<c:otherwise>
						<li><a href="/list?p=1">首页</a></li>
						<li><a href="/list?p=${page.pageNo-1 }">上一页</a></li>
					</c:otherwise>
				</c:choose>
				
				<c:choose>
				  	<c:when test="${page.pageNo == page.totalPage }">这里是从服务器响应过来的page，所以在构造方法里面已经对pageNo的值进行约束了，>=1，所以这里只用约束=1情况就行，或者直接》1 
					    <li class="disabled"><a href="/list?p=${page.pageNo+1 }">下一页</a></li>
					    <li class="disabled"><a href="/list?p=${page.totalPage }">尾页</a></li>
					</c:when>	
					<c:otherwise>
					    <li><a href="/list?p=${page.pageNo+1 }">下一页</a></li>
					    <li><a href="/list?p=${page.totalPage }">尾页</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</nav> --%>
		
		
		
		<nav>
			<ul id="pagination" class="pagination pull-right"></ul>
		</nav>
	</div>
	
	<script src="/static/js/jquery-1.11.3.min.js"></script>
	<script src="/static/js/jquery.twbsPagination.min.js"></script>
	<script>
		$(function(){
			
			$("#pagination").twbsPagination({
                totalPages:${page.totalPage},
                visiblePages:5,
                href:"/list?p={{number}}",
                first:"首页",
                prev:"上一页",
                next:"下一页",
                last:"末页"
            });
			
				

			
			
			
			
			$(".update").click(function() {
				if(confirm("确定修改吗？")){
					var id = $(this).attr("rel");
					//在javascript里面跳转到servlet,地址栏会跳转到update。可以通过地址栏修改属性值，需要做判断，不符合要求给错误404
					location.href="/update?id=" + id;
				}
				
			
			});
			
			$(".del").click(function() {
				if(confirm("确定删除吗？")){//confirm弹框确定或者取消
					
					var id = $(this).attr("rel");
					//在javascript里面跳转到servlet
					location.href="/del?id=" + id;//location.href=""在script里面跳转
				}
				
			
			});
		});
	
	</script>
	
</body>
</html>