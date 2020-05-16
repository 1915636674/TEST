<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- 引入core标签库 -->
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工列表</title>
 <!-- 引入jQuery -->
 <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery/jquery-1.12.4.min.js"></script>
<!-- 引入bootstrap -->
<script type="text/javascript" 
 src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" 
 href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">

</head>
<body>
<!-- 添加员工模态框 -->
   <div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
     <div class="modal-dialog" role="document">
       <div class="modal-content">
         <div class="modal-header">
           <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
           <h4 class="modal-title" id="myModalLabel">添加员工</h4>
         </div>
         <div class="modal-body">
           <form class="form-horizontal" action="emp" method="post">
		     <div class="form-group">
		       <label class="col-sm-2 control-label">姓名</label>
		       <div class="col-sm-10">
	<input type="text" name="empName" class="form-control" id="empName_add" placeholder="张三">
		         <span class="help-block"></span>
		       </div>
		     </div>
		     <div class="form-group">
		       <label class="col-sm-2 control-label">邮箱</label>
		       <div class="col-sm-10">
		         <input type="text" name="email" class="form-control" id="email_add" placeholder="zs@sina.com">
		         <span class="help-block"></span>
		        </div>
		     </div>
		     <div class="form-group">
		       <label class="col-sm-2 control-label">性别</label>
		       <div class="col-sm-10">
		         <label class="radio-inline">
			       <input type="radio" name="gender" id="gender_add1" value="M" checked/>男
				 </label>
				 <label class="radio-inline">
				   <input type="radio" name="gender" id="gender_add2" value="F"/>女
				 </label>
		       </div>
		     </div>
		     <div class="form-group">
		       <label class="col-sm-2 control-label">部门</label>
		       <div class="col-sm-4">
		         <select class="form-control" name="dId" id="dept_add"></select>
		       </div>
		     </div>
		   </form>
         </div>
         <div class="modal-footer">
           <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
           <button type="button" class="btn btn-primary" id="emp_save_btn">保存</button>
         </div>
       </div>
     </div>
   </div>
   <!-- 编辑员工模态框 -->
   <!-- 编辑员工模态框 -->
   <div class="modal fade" id="empEditModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
     <div class="modal-dialog" role="document">
       <div class="modal-content">
         <div class="modal-header">
           <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
           <h4 class="modal-title">编辑员工</h4>
         </div>
         <div class="modal-body">
           <form class="form-horizontal">
		     <div class="form-group">
		       <label class="col-sm-2 control-label">姓名</label>
		       <div class="col-sm-10">
		      	<p class="form-control-static" id="empName_edit"></p>
		       </div>
		     </div>
		     <div class="form-group">
		       <label class="col-sm-2 control-label">邮箱</label>
		       <div class="col-sm-10">
		         <input type="text" name="email" class="form-control" id="email_edit" placeholder="zs@sina.com">
		         <span class="help-block"></span>
		       </div>
		     </div>
		     <div class="form-group">
		       <label class="col-sm-2 control-label">性别</label>
		       <div class="col-sm-10">
		         <label class="radio-inline">
				   <input type="radio" name="gender" id="gender_edit1" value="M" checked/>男
				 </label>
				 <label class="radio-inline">
				   <input type="radio" name="gender" id="gender_edit2" value="F"/>女
				 </label>
		       </div>
		     </div>
		     <div class="form-group">
		       <label class="col-sm-2 control-label">部门</label>
		       <div class="col-sm-4">
		         <select class="form-control" name="dId"></select>
		       </div>
		     </div>
	 	   </form>
         </div>
         <div class="modal-footer">
           <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
           <button type="button" class="btn btn-primary" id="emp_edit_btn">编辑</button>
         </div>
       </div>
     </div>
   </div>
	<!-- 搭建员工信息显示页面 -->
	<div class="container"><br/>
		<!-- 左上角新增、删除按钮部分 -->
		<div class="row">
			<div class="col-md-4">
				<button class="btn btn-primary" id="emp_add_btn">新增</button>
				<button class="btn btn-danger" id="emp_del_btn">删除</button>
			</div>
		</div><br/>
		<!-- 显示员工信息的表格部分 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover">
					<tr>
					<th>
					<input type="checkbox" id="ck_all"/>
					</th>
					  <th>工号</th>
					  <th>姓名</th>
					  <th>性别</th>
					  <th>邮箱</th>
					  <th>所在部门</th>
					  <th>操作</th>
					</tr>
					<c:forEach items="${pageInfo.list}" var="emp">
					<tr>
					<td>
					<input type="checkbox" class="ck_emp"/>
					</td>
					<td>${emp.empId}</td>
					<td>${emp.empName}</td>
					<td>${emp.gender=="M" ? "男" : "女"}</td>
					<td>${emp.email}</td>
					<td>${emp.department.deptName}</td>
					<td>
					<button class="btn btn-primary btn-sm edit_btn" edit_id="${emp.empId}">
						  <span class="glyphicon glyphicon-pencil"></span>
						      编辑
						</button>
						<button class="btn btn-danger btn-sm del_btn" del_id="${emp.empId}">
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
	<script type="text/javascript">
	$("#emp_add_btn").click(function(){
		clearForm("#empAddModal form")
		getDept("#empAddModal select");
		$("#empAddModal").modal({
			backdrop:"static"
		});
	});
	function getDept(st){
		$(st).empty();
		$.ajax({
			url:"depts",type:"get",success:function(data){
				$.each(data,function(){
					var opt = $("<option></option>").append(this.deptName).attr("value",this.deptId);
					$(st).append(opt);
				});
			}
		});
	}
	$("#emp_save_btn").click(function(){
		
		if(checkForm()&&$("#emp_save_btn").attr("yn")=="success"){
			$("#empAddModal form").submit();
		}
		
	});
	function checkForm(){
		var flag1=1;
		var flag2=1;
		var empName = $("#empName_add").val();
		var empNameReg = /(^[a-zA-Z][a-zA-Z0-9_-]{7,15}$)|(^[\u4e00-\u9fa5]{2,5}$)/;
		if (empNameReg.test(empName)) {
			/*
			$("#empName_add").parent().addClass("has-success");
			$("#empName_add").next("span").text("");
			*/
			formStyleAndMess("#empName_add","success","");
		} else {
			/*
			$("#empName_add").parent().addClass("has-error");
			$("#empName_add").next("span").text("用户名必须是8-16个字符或2-5个中文");
			*/
			
			formStyleAndMess("#empName_add","error","用户名必须是8-16个字符或2-5个中文");
			flag1=0;
		}
		var email = $("#email_add").val();
		var emailReg = /^[a-zA-Z0-9]+@[a-zA-Z0-9]+(\.[a-zA-Z0-9]+)+$/;
		if (emailReg.test(email)) {
			/*
			$("#email_add").parent().addClass("has-success");
			$("#email_add").next("span").text("");
			*/
			formStyleAndMess("#email_add","success","");
		} else {
			/*
			$("#email_add").parent().addClass("has-error");
			$("#email_add").next("span").text("邮箱格式非法");
			*/
			formStyleAndMess("#email_add","error","邮箱格式非法");

			flag2=0;
		}
		if (flag1==1&&flag2==1) {
			return true;
		} else {
			return false;
		}
	}
	function formStyleAndMess(ele,status,mess){
		$(ele).parent().removeClass("has-success has-error");
		$(ele).next("span").text("");
		if (status == "success") {
			$(ele).parent().addClass("has-success");
			$(ele).next("span").text(mess);
		} else if(status == "error") {
			$(ele).parent().addClass("has-error");
			$(ele).next("span").text(mess);
		}
	}
	$("#empName_add").change(function(){
		   var empName = $(this).val();
		   //发送ajax请求校验员工是否已存在
		   $.ajax({
			   url:"hasEmp",
			   data:"empName="+empName,
			   type:"post",
			   success:function(data){
					if(data=="1"){
						formStyleAndMess("#empName_add","success","");
						$("#emp_save_btn").attr("yn","success");
					}else if(data=="0"){
						formStyleAndMess("#empName_add","error","员工已存在");
						$("#emp_save_btn").attr("yn","error");
					}
			   }
		   });
	   });

	function clearForm(ele){
		   //重置表单(清空表单内容)
		   $(ele)[0].reset();
		   //清空表单校验样式
		   $(ele).find("*").removeClass("has-error has-success");
		   //清空所有span标签文本
		   $(ele).find(".help-block").text("");

	}
	$(".edit_btn").click(function(){
		getDept("#empEditModal select");
		getEmpById($(this).attr("edit_id"));
		$("#emp_edit_btn").attr("edit_id",$(this).attr("edit_id"));
		$("#empEditModal").modal({
			backdrop:"static"
		});
	});
	function getEmpById(id){
		$.ajax({
			url:"emp/"+id,
				type:"get",
				success:function(data){
					$("#empName_edit").text(data.empName);
					$("#email_edit").val(data.email);
					$("#empEditModal input[name=gender]").val([data.gender]);
					$("#empEditModal select").val([data.dId]);
				}
		});
	}
	$("#emp_edit_btn").click(function(){
		$.ajax({
			url:"emp/"+$(this).attr("edit_id"),
				type:"post",
			data:$("#empEditModal form").serialize()+"&_method=put",
			success:function(data){
				if(data=="success"){
					window.location.reload();
				}
			}
		});
		
	});
	$(".del_btn").click(function(){
		var empId = $(this).attr("del_id");
		var empName = $(this).parents("tr").find("td:eq(1)").text();
		var yn = confirm("确定删除员工【"+empName+"】？");
		if(yn){
			$.ajax({
				url:"emp/"+empId,
				type:"post",
				data:"_method=delete",
				success:function(data){
					if(data=="success"){
						window.location.reload();
					}
				}
			});
		}
	});
	$("#ck_all").click(function(){
		$(".ck_emp").prop("checked",$(this).prop("checked"));
	});
	$(".ck_emp").click(function(){
		var yn = $(".ck_emp").length==$(".ck_emp:checked").length;
		$("#ck_all").prop("checked",yn);
	});
	$("#emp_del_btn").click(function(){
		var empIds="";
		var empNames="";
		$.each($(".ck_emp:checked"),function(){
			var id=$(this).parents("tr").find("td:eq(1)").text();
			empIds+=id+"-";
			var name=$(this).parents("tr").find("td:eq(2)").text();
			empNames+=name+"-";
		});
		empIds = empIds.substring(0,empIds.length-1);
		empNames = empNames.substring(0,empNames.length-1);
		var yn = confirm("确定删除员工【"+empNames+"】?");
		if(yn){
			$.ajax({
				url:"emp/"+empIds,
				type:"post",
				data:"_method=delete",
				success:function(data){
					if(data=="success"){
						window.location.reload();
					}	
				}
			});
		}
	});
	</script>
</body>
</html>