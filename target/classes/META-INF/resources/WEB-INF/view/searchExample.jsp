<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="UTF-8">
<title>查询案例</title>
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
			  ,content: '<form action="addModule" method="post" class="layui-form"><input  name="name" class="form-control" placeholder="模块名称"><br>'+
			  '<select  class="" id="projects" name="proId" style="width:100% ;font-size:23px;" onchange="getElements()"> '+
			  '<option  value="">项目名称</option>'+
              '<c:forEach items="${pros}" var="pro">'+
              '<option  id="pro_id" value="${pro.id}" onlick="">${pro.name}</option>'+
              '</c:forEach>'+
      		  '</select>'+
			  
			  '<select  class="" id="elements" name="eleId" style="width:100% ;font-size:23px;margin-top:20px" > '+
			  '<option  value="">组件名称</option>'+
      		  '</select>'+
			  '<div style="text-align:center;"><input type="submit" class="btn btn-default" value="提交"></div> </from>'
			  ,area:['500px', '400px']
	 });
}

function getElements() {
	var id = $("#projects").val();
	$("#elements").empty();
	$.ajax({
		type: "post",
		url: "/getElements",
		data: {"id": id},
		success: function (data) {
            $('#elements').append("<option value=''>" + '组件名称' + "</option>");
            for (var i = 0; i < data.length; i++) {
                $('#elements').append("<option value='" + data[i].id + "' >" + data[i].name + "</option>");
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
				  '<form class="form-horizontal" action="" method="post">                                                                  '+
				  '			<div class="col-sm-6" style="margin-top: 20px;">                                                             '+
				  '				<label for="inputEmail3" class="col-sm-4 control-label" style="padding-top: 0px; line-height: 15px;">    '+
				  '					<span>案例名称</span><br>                                                                            '+
				  '					<span style="color: red;font-size: 12px;">服务名称-四位编号</span>                                   '+
				  '				</label>                                                                                                 '+
				  '				<div class="col-sm-8">                                                                                   '+
				  '					<input  class="form-control" placeholder="模块编号">                                                 '+
				  '				</div>                                                                                                   '+
				  '			</div>                                                                                                       '+
				  '			<div class="col-sm-6" style="margin-top: 20px;">                                                             '+
				  '				<label for="inputEmail3" class="col-sm-4 control-label">案例类型</label>                                 '+
				  '				<div class="col-sm-8">                                                                                   '+
				  '					<input  class="form-control" placeholder="模块名称">                                                 '+
				  '				</div>                                                                                                   '+
				  '			</div>                                                                                                       '+
				  '			<div class="col-sm-6" style="margin-top: 20px;">                                                             '+
				  '				<label for="inputEmail3" class="col-sm-4 control-label">服务ID</label>                                   '+
				  '				<div class="col-sm-8">                                                                                   '+
				  '					<input  class="form-control" placeholder="组件名称">                                                 '+
				  '				</div>                                                                                                   '+
				  '			</div>                                                                                                       '+
				  '			<div class="col-sm-6" style="margin-top: 20px;">                                                             '+
				  '				<label for="inputEmail3" class="col-sm-4 control-label">服务名称</label>                                 '+
				  '				<div class="col-sm-8">                                                                                   '+
				  '					<input  class="form-control" placeholder="项目名称">                                                 '+
				  '				</div>                                                                                                   '+
				  '			</div>                                                                                                       '+
				  '			<div class="col-sm-6" style="margin-top: 20px;">                                                             '+
				  '				<label for="inputEmail3" class="col-sm-4 control-label">协议类型</label>                                 '+
				  '				<div class="col-sm-8">                                                                                   '+
				  '					<select class="selectpicker"  name="" style="width: 100%;font-size: 20px;" >                         '+
				  '						<option  value="">协议类型</option>                                                              '+
				  '						<option  value="0">DIVCSS5</option>                                                              '+
				  '			      		<option  value="1">DIVCSS5</option>                                                              '+
				  '		      		</select>                                                                                            '+
				  '	      		</div>                                                                                                   '+
				  '			</div>                                                                                                       '+
				  '			<div class="col-sm-6" style="margin-top: 20px;">                                                             '+
				  '				<label for="inputEmail3" class="col-sm-4 control-label">被测组件环境信息</label>                         '+
				  '				<div class="col-sm-8">                                                                                   '+
				  '					<select class="selectpicker"  name="" style="width: 100%;font-size: 20px;" >                         '+
				  '						<option  value="">被测组件环境信息</option>                                                      '+
				  '						<option  value="0">DIVCSS5</option>                                                              '+
				  '			      		<option  value="1">DIVCSS5</option>                                                              '+
				  '		      		</select>                                                                                            '+
				  '	      		</div>                                                                                                   '+
				  '			</div>                                                                                                       '+
				  '			<div class="col-sm-6" style="margin-top: 20px;">                                                             '+
				  '				<label for="inputEmail3" class="col-sm-4 control-label">项目名称</label>                                 '+
				  '				<div class="col-sm-8">                                                                                   '+
				  '					<select class="selectpicker"  name="" style="width: 100%;font-size: 20px;" >                         '+
				  '						<option  value="">项目名称</option>                                                              '+
				  '						<option  value="0">DIVCSS5</option>                                                              '+
				  '			      		<option  value="1">DIVCSS5</option>                                                              '+
				  '		      		</select>                                                                                            '+
				  '	      		</div>                                                                                                   '+
				  '			</div>                                                                                                       '+
				  '			<div class="col-sm-6" style="margin-top: 20px;">                                                             '+
				  '				<label for="inputEmail3" class="col-sm-4 control-label">组件名称</label>                                 '+
				  '				<div class="col-sm-8">                                                                                   '+
				  '					<select class="selectpicker"  name="" style="width: 100%;font-size: 20px;" >                         '+
				  '						<option  value="">组件名称</option>                                                              '+
				  '						<option  value="0">DIVCSS5</option>                                                              '+
				  '			      		<option  value="1">DIVCSS5</option>                                                              '+
				  '		      		</select>                                                                                            '+
				  '	      		</div>                                                                                                   '+
				  '			</div>                                                                                                       '+
				  '			<div class="col-sm-6" style="margin-top: 20px;">                                                             '+
				  '				<label for="inputEmail3" class="col-sm-4 control-label">所属模块</label>                                 '+
				  '				<div class="col-sm-8">                                                                                   '+
				  '					<select class="selectpicker"  name="" style="width: 100%;font-size: 20px;" >                         '+
				  '						<option  value="">所属模块</option>                                                              '+
				  '						<option  value="0">DIVCSS5</option>                                                              '+
				  '			      		<option  value="1">DIVCSS5</option>                                                              '+
				  '		      		</select>                                                                                            '+
				  '	      		</div>                                                                                                   '+
				  '			</div>                                                                                                       '+
				  '			<div class="col-sm-6" style="margin-top: 20px;">                                                             '+
				  '				<label for="inputEmail3" class="col-sm-4 control-label">案例性质</label>                                 '+
				  '				<div class="col-sm-8">                                                                                   '+
				  '					<select class="selectpicker"  name="" style="width: 100%;font-size: 20px;" >                         '+
				  '						<option  value="">案例性质</option>                                                              '+
				  '						<option  value="0">DIVCSS5</option>                                                              '+
				  '			      		<option  value="1">DIVCSS5</option>                                                              '+
				  '		      		</select>                                                                                            '+
				  '	      		</div>                                                                                                   '+
				  '			</div>                                                                                                       '+
				  '			<div class="col-sm-6" style="margin-top: 20px;">                                                             '+
				  '				<label for="inputEmail3" class="col-sm-4 control-label">所属平台</label>                                 '+
				  '				<div class="col-sm-8">                                                                                   '+
				  '					<select class="selectpicker"  name="" style="width: 100%;font-size: 20px;" >                         '+
				  '						<option  value="">所属平台</option>                                                              '+
				  '						<option  value="0">DIVCSS5</option>                                                              '+
				  '			      		<option  value="1">DIVCSS5</option>                                                              '+
				  '		      		</select>                                                                                            '+
				  '	      		</div>                                                                                                   '+
				  '			</div>                                                                                                       '+
				  '			<div class="col-sm-12" style="margin-top: 20px;">                                                            '+
				  '				<label for="inputEmail3" class="col-sm-2 control-label">请求报文</label>                                 '+
				  '				<div class="col-sm-10">                                                                                  '+
				  '					<textarea name="" rows="10" style="width: 100%"></textarea>                                          '+
				  '	      		</div>                                                                                                   '+
				  '			</div>                                                                                                       '+
				  '			<div class="col-sm-12" style="margin-top: 20px;">                                                            '+
				  '				<label for="inputEmail3" class="col-sm-2 control-label">期望返回报文</label>                             '+
				  '				<div class="col-sm-10">                                                                                  '+
				  '					<textarea name="" rows="10" style="width: 100%"></textarea>                                          '+
				  '	      		</div>                                                                                                   '+
				  '			</div>                                                                                                       '+
				  '			<div class="col-sm-12" style="margin-top: 20px;">                                                            '+
				  '				<label for="inputEmail3" class="col-sm-2 control-label">测试概述</label>                                 '+
				  '				<div class="col-sm-10">                                                                                  '+
				  '					<textarea name="" rows="10" style="width: 100%" value="验证:代收代付审批流程"></textarea>            '+
				  '	      		</div>                                                                                                   '+
				  '			</div>                                                                                                       '+
				  '			<div>                                                                                                        '+
				  '				<div class="col-sm-12" style="margin-top: 20px; text-align: center;">                                    '+
				  '					<button type="submit" class="btn btn-default">查询</button>                                          '+
				  '					<button type="reset" class="btn btn-default">重置</button>                                           '+
				  '				</div>                                                                                                   '+
				  '                                                                                                                        '+
				  '			</div>                                                                                                       '+
				  '		</form>                                                                                                          '
			  ,area: ['900px', '600px']
			 
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

		<form class="form-horizontal" action="selectExample" method="post">
			<div class="col-sm-6" style="margin-top: 20px;">
				<label for="code" class="col-sm-4 control-label">案例编号</label>
				<div class="col-sm-8">
					<input  id="code" name="code" class="form-control" placeholder="模块编号">
				</div>
			</div>
			<div class="col-sm-6" style="margin-top: 20px;">
				<label for="name" class="col-sm-4 control-label">案例名称</label>
				<div class="col-sm-8">
					<input  id="name" name="name" class="form-control" placeholder="模块名称">
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
		</div>
	</div>
	<div class="container" style="float: left; width: 100%;padding-left: 0px;padding-right: 0px;">
	
	
		<div class="table-responsive" >
			<table id="tab" class="table table-striped table-hover"  style="float: left;font-size: 20px;" >
				<tr class="danger">
					<th>案例编号</th><th>案例名称</th><th>服务ID</th><th>服务名称</th><th >协议类型</th><th>组件名称</th><th>操作</th></tr>
				<c:forEach items="${cases}" var="cas">
				<tr>
					<td>${cas.code}</td><td>${cas.name}</td><td>${cas.service_id}</td><td>${cas.service_name}</td><td>${cas.protocol}</td><td>${cas.ele_name}</td><td><input type="button" value="更新" class="btn btn-info" onclick="update(this)"></td>
				</tr>
				</c:forEach>
			</table>
		</div>
</div>

</body>
</html>