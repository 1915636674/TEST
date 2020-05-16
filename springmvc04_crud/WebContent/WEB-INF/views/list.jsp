<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%--引入core标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 引入jquery框架包的js文件 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
   //加载事件
  $(function(){
	  //给所有class属性值是del的删除超链接设置点击事件
	  $(".del").click(function(){
		  //拿到当前删除的超链接的href属性值(请求的uri路径)
		  var url = $(this).attr("href");
		  //给form表单的action属性赋值为删除超链接的请求url
		  $("#delForm").attr("action",url);
		  //提交表单
		  $("#delForm").submit();
		  //使删除超链接请求资源失效
		  return false;
	  });
  });
</script>
</head>
<body>
   <center>
     <c:choose>
       <c:when test="${empty requestScope.emps}">
         <h3 style="color:red;">目前没有员工!!!</h3>
       </c:when>
       <c:otherwise>
         <table border="1" cellspacing="0px" width="700px" height="400px">
           <tr>
             <th>工号</th>
             <th>姓名</th>
             <th>性别</th>
             <th>年龄</th>
             <th>邮箱</th>
             <th>部门</th>
             <th>操作</th>
           </tr>
           <c:forEach items="${requestScope.emps}" var="emp">
             <tr align="center">
               <td>${emp.id}</td>
               <td>${emp.ename}</td>
               <td>${emp.gender == 'male' ? '男' : '女'}</td>
               <td>${emp.age}</td>
               <td>${emp.email}</td>
               <td>${emp.dept.dname}</td>
               <td>
               <!-- 发出的也是项目/emp/被编辑员工的请求 -->
                <a href="emp/${emp.id}">编辑</a>
                <!-- 发出的是项目下emp/被删除员工工号的请求   头晕 -->
                <a href="emp/${emp.id}" class="del">删除</a>
                <form action="" method="post" id="delForm">
                  <input type="hidden" name="_method" value="delete"/>
                </form>
               </td>
             </tr>
           </c:forEach>
         </table>
       </c:otherwise>
     </c:choose>
     
     <hr/>
     <h3>
       <a href="emp">添加员工</a>
     </h3>
   </center>
</body>
</html>