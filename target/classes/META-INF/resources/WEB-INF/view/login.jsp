<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="../../js/bootstrap.min.css" rel="stylesheet">
 
<!-- 可选的Bootstrap主题文件（一般不使用） -->
<script src="../../js/bootstrap-theme.min.css"></script>
 
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="../../js/jquery.min.js"></script>
 
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="../../js/bootstrap.min.js"></script>
<style type="text/css">
.container {
	max-width: 450px;
}
</style>
<script type="text/javascript">
$(function(){
	  	//解决java后台跳出iframe的解决方法
	    if (window != top)
	    top.location.href = location.href; 
})
//焦点离开输入框，验证码验证
var codeCheck=false;
$(function(){
	$("#code").blur(function(){
		//获取请求参数
		var code = $("#code").val();
		//发送Ajax请求
		$.ajax({
			url:"/image/checkImage",
			type:"post",
			data:{"code":code},
			dataType:"json",
			success:function(data){//data={"ok":true|false}
				if(data.ok){
					//alert("验证码正确");
					$("#s_code").html("验证码正确");
					codeCheck=true;
				}else{
					//alert("验证错误");
					$("#s_code").html("验证码错误");
					codeCheck=false;
				}
			}
		});
	});
});

function changeJPG(){
	$("#login_img").attr("src","/image/getimage?flag="+Math.random());
}

function submitForm(){
	if(!codeCheck){
		$("#s_code").html("验证码错误");
		return false;
	}
	$("#s_code").html("验证码正确");
	var username=$("#username").val();
	if(username==null||username==""){
		$("#usernameCheck").html("用户名不能为空")
		return false;
	}
	$("#usernameCheck").html("")
	var password=$("#password").val();
	if(password==null||password==""){
		$("#passwordCheck").html("密码不能为空")
		return false;
	}
}
</script>
</head>
<body>
<div class="container">
	<%
	Object error = request.getAttribute("error");
	if(error!=null&&!"".equals(error.toString())) {
	%>
	<div class="alert alert-danger">
		<button type="button" class="close" data-dismiss="alert" aria-hidden="true">
         &times;
        </button>
		${error}
	</div>
	<% } %>
	<form action="login" method="post" onsubmit="return submitForm()">
	<h1 >用户登录</h1>
	<div  class="form-group">
	<input type="text" name="username" id="username" class="form-control" placeHolder="请输入用户名"><br/>
	<span id="usernameCheck"></span>
	</div>
	<div  class="form-group">
	<input type="password" name="password" id="password" class="form-control" placeHolder="请输入密码"><br/>
	<span id="passwordCheck"></span>
	</div>
	<div class="form-group">
		<input type="text" class="input-sm" name="code" id="code" placeHolder="请输入验证码">
		<img alt="" src="/image/getimage" onclick="changeJPG()" id="login_img">
		<a href="javascript:void(0)" onclick="changeJPG()">看不清楚？</a>
		<span id="s_code"></span>
	</div>
	<input type="submit" value="登录" class="btn btn-primary btn-lg btn-block" >
	<span id="result">${result }</span>
	</form>
</div>
</body>
</html>