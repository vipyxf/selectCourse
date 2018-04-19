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

<title>修改个人密码</title>

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
	<div style="float:left; ">
	<form action="servlet/Mpwd_update" method="post">
		<table border="5" style="border-style:dotted;  order-color: olive;margin:30px;font-family: '隶书'; font-size:24px;" cellpadding="15" cellspacing="0" >
			<tr>
				<td>旧密码：</td>
				<td><input type="text" value="${pwd}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>新密码：</td>
				<td><input type="text" name="xpwd" placeholder="请输入小于6个字符的英文字母和数字组合"></td>
			</tr>
			<tr>
				<td>确认密码：</td>
				<td><input type="text" name="qrpwd"></td>
			</tr>
			<tr align="center">
				<td><input type="submit" value="保存" style="width:80px;"></td>
				<td><input type="reset" value="取消"  style="width:80px;"></td>
			</tr>
		</table>

	</form>
	</div>
	<div >
	<br><br>
	<h2>密码修改成功</h2>
	<p>账号：${mid}</p>
	<p>新密码：${xpwd}</p>
	</div>
</body>
</html>
