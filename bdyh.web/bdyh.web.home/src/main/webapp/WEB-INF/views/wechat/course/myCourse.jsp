<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
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


<link rel="stylesheet" type="text/css" href="http://bdpak.cn:8080/home/address-master/dist/amazeui.address.css" />
<style type="text/css">
/* 标题栏字体重设 */
.am-header .am-header-title {
    font-size: 1.8rem;
}

.bdyh_mian {
	max-width: 640px;
	margin: 0 auto;
	background: #ececec;
	position: relative;
}

/*内容区块样式 */
.bdyh_news_content_main {
	margin-top: 15%;
}

/*课程内容列表样式 */
.am-list-news-default {
	margin: 0px 5px;
}

/* 选项卡区横向长度样式重写覆盖 */
[data-am-widget=tabs] {
    margin: -48px 0px 0px 0px;
}
.am-tabs-bd .am-tab-panel {
	padding:0px 0px;
}

/* 选项卡选中时颜色覆盖重写 */
.am-tabs-default .am-tabs-nav>.am-active a {
    background-color: #8fe0e4;
    color: #fff;
}
/*按钮样式*/
.am-btn{
    border-radius:5px;
    font-size:14px
}


</style>
</head>
<body>
<div class="bdyh_mian">
    <header data-am-widget="header" class="am-header am-header-default am-header-fixed">
        <h1 class="am-header-title">
            <a href="#title-link" class="">
                我的课程
            </a>
        </h1>
    </header>
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

        <!--选项栏 -->
        <div data-am-widget="tabs" class="am-tabs am-tabs-default">
            <ul class="am-tabs-nav am-cf" style="position:fixed;z-index: 1010;max-width: 640px;top: 40px;">
                <li class="am-active"><a href="[data-tab-panel-0]">未支付</a></li>
                <li class=""><a href="[data-tab-panel-1]">已支付</a></li>
            </ul>
            <div class="am-tabs-bd">

                <!--未支付-->
                <div data-tab-panel-0 class="am-tab-panel am-active" style="margin-top:55px;">
                    <div data-am-widget="list_news" class="am-list-news am-list-news-default" >
                        <!--课程列表-->
                        <c:forEach items="${userCourseListUnPay }" var="userCourse">
                        <div class="am-list-news-bd" style="box-shadow:0 0.05rem 0.1rem rgba(0,0,0,.3);border-radius:.1rem;padding:0px 10px;background:#fff">
                            <ul class="am-list">

                                    <!--缩略图在标题左边-->

                                        <div style="position: relative;top: 10px;font-size:13px">
                                            <span style="color:#999">下单时间 : ${userCourse.date}</span>
                                            <span id="order_number" style="display:none">${userCourse.orderId}</span>
                                            <span style="float:right;color:#f37b1d">待付款</span>
                                        </div>
                                        <hr style="border: 1px solid #ccc">
                                    <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left">
                                        <div >
                                            <div class="am-u-sm-4 am-list-thumb">

                                                <img src="http://bdpak.cn:8080/home/courseImg/${userCourse.course.courseImg}" />

                                            </div>
                                            <div class=" am-u-sm-8 am-list-main">
                                                <h3 class="am-list-item-hd">
                                                    <a href="#">${userCourse.course.courseName}</a>
                                                </h3>
                                                <div class="am-list-item-text">${userCourse.course.courseDesc}</div>
                                                <div class="am-list-item-text">
                                                    <span style="color:#f37b1d;">待付款(${userCourse.price})元</span>
                                                    <span class="am-list-news-lesson-amount am-fr">共${userCourse.count}节课</span>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <hr style="border: 1px solid #ccc">
                                    <div class="am-g" style="padding-top: 3px;padding-bottom: 15px;">
                                        <span style="color:#ef0d0d">实付款:￥${userCourse.price}</span>
                                        <span style="float:right"><button class="am-btn am-btn-primary " onclick="orderUnpay('${userCourse.orderId}')">取消订单</button> <button class="am-btn am-btn-warning" onclick="orderpay('${userCourse.orderId}')">支付订单</button></span>
                                    </div>
                            </ul>
                        </div>
                        </c:forEach>
               <%--         <div class="am-list-news-bd" style="box-shadow:0 0.05rem 0.1rem rgba(0,0,0,.3);border-radius:.1rem;padding:0px 10px;background:#fff">
                            <ul class="am-list">

                                <c:forEach items="${userCourseListUnPay }" var="userCourse">
                                    <!--缩略图在标题左边-->
                                    <li class="am-g" style="font-size:13px">
                                        <div style="position: relative;top: 10px;">
                                            <span style="color:#999">下单时间 : 2018-07-20</span>
                                            <span id="order_number" style="display:none">100011111</span>
                                            <span style="float:right;color:#f37b1d">待付款</span>
                                        </div>
                                    </li>
                                    <hr style="border: 1px solid #ccc">
                                    <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left">
                                        <div onclick="checkPay(${userCourse.course.courseId},${userCourse.course.coursePrice})">
                                            <div class="am-u-sm-4 am-list-thumb">

                                                <img src="http://img0.imgtn.bdimg.com/it/u=2479868636,1193546218&fm=27&gp=0.jpg" />

                                            </div>
                                            <div class=" am-u-sm-8 am-list-main">
                                                <h3 class="am-list-item-hd">
                                                    <a href="#">初中数学</a>
                                                </h3>
                                                <div class="am-list-item-text">数学很好啊</div>
                                                <div class="am-list-item-text">
                                                    <span style="color:#f37b1d;">待付款(100)元</span>
                                                    <span class="am-list-news-lesson-amount am-fr">共10节课</span>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <hr style="border: 1px solid #ccc">
                                    <li class="am-g" style="padding-top: 3px;padding-bottom: 15px;">
                                        <span style="color:#ef0d0d">实付款:￥100.00</span>
                                        <span style="float:right"><button class="am-btn am-btn-primary">取消订单</button> <button class="am-btn am-btn-warning">支付订单</button></span>
                                    </li>
                                </c:forEach>


                            </ul>

                        </div>--%>
                    </div>
                </div>

                <!-- 已支付 -->
                <div data-tab-panel-1 class="am-tab-panel" style="margin-top:55px;">
                    <div data-am-widget="list_news" class="am-list-news am-list-news-default" >
                        <!--课程列表-->
                        <c:forEach items="${userCourseListPayed}" var="userCourse">
                        <div class="am-list-news-bd" style="box-shadow:0 0.05rem 0.1rem rgba(0,0,0,.3);border-radius:.1rem;padding:0px 10px;background:#fff" onclick="Look('${userCourse.orderId}')">
                            <ul class="am-list">
                                <!--缩略图在标题左边-->
                                <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left">
                                    <div class="am-u-sm-4 am-list-thumb">
                                        <a href="javascript:;" class=""> <img
                                                src="http://bdpak.cn:8080/home/courseImg/${userCourse.course.courseImg}" />
                                        </a>
                                    </div>

                                    <div class=" am-u-sm-8 am-list-main">
                                        <h3 class="am-list-item-hd">
                                            <a href="${pageContext.request.contextPath}/course/courseDetails/${userCourse.course.courseId}">${userCourse.course.courseName}</a>
                                        </h3>
                                        <div class="am-list-item-text">${userCourse.course.courseDesc}</div>
                                        <div class="am-list-item-text">
                                            <span style="color:#f37b1d;">已付款(${userCourse.price})元</span>
                                            <span class="am-list-news-lesson-amount am-fr">共${userCourse.count}节课</span>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        </c:forEach>
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
<!-- <script src="/bdyh.web.home/wechat/teacher_subject/subject.js"></script> -->
<script src="http://bdpak.cn:8080/home/js/dist/amazeui.dialog.min.js" charset="utf-8"></script>
<script src="http://bdpak.cn:8080/home/address-master/dist/address.js"
	type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
/*查看已购课程详情*/

	function Look(orderid) {
	    window.location.href="${pageContext.request.contextPath}/order/paidCourse?orderId="+orderid;

    }
/*跳转到付款页面*/
    function orderpay(orderid) {

        window.location.href="${pageContext.request.contextPath}/order/intoOrder?orderId="+orderid;
    }


/*取消订单*/
    function orderUnpay(orderid) {
        var r=confirm("确定要取消订单吗？");
        if (r==true)
        {
            $.ajax({
                type:'POST',
                url:'${pageContext.request.contextPath}/order/cancelOrder',
                data:{
                    orderId:orderid
                },
                success:function (data) {
                    if(data.code=="success"){
                        alert("取消订单成功!");
                        window.location.reload();
                    }else {
                        alert("取消订单失败!");
                    }


                }
            });
        }
        else
        {
            confirm.close();
        }


    }

</script>
</html>