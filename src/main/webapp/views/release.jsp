<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>任务发布</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("basePath", basePath);
%>
<link rel="stylesheet" href="<%=basePath%>csss/bootstrap.min.css">
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
				<h1 style="text-align: center;">任务发布</h1>
				<p style="text-align: center;"><span  id="state" style="color:red;"></span></p>
			</div>
		</div>

		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<form action="<%=basePath%>releaseTask" method="post">
					<div class="form-group">
						<label for="taskTitle">任务标题</label> <input
							  class="form-control" name="taskTitle">
					</div>
					<div class="form-group">
						<label for="taskStart">开始日期</label> <input
							  class="form-control" type="date" name="taskStart">
					</div>
					<div class="form-group">
						<label for="taskEnd">截止日期</label> <input
							  class="form-control" type="date" name="taskEnd">
					</div>
					<div class="form-group">
						<label for="taskDetails">任务详情介绍</label> <input
							  class="form-control" name="taskDetails">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
		</div>
	</div>
	<script src='<%=basePath%>jss/jquery.min.js'></script>
	<script src="<%=basePath%>jss/bootstrap.min.js"></script>
</body>
</html>
