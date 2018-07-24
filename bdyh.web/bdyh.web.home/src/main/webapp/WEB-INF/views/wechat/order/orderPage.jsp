<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
    <title>订单页面</title>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">

    <meta content="yes" name="apple-mobile-web-app-capable"/>
    <meta content="black" name="apple-mobile-web-app-status-bar-style"/>
    <meta content="telephone=no" name="format-detection"/>

    <!-- <link rel="import" href="/bdyh.web.home/common/head.html"> -->
    <!-- common start -->
    <link rel="stylesheet" href="http://bdpak.cn:8080/home/bd-icon/iconfont.css">
    <link rel="stylesheet" href="http://bdpak.cn:8080/home/assets/css/amazeui.min.css"/>
    <link rel="stylesheet" type="text/css" href="http://bdpak.cn:8080/home/address-master/dist/amazeui.address.css"/>
    <link rel="stylesheet" href="http://bdpak.cn:8080/home/wechat/wechat-icon/iconfont.css"/>
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
    <%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script> --%>
    <script type="text/javascript">
        function submitOpinion() {
            var opinion = document.getElementById("opinion").value;
            if (opinion.trim().length == 0) {
                alert("请输入您的意见哦亲~~");
                return false;
            }
            if (opinion.trim().length > 200) {
                alert("最多输入200字哦亲~~");
                return false;
            }
            //这里还没有提交成功，但是为了方便，不做过多的处理
            alert("提交成功");
            window.location.href = "${pageContext.request.contextPath}/opinion/submitOpinion.action?opinion=" + opinion;
        }

        function pay(){
            $.ajax({
                type: "GET",
                url: "${pageContext.request.contextPath}/vipPay/wechatPay?coursePrice=${coursePrice}&tradeNo=${tradeNo}",
                success: function(data){
                    WeixinJSBridge.invoke(
                        'getBrandWCPayRequest', data ,
                        function(res){
                            if(res.err_msg == "get_brand_wcpay_request:ok" ) {
                                alert("支付成功");
                                window.open("${pageContext.request.contextPath}/course/courseDetails/${courseId}");

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
</head>
<body>
<div class="bdyh_mian">
    <header data-am-widget="header" class="am-header am-header-default am-header-fixed">
        <h1 class="am-header-title">
            <a href="#title-link" class="">
                订单页面
            </a>
        </h1>
    </header>

    <!-- bdyh_news_content_main start -->
    <div class="bdyh_news_content_main">
        <div class="am-g am-margin-top">
            <div class="am-u-sm-10 am-u-sm-offset-2">
                <div class="am-form-group am-g">
                    <h1>课程名：${course.courseName}</h1>
                    <h1>价格：${coursePrice} ￥</h1>
                    <h1>课程ID ${courseId}</h1>

                </div>

            </div>
        </div>
        <div class="am-g">
            <div class="">
                <button type="button" class="am-btn am-btn-secondary am-u-sm-8 am-u-sm-offset-2"
                        onclick="pay()">支付
                </button>
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
                <a href="${pageContext.request.contextPath}/index" style="margin-top:5px;">
                    <i style="color:#FFFFFF;font-size:25px;" class="iconfont icon-zhuye"></i>
                    <span class="am-navbar-label">首页</span>
                </a>
            </li>

            <li>
                <a href="${pageContext.request.contextPath}/course/myCourse" style="margin-top:5px;">
                    <i style="color:#FFFFFF;font-size:25px;" class="iconfont icon-wodekecheng"></i>
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


</script>
</html>
