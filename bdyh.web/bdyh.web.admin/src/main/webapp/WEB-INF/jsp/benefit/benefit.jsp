<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0" />
    <title>倒计时</title>
    <script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
    
    <link rel="stylesheet" href="http://bdpak.cn:8080/bdyhAdmin/admin/countdownhtml/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://bdpak.cn:8080/bdyhAdmin/admin/countdownhtml/css/CountDown.css">
</head>
<body class="systerm">
<div class="countdown">
    <div class="sk_time">
        <span>${income}元</span>
    </div>
    <canvas class="process" width="300px" height="300px"></canvas>
    <button class="btns" onclick="benefit_show()">课程收益情况</button>
</div>
<script>

	/*收益情况-查看*/
	function benefit_show(){
		window.location.href="${pageContext.request.contextPath}/statistics/benefitCourseStatisticsTeacher";
	}

    window.onload = function () {
       secondKill();
   }
    var times =  500;
    var sum = times;
    //倒计时函数
   var secondKill = function(){

       //console.log(timeList.length);
       var timer;
       timer = setInterval(function(){
           times  -- ;
           if(times <= 0){
               //times = 150
               clearInterval(timer)

           }
           drawProcess(300,times)
       },30);

   }

  //  drawProcess(300,0);
    //圆形进度条函数
    function drawProcess(width,times) {
        $('canvas.process').each(function() {
            var texts = $(this).text();
         //   var process = times//text.substring(0, text.length-1);
            var canvas = this;
            var context = canvas.getContext('2d');
            context.clearRect(0, 0, width, width);

            context.beginPath();
            context.moveTo(width/2, width/2);
            context.arc(width/2, width/2, width/2, 0, Math.PI * 2, false);
            context.closePath();
            context.fillStyle = '#50a3a2';
            context.fill();

            context.beginPath();
            context.moveTo(width/2, width/2);
            context.arc(width/2, width/2, width/2, 5.5, (-Math.PI * 2 * times / sum)+5.5, false);
            context.closePath();
            context.fillStyle = '#50a3a2';
            context.fill();

            context.beginPath();
            context.moveTo(width/2, width/2);
            context.arc(width/2, width/2, width/2 - 10, 0, Math.PI * 2, true);
            context.closePath();
            context.fillStyle = 'rgba(255,255,255,1)';
            context.fill();

       /*     context.beginPath();
            context.arc(width/2, width/2, width/2 - 20, 0, Math.PI * 2, true);
            context.closePath();
            context.strokeStyle = '#ddd';
            context.stroke();
            context.font = "bold 9pt Arial";
            context.fillStyle = '#50a3a2';
            context.textAlign = 'center';
            context.textBaseline = 'middle';
            context.moveTo(width/2, width/2);
            context.fillText(texts, width/2, width/2);*/
        });
    }
</script>
</body>
</html>