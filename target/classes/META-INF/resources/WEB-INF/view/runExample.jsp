<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="UTF-8">
<title>执行案例</title>
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
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<script type="text/javascript" src="../../layer/layer/layer.js"></script>
<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
<style type="text/css">
.margin_top_20 {
	margin-top: 20px;
}
</style>
<script type="text/javascript">

function run(case_id)  {  
	$.ajax({
		url:"${pageContext.request.contextPath}/run",
		type:"post",
		data:{"case_id":case_id},
		dataType:"json",
		success:function(data){
			if(data.res==1){
				alert("执行成功");
			}else{
				alert("执行失败");
			}
		}
	});
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

		<form class="form-horizontal" action="findExample" method="post">
			<div class="col-sm-4" style="margin-top: 20px;">
				<label for="code" class="col-sm-4 control-label">案例编号</label>
				<div class="col-sm-8">
					<input  class="form-control" placeholder="案例编号" id="code" name="code" >
				</div>
			</div>
			<div class="col-sm-4" style="margin-top: 20px;">
				<label for="ip" class="col-sm-4 control-label">服务ID</label>
				<div class="col-sm-8">
					<input  class="form-control" placeholder="服务ID" id="service_id" name="service_id">
				</div>

			</div>
			<div class="col-sm-4" style="margin-top: 20px;">
				<label for="port" class="col-sm-4 control-label">服务名称</label>
				<div class="col-sm-8">
					<input  class="form-control" placeholder="服务名称" id="service_name" name="service_name">
				</div>
			</div>
			<div class="col-sm-4" style="margin-top: 20px;">
				<label for="url" class="col-sm-4 control-label">模块编号</label>
				<div class="col-sm-8">
					<input  class="form-control" placeholder="模块编号" id="modules" name="modules">
				</div>
			</div>
			<div class="col-sm-4" style="margin-top: 20px;">
				<label for="name" class="col-sm-4 control-label">组件编号</label>
				<div class="col-sm-8">
					<input  class="form-control" placeholder="组件编号" id="elements" name="elements">
				</div>
			</div>
			<div class="col-sm-4" style="margin-top: 20px;">
				<label for="name" class="col-sm-4 control-label">项目编号</label>
				<div class="col-sm-8">
					<input  class="form-control" placeholder="项目编号" id="pro_id" name="projects">
				</div>
			</div>
			<div class="col-sm-4" style="margin-top: 20px;">
				<label for="name" class="col-sm-4 control-label">平台ID</label>
				<div class="col-sm-8">
					<input  class="form-control" placeholder="平台ID" id="platform" name="platform">
				</div>
			</div>
			<div class="col-sm-4" style="margin-top: 20px;">
				<label for="name" class="col-sm-4 control-label">案例名称</label>
				<div class="col-sm-8">
					<input  class="form-control" placeholder="案例名称" id="name" name="name">
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
<!-- 			<div class="logo navbar-logo f-l mr-10 hidden-xs" -->
<!-- 				style="width: 184px; text-align: left;" onclick="run();" id="add">执行</div> -->
		</div>
	</div>
	<div class="container" style="float: left; width: 100%;padding-left: 0px;padding-right: 0px;">
	
	
		<div class="table-responsive" >
			<table id="tab" class="table table-striped table-hover"  style="float: left;font-size: 20px;" >
				<tr class="danger">
					<th>操作</th><th>案例ID</th><th>案例名称</th><th>用户名称</th><th>服务ID</th><th>服务名称</th><th >创建时间</th><th>协议类型</th></tr>
				<c:forEach items="${cases}" var="cas">
				<tr>
					<td><input type="button" class="btn btn-info" value="执行" onclick="run(${cas.id})"></td><td>${cas.id}</td><td>${cas.name}</td><td>用户名</td><td>${cas.service_id}</td><td>${cas.service_name}</td><td>${cas.create_time}</td><td>${cas.case_type}</td>
				</tr>
				</c:forEach>
			</table>
		</div>
</div>

</body>
</html>