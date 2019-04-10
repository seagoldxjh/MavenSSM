<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="width:100%;height:100%;">
<head>
<meta charset="UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("basePath", basePath);
%>
<link rel="stylesheet" href="<%=basePath%>csss/bootstrap.min.css">
<link rel="stylesheet" href="<%=basePath%>csss/Model.css">
<title>模块选择</title>
</head>
<body style="width:100%;height:100%;">
<div class="jumbotron text-center">
  <div class="container">
    
    <h1>IT&copy;TI工作室</h1>
    <p style="color:#888;">IT&copy;TI工作室大家庭欢迎您的加入!</p>
    
  </div>
</div>
<div class="container"> 
  <!-- Example row of columns -->
  
  <div class="row">
    <div class="col-md-12 text-center">
      <h2>模块选择</h2>
    </div>
  </div>
  
  <div class="row">
    <div class="col-md-3 col-sm-3 col-xs-6"> <a href="<%=basePath%>views/taskitem.jsp" class="btn btn-sm animated-button victoria-one">任务列表</a> </div>
    <div class="col-md-3 col-sm-3 col-xs-6"> <a href="#" class="btn btn-sm animated-button victoria-two">在线影院</a></div>
    <div class="col-md-3 col-sm-3 col-xs-6"> <a href="#" class="btn btn-sm animated-button victoria-three">我的云盘</a> </div>
    <div class="col-md-3 col-sm-3 col-xs-6"> <a href="#" class="btn btn-sm animated-button victoria-four">个人信息</a> </div>
  </div>
  
  <div class="row">
    <div class="col-md-12 text-center">
      <h2 class="mrng-60-top">敬请期待</h2>
    </div>
  </div>
  
  <div class="row">
    <div class="col-md-3 col-sm-3 col-xs-6"> <a href="#" class="btn btn-sm animated-button sandy-one">敬请期待</a> </div>
    <div class="col-md-3 col-sm-3 col-xs-6"> <a href="#" class="btn btn-sm animated-button sandy-two">敬请期待</a> </div>
    <div class="col-md-3 col-sm-3 col-xs-6"> <a href="#" class="btn btn-sm animated-button sandy-three">敬请期待</a> </div>
    <div class="col-md-3 col-sm-3 col-xs-6"> <a href="#" class="btn btn-sm animated-button sandy-four">敬请期待</a> </div>
  </div>
  
  
  
  <!-- <div class="row">
    <div class="col-md-12 text-center">
      <h2 class="mrng-60-top">Gibson</h2>
    </div>
  </div>
  
  <div class="row">
    <div class="col-md-3 col-sm-3 col-xs-6"> <a href="#" class="btn btn-sm animated-button gibson-one">Sign up</a> </div>
    <div class="col-md-3 col-sm-3 col-xs-6"> <a href="#" class="btn btn-sm animated-button gibson-two">Login</a> </div>
    <div class="col-md-3 col-sm-3 col-xs-6"> <a href="#" class="btn btn-sm animated-button gibson-three">Register</a> </div>
    <div class="col-md-3 col-sm-3 col-xs-6"> <a href="#" class="btn btn-sm animated-button gibson-four">Learn more</a> </div>
  </div>
  
  
  
  <div class="row">
    <div class="col-md-12 text-center">
      <h2 class="mrng-60-top">Thar</h2>
    </div>
  </div>
  
  <div class="row">
    <div class="col-md-3 col-sm-3 col-xs-6"> <a href="#" class="btn btn-sm animated-button thar-one">Sign up</a> </div>
    <div class="col-md-3 col-sm-3 col-xs-6"> <a href="#" class="btn btn-sm animated-button thar-two">Login</a> </div>
    <div class="col-md-3 col-sm-3 col-xs-6"> <a href="#" class="btn btn-sm animated-button thar-three">Register</a> </div>
    <div class="col-md-3 col-sm-3 col-xs-6"> <a href="#" class="btn btn-sm animated-button thar-four">Learn more</a> </div>
  </div> -->
</div>
<footer class="jumbotron text-center">
  <div class="container">
    <p style="color:#888">IT&nbsp;TI工作室&copy;所有 <a href="#">雪秀科技</a></p>
    </div>
  </footer>
  
  

</body>

</html>
</body>
		<script src='<%=basePath%>jss/jquery.min.js'></script>
		<script src="<%=basePath%>jss/bootstrap.min.js"></script>
</html>