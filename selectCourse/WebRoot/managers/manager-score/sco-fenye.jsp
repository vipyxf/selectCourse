<%@ page language="java" import="java.util.*,model.*,dao.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>分页查询处理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
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
		
		<c:forEach var="s" items="${sco}" >
		<tr>
			<td>${s.getSid()}</td>
			<td>${s.getStuid() }</td>
			<td>${s.getStuname() }</td>
			<td>${s.getBanji() }</td>
			<td>${s.getCid() }</td>
			<td>${s.getCname() }</td>
			<td>${s.getFenshu()}</td>
		</tr>
		</c:forEach>
		
	</table>
	<form action="fenye1" method="post">
	<% 
	int p=(Integer)request.getAttribute("pp");
	int pageNow=(Integer)request.getAttribute("pageNow");  //当前页
	request.setAttribute("pn", pageNow);
	%>
	<a href="fenye1?pageNow=1">首页</a>
	 <c:if test="${pn>1 }">
	   <a href="fenye1?pageNow=${pn-1 }">上一页</a>
	</c:if> 
	    <c:if test="${pn<pp&&pn>1 }">
	    <a href="fenye1?pageNow=${pn-1 }">【${pn-1 }】</a>
	   <a href="fenye1?pageNow=${pn }">【${pn }】</a>
	   <a href="fenye1?pageNow=${pn+1 }">【${pn+1 }】</a>
	  </c:if>
	   <c:if test="${pn>=pp }">
	   <a href="fenye1?pageNow=${pp-2 }">【${pp-2 }】</a>
	   <a href="fenye1?pageNow=${pp-1 }">【${pp-1 }】</a>
	   <a href="fenye1?pageNow=${pp }">【${pp }】</a>
	   </c:if>
	    <c:if test="${pn<=1 }" >
	    <a href="fenye1?pageNow=1">【1】</a>
	   <a href="fenye1?pageNow=2">【2】</a>
	    <a href="fenye1?pageNow=3">【3】</a>
	   </c:if>
	 <c:if test="${pn<pp }">
	  <a href="fenye1?pageNow=${pn+1 }">下一页</a>
	 </c:if>
	 
	
	<a href="fenye1?pageNow=${pp }">尾页</a>
	共：${pp }页
	跳转到第：<input type="text" name="pageNow" size="4">
	<input type="submit" value="GO">
	</form>
</body>
</html>
