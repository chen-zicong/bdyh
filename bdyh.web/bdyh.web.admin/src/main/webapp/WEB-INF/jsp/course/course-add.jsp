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
<title>新增课程</title>
<script type="text/javascript">
function courseAddSubmit(){
	var fd = new FormData($("#form-article-add")[0]);
	$.ajax({
		url : "${pageContext.request.contextPath}/course/courseAdd",
		type : "POST",
		data : fd,
		dataType : "json",
		processData : false, // 告诉jQuery不要去处理发送的数据
		contentType : false, // 告诉jQuery不要去设置Content-Type请求头
		success: function(data){
			if (data.status==1){
				alert("添加课程成功,快去上传视频吧亲！");
				location.href="${pageContext.request.contextPath}/course/myCourse";
			}else if(data.status==-1){
				alert("请选择课程封面！");
			}else{
				alert("添加失败！");
			}
		}
	});
}
</script>
</head>
<body>
<div class="page-container">
	<form class="form form-horizontal" id="form-article-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>课程名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="请输入课程名哦" id="courseName" name="courseName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">课程科目：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
					<select name="courseType" class="select">
						<option value="语文">语文</option>
						<option value="数学">数学</option>
						<option value="英语">英语</option>
						<option value="物理">物理</option>
						<option value="生物">生物</option>
						<option value="化学">化学</option>
						<option value="地理">地理</option>
						<option value="政治">政治</option>
						<option value="历史">历史</option>
					</select>
				</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>课程年级：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
					<select name="courseLevel" class="select">
						<option value="1">一年级</option>
						<option value="2">二年级</option>
						<option value="3">三年级</option>
						<option value="4">四年级</option>
						<option value="5">五年级</option>
						<option value="6">六年级</option>
						<option value="7">初一</option>
						<option value="8">初二</option>
						<option value="9">初三</option>
						<option value="10">高一</option>
						<option value="11">高二</option>
						<option value="12">高三</option>
					</select>
				</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>课程难度：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
				<select name="courseDifficulty" class="select">
					<option value="1">初级</option>
					<option value="2">中级</option>
					<option value="3">高级</option>
				</select>
				</span>
			</div>
		</div>
		<%--<div class="row cl">--%>
			<%--<label class="form-label col-xs-4 col-sm-2">视频数量：</label>--%>
			<%--<div class="formControls col-xs-8 col-sm-9">--%>
				<%--<input type="text" class="input-text" value="" placeholder="请输入视频的个数哦" id="lessionNum" name="lessionNum">--%>
			<%--</div>--%>
		<%--</div>--%>
		<%--<div class="row cl">--%>
			<%--<label class="form-label col-xs-4 col-sm-2">课程价格：</label>--%>
			<%--<div class="formControls col-xs-8 col-sm-9">--%>
				<%--<input type="text" class="input-text" value="" placeholder="请输入课程价格" id="coursePrice" name="coursePrice">--%>
			<%--</div>--%>
		<%--</div>--%>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">课程介绍：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="courseDesc" cols="3" rows="80" class="textarea" placeholder="说点什么...最少输入10个字符" datatype="*10-100" dragonfly="true" nullmsg="备注不能为空！" onKeyUp="$.Huitextarealength(this,200)"></textarea>
				<!-- <p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p> -->
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">课程封面：</label>
			<div class="formControls col-xs-8 col-sm-9">
				
				<input id="doc-form-file" type="file" name="image" multiple required />
			</div>
		</div>
		
		<!-- <div class="am-form-group am-form-file">
			<label for="user-name" class="am-u-sm-3 am-form-label">合同文件
			</label>
			<div class="am-u-sm-9">
				<button type="button" class="am-btn am-btn-danger am-btn-sm">
					<i class="am-icon-cloud-upload"></i> 选择要上传的文件
				</button>
				<input id="doc-form-file" type="file" name="agentContract" multiple required />
			</div>
			<div class="am-u-sm-9">
				<div id="file-list"></div>
			</div>
		</div> -->
		
		
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<!-- <button onClick="article_save_submit();" class="btn btn-primary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 保存并提交审核</button> -->
				<button onClick="courseAddSubmit();" class="btn btn-primary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 保存并提交审核</button>
				<!-- <button onClick="article_save();" class="btn btn-secondary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 保存草稿</button> -->
				<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="http://bdpak.cn:8080/bdyhAdmin/admin/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="http://bdpak.cn:8080/bdyhAdmin/admin/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="http://bdpak.cn:8080/bdyhAdmin/admin/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="http://bdpak.cn:8080/bdyhAdmin/admin/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="http://bdpak.cn:8080/bdyhAdmin/admin/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="http://bdpak.cn:8080/bdyhAdmin/admin/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="http://bdpak.cn:8080/bdyhAdmin/admin/lib/jquery.validation/1.14.0/messages_zh.js"></script> 
<script type="text/javascript" src="http://bdpak.cn:8080/bdyhAdmin/admin/lib/webuploader/0.1.5/webuploader.min.js"></script> 
</body>
</html>


