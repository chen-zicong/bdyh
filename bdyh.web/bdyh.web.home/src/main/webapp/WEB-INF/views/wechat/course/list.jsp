<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
    <title>搜索</title>
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
    <link rel="stylesheet" href="http://bdpak.cn:8080/home/wechat/wechat-icon/iconfont1.css"/>
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
    </style>
    <!-- common end -->

    <link rel="stylesheet" type="text/css" href="http://bdpak.cn:8080/home/address-master/dist/amazeui.address.css"/>
    <style type="text/css">
        /* 条件搜索选区样式 */
        #search_condition button {
            border-color: #fff;
        }

        #search_condition button > span {
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
            margin-top: 15%;
        }

        .am-list-news-default {
            margin: 0px 5px;
        }
    </style>

    <script type="text/javascript">
        function searchCourse() {
            var courseName = document.getElementById("search").value;
            var districtName = document.getElementById("address1-form").value;
            var courseType = document.getElementById("tea_grade").value;
            var courseLevel = document.getElementById("tea_subject").value;
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
                    courseName: courseName,
                    districtName: districtName,
                    courseType: courseType,
                    courseLevel: courseLevel
                },
                success: function (data) {
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
            <input id="search" type="text"
                   style="display:inline-block;width:70%;border-radius:.5rem;padding-left:25px;height:30px;margin-bottom:20px;"
                   class="am-form-field" placeholder="输入关键字">
            <button type="button" class="am-btn am-btn-secondary am-radius"
                    style="padding:.2em .5em;margin:0px 0px 20px 5px;" onclick="searchCourse()">搜索
            </button>
        </div>
    </header>

    <!--condition select bar -->
    <div id="search_condition"
         style="position:fixed;top:40px;left: 0;right: 0; width: 100%;z-index: 1010;background:#fff;max-width: 640px;margin: 0 auto;">
        <div id="address1" style="display:inline-block;width:32%;">
            <select id="address1-form"
                    data-am-selected="{btnWidth: '100%',maxHeight:0}">
                <option id="city" value="惠州市">惠州市</option>
                <option id="prov" value="广东省">广东省</option>
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
            <div id="searchList" class="am-list-news-bd"
                 style="box-shadow:0 0.05rem 0.1rem rgba(0,0,0,.3);border-radius:.1rem;padding:0px 10px;">

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
                                    <h3 class="am-list-item-hd"><a href="">${course.courseName }</a></h3>
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
    <div data-am-widget="gotop" class="am-gotop am-gotop-fixed">
        <a href="#top" title="">
            <i class="am-gotop-icon am-icon-hand-o-up"></i>
        </a>
    </div>

    <!-- foot navbar start -->
    <div data-am-widget="navbar" class="am-navbar am-cf am-navbar-default">
        <ul class="am-navbar-nav am-cf am-avg-sm-4" style="width: auto">
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
<%--<script src="http://bdpak.cn:8080/home/wechat/teacher_subject/subject.js"></script>--%>
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
            type: 'post',
            url: "${pageContext.request.contextPath}/educateInfoW/select",
            dataType: 'json',
            data: {
                startPage: startPage,
                pageSize: pageSize,
                teacherLesson: $("#tea_subject").val(),
                teacherGrade: $("#tea_grade").val(),
                placeProvince: $("#prov").val(),
                placeCity: $("#city").val(),
                placeDistrict: $("#district").val(),
                otherExplain: $("#keyWord").val()
            },
            beforeSend: function () {

            },
            success: function (data) {
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
            type: 'post',
            url: "/bdyh.web.home/course/selectCourse",
            dataType: 'json',
            data: {
                startPage: startPage,
                pageSize: pageSize,
                teacherLesson: $("#tea_subject").val(),
                teacherGrade: $("#tea_grade").val(),
                placeProvince: $("#prov").val(),
                placeCity: $("#city").val(),
                placeDistrict: $("#district").val(),
                otherExplain: $("#keyWord").val()
            },
            beforeSend: function () {

            },
            success: function (data) {
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
                            title: '提示',
                            content: "暂无数据",
                            onConfirm: function () {
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

    function checkPay(courseId) {
        window.location.href = "${pageContext.request.contextPath}/course/courseDetails/" + courseId;
    }
</script>
<%--<script src="http://bdpak.cn:8080/home/address-master/dist/address.js"--%>
        <%--type="text/javascript" charset="utf-8"></script>--%>
<script type="text/javascript">
    $(function () {
        /* document.addEventListener('touchmove', function (e) {
            e.preventDefault();
        }, false); */
        //	自定义输出
        var courseName = document.getElementById("search").value;
        $("#address1").address(
            {
                customOutput: true,
                selectEnd: function (json, address) {
                    console.log(json);
                    for (var key in json) {
                        $("#address1-form")
                            .find("option[id='" + key + "']").val(
                            json[key]);
                        if(key==="district")
                            continue;
                       document.getElementById(key).innerText = json[key];
                    }
                    //alert(json['district']);
                    //searchCourse(json['district']);
                    searchCourse(json['district']);

                    //window.location.href="${pageContext.request.contextPath}/course/searchCourse.action?courseRecommand=${courseRecommend}&courseLevel=${courseLevel}&courseName="+courseName;
                    //异步请求实现页面局部刷新，只刷新课程列表
                    /* $.ajax({
                           type: "GET",
                           url: "
                    ${pageContext.request.contextPath}/course/searchCourse",
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
            }).on("provTap", function (event, activeli) {
            console.log(activeli.text());
        }).on("cityTap", function (event, activeli) {
            console.log(activeli.text());
        })
    });



    $(function(){
        /*

        var teacherSubjectJson = [{
            "id": 1,
            "name": "语文",
            "type": 0,
            "grade": [{
                "id": 1,
                "name": "一年级"
            }, {
                "id": 2,
                "name": "二年级"
            }, {
                "id": 3,
                "name": "三年级"
            }, {
                "id": 4,
                "name": "四年级"
            }, {
                "id": 5,
                "name": "五年级"
            }, {
                "id": 6,
                "name": "六年级"
            }, {
                "id": 7,
                "name": "初一"
            }, {
                "id": 8,
                "name": "初二"
            }, {
                "id": 9,
                "name": "初三"
            }, {
                "id": 10,
                "name": "高一"
            }, {
                "id": 11,
                "name": "高二"
            }, {
                "id": 12,
                "name": "高三"
            }]
        }, {
            "id": 2,
            "name": "数学",
            "type": 0,
            "grade": [{
                "id": 1,
                "name": "一年级"
            }, {
                "id": 2,
                "name": "二年级"
            }, {
                "id": 3,
                "name": "三年级"
            }, {
                "id": 4,
                "name": "四年级"
            }, {
                "id": 5,
                "name": "五年级"
            }, {
                "id": 6,
                "name": "六年级"
            }, {
                "id": 7,
                "name": "初一"
            }, {
                "id": 8,
                "name": "初二"
            }, {
                "id": 9,
                "name": "初三"
            }, {
                "id": 10,
                "name": "高一"
            }, {
                "id": 11,
                "name": "高二"
            }, {
                "id": 12,
                "name": "高三"
            }]
        }, {
            "id": 3,
            "name": "英语",
            "type": 0,
            "grade": [{
                "id": 3,
                "name": "三年级"
            }, {
                "id": 4,
                "name": "四年级"
            }, {
                "id": 5,
                "name": "五年级"
            }, {
                "id": 6,
                "name": "六年级"
            }, {
                "id": 7,
                "name": "初一"
            }, {
                "id": 8,
                "name": "初二"
            }, {
                "id": 9,
                "name": "初三"
            }, {
                "id": 10,
                "name": "高一"
            }, {
                "id": 11,
                "name": "高二"
            }, {
                "id": 12,
                "name": "高三"
            }]
        }, {
            "id": 4,
            "name": "生物",
            "type": 0,
            "grade": [{
                "id": 7,
                "name": "初一"
            }, {
                "id": 8,
                "name": "初二"
            }]
        }, {
            "id": 5,
            "name": "化学",
            "type": 1,
            "grade": [{
                "id": 9,
                "name": "初三"
            }]
        }, {
            "id": 6,
            "name": "物理",
            "type": 1,
            "grade": [{
                "id": 8,
                "name": "初二"
            }, {
                "id": 9,
                "name": "初三"
            }]
        }, {
            "id": 7,
            "name": "地理",
            "type": 0,
            "grade": [{
                "id": 7,
                "name": "初一"
            }, {
                "id": 8,
                "name": "初二"
            }]
        }, {
            "id": 8,
            "name": "政治",
            "type": 2,
            "grade": [{
                "id": 7,
                "name": "初一"
            }, {
                "id": 8,
                "name": "初二"
            }, {
                "id": 9,
                "name": "初三"
            }]
        }, {
            "id": 9,
            "name": "历史",
            "type": 0,
            "grade": [{
                "id": 7,
                "name": "初一"
            }, {
                "id": 8,
                "name": "初二"
            }]
        }]
        */
        var jsonstr = '${openClazzAndSubject}';
        var teacherSubjectJson =  JSON.parse(jsonstr);
        console.log(teacherSubjectJson);

        var teacher_optType=["tea_subject","tea_grade"];//两个select的ID
        //var teacher_opt0 = ["学科","年级"];//初始值
        var selectedOptType=document.getElementById(teacher_optType[0]);//
        var selectedOptType1=document.getElementById(teacher_optType[1]);//
        var obj=document.getElementById(teacher_optType[0]);
        obj.options.length=0;
        var obj1=document.getElementById(teacher_optType[1]);
        obj1.options.length=0;

        // 初始化学科
        for(var j=0;j<teacherSubjectJson.length;j++){

                if(teacherSubjectJson[j].name ==='${nianji}') {
                    console.log(teacherSubjectJson[j].name);
                    selectedOptType.options.add(
                        new Option(teacherSubjectJson[j].name, teacherSubjectJson[j].name, true, true));
                }else {
                    selectedOptType.options.add(
                        new Option(teacherSubjectJson[j].name, teacherSubjectJson[j].name, true, false));
                }

        }
        // var index = document.getElementById(teacher_optType[0]).selectedIndex; // 获取学科下拉选项初始后的默认索引值
        // var value = document.getElementById(teacher_optType[0]).options[index].value; // 获取学科下拉选项初始后的默认值

        var value = '${nianji}';
        if(value===""){
            value = teacherSubjectJson[0].name;
        }
        console.log(value+"--------------这个是value")

        change(value);//初始化年级下拉选项

        // 当学科发生变化时年级发生初始化
        $('#tea_subject').change(function(){
            index = document.getElementById(teacher_optType[0]).selectedIndex;
            value = document.getElementById(teacher_optType[0]).options[index].value;
            change(value);
        })

        $('#tea_grade').change(function () {
            searchCourse()
        })
        function change(value){
            var obj=document.getElementById(teacher_optType[1]);
            obj.options.length=0;
            var grade;
            for(var i = 0;i<teacherSubjectJson.length;i++){
                if(value == teacherSubjectJson[i].name){
                    grade = teacherSubjectJson[i].grade;
                    break;
                }
            }
            for(var j = 0;j<grade.length;j++){
                selectedOptType1.options.add(
                    new Option(grade[j].name,grade[j].name)
                );
            }
            searchCourse()
        }
    })


    (function(factory) {
        'use strict';
        if(typeof define === 'function' && define.amd) {
            define(['jquery', 'amazeui'], factory);
        } else if(typeof exports !== 'undefined') {
            module.exports = factory(require('jquery'), require('amazeui'));
        } else {
            factory(jQuery, jQuery.AMUI);
        }

    }(function($) {
        "use strict";

        var jsonstr = '${addressJson}';
        var addressJson =  JSON.parse(jsonstr);

        var iScroll;
        if(typeof(IScroll) == "undefined") { // 检测 iScroll 是否存在
            iScroll = $.AMUI.iScroll;
        } else {
            iScroll = IScroll;
        }

        // 构造函数
        function address(elm, options) {
            var self = this;
            self.$element = elm;
            self.options = options;

            // 初始化
            self._ready();

            // 带底部参数
            if(self.options.footer) {
                var $cancelBtn = self.$popup.find('.am-address-cancel');
                var $confirmBtn = self.$popup.find('.am-address-confirm');
                $confirmBtn.on('click', function() {
                    self._selectEnd();
                    return false;
                });
                $cancelBtn.on('click', function() {
                    self.$popup.modal("close");
                    return false;
                });
            }

            // 窗口被打开
            self.$popup.on('open.modal.amui', function() {
                self._readyProv();
            });

            // 窗口关闭
            self.$popup.on('close.modal.amui', function() {
                var selectProv = self.$prov.find("li.am-active").text();
                if(selectProv != self.options.prov) {
                    self.$prov.find("li:contains(" + self.options.prov + ")").addClass("am-active").siblings().removeClass("am-active");
                }
            });

            // 是否自动打开
            if(self.options.autoOpen) {
                self.$popup.modal("open");
            }

            self.$element.on("click", function() {
                self.$popup.modal("open");
            });

            // 给 element 对象绑定选择窗口的id
            self.$element.data("address-popup", self.$popup.attr("id"));
        }

        // 渲染选项列表
        address._readyList = function(json, selectedAddress) {
            var index = 0;
            var html = [];
            $.each(json, function(i, v) {
                // 循环第一个值时，如果没有默认选择值就添加 active
                if(i == 0 && !selectedAddress) {
                    html.push('<li class="am-active">' + v.name + '</li>');
                    index = i;
                    return;
                }
                if(selectedAddress && v.name === selectedAddress) {
                    html.push('<li class="am-active">' + v.name + '</li>');
                    index = i;
                } else {
                    html.push('<li>' + v.name + '</li>');
                }
            });
            return {
                list: html.join(''),
                index: index
            };
        }

        // 渲染选择窗口
        address.prototype._ready = function() {
            var self = this;
            var html = [];
            html.push('<div class="am-popup am-address-popup" id="' + Math.ceil(Math.random() * (new Date).getTime()) + '">');
            html.push('<div class="am-popup-inner">');
            html.push('<div class="am-popup-hd">');
            html.push('<h4 class="am-popup-title">' + self.options.title + '</h4>');
            html.push('<span data-am-modal-close class="am-close">&times;</span>');
            html.push('</div>');
            html.push('<div class="am-popup-bd">');
            if(self.options.footer) {
                html.push('<div class="am-address-list am-address-list-footer">');
            } else {
                html.push('<div class="am-address-list">');
            }
            html.push('<div class="am-u-sm-4 am-address-prov"><ul class="am-list am-list-static"></div>');
            html.push('<div class="am-u-sm-4 am-address-city"><ul class="am-list am-list-static"></div>');
            html.push('<div class="am-u-sm-4 am-address-district"><ul class="am-list am-list-static"></div>');
            html.push('</div>');

            if(self.options.footer) {
                html.push('<div class="am-modal-footer am-address-footer">');
                html.push('<span class="am-modal-btn am-address-cancel">取消</span>');
                html.push('<span class="am-modal-btn am-address-confirm">确定</span>');
                html.push('</div>');
            }
            html.push('</div>');
            html.push('</div>');
            html.push('</div>');
            self.$popup = $(html.join('')).appendTo('body');

            self.$prov = self.$popup.find('div.am-address-prov');
            self.$city = self.$popup.find('div.am-address-city');
            self.$district = self.$popup.find('div.am-address-district');

            // 初始化数据
            self._readyProv("create");

            // 判断是否需要添加市级或县级栏
            if(self.options.selectNumber == 1) {
                self.$popup.find("div.am-address-list>div").removeClass("am-u-sm-4").addClass("am-u-sm-12");
            } else {
                self._readyCity("create");
            }
            if(self.options.selectNumber == 2) {
                self.$popup.find("div.am-address-list>div").removeClass("am-u-sm-4").addClass("am-u-sm-6");
            } else {
                self._readyDistrict("create");
            }
        }

        // 函数 _readyxxx 的参数 methods="create" 表示新建 否则负责刷新 IScroll
        // {渲染,刷新} 省级数据
        address.prototype._readyProv = function(methods) {
            var self = this;
            if(methods == "create") {
                var prov = address._readyList(addressJson, self.options.prov);
                self.$prov.children("ul").html(prov.list).data("address-active", prov.index);
                if(!prov.index) {
                    self.$prov.find("li:eq(0)").addClass("am-active").siblings("li").removeClass("am-active");
                }

                self.provIscroll = new iScroll(self.$prov[0], {
                    tap: "addressTap",
                    mouseWheel: true
                });

                // 点击事件
                self.$prov.on("addressTap", "li", function() {
                    var $this = $(this);
                    if($this.hasClass("am-active")) {
                        return false;
                    }
                    $this.addClass("am-active").siblings("li").removeClass("am-active");
                    if(self.options.selectNumber != 1) {
                        self._readyCity(null, "tap");
                    } else {
                        self._selectEnd();
                    }
                    self.$element.trigger("provTap", [$this]);
                });
            } else {
                if(self.options.selectNumber != 1) {
                    self._readyCity();
                }
                self.provIscroll.refresh();
                self.provIscroll.scrollToElement(self.$prov.find("li.am-active")[0], null, null, self.options.scrollToCenter);
            }
        }

        // {渲染,刷新} 市级数据
        address.prototype._readyCity = function(methods, onEvent) {
            var self = this;
            if(methods == "create") {
                self.cityIscroll = new iScroll(self.$city[0], {
                    tap: "addressTap",
                    mouseWheel: true
                });
                self.$city.on("addressTap", "li", function() {
                    var $this = $(this);
                    if($this.hasClass("am-active")) {
                        return false;
                    }
                    $this.addClass("am-active").siblings("li").removeClass("am-active");
                    if(self.options.selectNumber != 2) {
                        self._readyDistrict(null, "tap");
                    } else {
                        self._selectEnd();
                    }
                    self.$element.trigger("cityTap", [$this]);
                });
            } else {
                var provIndex = self.$prov.find(".am-active").index();
                var city = address._readyList(addressJson[provIndex].city, self.options.city);
                self.$city.children("ul").html(city.list).data("address-active", city.index);
                if(!city.index) { // 没有默认选中项
                    self.$city.find("li:eq(0)").addClass("am-active").siblings("li").removeClass("am-active");
                }
                // 触发省级 tap 事件时，如果市级只要一个并且是省市级联时，触发选择完毕函数
                if(onEvent === "tap" && addressJson[provIndex].city.length <= 1 && self.options.selectNumber == 2) {
                    self._selectEnd();
                }

                self.cityIscroll.refresh();
                self.cityIscroll.scrollToElement(self.$city.find("li.am-active")[0], null, null, self.options.scrollToCenter);

                if(self.options.selectNumber != 2) {
                    self._readyDistrict();
                }
            }
        }

        // {渲染,刷新} 县级 数据
        address.prototype._readyDistrict = function(methods, onEvent) {
            var self = this;
            if(methods == "create") {
                self.districtIscroll = new iScroll(self.$district[0], {
                    tap: "addressTap",
                    mouseWheel: true
                });

                // 点击事件
                self.$district.on("addressTap", "li", function() {
                    var $this = $(this);
                    $this.addClass("am-active").siblings("li").removeClass("am-active");
                    self._selectEnd();
                });
            } else {
                var provIndex = self.$prov.find(".am-active").index();
                var cityIndex = self.$city.find(".am-active").index();
                var districtJson = addressJson[provIndex].city[cityIndex].district;
                if(districtJson.length <= 0) { // 如果县级数据不存在，设置为空
                    self.$district.children("ul").html("");
                    if(onEvent == "tap") {
                        self._selectEnd();
                    }
                    return;
                }

                var district = address._readyList(districtJson, self.options.district);

                self.$district.children("ul").html(district.list).data("address-active", district.index);
                if(!district.index) {
                    self.$district.find("li:eq(0)").addClass("am-active").siblings("li").removeClass("am-active");
                }
                self.districtIscroll.refresh();
                self.districtIscroll.scrollToElement(self.$district.find("li.am-active")[0], null, null, self.options.scrollToCenter);
            }
        }

        // 选择完毕
        address.prototype._selectEnd = function() {
            var self = this;
            // 获取已选省级数据
            var provIndex = self.$prov.find("li.am-active").index();
            var provJson = addressJson[provIndex];

            var sJson = {
                prov: provJson.name,
                city: "",
                district: ""
            }

            if(self.options.selectNumber != 1) { // selectNumber = 1 表示只选省级
                var cityIndex = self.$city.find("li.am-active").index();
                var cityJson = addressJson[provIndex].city[cityIndex];
                sJson.city = cityJson.name;
                // 判断是否有 县区 级数据
                if(cityJson.district.length && self.options.selectNumber != 2) { // selectNumber = 2 表示只选省市级
                    var districtIndex = self.$district.find("li.am-active").index();
                    var districtJson = addressJson[provIndex].city[cityIndex].district[districtIndex];
                    sJson.district = districtJson.name;
                }
            }

            self.options = $.extend(true, self.options, sJson); // 合并参数,下次打开选择窗口时，需读取 options 数据进行定位

            // 自动填充
            if(!self.options.customOutput) {
                self.$element.find("input").val(sJson.prov + sJson.city + sJson.district);
            }

            // 选取完毕回调
            if($.isFunction(self.options.selectEnd)) {
                self.options.selectEnd(sJson, self);
            }
            this.$popup.modal("close");
        }

        $.fn.address = function(options) {
            var opt = $.extend(true, {
                title: "请选择地址",
                prov: "北京",
                city: "北京市",
                district: "东城区",
                selectNumber: 2,
                scrollToCenter: false,
                autoOpen: false,
                customOutput: false,
                selectEnd: false,
            }, options);
            new address(this, opt);
            return this;
        }

        $.AMUI.ready(function(doc) {
            $('[data-am-address]', doc).each(function() {
                var $this = $(this);
                var options = $.AMUI.utils.parseOptions($this.attr('data-am-address') || $this.data("am-address"));
                $this.address(options);
            });
        });

        return $;
    }));
</script>
</html>
