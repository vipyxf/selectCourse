<%@ page language="java" import="java.util.*,model.*" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询老师信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body leftmargin="20px" >
  <h1>查询教师基本信息</h1>
 <div style="float:left;">
	<form action="tselectone" method="post">
		<input type="submit" value="查询单个老师基本信息" /> 
		<input type="text" name="txtin" placeholder="输入账号或姓名模糊查询">
		</form>
	</div>
	&nbsp;&nbsp;&nbsp;&nbsp;<a href="teainfoall?id=select"  ><img src="./photo/cx2.png">
	</a>

	<div style=" width:600px;height:390px;margin-top:20px">
	<table border="5"
		style="border-style:dotted; order-color: olive;font-family: '隶书'; font-size:24px;"
		cellspacing="0" title="教师基本信息">
		<tr>
			<th>账号</th>
			<th>姓名</th>
			<th>职称</th>
			<th>部门</th>
		</tr>
		<s:forEach var="t" items="${tea }">
		<tr>
			<td>${t.getTid() }</td>
			<td>${t.getTname() }</td>
			<td>${t.getTitle() }</td>
			<td>${t.getDepartment() }</td>
		</tr>
		</s:forEach>
	</table>
   </div>
  </body>
</html>
