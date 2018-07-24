<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<title>搜索</title>
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />
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
		
	<link rel="stylesheet" type="text/css" href="http://bdpak.cn:8080/home/address-master/dist/amazeui.address.css" />
	<style type="text/css">
		/* 条件搜索选区样式 */
		#search_condition button {
			border-color: #fff;
		}
		
		#search_condition button>span {
			text-align: center;
		}
		
		.bdyh_mian {
			max-width: 640px;
			margin: 0 auto;
			background: #ececec;
			position: relative;
		}
		
		/*内容区样式 */
		.bdyh_news_content_main {
			margin-top:15%;
		}
		.am-list-news-default {
		    margin: 0px 5px;
		}
	</style>
	
	<script type="text/javascript">
		function searchCourse(){
			var courseName = document.getElementById("search").value;
			var districtName = document.getElementById("address1-form").value;
			var courseType = document.getElementById("tea_subject").value;
			var courseLevel = document.getElementById("tea_grade").value;
			/* alert(courseName);
			alert(districtName);
			alert(courseType);
			alert(courseLevel); */
			/* if(courseName == null || courseName == ''){
				alert("请输入课程名称哦 ^^");
				return false;
			} */
			//去掉courseRecommend，courseLevel条件，搜索时候应该是没有这些条件的
			//window.location.href="${pageContext.request.contextPath}/course/searchCourse.action?courseRecommand=${courseRecommend}&courseLevel=${courseLevel}&courseName="+courseName;
			//异步请求实现页面局部刷新，只刷新课程列表
			$.ajax({
				   type: "GET",
				   url: "${pageContext.request.contextPath}/course/searchCourse",
				   data: {
					   courseName:courseName,
					   districtName:districtName,
					   courseType:courseType,
					   courseLevel:courseLevel
				   },
				   success: function(data){
					   	//alert(data);
					   	$("#searchList").html(data);
			   	   }
			  });	
		}
		
	</script>
</head>
<body>
	<div class="bdyh_mian">
		<header data-am-widget="header"
			class="am-header am-header-default am-header-fixed">
			<div style="margin:5px 0px 0px 0px;">
				<span style="color:#b4b4b4;background-color:#fff;position:relative;left:8%;z-index:10;bottom: 8px;">
					<i class="am-icon-search"></i>
				</span> 
				<input id="search" type="text" style="display:inline-block;width:70%;border-radius:.5rem;padding-left:25px;height:30px;margin-bottom:20px;"
					class="am-form-field" placeholder="输入关键字">
				<button type="button" class="am-btn am-btn-secondary am-radius"
					style="padding:.2em .5em;margin:0px 0px 20px 5px;" onclick="searchCourse()">搜索</button>
			</div>
		</header>

		<!--condition select bar -->
		<div id="search_condition" style="position:fixed;top:40px;left: 0;right: 0; width: 100%;z-index: 1010;background:#fff;max-width: 640px;margin: 0 auto;">
			<div id="address1" style="display:inline-block;width:32%;">
				<select id="address1-form"
					data-am-selected="{btnWidth: '100%',maxHeight:0}">
					<option id="district" value="东城区">东城区</option>
					<option id="city" value="北京市">北京市</option>
					<option id="prov" value="北京">北京</option>
				</select>
			</div>
			<div style="display:inline-block;width:32%;">
				<select id="tea_subject"
					data-am-selected="{maxHeight:0,btnWidth: '100%'}">

				</select>
			</div>
			<div style="display:inline-block;width:32%;">
				<select id="tea_grade"
					data-am-selected="{maxHeight:0,btnWidth: '100%'}">
					
				</select>
			</div>
		</div>

		<!-- bdyh_news_content_main start -->
		<div class="bdyh_news_content_main">

			<!-- <div data-am-widget="list_news"
				class="am-list-news am-list-news-default">
				<div class="am-list-news-bd" style="margin-top:50px;">
					<ul id="listContent" class="am-list">

					</ul>
				</div>
				<div style="margin:0px 0px 0px 35%;">
					<a href="javaScript:getMore()" class="fa-cubes"> <span
						id="getMore" style="color:#757575;">点击加载更多</span>
					</a>
				</div>
			</div> -->
			
			<div data-am-widget="list_news" class="am-list-news am-list-news-default" style="background-color:#fff;">
				<!--列表主体内容-->
				<div id="searchList" class="am-list-news-bd" style="box-shadow:0 0.05rem 0.1rem rgba(0,0,0,.3);border-radius:.1rem;padding:0px 10px;">
					
					<!-- 作为一个单独页面分离出去 searchList 当再次查询时异步加载局部刷新页面-->
					<!-- searchList.jsp start -->
					<ul class="am-list">
						<!--缩略图在标题左边-->
						<c:forEach items="${courseList }" var="course">
							<li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left">
								<%--<a href="${pageContext.request.contextPath}/course/checkPay?courseId=${course.courseId}&coursePrice=${course.coursePrice}">--%>
									<div onclick=checkPay('${course.courseId}')>
								<div class="am-u-sm-4 am-list-thumb">
										<%--${pageContext.request.contextPath}/course/courseDetails/${course.courseId}--%>

								    <img src="http://bdpak.cn:8080/home/courseImg/${course.courseImg }"/>

								</div>


								<div class=" am-u-sm-8 am-list-main">
								    <h3 class="am-list-item-hd"><a href="" >${course.courseName }</a></h3>
								    <div class="am-list-item-text">${course.courseDesc }</div>
								    <div class="am-list-item-text">
										<span style="color:#f37b1d;">
											<c:choose>
												<c:when test="${course.coursePrice eq 0 }">
													免费
												</c:when>
												<c:otherwise>
													${course.coursePrice }元
												</c:otherwise>
											</c:choose>
										</span>
										<span class="am-list-news-lesson-amount am-fr">共${course.lessionNum }节课</span>
							        </div>
							        <!-- <div class="am-list-item-text">
										<span class="am-list-news-lesson-amount ">10000人已学</span>
							        </div>	 -->
								</div>
									</div>
							<%--</a>--%>
							</li>
						</c:forEach>
					</ul>
					<!-- searchList.jsp end -->
					
					
				</div>
			</div>
			
		</div>
		<!-- bdyh_news_content_main end -->
		
		<!--回顶部 -->
		<div data-am-widget="gotop" class="am-gotop am-gotop-fixed" >
		    <a href="#top" title="">
		          <i class="am-gotop-icon am-icon-hand-o-up"></i>
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
<script type="text/javascript">
	function setLi(item) {
		var Li = '<li class="am-g am-list-item-desced">'
				+ '<div>'
				+ '<a href="###">'
				+ '<i style="color:#6C7B8B;font-size:16px;" class="iconfont icon-lesson1"></i>'
				+ '<span style="color:#757575;">'
				+ item.teacherLesson
				+ '</span>'
				+ '<span class="am-list-news-grade am-fr">《'
				+ item.teacherGrade
				+ '》</span>'
				+ '</a>'
				+ '</div>'
				+ '<div class="am-list-item-hd">'
				+ '<span>家长：</span>'
				+ item.parentName
				+ '</span>'
				+ '<span class="am-fr">联系电话：'
				+ item.linkPhone
				+ '</span>'
				+ '</div>'
				+ '<div class="am-list-item-text">'
				+ '<span>期望老师：</span>'
				+ item.expectSex
				+ '</span>'
				+ '<span style="display:inline-block;margin-left:5%;">课时费：'
				+ item.lessonCharge
				+ '元/h</span>'
				+ '<span class="am-fr">每周次数：'
				+ item.timesWeek
				+ '</span>'
				+ '</div>'
				+ '<div class="am-list-item-text">家教地址：'
				+ item.placeProvince
				+ item.placeCity
				+ item.placeDistrict
				+ item.managerName
				+ '</div>'
				+ '<div class="am-list-item-text">要求说明：'
				+ item.otherExplain
				+ '</div>'
				+ '<div class="am-list-item-text">发布时间：'
				+ item.addTime + '</div>' + '</li>';
		return Li;
	}
</script>
<script src="http://bdpak.cn:8080/home/js/jquery-3.2.1.min.js"></script>
<script src="http://bdpak.cn:8080/home/assets/js/amazeui.min.js"></script>
<script src="http://bdpak.cn:8080/home/wechat/teacher_subject/subject.js"></script>
<script src="http://bdpak.cn:8080/home/js/dist/amazeui.dialog.min.js"
	charset="utf-8"></script>
<script type="text/javascript">
	var pageSize = 10, startPage = 1, totalPage = 0;
	var applicationRecord = document.getElementById('listContent');

	function getMore() {
		//getMoreData(1,10);
		if (startPage == totalPage || totalPage == 0) {
			return;
		} else {
			startPage += 1;
		}
		var dataList;
		$.ajax({
			type : 'post',
			url : "${pageContext.request.contextPath}/educateInfoW/select",
			dataType : 'json',
			data : {
				startPage : startPage,
				pageSize : pageSize,
				teacherLesson : $("#tea_subject").val(),
				teacherGrade : $("#tea_grade").val(),
				placeProvince : $("#prov").val(),
				placeCity : $("#city").val(),
				placeDistrict : $("#district").val(),
				otherExplain : $("#keyWord").val()
			},
			beforeSend : function() {

			},
			success : function(data) {
				if (data.status == 1) {
					dataList = data.data.familyEducateInfoList;
					var html = '';
					for (var i = 0; i < dataList.length; i++) {
						html += setLi(dataList[i]);
					}
					$("#listContent").append(html);
					if (startPage == totalPage) {
						document.getElementById('getMore').innerHTML = "暂无更多！";
					}
					//成功  
				} else {
					//出错   
				}
			}
		});
	}

	function search() {
		startPage = 1;
		alert($("#tea_subject").val());
				$.ajax({
					type : 'post',
					url : "/bdyh.web.home/course/selectCourse",
					dataType : 'json',
					data : {
						startPage : startPage,
						pageSize : pageSize,
						teacherLesson : $("#tea_subject").val(),
						teacherGrade : $("#tea_grade").val(),
						placeProvince : $("#prov").val(),
						placeCity : $("#city").val(),
						placeDistrict : $("#district").val(),
						otherExplain : $("#keyWord").val()
					},
					beforeSend : function() {
						
					},
					success : function(data) {
						if (data.status == 1) {
							dataList = data.data.familyEducateInfoList;
							var html = '';
							if (data.data.totalPage > 0) {
								for (var i = 0; i < dataList.length; i++) {
									html += setLi(dataList[i]);
								}
								applicationRecord.innerHTML = html;
								totalPage = data.data.totalPage;
								if (startPage == totalPage) {
									document.getElementById('getMore').innerHTML = "暂无更多！";
								} else {
									document.getElementById('getMore').innerHTML = "点击加载更多！";
								}
							} else if (data.data.totalPage == 0) {
								applicationRecord.innerHTML = "";
								document.getElementById('getMore').innerHTML = "暂无更多！";
								AMUI.dialog.alert({
									title : '提示',
									content : "暂无数据",
									onConfirm : function() {
										console.log('close');
									}
								});
							} else {
								document.getElementById('getMore').innerHTML = "暂无更多！";
							}
							//成功  
						} else {
							//出错   
						}
					}
				});
	}

	function back() {
		window.history.back();
	}

    function checkPay(courseId){
        window.location.href="${pageContext.request.contextPath}/course/courseDetails/"+courseId;
    }
</script>
<script src="http://bdpak.cn:8080/home/address-master/dist/address.js"
	type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	$(function() {
		/* document.addEventListener('touchmove', function (e) {
			e.preventDefault();
		}, false); */
		//	自定义输出
		var courseName = document.getElementById("search").value;
		$("#address1").address(
				{
					customOutput : true,
					selectEnd : function(json, address) {
						for ( var key in json) {
							$("#address1-form")
									.find("option[id='" + key + "']").val(
											json[key]);
							document.getElementById(key).innerText = json[key];
						}
						//alert(json['district']);
						//searchCourse(json['district']);
						searchCourse(json['district']);
						
						//window.location.href="${pageContext.request.contextPath}/course/searchCourse.action?courseRecommand=${courseRecommend}&courseLevel=${courseLevel}&courseName="+courseName;
						//异步请求实现页面局部刷新，只刷新课程列表
						/* $.ajax({
							   type: "GET",
							   url: "${pageContext.request.contextPath}/course/searchCourse",
							   data: {
								   courseName:courseName,
								   districtName:json['district'],
							   },
							   success: function(data){
								   //刷新列表
								   $("#searchList").html(data);
							   }
						}); */	
					}
				}).on("provTap", function(event, activeli) {
			console.log(activeli.text());
		}).on("cityTap", function(event, activeli) {
			console.log(activeli.text());
		})
	});
</script>
</html>
