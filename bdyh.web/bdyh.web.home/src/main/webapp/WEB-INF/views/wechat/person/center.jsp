<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>个人中心</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
	<!-- <link rel="import" href="/bdyh.web.home/common/head.html"> -->
	<%-- <%@ include file="${pageContext.request.contextPath}/common/head.jsp"%> --%>
	<!-- common start -->
	<link rel="stylesheet" href="http://bdpak.cn:8080/home/bd-icon/iconfont.css">
	<link rel="stylesheet" href="http://bdpak.cn:8080/home/assets/css/amazeui.min.css" />
	<link rel="stylesheet" type="text/css" href="http://bdpak.cn:8080/home/address-master/dist/amazeui.address.css" />
	<link rel="stylesheet" href="http://bdpak.cn:8080/home/wechat/wechat-icon/iconfont.css" />
	<style>
	/* 清除浏览器差异，保持样式统一 */
	{
		margin:0;
		padding:0;
		border:0;
		-webkit-font-smoothing:antialiased;
	}
	body, html {
		min-height: 100%;
		background-color: #efeff4;
	}
	
	/* 头部标题栏背景色覆盖重写 */
	.am-header-default {
		background-color: #78b3e9;
	}
	
	/*底部工具栏背景色覆盖重写 */
	.am-navbar-default .am-navbar-nav {
		background-color: #78b3e9;
	}
	/*底部工具栏高度覆盖重写 */
	.am-navbar {
		max-width: 640px;
		margin: 0 auto;
		left:inherit;
	    height: 45px;
	    line-height: 45px;
	}
	
	/* 头部栏样式重写 */
	.am-header {
		max-width: 640px;
		margin: 0 auto;
	    height: 40px;
	    line-height: 40px;
	    padding: 0 10px;
	}
	.am-with-fixed-header {
	    padding-top: 40px;
	}
	
	/*图标样式重新覆盖 */
	.iconfont {
		font-family:"iconfont" !important;
		font-size:40px;
		font-style:normal;
		-webkit-font-smoothing: antialiased;
		-moz-osx-font-smoothing: grayscale;
	}
	</style>
		
	<!-- common end -->
	
	
	<style>
		/* 标题栏字体重设 */
		.am-header .am-header-title {
		    font-size: 1.8rem;
		 }
		 
		 .bdyh_circle_nav {
		  	padding:5px 10px 5px;
		  	max-width: 100%;  
		 }
		.bdyh_circle_nav_list { 
			max-width: 100%; 
			overflow: hidden;
		}
		.bdyh_circle_nav_list li { 
			width: 25%; 
			margin-bottom: 15px;
			padding:5px 5px;
		}
		.bdyh_circle_nav_list a {
		border:1px solid #ccc;
			border-radius: 10%; 
			height: 75px; 
			display: block; 
			margin: 0 auto; 
			text-align: center; 
			line-height: 55px; 
			font-size: 35px;
			-webkit-transition: all 0.2s ease;
			transition: all 0.2s ease;
		}
		.bdyh_circle_nav_list span { 
		    position:relative;
			display: block; 
			width: 100%; 
			text-align: center; 
			font-size: 14px;
			top:-25px;
		}
		
		/*图标样式重新覆盖 */
		.iconfont {
			font-family:"iconfont" !important;
			font-size:40px;
			font-style:normal;
			-webkit-font-smoothing: antialiased;
			-moz-osx-font-smoothing: grayscale;
		}
	</style>
</head>
<body>
	<header data-am-widget="header" class="am-header am-header-default">
		<div class="am-header-left am-header-nav">
		    <a href="javascript:back()" class="">
		          <i class="am-header-icon am-icon-chevron-left"></i>
		    </a>
		</div>
		
		<h1 class="am-header-title">
		    <a href="#title-link" class="">
		      	个人中心
		    </a>
		</h1>
	</header>
	
	<div class="bdyh_news_content_main">
		<!-- icon modify start-->
		<div class="am-panel am-panel-default" style="margin-bottom:0px;">
	    	<div class="am-panel-bd am-center" style="width:100px;">
	    		<img  class="am-circle am-center" style="margin:0px auto;width:80px;height:80px;" src="${sessionScope.user.headimgurl}"/>
	    	</div>
	    	<div>
	    		<div style="width:100%;margin-bottom:10px;text-align:center;">昵称:${sessionScope.user.nickname}</div>
	    	</div>
		</div>
		<!--头像选取弹出框 -->
		<div class="am-modal am-modal-no-btn" tabindex="0" z-index="" id="doc-modal-1">
		  <div class="am-modal-dialog" >
		    <div class="am-modal-hd">
		    	<label>添加联系人</label>
		      <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
		    </div>
		    <div class="am-modal-bd">
				<div class="am-form-group am-form-file">
				  <div class="am-fl">
					<!-- <button type="button" class="am-btn am-btn-default am-btn-sm">
					  <i class="am-icon-cloud-upload"></i> 选择要上传的图片</button> -->
				  </div>
				  <input type="file" id="inputImage">
				</div>
				<div class="am-g am-fl" style="width:280px;height:200px;">
					<div class="up-pre-before up-frame-radius">
						<!-- <img style="width:280px;height:200px;" alt="" src="" id="image" > -->
						<img  style="width:220px;height:220px;" alt="" src="http://bdpak.cn:8080/home/answer2.jpg">
					</div>
					<!-- <div class="up-pre-after up-frame-radius">
					</div> -->
				</div>
				<%-- <div class="am-g am-fl">
					<div class="up-control-btns">
						<span class="am-icon-rotate-left am-icon-sm" style="margint:5px 5px 0px 0px;" onclick="rotateimgleft()"></span>
						<span class="am-icon-rotate-right am-icon-sm" style="margin:5px 5px 0px 0px;" onclick="rotateimgright()"></span>
						<span class="am-icon-check am-icon-sm"  style="margin:5px 0px 0px 0px;" id="up-btn-ok" url="${pageContext.request.contextPath}/teacherW/updateIcon"></span>
					</div>
				</div> --%>
				
		    </div>
		    
		  </div>
		</div>
		<!-- icon modify end-->
		
		
		<div class="bdyh_circle_nav" style="background:#fff;">
			<ul class="bdyh_circle_nav_list am-avg-sm-4">
		        <li>
		        	<a href="${pageContext.request.contextPath}/routeW/vip" >
			        	<i style="color:#efea6b;" class="iconfont icon-VIPfuwu"></i>
			        	<span>VIP服务</span>
		        	</a>
		        </li>
		        <li>
			        <a href="${pageContext.request.contextPath}/course/myCourse" >
				        <i style="color:#55ea83;" class="iconfont icon-wode_kecheng"></i>
				        <span>我的课程</span>
			        </a>       	
		        </li>
		        <li>
		        	<a href="${pageContext.request.contextPath}/course/myTrack">
			        	<i  style="color:blue;" class="iconfont icon-wodezuji"></i>
			        	<span>我的足迹</span>
		        	</a>
		        </li>
		        <li>
			        <a href="${pageContext.request.contextPath}/course/collectCourse">
				        <i style="color:#6C7B8B;" class="iconfont icon-kecheng"></i>
				        <span>收藏课程</span>
			        </a>
		        </li>
		        <li>
		        	<a href="${pageContext.request.contextPath}/teacher/collectTeacher">
			        	<i style="color:#55ea83;" class="iconfont icon-jiangshirenzheng"></i>
			        	<span>收藏讲师</span>
		        	</a>
		        </li>
		        <li>
		        	<a id="up-img-touch"  href="#">
			        	<i  style="color:#00BFFF;" class="iconfont icon-wentijieda"></i>
			        	<span>问题解答</span>
		        	</a>
		        </li>
		        <li>
		        	<a href="https://m.sohu.com/ch/25/22">
			        	<i style="color:#00BFFF;" class="iconfont icon-zhengcechaxun"></i>
			        	<span>教育政策</span>
		        	</a>
		        </li>
		        <li>
			        <a href="${pageContext.request.contextPath}/opinion/writeOpinion">
				        <i style="color:#ADFF2F;" class="iconfont icon-yijianfankui"></i>
				        <span>意见反馈</span>
			        </a>
		        </li>
	    	</ul>
		</div>
		
		<!-- foot navbar start -->
		<div data-am-widget="navbar" class="am-navbar am-cf am-navbar-default">
			<ul class="am-navbar-nav am-cf am-avg-sm-4">
			    <li>
			      <a href="${pageContext.request.contextPath}/index"  style="margin-top:5px;">
			          <i style="color:#FFFFFF;font-size:25px;" class="iconfont icon-zhuye" ></i>
			          <span class="am-navbar-label">首页</span>
			      </a>
			    </li>

			    <li>
			      <a href="${pageContext.request.contextPath}/course/myCourse"  style="margin-top:5px;">
			          <i style="color:#FFFFFF;font-size:25px;" class="iconfont icon-wodekecheng" ></i>
			          <span class="am-navbar-label">我的课程</span>
			      </a>
			    </li>
			    
			    <li>
			      <a href="${pageContext.request.contextPath}/user/userCenter" style="margin-top:5px;">
			          <i style="color:#FFFFFF;font-size:25px;" class="iconfont icon-gerenzhongxinxia"></i>
			          <span class="am-navbar-label">个人中心</span>
			      </a>
			    </li>
			</ul>
		</div>
		<!-- foot navbar end-->
	</div>	
	

	<script src="http://bdpak.cn:8080/home/js/jquery-3.2.1.min.js"></script>
	<script src="http://bdpak.cn:8080/home/assets/js/amazeui.min.js"></script>
	<script src="http://bdpak.cn:8080/home/assets/js/app.js"></script>
	
	<!-- <script class="resources library" src="/ezsh/js/area.js" type="text/javascript"></script>
    <script type="text/javascript">_init_area();</script> -->
    
    <script src="http://bdpak.cn:8080/home/js/dist/amazeui.dialog.min.js" charset="utf-8"></script>
    <script src="http://bdpak.cn:8080/home/wechat/up-head-img/js/cropper.min.js" charset="utf-8"></script>
    <script src="http://bdpak.cn:8080/home/wechat/up-head-img/js/custom_up_img.js" charset="utf-8"></script>
    <script type="text/javascript">
    function changePic(file,imgPreviewId){
		if(file.files!=null){
			var img = document.getElementById(imgPreviewId); 
			var reader = new FileReader();
		    //读取File对象的数据  
		    reader.onload = function(evt){  
		        img.width  =  "100";  
		        img.height =  "100";  
		        img.src = evt.target.result;  
		    }  
		    reader.readAsDataURL(file.files[0]);
		}	 
	}
    
    $("#submit").click(function(){
    	if($('#formInfo').validator('isFormValid')){
    		var formData = new FormData(document.getElementById("formInfo"));
    		$.ajax({
    		    type: "POST",
    		    url:"/ezsh/teacherW/update",
    		    data: formData,
                processData: false,
                contentType: false,
                dataType:"json",
    		    success: function(data) {
    		    	console.log(data.status);
    		    	AMUI.dialog.alert({
					     title: '提示',
					     content: data.message,
					     onConfirm: function() {
					     console.log('close');
					     }
					});
    		   }
    		})
    	 } else {
			AMUI.dialog.alert({
			     title: '提示',
			     content: '未填填完整',
			     onConfirm: function() {
			     console.log('close');
			     }
			});
    	 } 
    })
    </script>
    <!-- <script type="text/javascript">
	var Gid  = document.getElementById ;
	var showArea = function(){
		Gid('show').innerHTML = "<h3>省" + Gid('s_province').value + " - 市" + 	
		Gid('s_city').value + " - 县/区" + 
		Gid('s_county').value + "</h3>"
	}
	</script> -->
	
	<script type="text/javascript">

	function back(){
		window.history.back();  
	}
	</script>
</body>
</html>