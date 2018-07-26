<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<title>收藏课程</title>
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />

<!-- <link rel="import" href="/bdyh.web.home/common/head.html"> -->
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

<style type="text/css">
/* 标题栏字体重设 */
.am-header .am-header-title {
    font-size: 1.8rem;
}

/* body主体区样式 */
.bdyh_mian {
	max-width: 640px;
	margin: 0 auto;
	background: #ececec;
	position: relative;
}


/*课程内容列表样式 */
.am-list-news-default {
	margin: 0px 5px;
}

</style>
</head>
<body>
	<div class="bdyh_mian">
		<header data-am-widget="header" class="am-header am-header-default am-header-fixed">
			<h1 class="am-header-title">
			    <a href="#title-link" class="">
			      	收藏课程
			    </a>
			</h1>
		</header>

		<!-- bdyh_news_content_main start -->
		<div class="bdyh_news_content_main">
			<div data-am-widget="list_news" class="am-list-news am-list-news-default" style="background-color:#fff;">
				<!--课程列表-->
				<div class="am-list-news-bd">
					<ul class="am-list">
					
					<c:forEach items="${userCollectCourseList }" var="userCollectCourse">
						<!--内容列表-->
						<li
							class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-bottom-left">
							<h3 class="am-list-item-hd">
								<a href="#"
									style="margin-left:5%;">课程简介</a>
							</h3>
							<hr data-am-widget="divider" style="margin:0.5rem auto;"
								class="am-divider am-divider-dotted" />
							<div class="am-u-sm-4" >
								<a href="${pageContext.request.contextPath}/course/courseDetails/${userCollectCourse.course.courseId}" class="">
									<img style="width:100%;height:95px;" src="http://bdpak.cn:8080/home/courseImg/${userCollectCourse.course.courseImg }"
									alt="我很囧，你保重....晒晒旅行中的那些囧！" />
								</a>
							</div>

							<div class=" am-u-sm-8  am-list-main">
								<div class="am-list-item-text">课程名：${userCollectCourse.course.courseName }</div>
								<div class="am-list-item-text">课程难度：
									<c:if test="${userCollectCourse.course.courseDifficulty eq 1 }">
										初级
									</c:if>
									<c:if test="${userCollectCourse.course.courseDifficulty eq 2 }">
										中级
									</c:if>
									<c:if test="${userCollectCourse.course.courseDifficulty eq 3 }">
										高级
									</c:if>
								</div>
								
								<div class="am-g">
									<div class="am-u-sm-12" style="margin-right:5%;height:50px;">
										<a class="am-fr" href="javaScript:lessonCollect(${userCollectCourse.course.courseId })"> <span
											style="display:inline-block;color:#2e2e2e;bottom: 8px;position: relative;">收藏</span>
											<i id="${userCollectCourse.course.courseId }_no" hidden="hidden"
											style="color:#55ea83;font-size:35px;"
											class="iconfont icon-shoucang1"></i> 
											<i id="${userCollectCourse.course.courseId }_yes"
											style="color:red;font-size:35px;"
											class="iconfont icon-shoucang2"></i>
										</a>
									</div>
								</div>
							</div>

							
						</li>
					</c:forEach>
					
						<!-- 
						<li
							class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-bottom-left">
							<h3 class="am-list-item-hd">
								<a href="http://www.douban.com/online/11614662/"
									style="margin-left:5%;">课程简介</a>
							</h3>
							<hr data-am-widget="divider" style="margin:0.5rem auto;"
								class="am-divider am-divider-dotted" />
							<div class="am-u-sm-4 am-list-thumb">
								<a href="http://www.douban.com/online/11614662/" class="">
									<img src="/bdyh.web.home/demo/头像.png"
									alt="我很囧，你保重....晒晒旅行中的那些囧！" />
								</a>
							</div>

							<div class=" am-u-sm-8  am-list-main">
								<div class="am-list-item-text">课程名：六年级数学同步微课</div>
								<div class="am-list-item-text">课程难度：初级</div>
							</div>

							<div class="am-u-sm-8" style="margin-right:5%;height:50px;">
								<a class="am-fr" href="javaScript:lessonCollect()"> <span
									style="display:inline-block;color:#2e2e2e;bottom: 8px;position: relative;">取消收藏</span>
									<i id="lesson_collect_no" hidden="hidden"
									style="color:#55ea83;font-size:35px;"
									class="iconfont icon-shoucang1"></i> <i
									id="lesson_collect_yes"
									style="color:red;font-size:35px;"
									class="iconfont icon-shoucang2"></i>
								</a>
							</div>
						</li>
						
						<li
							class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-bottom-left">
							<h3 class="am-list-item-hd">
								<a href="http://www.douban.com/online/11614662/"
									style="margin-left:5%;">课程简介</a>
							</h3>
							<hr data-am-widget="divider" style="margin:0.5rem auto;"
								class="am-divider am-divider-dotted" />
							<div class="am-u-sm-4 am-list-thumb">
								<a href="http://www.douban.com/online/11614662/" class="">
									<img src="/bdyh.web.home/demo/头像.png"
									alt="我很囧，你保重....晒晒旅行中的那些囧！" />
								</a>
							</div>

							<div class=" am-u-sm-8  am-list-main">
								<div class="am-list-item-text">课程名：六年级数学同步微课</div>
								<div class="am-list-item-text">课程难度：初级</div>
							</div>

							<div class="am-u-sm-8" style="margin-right:5%;height:50px;">
								<a class="am-fr" href="javaScript:lessonCollect(this)"> <span
									style="display:inline-block;color:#2e2e2e;bottom: 8px;position: relative;">取消收藏</span>
									<i id="lesson_collect_no" hidden="hidden"
									style="color:#55ea83;font-size:35px;"
									class="iconfont icon-shoucang1"></i> <i
									id="lesson_collect_yes" 
									style="color:red;font-size:35px;"
									class="iconfont icon-shoucang2"></i>
								</a>
							</div>
						</li> -->
						
					</ul>
				</div>
			</div>	
		</div>
		<!-- bdyh_news_content_main end -->

		<!--回顶部 -->
		<div data-am-widget="gotop" class="am-gotop am-gotop-fixed">
			<a href="#top" title=""> <i
				class="am-gotop-icon am-icon-hand-o-up"></i>
			</a>
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
</body>

<script src="http://bdpak.cn:8080/home/js/jquery-3.2.1.min.js"></script>
<script src="http://bdpak.cn:8080/home/assets/js/amazeui.min.js"></script>
<script src="http://bdpak.cn:8080/home/js/dist/amazeui.dialog.min.js" charset="utf-8"></script>
<script>
/* function lecturerCollect() {
	if ($("#lecturer_collect_no").prop("hidden")) {
		$("#lecturer_collect_no").prop("hidden", false);
		$("#lecturer_collect_yes").prop("hidden", true);
	} else {
		$("#lecturer_collect_no").prop("hidden", true);
		$("#lecturer_collect_yes").prop("hidden", false);
	}
} */

/* function lessonCollect(obj) {
	
	sconsole.log(obj);
} */
function lessonCollect(courseId) {
	if ($("#"+courseId+"_no").prop("hidden")) {
		//取消收藏
		//alert("取消收藏");
		//alert(courseId);
		//异步请求页面不刷新
		$.ajax({
			   type: "POST",
			   url: "${pageContext.request.contextPath}/course/cancelCollectCourse",
			   data: {
				   courseId:courseId,
			   },
			   success: function(data){
			   		if(data["status"] == 1){
					alert("操作成功");
					window.location.reload();
			   	}else{
					alert(data["message"]);
					window.location.reload();
			   	}
		   }
		});	
		
		$("#"+courseId+"_no").prop("hidden", false);
		$("#"+courseId+"_yes").prop("hidden", true);
		
	} else {
		//收藏
		//alert("收藏");
		//alert(courseId);
		$.ajax({
			   type: "POST",
			   url: "${pageContext.request.contextPath}/course/collectCourse",
			   data: {
				   courseId:courseId,
			   },
			   success: function(data){
			   		if(data["status"] == 1){
					alert("操作成功");
					window.location.reload();
			   	}else{
					alert(data["message"]);
					window.location.reload();
			   	}
		   }
		});	
		$("#"+courseId+"_no").prop("hidden", true);
		$("#"+courseId+"_yes").prop("hidden", false);
	}
}
</script>
</html>
