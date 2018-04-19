<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
	<link rel="stylesheet" type="text/css" href="./css/login.css">
   
  </head>
  
  <body bgcolor="#36818d">
  <div class="header">
  <!-- <marquee behavior="slide" direction="left" > -->
  <p class="p1"><strong>欢迎使用大飞成绩管理系统</strong> </p>
  <!-- </marquee> -->
 </div>
 <div class="pagebody">
    <div class="left">
	<image class="img1" src="photo/t4.jpg" width="80%" height="300px"></image>
    </div>
	<div class="right">
	
	
	 <form action="loginservlet" method="post">
	    <p class="p3">账&nbsp;&nbsp;号：
	    <input type="text" id="input2" name="jid">${zhanghao}${manager }
	    <p class="p4">密&nbsp;&nbsp;码：
	    <input type="password" class="input2" name="jpwd">${mima}
	    <p class="p4">身&nbsp;&nbsp;份：
	    <input type="radio" name="identify" value="学生" checked="checked">学生
	    <input type="radio" name="identify" value="教师">教师
	    <input type="radio" name="identify" value="管理员">管理员
	    <br/><br/><br/>
	    <input type="submit" value="登录" class="input1" placeholder="请输入账号" >
	    <input type="reset" value="重置" class="input1">
	 </form>
	</div>
	</div>
 <div class="footer">
 <p class="p2"> 版权所有&nbsp;&nbsp;&nbsp;大飞<br>
     Copyright &copy;2017-2018&reg;All Right Reserved</p>
 </div>
  </body>
</html>

