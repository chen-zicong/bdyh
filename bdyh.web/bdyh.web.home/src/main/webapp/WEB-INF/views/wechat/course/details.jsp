	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<!doctype html>
	<html>
	<head>
		<%--未支付的视频界面--%>
		<title>我的课程</title>
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
				background-color: #41d1e0;
			}

			/*底部工具栏背景色覆盖重写 */
			.am-navbar-default .am-navbar-nav {
				background-color: #41d1e0;
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

		<link rel="stylesheet" href="http://bdpak.cn:8080/home/video.js/amazeui.videojs.css" />
		<style type="text/css">
			/* 标题栏字体重设 */
			.am-header .am-header-title {
				font-size: 1.8rem;
			}


			/*内容区块样式 */
			.bdyh_mian {
				max-width: 640px;
				margin: 0 auto;
				background: #ececec;
				position: relative;
			}


			/* 视频播放区按钮部分样式覆盖重写 */
			.vjs-amazeui .vjs-big-play-button:before {
				font-size: 50px;
				margin-top: -7%;
				margin-left: -5%;
			}
			/* 视频区音量条一栏样式重写覆盖 */
			.vjs-amazeui .vjs-mute-control, .vjs-amazeui .vjs-volume-menu-button {
				bottom: 60px;
				right: 95px;
			}
			.vjs-amazeui .vjs-control {
				top: 6px;
			}
			.vjs-amazeui .vjs-progress-control {
				top: 0px;
			}
			.vjs-amazeui .vjs-mute-control, .vjs-amazeui .vjs-volume-menu-button {
				top: -54px;
			}
			.vjs-time-divider {
				line-height: 6em;
			}


			/*选项卡区横向长度样式重写覆盖 */
			[data-am-widget=tabs] {
				margin: -48px 0px 0px 0px;
			}
			.am-tabs-bd .am-tab-panel {
				padding: 0px 0px;
			}
			/*选项卡选中时颜色覆盖重写 */
			.am-tabs-default .am-tabs-nav>.am-active a {
				background-color: #8fe0e4;
				color: #fff;
			}


			/*课程内容列表样式 */
			.am-list-news-default {
				margin: 0px 5px;
			}
			/* 课程目录a标签样式*/
			.am-list .am-list-item-dated a {
				padding-right: 5%;
			}

            /*菜单样式重写覆盖*/
			.am-menu-slide1 .am-menu-nav>.am-parent.am-open>a:before{
				display:none;
			}
			.am-menu-slide1 .am-menu-nav>.am-parent>a:after{
				content:none;
			}
		</style>
	</head>
	<body>
	<div class="bdyh_mian">
		<header data-am-widget="header" class="am-header am-header-default am-header-fixed">
			<div class="am-header-left am-header-nav">
				<a href="${pageContext.request.contextPath}/index">
		    <span class="am-header-nav-title">
                首页
              </span>
				<i class="am-header-icon am-icon-home"></i>
				</a>

			</div>
			<h1 class="am-header-title">
				<a href="#title-link" class=""> 我的课程 </a>
			</h1>
			<div class="am-header-right am-header-nav">
				<a href="${pageContext.request.contextPath}/user/userCenter" >
					<i class="am-header-icon am-icon-user" style="font-size:15px"></i>
					<span class="am-header-nav-title">
                 个人中心
              </span>

				</a>
			</div>
		</header>

		<!-- bdyh_news_content_main start -->
		<div class="bdyh_news_content_main">
			<!-- vedio play district -->
			<div style="width:100%;">
				<video id="example_video_1" class="video-js vjs-amazeui" controls
					   preload="none" width="100%" height="264"
					   poster="http://bdpak.cn:8080/home/demo/slideshow5.jpg" data-setup="{}">
					<source id="example_video_source" src="http://bdpak.cn:8080/home/video/${video[0].videoPath}" type='video/mp4' />
					<!-- <source src="http://video-js.zencoder.com/oceans-clip.webm" type='video/webm' />
				  <source src="http://video-js.zencoder.com/oceans-clip.ogv" type='video/ogg' /> -->
					<track kind="captions" src="http://bdpak.cn:8080/home/video.js/demo.captions.vtt" srclang="en" label="English"></track>
					Tracks need an ending tag thanks to IE9
					<track kind="subtitles" src="http://bdpak.cn:8080/home/video.js/demo.captions.vtt" srclang="en" label="English"></track>
					Tracks need an ending tag thanks to IE9
					<p class="vjs-no-js">
						To view this video please enable JavaScript, and consider
						upgrading to a web browser that
						<a href="http://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a>
					</p>
				</video>
			</div>

			<!--选项栏 -->
			<div data-am-widget="tabs" class="am-tabs am-tabs-d2" style="margin-top:0px;">
				<ul class="am-tabs-nav am-cf">
					<li class="am-active"><a href="[data-tab-panel-0]">详细情况</a></li>
					<li class=""><a href="[data-tab-panel-1]">目录</a></li>
				</ul>
				<div class="am-tabs-bd">
					<div data-tab-panel-0 class="am-tab-panel am-active">
						<!--列表标题-->

						<div data-am-widget="list_news"
							 class="am-list-news am-list-news-default">
							<!--列表标题-->
							<div class="am-list-news-bd">
								<ul class="am-list">
									<!--内容列表-->
									<li style="padding-top: 0rem;padding-bottom: 0rem;"
										class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-bottom-left">
										<h3 class="am-list-item-hd">
											<a href="http://www.douban.com/online/11614662/"
											   style="margin-left:5%;">讲师信息</a>
										</h3>
										<hr data-am-widget="divider" style="margin:0.5rem auto;"
											class="am-divider am-divider-dotted" />
										<div class="am-u-sm-4">
											<a> <img style="width:100%;height:95px;" src="http://bdpak.cn:8080/home/teacherImg/${teacher.teacherImg}" />
											</a>
										</div>
										<div class="am-u-sm-8  am-list-main">
											<div class="am-list-item-text">姓名：${teacher.teacherName}</div>
											<div class="am-list-item-text">
												性别：
												<c:choose>
													<c:when test="${teacher.sex eq 1 }">
														男
													</c:when>
													<c:otherwise>
														女
													</c:otherwise>
												</c:choose>
											</div>

											<div class="am-list-item-text">主讲：${teacher.major }</div>
											<div class="am-g">
												<c:choose>
													<c:when test="${teacherCollect eq 1 }">
														<div class="am-u-sm-12" style="margin-right:5%;height:50px;">
															<a class="am-fr" href="javaScript:lecturerCollect(${teacher.teacherId })"> <span
																	style="display:inline-block;color:#2e2e2e;bottom: 8px;position: relative;">收藏</span>
																<i id="lecturer_collect_no" hidden="hidden"
																   style="color:#55ea83;font-size:35px;"
																   class="iconfont icon-shoucang1"></i> <i
																		id="lecturer_collect_yes"
																		style="color:red;font-size:35px;"
																		class="iconfont icon-shoucang2"></i>
															</a>
														</div>
													</c:when>
													<c:otherwise>
														<div class="am-u-sm-12" style="margin-right:5%;height:50px;">
															<a class="am-fr" href="javaScript:lecturerCollect(${teacher.teacherId })"> <span
																	style="display:inline-block;color:#2e2e2e;bottom: 8px;position: relative;">收藏</span>
																<i id="lecturer_collect_no"
																   style="color:#55ea83;font-size:35px;"
																   class="iconfont icon-shoucang1"></i> <i
																		id="lecturer_collect_yes" hidden="hidden"
																		style="color:red;font-size:35px;"
																		class="iconfont icon-shoucang2"></i>
															</a>
														</div>
													</c:otherwise>
												</c:choose>
											</div>
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
										<div class="am-u-sm-4">
											<a href="http://www.douban.com/online/11614662/" class="">
												<img style="width:100%;height:95px;" src="http://bdpak.cn:8080/home/courseImg/${course.courseImg}"
													 alt="我很囧，你保重....晒晒旅行中的那些囧！" />
											</a>
										</div>

										<div class=" am-u-sm-8  am-list-main">
											<div class="am-list-item-text">课程名：${course.courseName }</div>
											<div class="am-list-item-text">课程难度：
												<c:if test="${course.courseDifficulty eq 1 }">
													初级
												</c:if>
												<c:if test="${course.courseDifficulty eq 2 }">
													中级
												</c:if>
												<c:if test="${course.courseDifficulty eq 3 }">
													高级
												</c:if>
											</div>

											<div class="am-g">
												<c:choose>
													<c:when test="${courseCollect eq 1 }">
														<div class="am-u-sm-12" style="margin-right:5%;height:50px;">
															<a class="am-fr" href="javaScript:lessonCollect(${course.courseId })"> <span
																	style="display:inline-block;color:#2e2e2e;bottom: 8px;position: relative;">收藏</span>
																<i id="lesson_collect_no" hidden="hidden"
																   style="color:#55ea83;font-size:35px;"
																   class="iconfont icon-shoucang1"></i>
																<i id="lesson_collect_yes"
																   style="color:red;font-size:35px;"
																   class="iconfont icon-shoucang2"></i>
															</a>
														</div>
													</c:when>
													<c:otherwise>
														<div class="am-u-sm-12" style="margin-right:5%;height:50px;">
															<a class="am-fr" href="javaScript:lessonCollect(${course.courseId })"> <span
																	style="display:inline-block;color:#2e2e2e;bottom: 8px;position: relative;">收藏</span>
																<i id="lesson_collect_no"
																   style="color:#55ea83;font-size:35px;"
																   class="iconfont icon-shoucang1"></i>
																<i id="lesson_collect_yes" hidden="hidden"
																   style="color:red;font-size:35px;"
																   class="iconfont icon-shoucang2"></i>
															</a>
														</div>
													</c:otherwise>
												</c:choose>
											</div>
										</div>




									</li>

								</ul>
							</div>
						</div>
					</div>

					<!--目录 -->
					<div data-tab-panel-1 class="am-tab-panel">
						<div data-am-widget="list_news" class="am-list-news am-list-news-default"
							 style="background-color:#fff;">
							<!--课程目录-->
							<div class="am-list-news-hd am-cf">
								<!--带更多链接-->
								<a style="margin-left:10px;color:#464846;display: inline-block;">
									<span>${course.courseName }(共${course.lessionNum }节)</span>
								</a>
								<a style="float:right" class="select_all">全选 <i class="am-icon-check-circle"></i></a>
							</div>

							<div class="am-list-news-bd course-list">
								<ul class="am-list am-list-course" style="font-size:14px;">
									<c:forEach items="${videoList }" var="video">
										<li class="am-g am-list-item-dated" style="margin-bottom:8px">

											<div  class="am-list-item-hd lesson-catalog-list" style="display: inline-block; width: 95%">
												<c:choose>
                                                <c:when test="${video.paystatus eq 1}">
												<a id="Ccourse" href="javascript:playVideo('${video.videoPath}')" style="display:inline-block">
													<i style="font-size:15px;margin-left:5px;" class="iconfont icon-bofang"></i>
													<span>${video.videoName}</span>
													<span style="color:green;">(已购)</span>
														<span id="Permission" style="display:none">${video.paystatus}</span>
													    <span id="path" style="display:none;">${video.videoPath}</span>
												</a>
                                                </c:when>
                                                <c:when test="${video.paystatus eq 0}">
                                                <a id="Ccourse" href="${pageContext.request.contextPath}/routeW/Goto/course/warn" style="display:inline-block">
                                                    <i style="font-size:15px;margin-left:5px;" class="iconfont icon-bofang"></i>
                                                    <span>${video.videoName}</span>
                                                    <span  style="color:red;">(￥<span id="CoursePrice">${video.videoPrice}</span>元)</span>
                                                    <span id="Permission" style="display:none">${video.paystatus}</span>
                                                    <span id="path" style="display:none;">${video.videoPath}</span>
                                                </a>
                                                    <i class="am-icon-plus-circle" style="float: right;display: inline-block;font-size:18px;color:blue"></i>
													<i class="am-icon-check-circle-o" style="float: right;display: inline-block;font-size:18px;color:green;display:none"></i>
                                                    <span id="videoId" style="display:none">${video.videoId}</span>
                                                </c:when>
                                                <c:otherwise>
                                                <a id="Ccourse" href="${pageContext.request.contextPath}/routeW/Goto/course/warn" style="display:inline-block">
                                                    <i style="font-size:15px;margin-left:5px;" class="iconfont icon-bofang"></i>
                                                    <span>${video.videoName}</span>
                                                    <span style="color:#ccc;">(待付款)</span>
                                                    <span id="Permission" style="display:none">${video.paystatus}</span>
                                                    <span id="path" style="display:none;">${video.videoPath}</span>
                                                </a>
                                                </c:otherwise>
												</c:choose>
											</div>

										</li>
									<%--	<li class="am-g am-list-item-dated">
											<a href="javaScript:playVideo('${video.videoPath}')" class="am-list-item-hd lesson-catalog-list">
												&lt;%&ndash;<a href="javaScript:pay()" class="am-list-item-hd lesson-catalog-list">&ndash;%&gt;
											-+	<i style="font-size:15px;margin-left:5px;" class="iconfont icon-bofang"></i>
												<span>${video.videoName }
													<c:choose>
														<c:when test="${video.videoPrice eq 0 }">
															(免费)
														</c:when>
														<c:otherwise>
															<span style="color:red;">(付费${video.videoPrice }元)</span>
														</c:otherwise>
													</c:choose>
												</span>
											</a>
										</li>--%>
									</c:forEach>
									

									<%--<li class="am-g am-list-item-dated" style="margin-bottom:8px">
										<div class="am-list-item-hd lesson-catalog-list" style="display: inline-block; width: 95%">
											<a id="Ccourse" href="javaScript:playVideo(2)" style="display:inline-block">
												<i style="font-size:15px;margin-left:5px;" class="iconfont icon-bofang"></i>
												<span>第一单第二节圆的面积</span>
												<span  style="color:red;">(￥<span id="CoursePrice">100</span>元)</span>
												<span id="Permission" style="display:none">0</span>
											</a>
											<i class="am-icon-plus-circle" style="float: right;display: inline-block;font-size:18px;color:blue"></i>
											<span id="videoId" style="display:none">1004</span>
										</div>
									</li>--%>
								</ul>
							</div>
						</div>
					</div>
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
			<nav data-am-widget="menu" class="am-menu  am-menu-slide1">
				<ul class="am-menu-nav am-avg-sm-2">
					<li class="am-parent" style="background:rgba(0,0,0,0.6); width: 70%;">
						<a> <i class=" am-header-icon am-icon-shopping-cart" style="font-size:30px;color:#00a2f4;padding-right: 10px;"><span id="Quantity" style="display:none"><span style="display: inline-block;background: red;width: 18px;height: 18px; border-radius: 25px;margin-bottom: 13px;"><span id="MenueLength" style=" font-size: 14px;color: white;position: relative;bottom: 97%;right: 2%;"></span></span></span></i><span style="color:white">购物车<span id="Tprice"></span></span></a>
						<ul class="am-menu-sub am-collapse  am-avg-sm-2 " style="bottom: 45px;left:0;background: rgba(0,0,0,.7);">
							<h5 style="color: white;font-family:楷体;text-align:center">已选购课程</h5>
							<%--<li style="width:100%" >
								<a href="##" class="" ><span style="position: absolute;left: 13px;font-size:14px;font-family:楷体">第三单元 :圆与曲线方程很长啊啊</span><span style="position: absolute; right: 20px;">￥5.5 <i class="am-icon-times-circle" style="margin-left: 20px"></i></span></a>
								<span id="CourseId" style="display:none">1003</span>
							</li>--%>
						</ul>
					</li>
					<button class="am-btn" style="float: right;background:rgba(0,0,0,0.3);color:#ffff;width:30%" onclick="Buy()">立即购买</button>
				</ul>


			</nav>
		</div>
		</div>
		<!-- foot navbar end-->

	</body>
	<script src="http://bdpak.cn:8080/home/js/jquery-3.2.1.min.js"></script>
	<script src="http://bdpak.cn:8080/home/assets/js/amazeui.min.js"></script>
	<script src="http://bdpak.cn:8080/home/js/dist/amazeui.dialog.min.js"
			charset="utf-8"></script>

	<script src="http://bdpak.cn:8080/home/video.js/video.js"></script>
	<script>
        videojs.options.flash.swf = "http://bdpak.cn:8080/home/video.js/video-js.swf";
	</script>
	<script>

        var IdList=[];  /*存放视频的ID*/
        var total_price=0; /*总价*/
		var courseid="${course.courseId}"; /*课程ID*/
        var isSelect_All=false; /*全选状态*/
        function lecturerCollect(teacherId) {
            if ($("#lecturer_collect_no").prop("hidden")) {
                //取消收藏
                //alert("取消收藏");
                //alert(teacherId);
                //异步请求页面不刷新
                $.ajax({
                    type: "POST",
                    url: "${pageContext.request.contextPath}/teacher/cancelCollectTeacher",
                    data: {
                        teacherId:teacherId,
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

                $("#lecturer_collect_no").prop("hidden", false);
                $("#lecturer_collect_yes").prop("hidden", true);
            } else {
                //收藏
                //alert("收藏");
                //alert(teacherId);
                //异步请求页面不刷新
                $.ajax({
                    type: "POST",
                    url: "${pageContext.request.contextPath}/teacher/collectTeacher",
                    data: {
                        teacherId:teacherId,
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
                $("#lecturer_collect_no").prop("hidden", true);
                $("#lecturer_collect_yes").prop("hidden", false);
            }
        }

        function lessonCollect(courseId) {
            if ($("#lesson_collect_no").prop("hidden")) {
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

                $("#lesson_collect_no").prop("hidden", false);
                $("#lesson_collect_yes").prop("hidden", true);

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
                $("#lesson_collect_no").prop("hidden", true);
                $("#lesson_collect_yes").prop("hidden", false);
            }
        }

        function playVideo(obj) {

            /*使用nginx时候把${pageContext.request.contextPath}替换成http://localhost:8080/video/obj*/
            if(obj.toString().trim()!=null){
                var path=obj.toString();
                $("#example_video_source").attr("src","http://bdpak.cn:8080/home/video/"+path);  //变换视频地址
                $("#example_video_1_html5_api").attr("src","http://bdpak.cn:8080/home/video/"+path);
            }

        }


    /*    /!*视频权限*!/
        $('.am-list').on('click','#Ccourse',function(){
            var Permission=$(this).find('#Permission').text();
            var path=$(this).find('#path').text();
            if(Permission==1){
                playVideo(path);
            }else{
              window.location.href="${pageContext.request.contextPath}/routeW/Goto/course/warn";
            }

        });*/

        /*获取菜单长度*/
        function ListMenue(){
            return $('.am-menu-nav').find('li').length;
        };


        /*获取视频列表长度*/
        function ListCourse(){
            return $('.am-list-course').find('li').length;
        }

        /*删除数组中元素方法*/
        function removeByValue(arr, val) {
            for(var i=0; i<arr.length; i++) {
                if(arr[i] == val) {
                    arr.splice(i, 1);
                    break;
                }
            }
        }
        /*重置添加按钮*/
        function back(ItemId){
            var CourseLength=ListCourse();
            for(var i=0;i<CourseLength;i++){
                var CourseId=$('.am-list-course').find('li').eq(i).find('#videoId').text();
                if(ItemId==CourseId){
                    $('.am-list-course').find('li').eq(i).find('.am-icon-plus-circle').show();
                    $('.am-list-course').find('li').eq(i).find('.am-icon-check-circle-o').css('display','none');
                }
            }
        }

        /*视频购买添加*/
        $('.am-list').on('click','.am-icon-plus-circle',function(){
            $('.am-btn').css('background','red');
            var CourseName=$(this).parent().find('span').eq(0).text();
            var CoursePrice=$(this).parent().find('#CoursePrice').text();
            var CourseId=$(this).parent().find('#videoId').text();
            $(this).css('display','none');
            $(this).parent().find('.am-icon-check-circle-o').show();
            var index=$.inArray(CourseId,IdList);
            if(index==-1){
                var items=  '<li style="width:100%" >'
                    +'<a href="##" class="" ><span style="position: absolute;left: 13px;font-size:14px;font-family:楷体">'+CourseName+'</span><span style="position: absolute; right: 20px;">￥<span id="McoursePrice">'+CoursePrice+'</span><i class="am-icon-times-circle" style="margin-left: 20px"></i></span></a>'
                    +'<span id="CourseId" style="display:none">'+CourseId+'</span>'
                    +'</li>';
                $('.am-menu-sub').append(items);
                IdList.push(CourseId);
                total_price=Number(total_price)+Number(CoursePrice); /*统计添加后的总金额*/
                $('#Tprice').show();
                $('#Tprice').text("￥"+total_price);
            }
            var Remalength=ListMenue();
            $('#MenueLength').text(Remalength-1);
            $('#Quantity').show();


        });

        /*已购视频删除*/
        $('.am-menu-sub').on('click','.am-icon-times-circle',function(){
            var CourseId=$(this).parent().parent().parent().find('#CourseId').text();
            var CoursePrice=$(this).parent().find('#McoursePrice').text();
            removeByValue(IdList,CourseId);
            $(this).parent().parent().parent().remove();
            total_price=Number(total_price)-Number(CoursePrice);/*统计删除后的总金额*/
            $('#Tprice').text("￥"+total_price);
            back(CourseId);
            isSelect_All=!isSelect_All;
            $('.select_all').css('color','#60b6e1'); /*点击删除时，重置全选按钮*/

            var Remalength=ListMenue();
            $('#MenueLength').text(Remalength-1);
            if(Remalength==1){
                $('.am-btn').css('background','rgba(0,0,0,0.3)');
                $('#Quantity').css('display','none');
                $('#Tprice').css('display','none');
                $('.select_all').css('color','#60b6e1');
                $('.am-menu-sub').removeClass("am-in");
            }
        });

        /*视频全选*/
        $('.select_all').on('click',function(){
            isSelect_All=!isSelect_All;
            if(isSelect_All){
                $('.select_all').css('color','red');
                var CourseLength=ListCourse();
                for(var i=0;i<CourseLength;i++){
                    var Permission=$('.am-list-course').find('li').eq(i).find('#Permission').text();
                    var CourseId=$('.am-list-course').find('li').eq(i).find('#videoId').text();
                    var CourseName=$('.am-list-course').find('li').eq(i).find('span').eq(0).text();
                    var CoursePrice=$('.am-list-course').find('li').eq(i).find('#CoursePrice').text();
                    if(Permission==0){
                        var index=$.inArray(CourseId,IdList);
                        if(index==-1){
                            var items=  '<li style="width:100%" >'
                                +'<a href="##" class="" ><span style="position: absolute;left: 13px;font-size:14px;font-family:楷体">'+CourseName+'</span><span style="position: absolute; right: 20px;">￥<span id="McoursePrice">'+CoursePrice+'</span><i class="am-icon-times-circle" style="margin-left: 20px"></i></span></a>'
                                +'<span id="CourseId" style="display:none">'+CourseId+'</span>'
                                +'</li>';
                            $('.am-menu-sub').append(items);
                            IdList.push(CourseId);
                            total_price=Number(total_price)+Number(CoursePrice); /*统计添加后的总金额*/
                            $('.am-list-course').find('li').eq(i).find('.am-icon-plus-circle').css('display','none');
                            $('.am-list-course').find('li').eq(i).find('.am-icon-check-circle-o').show();
                        }
                    }
                };
                var Remalength=ListMenue();
                if(Remalength>1){
                    $('.am-btn').css('background','red');
                    $('#Tprice').show();
                    $('#Tprice').text("￥"+total_price);
                    $('#MenueLength').text(Remalength-1);
                    $('#Quantity').show();

                }
            } else{                                                       /*重置全选，变为全删除*/
                var Remalength=ListMenue()-1;
                if(Remalength>1){
                    for(var i=0;i<Remalength;i++){
                        var  videoId=$('.am-menu-sub').find('li').eq(i).find('#CourseId').text();
                        var  videoPrice=$('.am-menu-sub').find('li').eq(i).find('#McoursePrice').text();
                        back(videoId);
                        removeByValue(IdList,videoId);
                        total_price=Number(total_price)-Number(videoPrice);/*统计删除后的总金额*/

                    }
                    $('.am-menu-sub').find('li').remove();
                    $('.am-btn').css('background','rgba(0,0,0,0.3)');
                    $('#Quantity').css('display','none');
                    $('#Tprice').css('display','none');
                    $('.select_all').css('color','#60b6e1');
                    $('.am-menu-sub').removeClass("am-in");
                }

            }
        });

        /*购买*/
        function Buy() {
            if(IdList.length){

            window.location.replace("${pageContext.request.contextPath}/routeW/createOrder?courseId="+courseid+"&videosId="+IdList);

				<%--window.location.href="${pageContext.request.contextPath}/order/createOrder?courseId="+courseid+"&videosId="+IdList;--%>
            }

        }
	</script>

	</html>
