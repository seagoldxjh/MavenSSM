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
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("basePath", basePath);
%>
<link rel="stylesheet" href="<%=basePath%>csss/bootstrap.min.css">
<script src='<%=basePath%>jss/jquery.min.js'></script>
<script src="<%=basePath%>jss/bootstrap.min.js"></script>
<title>任务详情</title>

</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">任务列表</a> <a class="navbar-brand"
					href="#">我的云盘</a> <a class="navbar-brand" href="#">意见反馈</a> <a
					class="navbar-brand" href="#">敬请期待</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">个人信息</a></li>
					<li><a href="<%=basePath%>logout">注销</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container" style="margin-top: 80px;">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<h1 style="text-align: center;">任务详情</h1>
				<p style="text-align: center;"><span  id="state" style="color:red;"></span></p>
				<div class="col-md-6 col-md-offset-3">
				<button type="button" class="btn btn-warning btn-block" id="task_btn">点击接受任务</button>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<form enctype="multipart/form-data"  action="<%=basePath%>upload" method="post">
				<div class="form-group">
						<input readonly="readonly" class="form-control" name="taskId" id="taskId" style="display: none">
					</div>
					<div class="form-group">
						<label for="taskTitle">任务标题</label> <input
							 readonly="readonly" class="form-control" id="taskTitle">
					</div>
					<div class="form-group">
						<label for="taskCreator">任务发起者</label> <input
							 readonly="readonly" class="form-control" id="taskCreator">
					</div>
					<div class="form-group">
						<label for="taskStart">开始日期</label> <input
							 readonly="readonly" class="form-control" id="taskStart">
					</div>
					<div class="form-group">
						<label for="taskEnd">截止日期</label> <input
							 readonly="readonly" class="form-control" id="taskEnd">
					</div>
					<div class="form-group">
						<label for="taskDetails">任务详情介绍</label> 
						<!-- <input readonly="readonly" class="form-control" id="taskDetails"> -->
						<textarea readonly="readonly" id="taskDetails" class="form-control" rows="8"></textarea>
							 <!-- <div class="col-sm-10">
      <p id="taskDetails" class="form-control-static">email@example.com</p>
    </div> -->
					</div>
					<div class="form-group">
						<label for="exampleInputFile">File input</label> <input
							type="file" name="file" id="exampleInputFile">
						<p class="help-block">项目源码及分工打包压缩包上传</p>
					</div>
					
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		var taskId = getParam("taskId");
		$.ajax({
			url : "<%=basePath%>queryTaskById",
			type : "GET",
			data : "taskId=" + taskId,
			success : function(result) {
				console.log("sss");
				$("#taskId").val(result.taskId);
				$("#taskTitle").val(result.taskTitle);
				$("#taskCreator").val(result.taskCreator);
				$("#taskStart").val(dateChange(result.taskStart));
				$("#taskEnd").val(dateChange(result.taskEnd));
				/* $("#taskDetails").val(result.taskDetails); */
				/* $("#taskDetails").html(result.taskDetails); */
				$("#taskDetails").text(result.taskDetails);
			}
		});
		
		$.ajax({
			url : "<%=basePath%>queryTaskState",
			type : "GET",
			data : "taskId=" + taskId,
			success : function(result) {
				if(result != "你还未接受该任务!"){
					$("#task_btn").css('display','none');
				}
				$("#state").html(result);
			}
		}); 
	});
	//获取url中?后的参数
	function getParam(paramName) { 
	    paramValue = "", isFound = !1; 
	    if (this.location.search.indexOf("?") == 0 && this.location.search.indexOf("=") > 1) { 
	        arrSource = unescape(this.location.search).substring(1, this.location.search.length).split("&"), i = 0; 
	        while (i < arrSource.length && !isFound) arrSource[i].indexOf("=") > 0 && arrSource[i].split("=")[0].toLowerCase() == paramName.toLowerCase() && (paramValue = arrSource[i].split("=")[1], isFound = !0), i++ 
	    } 
	    return paramValue == "" && (paramValue = null), paramValue 
	} 
	//js将时间戳转换为yyyy-mm-dd日期格式
	function dateChange(datea){
		var date = new Date(datea);
		Y = date.getFullYear() + '-';
		M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
		D = date.getDate() + ' ';
		return Y+M+D;
	}

	$("#task_btn").click(function(){
		$.ajax({
			url : "<%=basePath%>acceptTask",
			type : "GET",
			data : "taskId=" + getParam("taskId"),
			success : function(result) {
				$("#task_btn").css('display','none');
				$("#state").html(result);
			}
		}); 
	})
</script>
</html>