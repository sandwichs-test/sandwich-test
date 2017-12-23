<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="UTF-8">
<title>用户管理</title>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico">
<link rel="Shortcut Icon" href="/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="../../lib/html5shiv.js"></script>
<script type="text/javascript" src="../../lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css"
	href="../../static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="../../static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="../../lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="../../static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css"
	href="../../static/h-ui.admin/css/style.css" />

<link rel="stylesheet" type="text/css" href="../../js/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="../../css/bootstrap-theme.min.css" />
<!-- <link rel="stylesheet" type="text/css" -->
<!-- 	href="../../layui/layui/css/layui.css" /> -->
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<script type="text/javascript" src="../../layer/layer/layer.js"></script>
<!-- <script type="text/javascript" src="../../layui/layui/layui.all.js"></script> -->
<!-- <script type="text/javascript" src="../../layui/layui/layui.js"></script> -->
<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
<style type="text/css">
.margin_top_20 {
	margin-top: 20px;
}
</style>
<script type="text/javascript">
function checkUsername(){
	var newUsername=$("#username1").val();
	$.ajax({
		type: "post",
		url: "/checkUsername",
		data: {"username": newUsername},
		success: function (data) {
			if(data.res==1){
	            $("#checkUsernameRes").html("该用户已存在");
	            $("#submitBtn").attr("disabled", true); 
			}else{
				$("#checkUsernameRes").html("")
				$("#submitBtn").attr("disabled", false); 
			}
        },
		error: function () {
			alert("添加失败");
        }
	});
}
function add(){
	 layer.open({
		 title: '在线调试'
			  ,content: '<form action="addUser" method="post" class="layui-form">'+
			  '<input id="username" name="username" required lay-verify="required" onblur="checkUsername();" class="form-control" placeholder="用户名""><br>'+
			  '<span id="checkUsernameRes"></span>'+
			  '<input id="password" name="password" required  lay-verify="required"  class="form-control" placeholder="用户密码" ><br>'+
			  '<input id="email" name="email" type="text" required lay-verify="required|email" class="form-control" placeholder="email" ><br>'+
			  '<div style="text-align:center;"><input class="btn btn-default" id="submitBtn" type="submit" value="提交"><span>&nbsp;&nbsp;&nbsp;&nbsp;</span><input type="reset" class="btn btn-default" value="重置"> </div> </from>'
			  ,area:['500px', '400px']
	 });
}

function findUser(){
	var username=$("#username").val();
	var email=$("#emai").val();
	$("#tab").empty();
	$.ajax({
		type: "post",
		url: "/queryUser",
		data: {"username": username,"email":email},
		success: function (data) {
            $('#tab').append("<tr><th>用户名</th><th>用户密码</th><th>E-mail</th><th >操作</th></tr>");
            
            for (var i = 0; i < data.length; i++) {
                $('#tab').append("<tr><td>"+data[i].username+"</td><td>"+data[i].password+"</td><td>"+data[i].email+"</td><td><input type=\"button\" value=\"更新\" class=\"btn btn-info\" onclick=\"update(this)\"></td></tr>");
			}
        },
		error: function () {
			alert("加载失败");
        }
	});
}
function update(obj){
	 layer.open({
		 title: '在线调试'
			  ,content: 
			  '<form action="updateUser" method="post" class="layui-form">'+
			  '<input  name="username" class="form-control" required lay-verify="required" placeholder="用户名" value="'+$(obj).parent().prev().prev().prev().text()+'" readonly><br>'+
			  '<input  name="password" required lay-verify="required"  class="form-control" placeholder="用户密码" value="'+$(obj).parent().prev().prev().text()+'"><br>'+
			  '<input  name="email" required lay-verify="email" class="form-control" placeholder="email" value="'+$(obj).parent().prev().text()+'"><br>'+
			  '<div style="text-align:center;"><input class="btn btn-default" type="submit" value="提交"><span>&nbsp;&nbsp;&nbsp;&nbsp;</span><input type="reset" class="btn btn-default" value="重置"> </div> </from>'
			  ,area: ['500px', '400px']
	 });
}
function doclick(obj)  {  
    alert(); 
} 
function aa(){
	alert("aa")
}
</script>
</head>
<body>
	<div class="navbar ">
		<div class="container-fluid cl">
			<div class="logo navbar-logo f-l mr-10 hidden-xs"
				style="width: 184px; text-align: left;">功能菜单</div>
			<a class="logo navbar-logo-m f-l mr-10 visible-xs"></a>

		</div>
	</div>
	<div class="container-fluid">

		<form class="form-horizontal" action="queryUser" method="post">
			<div class="col-sm-8" style="margin-top: 20px;">
				<label for="username" class="col-sm-4 control-label">用户名</label>
				<div class="col-sm-8">
					<input  id="username" name="username" class="form-control" placeholder="用户名">
				</div>
			</div>

			<div class="col-sm-8" style="margin-top: 20px;">
				<label for="email" class="col-sm-4 control-label">E-mail</label>
				<div class="col-sm-8">
					<input  id="email" name="email" class="form-control" placeholder="email">
				</div>
			</div>
			
			<div>
				<div class="col-sm-12" style="margin-top: 20px; text-align: center;">
					<button type="submit" class="btn btn-default">查询</button>
					<button type="reset" class="btn btn-default">重置</button>
				</div>

			</div>

		</form>
	</div>
	<div class="navbar" style="margin-top: 20px;margin-bottom: 0px;">
		<div class="container-fluid cl">
			<div class="logo navbar-logo f-l mr-10 hidden-xs"
				style="width: 184px; text-align: left;">查询结果</div>
			<div class="logo navbar-logo f-l mr-10 hidden-xs"
				style="width: 184px; text-align: left;" onclick="add();" id="add">新增</div>
		</div>
	</div>
	<div class="container" style="float: left; width: 100%;padding-left: 0px;padding-right: 0px;">
	
	
		<div class="table-responsive" >
			<table id="tab" class="table table-striped table-hover"  style="float: left;font-size: 20px;" >
				<tr class="danger">
					<th>用户名</th><th>用户角色</th><th>E-mail</th><th >操作</th></tr>
				<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.username}</td><td><c:choose><c:when test="${user.status == 1}">管理员</c:when><c:otherwise>测试人员</c:otherwise></c:choose></td><td>${user.email}</td><td><input type="button" value="更新" class="btn btn-info" onclick="update(this)"></td>
				</tr>
				</c:forEach>
			</table>
		</div>
</div>

</body>
</html>