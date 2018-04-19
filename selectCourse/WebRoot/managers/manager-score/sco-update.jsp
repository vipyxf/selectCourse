<%@ page language="java" import="java.util.*,model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'sco-update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body leftmargin="30px" topmargin="20px">
   <h1>修改学生基本信息</h1>
	<table border="5"
		style="border-style:dotted; order-color: olive;font-family: '隶书'; font-size:24px;"
		cellspacing="0" title="修改学生成绩">
		<tr>
			<th>编号</th>
			<th>学号</th>
			<th>姓名</th>
			<th>班级</th>
			<th>课程号</th>
			<th>课程名</th>
			<th>分数</th>
			<th>删除</th>
			
		</tr>
		<%
			ArrayList<Score> list = (ArrayList<Score>) request
					.getAttribute("sco");

			for (Score s : list) {
		%>
		<tr>
			<td><%=s.getSid() %></td>
			<td><%=s.getStuid() %></td>
			<td><%=s.getStuname() %></td>
			<td><%=s.getBanji() %></td>
			<td><%=s.getCid() %></td>
			<td><%=s.getCname() %></td>
			<td><%=s.getFenshu() %></td>
			<td align="center"><a href="" style="text-decoration:none" >✄</a></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>

