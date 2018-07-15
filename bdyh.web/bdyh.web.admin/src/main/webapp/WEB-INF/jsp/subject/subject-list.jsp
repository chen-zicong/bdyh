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

<title>科目管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 科目管理 <span class="c-gray en">&gt;</span> 科目列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="addsubject('添加课程','${pageContext.request.contextPath}/subject/addSubjectPage/${clazzId}','400','250')" class="btn btn-primary radius"><!-- <i class="Hui-iconfont">&#xe6e2;</i> --> 添加课程</a> </span> <span class="r">共有数据：<strong>${subjectList.size() }</strong> 条</span> </div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-hover table-bg table-sort">
			<thead>
				<tr class="text-c">
					<th>科目ID</th>
					<!-- <th>年级</th> -->
					<th>科目</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${subjectList }" var="subject">
					<tr class="text-c">
						<td>${subject.subjectId }</td>
						<%-- <td>${clazzId }年级</td> --%>
						<td>
							<span class="label label-success radius">${subject.subject}</span>
						</td>
						<td class="td-status">
							<c:if test="${subject.status eq 1}">
							<span class="label label-success radius">已开放</span>
							</c:if>
							<c:if test="${subject.status eq 0}">
								<span class="label label-defaunt radius">未开放</span>
							</c:if>
						</td>
						<c:if test="${subject.status eq 1}">
							<td class="td-manage">
								<a style="text-decoration:none" onClick="subject_stop(this,'${subject.subjectId}')"
								   href="javascript:;" title="关闭"><i class="Hui-iconfont">&#xe6de;</i></a>
							</td>
						</c:if>
						<c:if test="${subject.status eq 0}">
							<td class="td-manage">
								<a style="text-decoration:none" onClick="subject_start(this,'${subject.subjectId }')"
								   href="javascript:;" title="开放"><i class="Hui-iconfont">&#xe603;</i></a>
							</td>
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
<script type="text/javascript" src="http://bdpak.cn:8080/bdyhAdmin/admin/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer /作为公共模版分离出去-->

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
		  {"orderable":false,"aTargets":[1,2]}// 制定列不参与排序
		]
	});

});
/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*用户-查看*/
function member_show(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*用户-停用*/
function member_stop(obj,id){
	layer.confirm('确认要停用吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="Hui-iconfont">&#xe6e1;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已停用</span>');
		$(obj).remove();
		layer.msg('已停用!',{icon: 5,time:1000});
	});
}

/*用户-启用*/
function member_start(obj,id){
	layer.confirm('确认要启用吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
		$(obj).remove();
		layer.msg('已启用!',{icon: 6,time:1000});
	});
}
/*用户-编辑*/
function member_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*密码-修改*/
function change_password(title,url,id,w,h){
	layer_show(title,url,w,h);	
}



/*------------------------------------------------------------------------------------------start-----------------------------------------------------------------------------*/
/*用户-删除*/
function opinion_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			   type: "GET",
			   url: "${pageContext.request.contextPath}/userOpinion/userOpinionDelete",
			   data: {
				   uoid:id,
			   },
			   success: function(data){
					var data = eval('(' + data + ')');
					if (data.status==1){
						location.href="${pageContext.request.contextPath}/userOpinion/opinionList";
					}else{
						alert("发生错误!请重新操作");
					}
			   }
		});	
	});
}


/*------------------------------------------------------------------------------------------end--------------------------------------------------------------------------------*/
/*科目关闭*/
function subject_stop(obj,id) {
    $.ajax({
		type:'POST',
		url:"${pageContext.request.contextPath}/subject/subjectDown",
		data:{
            subjectId:id
        },
		success:function (data) {
		    if(data.code=="success"){
                $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="subject_start(this,' + id + ')" href="javascript:;" title=""><i class="Hui-iconfont">&#xe603;</i></a>');
                $(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已关闭</span>');
                $(obj).remove();
                layer.msg('已关闭!', {icon: 5, time: 1000});
			}
			else {
                alert("发生错误!请重新操作");
			}
        }

	});

}

/*科目开放*/
function subject_start(obj,id) {
    $.ajax({
        type:'POST',
        url:"${pageContext.request.contextPath}/subject/subjectStart",
        data:{
            subjectId:id
        },
        success:function (data) {
            if(data.code=="success"){
                $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="subject_stop(this,' + id + ')" href="javascript:;" title=""><i class="Hui-iconfont">&#xe6de;</i></a>');
                $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已开放</span>');
                $(obj).remove();
                layer.msg('已开放!', {icon: 6, time: 1000});
            }
            else {
                alert("发生错误!请重新操作");
            }
        }

    });
}
/*课程添加*/
function addsubject(title,url,w,h) {
    layer_show(title, url, w, h);
}
</script>
</body>
</html>