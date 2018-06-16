<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="http://bdpak.cn:8080/bdyhAdmin/admin/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="http://bdpak.cn:8080/bdyhAdmin/admin/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="http://bdpak.cn:8080/bdyhAdmin/admin/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="http://bdpak.cn:8080/bdyhAdmin/admin/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="http://bdpak.cn:8080/bdyhAdmin/admin/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>代理商查看</title>
</head>
<body>
<div class="cl pd-20" style=" background-color:#5bacb6">
	<!-- 教师头像默认保存在home/agentImg -->
	<img class="avatar size-XL l" src="http://bdpak.cn:8080/home/agentImg/${agent.agentImg }">
	<dl style="margin-left:80px; color:#fff">
		<dt>
			<span class="f-18">${agent.nickname }</span>
			<!-- <span class="pl-10 f-12">余额：40</span> -->
		</dt>
		<dd class="pt-10 f-12" style="margin-left:0">${agent.agentIntro }</dd>
	</dl>
</div>
<div class="pd-20">
	<table class="table">
		<tbody>
			<tr>
				<th class="text-r" width="80">性别：</th>
				<c:choose>
					<c:when test="${agent.sex eq 1 }">
						<td>男</td>
					</c:when>
					<c:otherwise>
						<td>女</td>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<th class="text-r">手机：</th>
				<td>${agent.telephone }</td>
			</tr>
			<tr>
				<th class="text-r">账户：</th>
				<td>${agent.username }</td>
			</tr>
			<tr>
				<th class="text-r">邮箱：</th>
				<td>${agent.email }</td>
			</tr>
			<tr>
				<th class="text-r">注册时间：</th>
				<td>${agent.joinTime }</td>
			</tr>
			<tr>
				<th class="text-r">代理级别：</th>
				<td>
					<c:if test="${agent.agentLevel eq 1 }">省级代理</c:if>
					<c:if test="${agent.agentLevel eq 2 }">市级代理</c:if>
					<c:if test="${agent.agentLevel eq 3 }">区域代理</c:if>
				</td>
			</tr>
		</tbody>
	</table>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="http://bdpak.cn:8080/bdyhAdmin/admin/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="http://bdpak.cn:8080/bdyhAdmin/admin/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="http://bdpak.cn:8080/bdyhAdmin/admin/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="http://bdpak.cn:8080/bdyhAdmin/admin/static/h-ui.admin/js/H-ui.admin.js"></script> 
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
</body>
</html>