<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/17
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <%--<script src="js/index.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/angular.min.js" type="text/javascript" charset="utf-8"></script>--%>

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        .input-group {
            width: 150px;
        }

    </style>
</head>
<body>
<table class="table text-center">
    <thead>
    <tr class="bg-light">
        <th>老师编号</th>
        <th>老师名字</th>
        <th>老师分成</th>
        <th>修改操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="teacher" items="${divide}">
        <tr>
            <th scope="row">${teacher.teacherId}</th>
            <td>${teacher.teacherName}</td>
            <td><input class="text-center" type="number" value="${teacher.divide}" min="0" max="1" step="0.1"/></td>
            <td><button type="button" class="btn btn-danger btn-sm" onclick="commit_change()">确定修改</button></td>
        </tr>
    </c:forEach>

    <%--<tr>--%>
        <%--<th scope="row">2</th>--%>
        <%--<td>Jacob</td>--%>
        <%--<td><input class="text-center" type="number" value="60" min="0" max="100" step="10"/></td>--%>
        <%--<td><button type="button" class="btn btn-danger btn-sm" >确定修改</button></td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
        <%--<th scope="row">3</th>--%>
        <%--<td>Larry</td>--%>
        <%--<td><input class="text-center" type="number" value="60" min="0" max="100" step="10"/></td>--%>
        <%--<td><button type="button" class="btn btn-danger btn-sm">确定修改</button></td>--%>
    <%--</tr>--%>
    </tbody>
</table>
<script src="node_modules/jquery/dist/jquery.min.js"></script>
<script src="node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
<script>
    $(function () {
        /*提交修改的ajax请求*/
        $("button").on("click",function () {
                $.ajax({
                    url:"${pageContext.request.contextPath}/a.txt",
                    type:'get',

                    data:{"teacher_id":$(this).parent().siblings('th').text(),
                        "teacher_benefit":$(this).parent().prev().children("input").val()
                    },
                    dataType:'json',
                    success:function(data){
                        alert(data[0].pwd)
                    }
                })
                return false;
        })
    })
</script>
</body>
</html>
