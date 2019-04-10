<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>注册/登录</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("basePath", basePath);
%>
<link rel="stylesheet" href="<%=basePath%>csss/bootstrap.min.css">
<link href='<%=basePath%>csss/fonts.css' rel='stylesheet'
	type='text/css'>
<link rel="stylesheet" href="<%=basePath%>csss/ajax.css">
<link rel="stylesheet" href="<%=basePath%>csss/style.css">
</head>

<body>

	<div class="form">

		<ul class="tab-group">
			<li class="tab active"><a href="#signup">注册</a></li>
			<li class="tab"><a href="#login">登录</a></li>
		</ul>

		<div class="tab-content">
			<div id="signup">
				<h1>注册信息</h1>
				<form id="registerForm">
					<div class="top-row">
						<div class="field-wrap">
							<label> 学号<span class="req">*</span>
							</label> <input type="text" required autocomplete="off" name="stuNo" />
						</div>

						<div class="field-wrap">
							<label> 姓名<span class="req">*</span>
							</label> <input type="text" required autocomplete="off" name="stuName" />
						</div>
					</div>

					<div class="field-wrap">
						<label> 设置密码<span class="req">*</span>
						</label> <input type="password" required autocomplete="off"
							name="passWord" />
					</div>
				</form>
				<button type="botton" class="button button-block"
					id="registerButton" />
				确认注册
				</button>

			</div>

			<div id="login">
				<h1>欢迎登陆!</h1>

				<form action="<%=basePath%>login" method="post">

					<div class="field-wrap">
						<label> 学号<span class="req">*</span>
						</label> <input type="number" required autocomplete="off" name="stuNo" />
					</div>

					<div class="field-wrap">
						<label> 密码<span class="req">*</span>
						</label> <input type="password" required autocomplete="off"
							name="passWord" />
					</div>

					<p class="forgot">
						<a id="Modal">忘记密码?</a>
					</p>
					<button class="button button-block" />
					登录
					</button>


				</form>

			</div>
		</div>

		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="myModalLabel">修改密码</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal">

							<div class="form-group">
								<div class="col-sm-6 col-sm-offset-3">
									<input id="stuNo" name="stuNo" class="form-control"
										placeholder="学号">
								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-6 col-sm-offset-3">
									<input id="pwd" name="pwd" type="password" class="form-control"
										placeholder="修改密码">
								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-6 col-sm-offset-3">
									<input id="pwd2" name="pwd2" type="password"
										class="form-control" placeholder="确认密码">
								</div>
							</div>

						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="button" class="btn btn-primary" id="btn">确认修改</button>
					</div>
				</div>
			</div>
		</div>
		<script src='<%=basePath%>jss/jquery.min.js'></script>
		<script src="<%=basePath%>jss/index.js"></script>
		<script src="<%=basePath%>jss/bootstrap.min.js"></script>
		<script type="text/javascript">
			$("#registerButton").click(function() {
				$.ajax({
					url : "<%=basePath%>register",
					data : $("#registerForm").serialize(),
					type : "POST",
					success : function(result) {
						alert(result);
					}
				});
				$("input").each(function() {
					$(this).val("");
				});
			});

			$("#Modal").click(function() {
				$("#myModal").modal({
					backdrop : "static"
				});
			})
			
			$("#btn").click(function(){
				var stuNo = $("#stuNo").val();
				var re = /[0-9]/;
				var pwd = $("#pwd").val();
				var pwd2 = $("#pwd2").val();
				if(!re.test(stuNo) || stuNo=="" || pwd=="" || pwd==""){
					alert("学号只能为数字或没有填满所有字段!");
					return false;
				}else{
					$.ajax({
						url : "<%=basePath%>changePwd",
								data : "stuNo=" + stuNo + "&pwd=" + pwd
										+ "&pwd2=" + pwd2,
								type : "POST",
								success : function(result) {
									alert(result);
									$("input").each(function() {
										$(this).val("");
									});
									$('#myModal').modal('hide');
								}
							});
						}
					})
		</script>
</body>
</html>
