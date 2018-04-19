<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加学生成绩</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->


</head>

<body leftmargin="50px" topmargin="20px">
	<h2>添加学生基本信息</h2>
	<form action="scoadd" method="post">
		<table border="5"  cellpadding="8px"
			style="border-style:dotted;margin-left:10px;order-color: olive;font-family: '隶书'; font-size:24px;"
			cellspacing="0">
			<tr>
				<td>编号</td>
				<td><input type="text" name="id" id="id"  >
				</td>
				 
			</tr>
			<tr>
				<td>学号</td>
				<td><input type="text" name="stuid"  >
				</td>
				 
			</tr>
			<tr>
				<td>姓名</td>
				<td><input type="text" name="name" id="name"  >
				</td>
				 
			</tr>
			<tr>
				<td>班级</td>
				<td><input type="text" name="banji"  >
				</td>
				 
			</tr>
			<tr>
				<td>课程号</td>
				<td><input type="text" name="cid" >
				</td>
			</tr>
			<tr>
				<td>课程名</td>
				<td><input type="text" name="cname"  >
				</td>
			</tr>
			<tr>
				<td>分数</td>
				<td><input type="text" name="fenshu"  >
				</td>
			</tr>
			
			<tr align="center">
				<td><input type="submit" value="添加" style="width:80px">
				</td>
				<td><input type="reset" value="取消" style="width:80px">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
