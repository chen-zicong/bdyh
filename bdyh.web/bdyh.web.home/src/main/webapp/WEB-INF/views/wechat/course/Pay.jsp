<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
    <title>下单</title>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta content="yes" name="apple-mobile-web-app-capable" />
    <meta content="black" name="apple-mobile-web-app-status-bar-style" />
    <meta content="telephone=no" name="format-detection" />
    <link rel="stylesheet" href="http://bdpak.cn:8080/home/bd-icon/iconfont.css">
    <link rel="stylesheet" href="http://bdpak.cn:8080/home/assets/css/amazeui.min.css" />
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
            background-color: #e3e3e5;
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

            margin: 0 auto;
            left:inherit;
            height: 45px;
            line-height: 45px;
        }

        /* 头部栏样式重写 */
        .am-header {
            margin: 0 auto;
            height: 50px;
            line-height: 40px;
            padding: 0 10px;
        }

        /*列表样式重写*/
        .am-list-news-default{
            margin:0 auto;

        }
        .am-list-news-default,li{
            border-radius:5px;
        }
        .am-list-news-default .am-list .am-list-item-desced{
            padding-left:10px;
        }

    </style>
</head>
<body>
<div >
    <header data-am-widget="header"
            class="am-header am-header-default am-header-fixed">
        <div class="am-header-left am-header-nav">
            <a href="javascript:back();" >
                <img class="am-header-icon-custom" src="data:image/svg+xml;charset&#x3D;utf-8,&lt;svg xmlns&#x3D;&quot;http://www.w3.org/2000/svg&quot; viewBox&#x3D;&quot;0 0 12 20&quot;&gt;&lt;path d&#x3D;&quot;M10,0l2,2l-8,8l8,8l-2,2L0,10L10,0z&quot; fill&#x3D;&quot;%23fff&quot;/&gt;&lt;/svg&gt;" alt=""/>
            </a>
        </div>

        <h5 class="am-header-title">
            确认下单
        </h5>
    </header>
    <div style="margin-bottom:20%">
        <div data-am-widget="list_news" class="am-list-news am-list-news-default" style="margin-top:10%">
            <!--列表标题-->
            <div class="am-list-news-hd am-cf">
                <h2 style="color: #f37b1d;padding-left:3%;">商 品 信 息</h2>
            </div>

            <div class="am-list-news-bd">
                <ul class="am-list">

                    <!--缩略图在标题左边-->
                    <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left">
                        <div class="am-u-sm-4 am-list-thumb">
                            <a href="##" class="">
                                <img src="http://bdpak.cn:8080/home/courseImg/${order.course.courseImg}" />
                            </a>
                        </div>

                        <div class=" am-u-sm-8 am-list-main">
                            <h3 class="am-list-item-hd"><span style="">${order.course.courseName}</span><span style="float:right;padding-right: 4%">￥${order.price}</span></h3>
                            <div class="am-list-item-text" style="margin-top: 8%">规格 : 共计${order.count}个视频</div>

                        </div>
                    </li>
                    <li class="am-g am-list-item-dated"style="margin-top:8%" >
                        <a class="am-list-item-hd " style="color:#484242;padding-left:12px">课程金额</a>
                        <span class="am-list-date"  style="color:#484242;padding-right: 2%">￥${order.price}</span>
                    </li>

                    <li class="am-g" style="padding-top: 20px;padding-bottom: 20px;margin-top:12%;padding-left: 25%;">
                        <div style="float:right;margin-right: 3%;">
                        <span style="color: #f37b1d;margin-top: 5px;display:inline-block;margin-right: 11px;">需付: ￥${order.price}元</span>
                        <button class="am-btn am-btn-warning" style=" border-radius: 6px;" onclick="Pay('${order.orderId}')">提交订单</button>
                        </div>
                    </li>
                </ul>
                <p style="font-size:14px;text-align:center;color:#355eef">©版权所有小科斗微课堂</p>
            </div>

        </div>


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
<script>
    /*返回上一级*/
    function back() {
        window.history.back();
    }

    /*支付*/
    function Pay(orderid) {
        $.ajax({
            type: "GET",
            url: "${pageContext.request.contextPath}/vipPay/wechatPay?orderId="+orderid,
            success: function(data){
                WeixinJSBridge.invoke(
                    'getBrandWCPayRequest', data ,
                    function(res){
                        if(res.err_msg == "get_brand_wcpay_request:ok" ) {
                            alert("支付成功");
                            window.open("${pageContext.request.contextPath}/course/courseDetails?orderId="+orderid);
                        } else if(res.err_msg == "get_brand_wcpay_request:cancel"){
                            alert("取消支付");
                        } else {
                            alert("支付失败");
                        }
                        /* alert(res.err_code +","+ res.err_desc +" ,"+ res.err_msg); */
                    }
                );
                if (typeof WeixinJSBridge == "undefined"){
                    if( document.addEventListener ){
                        document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
                    }else if (document.attachEvent){
                        document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
                        document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
                    }
                }else{
                    onBridgeReady();
                }
            }
        })

    }


</script>
</html>
