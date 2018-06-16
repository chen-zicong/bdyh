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
<title>代理商管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 教师管理 <span class="c-gray en">&gt;</span> 教师列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a href="javascript:;" onclick="member_add('添加用户','${pageContext.request.contextPath}/adminAgent/agentAddPage','','510')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加代理商</a></span> <span class="r">共有数据：<strong>${agentList.size() }</strong> 条</span> </div>
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				<th width="25"><input type="checkbox" name="" value=""></th>
				<th width="80">ID</th>
				<th width="100">姓名</th>
				<th width="40">性别</th>
				<th width="90">手机</th>
				<th width="150">邮箱</th>
				<th width="">简介</th>
				<th width="130">加入时间</th>
				<th width="70">代理级别</th>
				<th width="70">状态</th>
				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${agentList }" var="agent">
				<tr class="text-c">
					<td><input type="checkbox" value="1" name=""></td>
					<td>${agent.agentId }</td>
					<th><u style="cursor:pointer" class="text-primary" onclick="agent_show('${agent.nickname }','${pageContext.request.contextPath}/adminAgent/agentShow/${agent.agentId}','10001','360','400')">${agent.nickname }</u></th>
					<td>
						<c:choose>
							<c:when test="${agent.sex eq 1 }">男</c:when>
							<c:otherwise>女</c:otherwise>
						</c:choose>
					</td>
					<td>${agent.telephone }</td>
					<td>${agent.email }</td>
					<td class="text-l">${agent.agentIntro }</td>
					<td>${agent.joinTime }</td>
					<th>
						<c:if test="${agent.agentLevel eq 1 }">省级代理</c:if>
						<c:if test="${agent.agentLevel eq 2 }">市级代理</c:if>
						<c:if test="${agent.agentLevel eq 3 }">区域代理</c:if>
					</th>
					<td class="td-status">
						
						<c:if test="${agent.status eq 1 }">
							<span class="label label-success radius">正常</span>
						</c:if>
						<c:if test="${agent.status eq 0 }">
							<span class="label label-defaunt radius">已停用</span>
						</c:if>
					</td>
					
					
					<c:if test="${agent.status eq 1 }">
						<td class="td-manage"><a style="text-decoration:none" onClick="agent_stop(this,'${agent.agentId}')" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a> <a title="编辑"  onclick="teacher_edit('编辑','${pageContext.request.contextPath}/adminAgent/agentEditPage/${agent.agentId }','4','','510')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" class="ml-5" onClick="change_password('修改密码','${pageContext.request.contextPath}/adminAgent/changePasswordPage/${agent.agentId }','10001','600','270')" href="javascript:;" title="修改密码"><i class="Hui-iconfont">&#xe63f;</i></a> <a title="删除" href="javascript:;" onclick="agent_del(this,'${agent.agentId}')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
					</c:if>
					<c:if test="${agent.status eq 0 }">
						<td class="td-manage"><a style="text-decoration:none" onClick="agent_start(this,'${agent.agentId}')" href="javascript:;" title="启用"><i class="Hui-iconfont">&#xe6e1;</i></a> <a title="编辑"  onclick="teacher_edit('编辑','${pageContext.request.contextPath}/adminAgent/agentEditPage/${agent.agentId }','4','','510')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" class="ml-5" onClick="change_password('修改密码','${pageContext.request.contextPath}/adminAgent/changePasswordPage/${agent.agentId }','10001','600','270')" href="javascript:;" title="修改密码"><i class="Hui-iconfont">&#xe63f;</i></a> <a title="删除" href="javascript:;" onclick="agent_del(this,'${agent.agentId}')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="http://bdpak.cn:8080/bdyhAdmin/admin/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="http://bdpak.cn:8080/bdyhAdmin/admin/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="http://bdpak.cn:8080/bdyhAdmin/admin/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="http://bdpak.cn:8080/bdyhAdmin/admin/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="http://bdpak.cn:8080/bdyhAdmin/admin/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="http://bdpak.cn:8080/bdyhAdmin/admin/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="http://bdpak.cn:8080/bdyhAdmin/admin/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
$(function(){
	$('.table-sort').dataTable({
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,8,9]}// 制定列不参与排序
		]
	});
	
});
/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*用户-查看*/
function agent_show(title,url,id,w,h){
	layer_show(title,url,w,h);
}




/*用户-停用*/
function agent_stop(obj,id){
	layer.confirm('确认要停用吗？',function(index){
	$.ajax({
		   type: "POST",
		   url: "${pageContext.request.contextPath}/adminAgent/agentStop",
		   data: {
			   agentId:id,
		   },
		   success: function(data){
				var data = eval('(' + data + ')');
				if (data.status==1){
					$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="agent_start(this,'+id+')" href="javascript:;" title="启用"><i class="Hui-iconfont">&#xe6e1;</i></a>');
					$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已停用</span>');
					$(obj).remove();
					layer.msg('已停用!',{icon: 5,time:1000});
				}else{
					alert("发生错误!请重新操作");
				}
		   }
		});
	});
	
}

/*用户-启用*/
function agent_start(obj,id){
	
	layer.confirm('确认要启用吗？',function(index){
		$.ajax({
		   type: "POST",
		   url: "${pageContext.request.contextPath}/adminAgent/agentStart",
		   data: {
			   agentId:id,
		   },
		   success: function(data){
				var data = eval('(' + data + ')');
				if (data.status==1){
					$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="agent_stop(this,'+id+')" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>');
					$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">正常</span>');
					$(obj).remove();
					layer.msg('已启用!',{icon: 6,time:1000});
				}else{
					alert("发生错误!请重新操作");
				}
		   }
		});
	});
}





/*用户-编辑*/
function teacher_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*密码-修改*/
function change_password(title,url,id,w,h){
	layer_show(title,url,w,h);	
}
/*用户-删除*/
function agent_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
		   type: "POST",
		   url: "${pageContext.request.contextPath}/adminAgent/agentDelete",
		   data: {
			   agentId:id,
		   },
		   success: function(data){
				var data = eval('(' + data + ')');
				if (data.status==1){
					$(obj).parents("tr").remove();
					layer.msg('已删除!',{icon:1,time:1000});
					/* 不需要重新请求链接 */
					/* location.href="${pageContext.request.contextPath}/teacher/teacherList" */
				}else{
					alert("发生错误!请重新操作");
				}
		   }
		});
	});
}
</script> 
</body>
</html>