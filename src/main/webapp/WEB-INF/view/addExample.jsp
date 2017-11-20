<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="UTF-8">
<title>新增案例</title>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico">
<link rel="Shortcut Icon" href="/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="../../../../lib/html5shiv.js"></script>
<script type="text/javascript" src="../../lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css"
	href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css"
	href="static/h-ui.admin/css/style.css" />

<link rel="stylesheet" type="text/css" href="js/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="css/bootstrap-theme.min.css" />
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

</script>
</head>
<body>
	<div class="navbar ">
		<div class="container-fluid cl">
			<div class="logo navbar-logo f-l mr-10 hidden-xs"
				style="width: 184px; text-align: left;">组件组装测试工具-单笔执行</div>
			<a class="logo navbar-logo-m f-l mr-10 visible-xs"></a>

		</div>
	</div>
	<div class="container-fluid">

		<form class="form-horizontal" action="" method="post">
			<div class="col-sm-6" style="margin-top: 20px;">
				<label for="inputEmail3" class="col-sm-4 control-label" style="padding-top: 0px; line-height: 15px;"><span>案例名称</span><br><span style="color: red;font-size: 12px;">服务名称-四位编号</span></label>
				<div class="col-sm-8">
					<input  class="form-control" placeholder="模块编号">
				</div>
			</div>
			<div class="col-sm-6" style="margin-top: 20px;">
				<label for="inputEmail3" class="col-sm-4 control-label">案例类型</label>
				<div class="col-sm-8">
					<input  class="form-control" placeholder="模块名称">
				</div>

			</div>
			<div class="col-sm-6" style="margin-top: 20px;">
				<label for="inputEmail3" class="col-sm-4 control-label">服务ID</label>
				<div class="col-sm-8">
					<input  class="form-control" placeholder="组件名称">
				</div>
			</div>
			<div class="col-sm-6" style="margin-top: 20px;">
				<label for="inputEmail3" class="col-sm-4 control-label">服务名称</label>
				<div class="col-sm-8">
					<input  class="form-control" placeholder="项目名称">
				</div>
			</div>
			
			<div class="col-sm-6" style="margin-top: 20px;">
				<label for="inputEmail3" class="col-sm-4 control-label">协议类型</label>
				<div class="col-sm-8">
					<select class="selectpicker"  name="" style="width: 100%;font-size: 20px;" >
						<option  value="">协议类型</option>
						<option  value="0">HTTP</option>
			      		<option  value="1">Socket</option>
			      		<option  value="2">MQ</option>
			      		<option  value="3">主机</option>
			      		<option  value="4">Tuxedo</option>
			      		<option  value="5">Ajax</option>
		      		</select>
	      		</div>
			</div>
			<div class="col-sm-6" style="margin-top: 20px;">
				<label for="inputEmail3" class="col-sm-4 control-label">被测组件环境信息</label>
				<div class="col-sm-8">
					<select class="selectpicker"  name="" style="width: 100%;font-size: 20px;" >
						<option  value="">被测组件环境信息</option>
						<option  value="0">DIVCSS5</option>
			      		<option  value="1">DIVCSS5</option>
		      		</select>
	      		</div>
			</div>
			
			<div class="col-sm-6" style="margin-top: 20px;">
				<label for="inputEmail3" class="col-sm-4 control-label">项目名称</label>
				<div class="col-sm-8">
					<select class="selectpicker"  name="" style="width: 100%;font-size: 20px;" >
						<option  value="">项目名称</option>
						<option  value="0">代收代付</option>
			      		<option  value="1">现金管理</option>
			      		<option  value="2">企业网银</option>
			      		<option  value="3">个人网银</option>
			      		<option  value="4">金融市场</option>
			      		<option  value="5">国结系统</option>
			      		<option  value="6">客户信息</option>
			      		<option  value="7">对公管理</option>
			      		<option  value="8">对私信息</option>
		      		</select>
	      		</div>
			</div>
			<div class="col-sm-6" style="margin-top: 20px;">
				<label for="inputEmail3" class="col-sm-4 control-label">组件名称</label>
				<div class="col-sm-8">
					<select class="selectpicker"  name="" style="width: 100%;font-size: 20px;" >
						<option  value="">组件名称</option>
						<option  value="0">代收代付组件</option>
			      		<option  value="1">现金管理组件</option>
			      		<option  value="2">企业网银组件</option>
			      		<option  value="3">个人网银组件</option>
			      		<option  value="4">金融市场组件</option>
			      		<option  value="5">国结系统组件</option>
			      		<option  value="6">客户信息组件</option>
			      		<option  value="7">对公管理组件</option>
			      		<option  value="8">对私信息组件</option>
		      		</select>
	      		</div>
			</div>
			<div class="col-sm-6" style="margin-top: 20px;">
				<label for="inputEmail3" class="col-sm-4 control-label">所属模块</label>
				<div class="col-sm-8">
					<select class="selectpicker"  name="" style="width: 100%;font-size: 20px;" >
						<option  value="">所属模块</option>
						<option  value="0">代收代付-代付款</option>
			      		<option  value="1">现金管理-转账</option>
			      		<option  value="2">企业网银-登录</option>
			      		<option  value="3">企业网银-查询</option>
			      		<option  value="4">个人网银-登录</option>
			      		<option  value="5">金融市场-销售价格</option>
			      		<option  value="6">国结系统-进口结算</option>
			      		<option  value="7">国结系统-出口结算</option>
			      		<option  value="8">客户信息-对账</option>
			      		<option  value="9">对公管理-定价</option>
			      		<option  value="10">对私信息-明细</option>
		      		</select>
	      		</div>
			</div>
			<div class="col-sm-6" style="margin-top: 20px;">
				<label for="inputEmail3" class="col-sm-4 control-label">案例性质</label>
				<div class="col-sm-8">
					<select class="selectpicker"  name="" style="width: 100%;font-size: 20px;" >
						<option  value="">案例性质</option>
						<option  value="">案例性质</option>
						<option  value="0">正案例</option>
			      		<option  value="1">反案例</option>
		      		</select>
	      		</div>
			</div>
			<div class="col-sm-6" style="margin-top: 20px;">
				<label for="inputEmail3" class="col-sm-4 control-label">所属平台</label>
				<div class="col-sm-8">
					<select class="selectpicker"  name="" style="width: 100%;font-size: 20px;" >
						<option  value="">所属平台</option>
						<option  value="0">前台系统</option>
			      		<option  value="1">后台系统</option>
			      		<option  value="2">新平台</option>
		      		</select>
	      		</div>
			</div>
			<div class="col-sm-12" style="margin-top: 20px;">
				<label for="inputEmail3" class="col-sm-2 control-label">请求报文</label>
				<div class="col-sm-10">
					<textarea name="" rows="10" style="width: 100%"></textarea>
	      		</div>
			</div>
			<div class="col-sm-12" style="margin-top: 20px;">
				<label for="inputEmail3" class="col-sm-2 control-label">期望返回报文</label>
				<div class="col-sm-10">
					<textarea name="" rows="10" style="width: 100%"></textarea>
	      		</div>
			</div>
			<div class="col-sm-12" style="margin-top: 20px;">
				<label for="inputEmail3" class="col-sm-2 control-label">测试概述</label>
				<div class="col-sm-10">
					<textarea name="" rows="10" style="width: 100%" value="验证:代收代付审批流程"></textarea>
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

</body>
</html>
