<%@ page language="java" import="java.util.*,model.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>查询成绩信息</title>

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
	 <form action="selStuone" method="post">
		<input type="submit" value="查询单个学生基本信息" /> 
		<input type="text" name="txtin" placeholder="输入学号或姓名模糊查询">
		</form>
	</div>
	<a href></a>
	&nbsp;&nbsp;&nbsp;&nbsp;<a href="stuinfoall?id=select"  ><img src="./photo/cx1.png">
	</a>
 
	<div style=" width:600px;height:390px;margin-top:20px">
	 <table border="5" style="border-style:dotted; order-color: olive;font-family: '隶书'; font-size:24px;"  cellspacing="0" title="学生基本信息">
       <tr>
       <th>学号</th><th>姓名</th><th>班级</th><th>籍贯</th><th>电话</th><th>邮箱</th>
       </tr>
        
        <c:forEach var="stu" items="${s }">
         <tr>
       <td>${stu.getSid() }</td>
       <td>${stu.getSname() }</td>
       <td>${stu.getBanji()}</td>
       <td>${stu.getHome() }</td>
       <td>${stu.getPhone() }</td>
       <td>${stu.getEmail() }</td>
       
       
       </tr>
       </c:forEach>
       </table>
	</div> 
</body>
</html>
