<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%--引入form标签库 --%>
<%@  taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- 引入core标签库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <center>
    <form:form action="${pageContext.request.contextPath}/emp" method="post" modelAttribute="emp">
    <!-- 说明是添加,显示姓名是文本框 -->
    <c:if test="${emp.id == null}">
              姓名:<form:input path="ename"/><br/><br/>
    </c:if>
    <!-- 说明是编辑,1>提供隐藏框指定id,2>在提供隐藏框将post转成put -->
    <c:if test="${emp.id!=null}">
      <form:hidden path="id"/> 
      <input type="hidden" name="_method" value="put"/>
    </c:if>
              性别:<form:radiobuttons items="${genderMap}" path="gender"/><br/><br/>
              年龄:<form:input path="age"/><br/><br/>
              邮箱:<form:input path="email"/><br/><br/>
              部门:<form:select items="${depts}" itemValue="id" itemLabel="dname" path="dept.id"/>
           <br/><br/>
           <input type="submit" value="提交"/>
    </form:form>
  </center>
</body>
</html>