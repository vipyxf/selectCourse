<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>My JSP 'per-info.jsp' starting page</title>

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
		style="border-style:dotted;  order-color: olive;margin:30px;font-family: '隶书'; font-size:24px;"
		cellpadding="15" cellspacing="0" title="教师个人基本信息">
		<tr>
			<td>账号</td>
			<td>姓名</td>
			<td>职称</td>
			<td>部门</td>
		</tr>
		<tr>
			<td>${mid}</td>
			<td>${name}</td>
			<td>${title}</td>
			<td>${department}</td>
		</tr>
	</table>
</body>
</html>
