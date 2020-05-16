<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- 引入core标签库 -->
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工列表</title>

<!-- 引入bootstrap -->
<script type="text/javascript" 
 src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" 
 href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
 
</head>
<body>
	<!-- 搭建员工信息显示页面 -->
	<div class="container"><br/>
		<!-- 左上角新增、删除按钮部分 -->
		<div class="row">
			<div class="col-md-4">
				<button class="btn btn-primary">新增</button>
				<button class="btn btn-danger">删除</button>
			</div>
		</div><br/>
		<!-- 显示员工信息的表格部分 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover">
					<tr>
					  <th>工号</th>
					  <th>姓名</th>
					  <th>性别</th>
					  <th>邮箱</th>
					  <th>所在部门</th>
					  <th>操作</th>
					</tr>
					<c:forEach items="${pageInfo.list}" var="emp">
					<tr>
					<td>${emp.empId}</td>
					<td>${emp.empName}</td>
					<td>${emp.gender=="M" ? "男" : "女"}</td>
					<td>${emp.email}</td>
					<td>${emp.department.deptName}</td>
					<td>
					<button class="btn btn-primary btn-sm">
						  <span class="glyphicon glyphicon-pencil"></span>
						      编辑
						</button>
						<button class="btn btn-danger btn-sm">
						  <span class="glyphicon glyphicon-trash"></span>
						      删除
						</button>
					</td>
					</tr>
					</c:forEach>
					
				</table>
			</div>
		</div>

		<!-- 显示分页信息部分 -->
		<div class="row">
			<!--分页文字信息  -->
			<div class="col-md-6">当前第${pageInfo.pageNum}页,共${pageInfo.pages}页,共${pageInfo.total}条记录</div>
			<!-- 分页条信息 -->
			
			<div class="col-md-6">
			  <nav aria-label="Page navigation">
				<ul class="pagination">
					<li><a href="emps?pn=1">首页</a></li>
					<%-- 处理上一页 --%>
					<c:if test="${pageInfo.hasPreviousPage}">
					<li>
					  <a href="emps?pn=${pageInfo.pageNum-1}" aria-label="Previous"> 
					    <span aria-hidden="true">&laquo;</span>
					  </a>
					</li>
					</c:if>
					<%--遍历pageInfo对象中的数组属性 --%>
					<c:forEach items="${pageInfo.navigatepageNums}" var="page_num">
					<c:choose>
					<c:when test="${pageInfo.pageNum == page_num}">
					<li class="active"><a href="#">${page_num}</a></li>
					</c:when>
					
					<c:otherwise>
					<li><a href="emps?pn=${page_num}">${page_num}</a></li>
					</c:otherwise>
					</c:choose>
					</c:forEach>
					<c:if test="${pageInfo.hasNextPage}">
					<li>
					  <a href="emps?pn=${pageInfo.pageNum+1}" aria-label="Next"> 
					    <span aria-hidden="true">&raquo;</span>
					  </a>
					</li>
					</c:if>
					
					<li><a href="emps?pn=${pageInfo.pages}">尾页</a></li>
				</ul>
			  </nav>
			</div>
		</div>
	</div>
</body>
</html>