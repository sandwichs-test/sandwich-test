<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="UTF-8">
<title>项目管理</title>
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
function add(){
	 layer.open({
		 title: '在线调试'
			  ,content: '<form action="addProject" method="post"><input  name="name" class="form-control" placeholder="中文名称"><br>'+
			  '<input  name="ename" class="form-control" placeholder="英文名称"><br>'+
			  '<input  name="description" class="form-control" placeholder="项目描述"><br>'+
			  '<div style="text-align:center;"><input type="submit" class="btn btn-default" value="提交"></div> </from>'
			  ,area:['500px', '400px']
	 });
}
function update(obj){
	$(obj).parent().prev().text()
	 layer.open({
		 title: '在线调试'
			  ,content: 
			  '<form action="updateProject" method="post">'+
			  '<input  class="form-control" placeholder="项目编号" value="'+$(obj).parent().prev().prev().prev().prev().text()+'" disabled="disabled"><br>'+
			  '<input  name="code" type="hidden" class="form-control" placeholder="项目编号" value="'+$(obj).parent().prev().prev().prev().prev().text()+'"><br>'+
			  '<input  name="name" class="form-control" placeholder="中文名称" value="'+$(obj).parent().prev().prev().prev().text()+'"><br>'+
			  '<input  name="ename" class="form-control" placeholder="英文名称" value="'+$(obj).parent().prev().prev().text()+'"><br>'+
			  '<input  name="description" class="form-control" placeholder="项目描述" value="'+$(obj).parent().prev().text()+'"><br>'+
			  '<div style="text-align:center;"><input class="btn btn-default" type="submit" value="提交"><span>&nbsp;&nbsp;&nbsp;&nbsp;</span><input type="reset" class="btn btn-default" value="重置"> </div> </from>'
			  ,area: ['500px', '400px']
			 
	 });
}
function doclick(obj)  {  
    alert(); 
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

		<form class="form-horizontal" action="queryProject" method="post">
			<div class="col-sm-6" style="margin-top: 20px;">
				<label for="code" class="col-sm-4 control-label">项目编号</label>
				<div class="col-sm-8">
					<input  class="form-control" placeholder="项目编号" id="code" name="code">
				</div>
			</div>
			<div class="col-sm-6" style="margin-top: 20px;">
				<label for="name" class="col-sm-4 control-label">中文名称</label>
				<div class="col-sm-8">
					<input  class="form-control" placeholder="中文名称" id="name" name="name">
				</div>

			</div>
			<div class="col-sm-6" style="margin-top: 20px;">
				<label for="ename" class="col-sm-4 control-label">英文名称</label>
				<div class="col-sm-8">
					<input  class="form-control" placeholder="英文名称" id="ename" name="ename">
				</div>
			</div>
			<div class="col-sm-6" style="margin-top: 20px;">
				<label for="description" class="col-sm-4 control-label">项目描述</label>
				<div class="col-sm-8">
					<input  class="form-control" placeholder="项目描述" id="description" name="description">
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
					<th>项目编号</th><th>中文名称</th><th>英文名称</th><th>项目描述</th><th >操作</th></tr>
				<c:forEach items="${pros}" var="pro">
				<tr>
					<td>${pro.code}</td><td>${pro.name}</td><td>${pro.ename}</td><td>${pro.description}</td><td><input type="button" value="更新" class="btn btn-info" onclick="update(this)"></td>
				</tr>
				</c:forEach>
			</table>
		</div>
</div>

</body>
</html>