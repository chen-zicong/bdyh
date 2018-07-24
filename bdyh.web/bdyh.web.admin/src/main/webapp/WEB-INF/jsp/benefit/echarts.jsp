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
    <title>老师图标收益统计</title>
</head>
<body>

<div id="main" style="width: 1000px;height:600px;"></div>
<script src="${pageContext.request.contextPath}/node_modules/echarts/dist/echarts.min.js"></script>
<script src="${pageContext.request.contextPath}/node_modules/jquery/dist/jquery.min.js"></script>
<script>
    var teacher_id=<%=request.getParameter("teacher_id")%>
    var myChart = echarts.init(document.getElementById('main'));
    $.ajax({
        url : 'benefit_teacher.json',
        type : "get",
        dataType : "json",
        data :{teacher_id:teacher_id},
        cache : false,
        async : false,
        success :function (data) {
            myChart.setOption(option = {
                title: {
                    text: '老师每月收益'
                },
                tooltip: {
                    trigger: 'axis'
                },
                xAxis: {
                    data: data.map(function (item) {
                        return item[0];
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
                        lte: 1000,
                        color: '#096'
                    },{
                        gt: 1000,
                        lte: 1500,
                        color: '#ff9933'
                    }, {
                        gt: 1500,
                        lte: 2000,
                        color: '#cc0033'
                    }, {
                        gt: 2000,
                        lte: 3000,
                        color: '#660099'
                    }, {
                        gt: 3000,
                        color: '#7e0023'
                    }],
                    outOfRange: {
                        color: '#999'
                    }
                },
                series: {
                    name: '收益',
                    type: 'line',
                    data: data.map(function (item) {
                        return item[1];
                    }),
                    markLine: {
                        silent: true,
                        data: [{
                            yAxis: 1000
                        }, {
                            yAxis: 1500
                        }, {
                            yAxis: 2000
                        }]
                    }
                }
            });
        } ,
        error : function() {
            alert("请求失败")
        }
    });


    /*    $.get('benefit_teacher.json', function (data) {
            myChart.setOption(option = {
                title: {
                    text: '老师每月收益'
                },
                tooltip: {
                    trigger: 'axis'
                },
                xAxis: {
                    data: data.map(function (item) {
                        return item[0];
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
                        lte: 500,
                        color: '#096'
                    }, {
                        gt: 500,
                        lte: 1000,
                        color: '#ffde33'
                    }, {
                        gt: 1000,
                        lte: 1500,
                        color: '#ff9933'
                    }, {
                        gt: 1500,
                        lte: 2000,
                        color: '#cc0033'
                    }, {
                        gt: 2000,
                        lte: 3000,
                        color: '#660099'
                    }, {
                        gt: 3000,
                        color: '#7e0023'
                    }],
                    outOfRange: {
                        color: '#999'
                    }
                },
                series: {
                    name: '收益',
                    type: 'line',
                    data: data.map(function (item) {
                        return item[1];
                    }),
                    markLine: {
                        silent: true,
                        data: [{
                            yAxis: 500
                        }, {
                            yAxis: 1000
                        }, {
                            yAxis: 1500
                        }, {
                            yAxis: 2000
                        }/!*, {
                            yAxis: 3000
                        }*!/]
                    }
                }
            });
        });*/
</script>
</body>
</html>
