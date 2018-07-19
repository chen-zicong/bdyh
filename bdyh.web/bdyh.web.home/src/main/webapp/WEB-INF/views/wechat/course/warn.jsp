<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
    <title>小科斗微课堂</title>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta content="yes" name="apple-mobile-web-app-capable" />
    <meta content="black" name="apple-mobile-web-app-status-bar-style" />
    <meta content="telephone=no" name="format-detection" />
    <link href="https://cdn.bootcss.com/weui/1.1.2/style/weui.css" rel="stylesheet">
</head>
<body>
<div class="weui-msg" style="margin-top:50px;">
    <div class="weui-icon_area"><i class="weui-icon-warn weui-icon_msg"></i></div>
    <div class="weui-text_area" style="margin-top:20px">
        <p class="weui_msg_desc" style="font-weight:bold;">请先购买课程后再学习！</p>
    </div>
    <div class="weui-opr_area" style="margin-top:20px">
        <p class="weui-btn_area">
            <a href="javascript:;" class="weui-btn weui-btn_primary">确定</a>
        </p>
    </div>
</div>
<script src="http://bdpak.cn:8080/home/js/jquery-3.2.1.min.js"></script>
<script>
    $('.weui-btn').click(function () {
        window.location.href="${pageContext.request.contextPath}/routeW/Goto/course/details";
    })

</script>
</body>
</html>