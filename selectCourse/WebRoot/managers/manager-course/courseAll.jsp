<%@ page language="java" import="java.util.*,model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>课程管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body leftmargin="30px" >
 <h1>课程信息管理</h1>
	<table  border="5" style="border-style:dotted; order-color: olive;font-family: '隶书'; font-size:24px;" cellspacing="0" title="课程信息的增删改查">
		<tr>
			<th>课程ID</th>
			<th>课程名</th>
			<th>课程类别</th>
			<th>学分</th>
			<th>任课教师ID</th>
			<th>修改</th>
			<th>删除</th>
		</tr>
		<%
		ArrayList<Course> list=(ArrayList<Course>)request.getAttribute("c");
		for(Course cou:list){
		 %>
		 <tr>
		 <td><%=cou.getCid() %></td>
		 <td><%=cou.getCname() %></td>
		 <td><%=cou.getType() %></td>
		 <td><%=cou.getCredit() %></td>
		 <td><%=cou.getTid() %></td>
		 <td align="center"><a href="coudelete?id=<%=cou.getCid() %>" onclick="return confirm('是否确定删除该条数据？')" style="text-decoration:none">✘</a></td>
		 <td align="center"><a href="cupdate?id=<%=cou.getCid() %>" style="text-decoration:none">✄</a></td>
		
		 </tr>
		 <% } %>
		 <tr><td colspan="7"><a href="./managers/manager-course/cou-add.jsp">添加课程信息</a></td></tr>
	</table>
</body>
</html>