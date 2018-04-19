<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生主页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="./javascript/jquery.js"></script>
<link href="./css/default.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="./css/menu.css">
<link rel="stylesheet" type="text/css" href="./css/main.css">



</head>
<body>
	<div class="head">
		<div class="head_left">
			<p class="p1">欢迎使用大飞成绩管理系统</p>
		</div>
		<div class="head_right">
			<p class="p_top" align="right">
				你好，
				<%=request.getSession().getAttribute("name")%>
			</p>
			<p class="p_top" align="right">
				<a href="login.jsp">退出</a>本次登录
			</p>
		</div>
	</div>
	<div class="center">
		<div class="left">
			<div class="left_shang">
			 <%
	if (application.getAttribute("counter") == null) {
		application.setAttribute("counter", "1");
	} else {
		String strnum = null;
		strnum = application.getAttribute("counter").toString(); //如果有值，拿到页面的值
		int intcount = 0;
		intcount = Integer.valueOf(strnum).intValue(); //把拿到的值变成int类型
		intcount++; //再给其加1

		//	application.setAttribute("counter", Integer.toString(intcount));

		String n = String.valueOf(intcount);
		application.setAttribute("counter", n);
	}
%>

<p> 总访问人数：<%=application.getAttribute("counter")%></p>
 <font style='font-size:14px;'>当前时间:<br>
<script charset="utf-8" type="text/javascript"
				src="./javascript/main.js"></script>
 
   <font id="Clock"
      style="FONT-SIZE: 9pt; FILTER: dropshadow(color=#FFFFFF,offx=1,offy=1,positive=1);COLOR: #000000;" 
      align=center>&nbsp;
	  
	  </font>&nbsp;
			
			</div>
			<div style="background:white;height:30px; width:140px;">
			<h1>当前身份：${shenfen}</h1>
			</div>
			
		<div class="rightNav">
	<a href="./students/stuper-info.jsp" style="left: -110px;" target="y">查看个人信息<em>0</em></a>
	<a href="./students/update-pwd.jsp" style="left: -110px;" target="y">修改个人密码<em>1</em></a>
	<a href="stusco" style="left: -110px;" target="y">查看成绩信息<em>2</em></a>
	<a href="http://sc.chinaz.com" style="left: -110px;" target="y">课程信息<em>3</em></a>
	<a href="listfileload" style="left: -110px;" target="y">下载文件<em>4</em></a>
</div>
<script type="text/javascript" src="./javascript/student_main.js"></script>
			
		</div>
		<div class="right">
			<iframe name="y" frameborder="0" src="./S5/index.html"></iframe>
		</div>
	</div>
	<div id="foot">
	<p class="p2"> 版权所有&nbsp;&nbsp;&nbsp;大飞<br>
     Copyright &copy;2017-2018&reg;All Right Reserved</p>
	</div>
</body>

</html>
