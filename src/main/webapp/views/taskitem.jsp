<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	pageContext.setAttribute("basePath", basePath);
%>
<link rel="stylesheet" href="<%=basePath%>csss/bootstrap.min.css">
<link rel="stylesheet" href="<%=basePath%>csss/Model.css">
<script src='<%=basePath%>jss/jquery.min.js'></script>
<script src="<%=basePath%>jss/bootstrap.min.js"></script>
<title>任务列表</title>

<style type="text/css">
	.table-hover>tbody>tr:hover {
    background-color: #424242!important;
    color: black!important;
} 
	tr {
		text-align: center!important;
	}
	
	#firstth>th{
		text-align: center!important;
	}
</style>

</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">任务列表</a>
					<a class="navbar-brand" href="#">我的云盘</a>
					<a class="navbar-brand" href="#">意见反馈</a>
					<a class="navbar-brand" href="#">敬请期待</a>
				</div>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#">个人信息</a></li>
						<li><a href="<%=basePath%>logout">注销</a></li>
					</ul>
				</div>
			</div>
	</nav>
	<div class="container" style="margin-top: 80px;">
		<div class="row">
			<div class="col-md-12">
				<h1>任务列表</h1>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<table id="task_table" class="table table-hover" style="margin-top: 50px;">
					<thead>
						<tr id="firstth" style="">
							<th style="text-align:center;">任务号</th>
							<th>任务标题</th>
							<th>开始时间</th>
							<th>截至时间</th>
							<th>任务发布者</th>
							<th>查看任务详情</th>
						</tr>
					</thead>
					<tbody>
						<!-- <tr>
							<th>1</th>
							<th>ITTI项目开发</th>
							<th>2018-3-4</th>
							<th>2018-5-4</th>
							<th>Admin</th>
							<th>Admin</th>
						</tr>
						<tr>
							<th>2</th>
							<th>ITTI项目开发</th>
							<th>2018-3-4</th>
							<th>2018-5-4</th>
							<th>Admin</th>
							<th>Admin</th>
						</tr> -->
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		$.ajax({
			url : "<%=basePath%>queryAllTask",
			type : "GET",
			success : function(result) {
				build_task_table(result);
			}
		});
	});
	function build_task_table(result) {
		//清空表格数据
		$("#task_table tbody").empty();
		var tasks = result;
		function dateChange(datea){
			var date = new Date(datea);
			Y = date.getFullYear() + '-';
			M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
			D = date.getDate() + ' ';
			return Y+M+D;
		}
		
		$.each(tasks, function(index, item) {
			var taskId = $("<td></td>").append(item.taskId);
			var taskTitle = $("<td></td>").append(item.taskTitle);
			var taskStart = $("<td></td>").append(dateChange(item.taskStart));
			var taskEnd = $("<td></td>").append(dateChange(item.taskEnd));
			var taskCreator = $("<td></td>").append(item.taskCreator);
			var editBtn = $("<button></button>").addClass(
					"btn btn-primary btn-sm edit_btn").append(
					$("<span></span>").addClass("glyphicon glyphicon-pencil"))
					.append("查看详情");
			editBtn.attr("edit_taskId",item.taskId);
			var btnTd = $("<td></td>").append(editBtn).append(" ").attr("style", "width: 15%;");
			$("<tr></tr>").append(taskId).append(taskTitle).append(taskStart)
					.append(taskEnd).append(taskCreator).appendTo("#task_table tbody").append(btnTd);
		});
		
		 $(document).on("click",".edit_btn",function(){
				 var taskId = $(this).attr("edit_taskId");
				$.ajax({
					url : "<%=basePath%>queryTaskStu",
					type : "GET",
					data : "taskId=" + taskId,
					success : function(result) {
						console.log($(this).attr("edit_taskId"));
						var ixi =1;
						console.log(taskId);
						/* alert(taskId); */
						/* window.location.href = result+".jsp?taskid="+taskId; */
						window.location.href = result;
					}
				}); 
			/* window.location.href = "taskdetails.jsp?taskid="+$(this).attr("edit_taskId"); */
		});
	}
</script>
</html>