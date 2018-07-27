<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="Bookmark" href="/favicon.ico">
    <link rel="Shortcut Icon" href="/favicon.ico"/>
    <!--[if lt IE 9]>
    <script type="text/javascript" src="lib/html5shiv.js"></script>
    <script type="text/javascript" src="lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="http://bdpak.cn:8080/bdyhAdmin/admin/static/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css"
          href="http://bdpak.cn:8080/bdyhAdmin/admin/static/h-ui.admin/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css"
          href="http://bdpak.cn:8080/bdyhAdmin/admin/lib/Hui-iconfont/1.0.8/iconfont.css"/>
    <link rel="stylesheet" type="text/css"
          href="http://bdpak.cn:8080/bdyhAdmin/admin/static/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="http://bdpak.cn:8080/bdyhAdmin/admin/static/h-ui.admin/css/style.css"/>

    <!-- 城市选择 -->
    <!--
    <link href="http://bdpak.cn:8080/bdyhAdmin/admin/city/css/city.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="http://bdpak.cn:8080/bdyhAdmin/admin/city/js/jquery.min.js"></script>
    <script type="text/javascript" src="http://bdpak.cn:8080/bdyhAdmin/admin/city/js/city.min.js"></script>
     -->

    <script src="http://bdpak.cn:8080/bdyhAdmin/admin/city/jquery/jquery-1.9.1.min.js"></script>
    <script src="http://bdpak.cn:8080/bdyhAdmin/admin/city/cityselect/cityselect.js"></script>
    <link href="http://bdpak.cn:8080/bdyhAdmin/admin/city/cityselect/cityLayout.css" type="text/css" rel="stylesheet">

    <!--[if IE 6]>
    <script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <!--/meta 作为公共模版分离出去-->


    <script type="text/javascript">
        $(function () {
            init_city_select($("#district"));
        });
    </script>

    <title>添加教师</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
</head>
<body>
<article class="page-container">
    <form action="${pageContext.request.contextPath}/teacher/teacherAdd" class="form form-horizontal"
          id="form-teacher-add" method="POST">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>教师姓名：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" placeholder="" id="teacherName" name="teacherName">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>性别：</label>
            <div class="formControls col-xs-8 col-sm-9 skin-minimal">
                <div class="radio-box">
                    <input name="sex" type="radio" id="sex-1" value="1" checked>
                    <label for="sex-1">男</label>
                </div>
                <div class="radio-box">
                    <input type="radio" id="sex-2" name="sex" value="2">
                    <label for="sex-2">女</label>
                </div>
                <div class="radio-box">
                    <input type="radio" id="sex-3" name="sex" value="3">
                    <label for="sex-3">保密</label>
                </div>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>手机：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" placeholder="" id="telephone" name="telephone">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">邮箱：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" placeholder="@" name="email" id="email">
            </div>
        </div>
        <div class="row cl">
            <label for="doc-select-1" class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>主讲：</label>
            <div class="formControls col-xs-8 col-sm-9 am-form-select">
                <span class="select-box">
                <select id="doc-select-1" class="select" size="1" >
                    <c:forEach items="${subjects }" var="subject">
                        <option name="major" value="${subject}">${subject}</option>
                    </c:forEach>
                </select>
                    </span>


                <span class="am-form-caret"></span>

            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>账号：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" placeholder="" id="username" name="username">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>密码：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" placeholder="" id="password" name="password">
            </div>
        </div>


        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>地址：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input name="district" id="district" type="text" class="input-text" readonly="readonly"
                       placeholder="请选择地址~~">
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">简介：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <textarea name="teacherIntro" cols="" rows="" class="textarea" placeholder="说点什么...最少输入10个字符"
                          onKeyUp="$.Huitextarealength(this,100)"></textarea>
                <p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p>
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">教师照片：</label>
            <div class="formControls col-xs-8 col-sm-9">

                <input id="doc-form-file" type="file" name="image" multiple required/>
            </div>
        </div>


        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
                <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
            </div>
        </div>


    </form>
</article>

<!--_footer 作为公共模版分离出去-->


<script type="text/javascript" src="http://bdpak.cn:8080/bdyhAdmin/admin/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="http://bdpak.cn:8080/bdyhAdmin/admin/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="http://bdpak.cn:8080/bdyhAdmin/admin/static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript"
        src="http://bdpak.cn:8080/bdyhAdmin/admin/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript"
        src="http://bdpak.cn:8080/bdyhAdmin/admin/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript"
        src="http://bdpak.cn:8080/bdyhAdmin/admin/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript"
        src="http://bdpak.cn:8080/bdyhAdmin/admin/lib/jquery.validation/1.14.0/messages_zh.js"></script>


<script type="text/javascript">
    $(function () {
        $('.skin-minimal input').iCheck({
            checkboxClass: 'icheckbox-blue',
            radioClass: 'iradio-blue',
            increaseArea: '20%'
        });

        $("#form-teacher-add").validate({
            rules: {
                teacherName: {
                    required: true,
                },
                telephone: {
                    required: true,
                    isMobile: true,
                },
                major: {
                    required: true,
                },
                username: {
                    required: true,
                    minlength: 2,
                    maxlength: 16
                },
                password: {
                    required: true,
                    minlength: 6,
                    maxlength: 20
                },
                districtId: {
                    required: true,
                },
                teacherIntro: {
                    required: true,
                },


            },
            onkeyup: false,
            focusCleanup: true,
            success: "valid",
            submitHandler: function (form) {
                //这里使用异步提交是为了验证区域存不存在
                //form.submit();

                /* alert(5456);
                $(form).ajaxSubmit({

                    url : "
                ${pageContext.request.contextPath}/teacher/teacherAdd",
				type : "POST",
				data : fd,
				dataType : "json",
				processData : false, // 告诉jQuery不要去处理发送的数据
				contentType : false, // 告诉jQuery不要去设置Content-Type请求头
				success: function(data){
					if (data.status==1){
						alert("添加教师成功");
						location.href="
                ${pageContext.request.contextPath}/teacher/teacherList";
					}else{
						alert("添加失败！");
					}
				}
			}); */

                /*var index = parent.layer.getFrameIndex(window.name);
                //parent.$('.btn-refresh').click();
                parent.layer.close(index); */

                var fd = new FormData($("#form-teacher-add")[0]);
                $.ajax({
                    url: "${pageContext.request.contextPath}/teacher/teacherAdd",
                    type: "post",
                    data: fd,
                    dataType: "json",
                    processData: false, // 告诉jQuery不要去处理发送的数据
                    contentType: false, // 告诉jQuery不要去设置Content-Type请求头
                    success: function (data) {
                        if (data.status == 1) {
                            alert("添加教师成功");
                            /* location.href="
                            ${pageContext.request.contextPath}/teacher/teacherList"; */
                        } else if (data.status == 2) {
                            alert("暂未开通该区域！添加失败");
                        } else if (data.status == 3) {
                            alert("已存在相同用户名的教师！添加失败");
                        } else if (data.status == -1) {
                            alert("请选择教师照片！");
                        } else {
                            alert("添加失败！");
                        }
                    }
                });
            }
        });
    });
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>