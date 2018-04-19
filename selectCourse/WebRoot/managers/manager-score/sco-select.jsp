<%@ page language="java" import="java.util.*,model.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="x" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询学生成绩</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body leftmargin="50px">
<h1>查询学生信息</h1>
	<div style="float:left;">
	 <form action="scoone" method="post">
		<input type="submit" value="查询单个学生成绩信息" /> 
		<input type="text" name="txtin" placeholder="输入学号或姓名模糊查询">
		</form>
	</div>
	<a href></a>
	&nbsp;&nbsp;&nbsp;&nbsp;<a href="scoall?id=select"  ><img src="./photo/cx3.png">
	</a>

	<div style=" width:600px;height:390px;margin-top:20px">
	<table border="5"
		style="border-style:dotted; order-color: olive;font-family: '隶书'; font-size:24px;"
		cellspacing="0" title="学生成绩">
		<tr>
			<th>编号</th>
			<th>学号</th>
			<th>姓名</th>
			<th>班级</th>
			<th>课程号</th>
			<th>课程名</th>
			<th>分数</th>
		</tr>
	<x:forEach var="s" items="${sco}">
	<tr>
			<td>${s.getSid() }</td>
			<td>${s.getStuid()}</td>
			<td>${s.getStuname() }</td>
			<td>${s.getBanji() }</td>
			<td>${s.getCid() }</td>
			<td>${s.getCname() }</td>
			<td>${s.getFenshu() }</td>
		</tr>
	
	</x:forEach>
	</table>
	</div>
</body>
</html>

