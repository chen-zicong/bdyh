<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/20
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>老师收益Echarts</title>
</head>
<body>

<div id="main" style="width: 100%;height:600px;"></div>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

<%--<script src="https://cdn.bootcss.com/echarts/3.8.5/echarts-en.common.js"></script>--%>
<script src="http://echarts.baidu.com/dist/echarts.min.js"></script>
<script>
    var teacherID=<%=request.getAttribute("teacherID")%>
    var myChart = echarts.init(document.getElementById('main'));
    $.ajax({
        url : '${pageContext.request.contextPath}/statistics/teacherIncomeByTime',
        type : "get",
        dataType : "json",
        data :{teacherId:teacherID},
        cache : false,
        async : false,
        success :function (data) {
            myChart.setOption(option = {
                title: {
                    text: '代理商旗下老师收益统计'
                },
                tooltip: {
                    trigger: 'axis'
                },
                xAxis: {
                    data: data.map(function (item) {
                        return item[1];
                    })
                },
                yAxis: {
                    splitLine: {
                        show: false
                    }
                },
                toolbox: {
                    left: 'center',
                    feature: {
                        dataZoom: {
                            yAxisIndex: 'none'
                        },
                        restore: {},
                        saveAsImage: {}
                    }
                },
                dataZoom: [{
                    startValue: '2014-06-01'
                }, {
                    type: 'inside'
                }],
                visualMap: {
                    top: 10,
                    right: 10,
                    pieces: [{
                        gt: 0,
                        lte: 50,
                        color: '#096'
                    }, {
                        gt: 50,
                        lte: 100,
                        color: '#ffde33'
                    }, {
                        gt: 100,
                        lte: 150,
                        color: '#ff9933'
                    }, {
                        gt: 150,
                        lte: 200,
                        color: '#cc0033'
                    }, {
                        gt: 200,
                        lte: 300,
                        color: '#660099'
                    }, {
                        gt: 300,
                        color: '#7e0023'
                    }],
                    outOfRange: {
                        color: '#999'
                    }
                },
                series: {
                    name: 'Beijing AQI',
                    type: 'line',
                    data: data.map(function (item) {
                        return item[0];
                    }),
                    markLine: {
                        silent: true,
                        data: [{
                            yAxis: 50
                        }, {
                            yAxis: 100
                        }, {
                            yAxis: 150
                        }, {
                            yAxis: 200
                        }, {
                            yAxis: 300
                        }]
                    }
                }
            });
        } ,
        error : function() {
            alert("请求失败")
        }
    });
</script>
</body>
</html>
