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
<link href="http://bdpak.cn:8080/bdyhAdmin/admin/static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="http://bdpak.cn:8080/bdyhAdmin/admin/static/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />
<link href="http://bdpak.cn:8080/bdyhAdmin/admin/static/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
<link href="http://bdpak.cn:8080/bdyhAdmin/admin/lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />

<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>小科斗微课后台登录</title>
<meta name="keywords" content="">
<meta name="description" content="">

<script type="text/javascript">
	function sub(){
		var loginType=document.getElementById("role").value;
		var username=document.getElementById("username").value;
		var password=document.getElementById("password").value;
		var authCode=document.getElementById("authCode").value;
		
		$.ajax({
			   type: "POST",
			   url: "${pageContext.request.contextPath}/admin/login",
			   data: {
				   loginType:loginType,
				   username:username,
				   password:password,
				   authCode:authCode,
			   },
			   success: function(data){
					var data = eval('(' + data + ')');
					if (data.status==1){
						location.href="${pageContext.request.contextPath}/index";
					}else if(data.status==2){
						alert("验证码错误！");
					}else if(data.status==0){
						alert("用户不存在！");
					}else if(data.status==-1){
						alert("密码错误！");
					}else if(data.status==-2){
						alert("用户被冻结！");
					}
				}
		  });
	}
</script>


</head>
<body>
<input type="hidden" id="TenantId" name="TenantId" value="" />
<!-- <div class="header"></div> -->
<div class="loginWraper">
  <div id="loginform" class="loginBox">
    <form id="loginForm" class="form form-horizontal" acti	on="${pageContext.request.contextPath}/admin/login" method="post">
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe62d;</i></label>
        <div class="formControls col-xs-8">
          <!-- <input id="" name="" type="text" placeholder="账户" class="input-text size-L"> -->
          <select id="role" class="input-text size-L" name="loginType" ><!-- onchange="loginRole()" -->
          	<option value="admin">管理员</option>
          	<option value="agent">代理商</option>
          	<option value="teacher">教师</option>
          </select>
        </div>
      </div>
   	  <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        <div class="formControls col-xs-8">
          <input id="username" name="username" type="text" placeholder="账户" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-xs-8">
          <input id="password" name="password" type="password" placeholder="密码" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input id="authCode" name="authCode" class="input-text size-L" type="text" placeholder="验证码" onblur="if(this.value==''){this.value='验证码:'}" onclick="if(this.value=='验证码:'){this.value='';}"  style="width:150px;">
          <img src="${pageContext.request.contextPath}/kaptcha/getKaptchaImage" alt="验证码" onclick="this.src='${pageContext.request.contextPath}/kaptcha/getKaptchaImage'" > <!-- <a id="kanbuq" href="javascript:;">看不清，换一张</a>  --></div>
      </div>
      <!-- <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <label for="online">
            <input type="checkbox" name="online" id="online" value="">
            	使我保持登录状态
          </label>
        </div>
      </div> -->
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input name="" type="button" onclick="sub()" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
          <input name="" type="reset" class="btn btn-default radius size-L" value="&nbsp;重&nbsp;&nbsp;&nbsp;&nbsp;置&nbsp;">
        </div>
      </div>
    </form>
  </div>
  <div class="footer" style="height : 230px ; width: auto ; font-size : 15px;text-align:left; padding-left:40px"}>
            <div class="row cl" style="margin : 0px 130px 0px 130px ">
              <div class="col-xs-3 " >
                <div class="footer_main--column">
                  <b class="footer_main--column_title" style="font-size :20px">关于我们</b>
                  <div class="footer_about">
                      <p class="footer_about--text">
                         公司主要从事卫星导航运营服务、地理信息、
						 <br>
						 数据平台研发与技术服务、位置应用系统集成、
						 <br>
						 遥感信息以及导航终端的研发、生产、销售和服务。
                      </p>
                     
                    </div>
                </div>
              </div>

              <div class="col-xs-3 ">
                <div class="footer_main--column">
                  <strong class="footer_main--column_title" style="font-size :20px">产品中心</strong>
                  <ul class="footer_navigation">
                    <li class="footer_navigation--item"><a href="#" class="footer_navigation--link">小科斗</a><i class="Hui-iconfont" style="float:right">&#xe63d;</i></li>
                    <li class="footer_navigation--item"><a href="http://xkdschool.bdpak.com/Login/index" target="_blank" class="footer_navigation--link">校园平台</a><i class="Hui-iconfont" style="float:right">&#xe63d;</i></li>
                    <li class="footer_navigation--item"><a href="http://xkdschool.bdpak.com/adminmgr" target="_blank" class="footer_navigation--link">云平台</a><i class="Hui-iconfont" style="float:right">&#xe63d;</i></li>
                  </ul>
                </div>
              </div>

              <div class="col-xs-3 ">
                <div class="footer_main--column">
                  <strong class="footer_main--column_title" style="font-size :20px" >技术支持</strong>
                  <ul class="footer_navigation">
                    <li class="footer_navigation--item"><a href="#" class="footer_navigation--link">企业信息化白皮书</a><i class="Hui-iconfont" style="float:right">&#xe63d;</i></li>
                  </ul>
                </div>
              </div>

              <div class="col-xs-3 ">
                <div class="footer_main--column">
                  <strong class="footer_main--column_title" style="font-size :20px" >联系详情</strong>
                  <ul class="footer_contact_info">
                    <li class="footer_contact_info--item"><i class="Hui-iconfont">&#xe6a3;</i><span>  服务专线：400 6133 663</span></li>
                    <li class="footer_contact_info--item"><i class="Hui-iconfont">&#xe63b;</i><span>  bdpak.com</span></li>
                    <li class="footer_contact_info--item"><i class="Hui-iconfont">&#xe625;</i><span>  广东省惠州市惠城区江北三新北路10号互联网公园3楼</span></li>
                  </ul>
                </div>
              </div>
			  <div class="col-xs-12" style="text-align:center; color:#ffffff;">Copyright 北斗宇航 粤ICP备16090529号-2 <a href="http://www.miitbeian.gov.cn" style="color:#ffffff;" target="_blank"></a></div>
            </div>
          </div>
  
</div>
<!--div class="footer"> Copyright 北斗宇航 粤ICP备16090529号-2</div-->




<script type="text/javascript" src="http://bdpak.cn:8080/bdyhAdmin/admin/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="http://bdpak.cn:8080/bdyhAdmin/admin/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript">
	if (top.location != self.location){     
		top.location=self.location;     
	}
</script>
</body>
</html>