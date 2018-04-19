<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

<title>下载文件显示页面</title>

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
	<h2>下载相关教学文件</h2>
	<table border="5"
		style="border-style:dotted;  order-color: olive;margin:30px;font-family: '隶书'; font-size:18px;"
		cellpadding="5" cellspacing="0">
		<tr>
			<th>文件名</th>
			<th>下载</th>
		</tr>
		<c:forEach var="me" items="${fileNameMap}">

			<c:url var="downurl" value="downLoad">
				<c:param name="filename" value="${me.key }"></c:param>

			</c:url>
			<tr>
				<td>${me.value }</td>
				<td><a href="${downurl }" style="text-decoration:none">㊦</a>
				</td>
			</tr>

		</c:forEach>
	</table>
</body>
</html>
