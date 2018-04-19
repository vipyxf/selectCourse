<%@ page language="java" import="java.util.*,model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改教师基本信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
 <body leftmargin="30px">
 <h1>修改教师信息</h1>
	<table border="5"
		style="border-style:dotted; order-color: olive;font-family: '隶书'; font-size:24px;"
		cellspacing="0" title="修改教师基本信息">
		<tr>
			<th>账号</th>
			<th>姓名</th>
			<th>职称</th>
			<th>部门</th>
			<th>修改</th>
		</tr>
		<%
			ArrayList<Teacher> list = (ArrayList<Teacher>) request
					.getAttribute("tea");

			for (Teacher t : list) {
		%>
		<tr>
			<td><%=t.getTid()%></td>
			<td><%=t.getTname()%></td>
			<td><%=t.getTitle()%></td>
			<td><%=t.getDepartment()%></td>
			 <td align="center"><a href="teadelete?id=<%=t.getTid() %>" onclick="return confirm('确定要删除吗？');" style="text-decoration:none">✘</a>
       
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>
