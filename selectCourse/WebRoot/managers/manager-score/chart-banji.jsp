<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>  
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'chart-banji.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">   
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

 <script src="./javascript/jquery.js"></script>   
    
<script src="./javascript/echarts.min.js"></script>

<script type="text/javascript">
    $(document).ready(function () {
        var myChart = echarts.init(document.getElementById('main'));
        var option = {
            //提示框
            tooltip: {
                trigger: 'axis',
                axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                    type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                }
            },
            //图例
            legend: {
                data: ['高数',  'java基础',  'MySQL',  'web前端']
            },
            //工具箱
            toolbox: {
                show: true,
                feature: {
                    mark: { show: true },
                    dataView: { show: true, readOnly: false },
                    magicType: { show: true, type: ['line', 'bar'] },
                    restore: { show: true },
                    saveAsImage: { show: true }
                }
            },
            calculable: true,            //是否启用拖拽重计算特性，默认关闭
            //直角坐标系中纵轴数组
            yAxis: [
            {
                type: 'value'
            }
            ],
            //直角坐标系中横轴数组
            xAxis: [
            {
                type: 'category',
                axisTick: { show: false },
                data: ['一班', '二班', '三班', '四班']
            }
            ],
            //驱动图表生成的数据内容
            series: [
            {
                name: '高数',
                type: 'bar',
                //stack: '总量',
                barWidth: 20,
                itemStyle: { normal: { label: { show: true, position: 'left' } } },
                data: [${oneg},${twog},${threeg},${fourg }]
            },
            {
                name: 'java基础',
                type: 'bar',
             //   stack: '总量',
                barWidth: 20,
                itemStyle: {  normal: {
                        label: { show: true}}},
                data: [${j1},${j2},${j3},${j4}]
            },
            
             {
                name: 'MySQL',
                type: 'bar',
             //   stack: '总量',
                barWidth: 20,
                itemStyle: {  normal: {
                        label: { show: true}
                    }
                },
                data: [${m1},${m2},${m3},${m4}]
            },
            {
                name: 'web前端',
                type: 'bar',
               // stack: '总量',
                barWidth: 20,
                itemStyle: {
                    normal: {
                        label: { show: true}
                    }
                },
                data: [${w1},${w2},${w3},${w4}]
            }
            ]
        };

        myChart.setOption(option);
    });
</script>


  </head>
  
  <body>
     
     
    <div id="main" style="height:400px;"></div>
</body>
     
  </body>
</html>
