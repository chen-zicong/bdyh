<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
    <title>首页</title>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">

    <!-- common start -->
    <link rel="stylesheet" href="http://bdpak.cn:8080/home/bd-icon/iconfont.css">
    <link rel="stylesheet" href="http://bdpak.cn:8080/home/assets/css/amazeui.min.css"/>
    <link rel="stylesheet" type="text/css" href="http://bdpak.cn:8080/home/address-master/dist/amazeui.address.css"/>
    <link rel="stylesheet" href="http://bdpak.cn:8080/home/wechat/wechat-icon/iconfont.css"/>
    <link rel="stylesheet" href="http://bdpak.cn:8080/home/wechat/wechat-icon/iconfont1.css"/>
    <script src="http://bdpak.cn:8080/home/wechat/wechat-icon/iconfont.js">

    </script>
    <style>
        /* 清除浏览器差异，保持样式统一 */
        {
            margin: 0
        ;
            padding: 0
        ;
            border: 0
        ;
            -webkit-font-smoothing: antialiased
        ;
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
            left: inherit;
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
            font-family: "iconfont" !important;
            font-size: 40px;
            font-style: normal;
            -webkit-font-smoothing: antialiased;
            -moz-osx-font-smoothing: grayscale;
        }

        .icon {
            width: 1em;
            height: 1em;
            vertical-align: -0.15em;
            fill: currentColor;
            overflow: hidden;
        }
    </style>
    <!-- common end -->


    <%-- <jsp:include page="${pageContext.request.contextPath}/common/head.jsp"/> --%>
    <!-- <link rel="import" href="http://localhost:8080/common/head.html"> -->
    <style type="text/css">
        /* 内容区设置 */
        .bdyh_mian {
            max-width: 640px;
            margin: 0 auto;
            background: #ececec;
            position: relative;
        }

        /* 轮播图的高度 */
        .bdyh_mian .am-slides li {
            height: 180px;
        }

        /* 中间菜单栏*/
        .bdyh_circle_nav {
            padding: 5px 10px 5px;
            max-width: 100%;
        }

        .bdyh_circle_nav_list {
            max-width: 100%;
            overflow: hidden;
        }

        .bdyh_circle_nav_list li {
            width: 25%;
            margin-bottom: 15px;
        }

        .bdyh_circle_nav_list a {
            border-radius: 50%;
            width: 55px;
            height: 55px;
            display: block;
            margin: 0 auto;
            text-align: center;
            line-height: 55px;
            font-size: 35px;
            -webkit-transition: all 0.2s ease;
            transition: all 0.2s ease;
        }

        .bdyh_circle_nav_list span {
            position: relative;
            display: block;
            width: 100%;
            text-align: center;
            font-size: 14px;
            top: -25px;
        }

        /*内容展示区 */
        .bdyh_news_content_main {
            margin: auto;
            max-width: 96%;
            background: #fff;
            padding: 10px 20px;
            -webkit-box-shadow: 0 0 3px rgba(100, 100, 100, .1);
            box-shadow: 0 0 3px rgba(100, 100, 100, .1);
        }

        .am-list-news-title {
            border-left: 3px solid #84c2bf;
            color: #84c2bf;
        }

        .am-list-news-grade {
            border-right: 3px solid #7bfb9d;
            color: #6bf57d;
        }

        .am-list-news-lesson-amount {
            color: #6bf57d;
        }

        /*左侧栏a标签字体颜色 */
        .am-offcanvas-content a {
            color: #ceb4b4;
        }

        .am-list > li {
            background-color: rgba(255, 255, 255, 0);
            border: 1px solid rgba(222, 222, 222, 0.18);
            border-width: 1px 0;
        }
    </style>
</head>

<body>
<header style="height:40px;" data-am-widget="header" class="am-header am-header-default am-header-fixed">
    <p class="am-text-center" style="color:#fff;font-size:18px;">北斗宇航微课</p>
</header>

<div class="bdyh_mian">
    <!-- slider start -->
    <div id="your-slider" data-am-widget="slider" class="am-slider am-slider-default"
         data-am-slider='{&quot;animation&quot;:&quot;slide&quot;,&quot;slideshow&quot;:false;playAfterPaused:3000}'>
        <ul class="am-slides">
            <c:forEach items="${homePictureList }" var="homePicture">
                <li>
                    <img src="http://bdpak.cn:8080/home/home_picture/${homePicture.picturePath }">
                </li>
            </c:forEach>

            <!-- <li>
                  <img  src="http://bdpak.cn:8080/home/demo/slideshow5.jpg">
            </li>
            <li>
                  <img  src="http://bdpak.cn:8080/home/demo/slideshow2.jpg">
            </li>
            <li>
                  <img  src="http://bdpak.cn:8080/home/demo/slideshow3.jpg">
            </li>
            <li>
                  <img  src="http://bdpak.cn:8080/home/demo/slideshow4.jpg">
            </li> -->
        </ul>
    </div>
    <!-- slider end -->

    <!-- menu nav start -->
    <div class="bdyh_circle_nav">
        <ul class="bdyh_circle_nav_list am-avg-sm-4">
            <li>
                <a href="${pageContext.request.contextPath}/course/lessonListLevel/1">
                    <svg class="icon" aria-hidden="true">
                        <use xlink:href="#icon-zonghesuzhipingjiachuzhongban"></use>
                    </svg>
                    <span>一年级</span>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/course/lessonListLevel/2">
                    <%--<i style="color:#55ea83;" class="iconfont icon-erji"></i>--%>
                    <svg class="icon" aria-hidden="true">
                        <use xlink:href="#icon-gaozhongkecheng"></use>
                    </svg>
                    <span>二年级</span>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/course/lessonListLevel/3">
                    <svg class="icon" aria-hidden="true">
                        <use xlink:href="#icon-jiaoxuekeyan"></use>
                    </svg>
                    <span>三年级</span>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/course/lessonListLevel/4">
                    <svg class="icon" aria-hidden="true">
                        <use xlink:href="#icon-xueqingfenxixuanzhong"></use>
                    </svg>
                    <span>四年级</span>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/course/lessonListLevel/5">
                    <svg class="icon" aria-hidden="true">
                        <use xlink:href="#icon-jiaoxuezhongxin_keqianfankui"></use>
                    </svg>
                    <span>五年级</span>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/course/lessonListLevel/6">
                    <svg class="icon" aria-hidden="true">
                        <use xlink:href="#icon-jiaoxueloudanganguanli"></use>
                    </svg>
                    <span>六年级</span>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/course/allCourse">
                    <svg class="icon" aria-hidden="true">
                        <use xlink:href="#icon-jiaoxuezhongxin_wentidaoru"></use>
                    </svg>
                    <span>全部课程</span>
                </a>
            </li>
            <li>
                <a href="javascript:void(0);" data-am-offcanvas="{target: '#doc-oc-demo2', effect: 'push'}">
                    <i style="color:#ADFF2F;" class="iconfont icon-weibiaoti-"></i>
                    <span>更多</span>
                </a>
            </li>
        </ul>
    </div>
    <!-- menu nav end -->

    <!-- bdyh_news_content_main start -->
    <div class="bdyh_news_content_main">
        <div data-am-widget="list_news" class="am-list-news am-list-news-default">
            <!--列表标题-->
            <div class="am-list-news-hd am-cf">
                <!--带更多链接-->
                <span class="am-list-news-title am-text-default">推荐课程</span>
                <a href="${pageContext.request.contextPath}/course/moreLesson" class="am-fr"
                   style="display:inline-block;">
                    <span class="am-list-news-more">更多 &raquo;</span>
                </a>
            </div>

            <div class="am-list-news-bd">
                <ul id="am-list-news-bd" class="am-list">
                    <c:forEach items="${courseList }" var="course">
                        <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left">
                            <div onclick="Jump('${course.courseId}')">
                                <div class="am-u-sm-4 am-list-thumb">
                                    <a href="javascript:;" class="">
                                        <img src="http://bdpak.cn:8080/home/courseImg/${course.courseImg}"/>
                                    </a>
                                </div>

                                <div class=" am-u-sm-8 am-list-main">
                                    <h3 class="am-list-item-hd"><a href="javascript:;">${course.courseName}</a></h3>
                                    <div class="am-list-item-text">${course.courseDesc}</div>
                                    <div class="am-list-item-text">
										<span style="color:#f37b1d;">
											<c:choose>
                                                <c:when test="${course.coursePrice==0 }">
                                                    免费
                                                </c:when>
                                                <c:otherwise>
                                                    ${course.coursePrice}元
                                                </c:otherwise>
                                            </c:choose>
										</span>
                                        <span class="am-list-news-lesson-amount am-fr">共${course.lessionNum}节课</span>
                                    </div>
                                    <!-- <div class="am-list-item-text">
                                        <span class="am-list-news-lesson-amount ">10000人已学</span>
                                    </div>	 -->
                                </div>
                            </div>
                        </li>
                    </c:forEach>


                </ul>
            </div>
        </div>
    </div>
    <!-- bdyh_news_content_main end -->

    <!-- 左侧边栏内容 -->
    <div id="doc-oc-demo2" class="am-offcanvas">
        <div class="am-offcanvas-bar" style="width:220px;">
            <div class="am-offcanvas-content">

                <ul class="am-list admin-sidebar-list" id="collapase-nav-1">

                    <c:forEach items="${clazzList}" var="clazz">
                        <li class="am-panel">
                            <a href="${pageContext.request.contextPath}/course/lessonListLevel/${clazz.clazzId}">
                                <i style="color:#00BFFF;font-size:20px;line-height:20px;"
                                   class="iconfont icon-jihe5"></i>${clazz.clazz}
                                <i class="am-icon-angle-right am-fr am-margin-right"></i>
                            </a>
                        </li>
                    </c:forEach>

                    <%--<li class="am-panel">--%>
                        <%--<a href="${pageContext.request.contextPath}/course/lessonListLevel/8">--%>
                            <%--<i style="color:#00BFFF;font-size:20px;line-height:20px;" class="iconfont icon-hanshu"></i>(八年级)--%>
                            <%--<i class="am-icon-angle-right am-fr am-margin-right"></i>--%>
                        <%--</a>--%>
                    <%--</li>--%>
                    <%--<li class="am-panel">--%>
                        <%--<a href="${pageContext.request.contextPath}/course/lessonListLevel/9">--%>
                            <%--<i style="color:#00BFFF;font-size:20px;line-height:20px;"--%>
                               <%--class="iconfont icon-chusanfuxi"></i>(九年级)--%>
                            <%--<i class="am-icon-angle-right am-fr am-margin-right"></i>--%>
                        <%--</a>--%>
                    <%--</li>--%>
                    <%--<li class="am-panel">--%>
                        <%--<a href="${pageContext.request.contextPath}/course/lessonListLevel/10">--%>
                            <%--<i style="color:#00BFFF;font-size:20px;line-height:20px;"--%>
                               <%--class="iconfont icon-gaoyitongbu"></i>(高一)--%>
                            <%--<i class="am-icon-angle-right am-fr am-margin-right"></i>--%>
                        <%--</a>--%>
                    <%--</li>--%>
                    <%--<li class="am-panel">--%>
                        <%--<a href="${pageContext.request.contextPath}/course/lessonListLevel/11">--%>
                            <%--<i style="color:#00BFFF;font-size:20px;line-height:20px;"--%>
                               <%--class="iconfont icon-gaoertifen"></i>(高二)--%>
                            <%--<i class="am-icon-angle-right am-fr am-margin-right"></i>--%>
                        <%--</a>--%>
                    <%--</li>--%>
                    <%--<li class="am-panel">--%>
                        <%--<a href="${pageContext.request.contextPath}/course/lessonListLevel/12">--%>
                            <%--<i style="color:#00BFFF;font-size:20px;line-height:20px;"--%>
                               <%--class="iconfont icon-gaosanchongci"></i>(高三)--%>
                            <%--<i class="am-icon-angle-right am-fr am-margin-right"></i>--%>
                        <%--</a>--%>
                    <%--</li>--%>
                </ul>

            </div>
        </div>
    </div>

    <!-- foot navbar start -->
    <div data-am-widget="navbar" class="am-navbar am-cf am-navbar-default">
        <ul class="am-navbar-nav am-cf am-avg-sm-4">
            <li>
                <a href="${pageContext.request.contextPath}/index" style="margin-top:5px;">
                    <i style="color:#FFFFFF;font-size:25px;" class="iconfont icon-zhuye"></i>
                    <span class="am-navbar-label">首页</span>
                </a>
            </li>

            <li>
                <a href="${pageContext.request.contextPath}/course/myCourse" style="margin-top:5px;">
                    <i style="color:#FFFFFF;font-size:25px;" class="iconfont icon-shu"></i>
                    <span class="am-navbar-label">我的课程</span>
                </a>
            </li>

            <li>
                <a href="${pageContext.request.contextPath}/user/userCenter" style="margin-top:5px;">
                    <i style="color:#FFFFFF;font-size:25px;" class="iconfont icon-geren"></i>
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
<script src="http://bdpak.cn:8080/home/assets/js/app.js"></script>
<script>

    function Jump(courseId) {
        window.location.href = "${pageContext.request.contextPath}/course/courseDetails/" + courseId;
    }


    //初始化设置轮播图配置
    $('#your-slider').flexslider({
        playAfterPaused: 3000,
        before: function (slider) {
            if (slider._pausedTimer) {
                window.clearTimeout(slider._pausedTimer);
                slider._pausedTimer = null;
            }
        },
        after: function (slider) {
            var pauseTime = slider.vars.playAfterPaused;
            if (pauseTime && !isNaN(pauseTime) && !slider.playing) {
                if (!slider.manualPause && !slider.manualPlay && !slider.stopped) {
                    slider._pausedTimer = window.setTimeout(function () {
                        slider.play();
                    }, pauseTime);
                }
            }
        },
        // 设置其他参数
        startAt: 0,                     // Integer: 开始播放的 slide，从 0 开始计数
        slideshow: true,                // Boolean: 是否自动播放
        slideshowSpeed: 3000,           // Integer: ms 滚动间隔时间
        animationSpeed: 600,            // Integer: ms 动画滚动速度
        initDelay: 0,                   // Integer: ms 首次执行动画的延迟
        randomize: false,
    });
</script>
<!-- 	<script type="text/javascript">
		function show() {
			$(".bdyh.web.home_show_more_list").addClass('bdyh.web.home_show_more_list_show');
		}
		function close(){
			$(".bdyh.web.home_show_more_list").removeClass('bdyh.web.home_show_more_list_show');
		}
	</script>
	<script type="text/javascript">  
	var applicationRecord = document.getElementById('am-list-news-bd')

	//绘制单个div
	function setLi(item){
		var Li = '<li class="am-g am-list-item-desced">'
	    	+'<div>'
	            +'<a href="###">'
	            +'<i style="color:#6C7B8B;font-size:16px;" class="iconfont icon-kecheng"></i>'
			    +'<span style="color:#757575;">'+item.teacherLesson+'</span>'
			    +'<span class="am-list-news-grade am-fr">《一年级》</span>'
			    +'</a>'
	        +'</div>'
	        +'<div class="am-list-item-hd">'
	        	+'<span>家长：</span>'+item.parentName+'</span>'
	        	+'<span class="am-fr">联系电话：'+item.linkPhone+'</span>'
	        +'</div>'
	        +'<div class="am-list-item-text">'
		        +'<span>期望老师：</span>'+item.expectSex+'</span>'
	        	+'<span style="display:inline-block;margin-left:10%;">课时费：'+item.lessonCharge+'元/h</span>'
	        	+'<span class="am-fr">每周次数：'+item.timesWeek+'</span>'
	        +'</div>'
	        +'<div class="am-list-item-text">家教地址：'+item.placeProvince+item.placeCity+item.placeDistrict+item.managerName+'</div>'
	        +'<div class="am-list-item-text">要求说明：'+item.otherExplain+'</div>'
	        +'<div class="am-list-item-text">发布时间：'+item.addTime+'</div>'
	        +'</li>';
	    return Li;
	}
	
	//循环加载到页面
	function getApplicationData(){
		var dataList;
		$.ajax({  
            type:'post',  
            url:"/bdyh.web.home/educateInfoW/select",  
            dataType:'json',  
            /* data:{content:content}, */  
            beforeSend:function(){  
                /* obj.html('正在处理...'); */  
            },success:function(data){
                if(data.status == 1){
                	dataList = data.data.familyEducateInfoList;
                	var html = '';
            	    for(var i = 0;i<dataList.length;i++){
            	        html += setLi(dataList[i]);
            	    }
            	    applicationRecord.innerHTML = html;
                    //成功  
                }else{  
                    //出错   
                }  
            }  
    	});
	}

	 window.onload = getApplicationData();
	</script> -->
</html>
