<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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

<title>学生成绩管理系统主页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="./css/main.css">
<link rel="stylesheet" type="text/css" href="./css/menu.css">


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


				<p>
					总访问人数：<%=application.getAttribute("counter")%></p>
				<font style='font-size:14px;'>当前时间:<br> <script
						charset="utf-8" type="text/javascript" src="./javascript/main.js"></script>
					<font id="Clock"
					style="FONT-SIZE: 9pt; FILTER: dropshadow(color=#FFFFFF,offx=1,offy=1,positive=1);COLOR: #000000;"
					align=center>&nbsp; </font>&nbsp; 
			</div>
			<ul class="nav">
				<li><a>身份：${shenfen}</a>
				</li>
				<li><a class="sub" tabindex="1">管理员信息</a><img
					src="./photo/up.gif" alt="" />
					<ul>
						<li><a href="./managers/info-man/per-info.jsp" target="y">基本信息</a>
						</li>
						<li><a href="./managers/info-man/update-pwd.jsp" target="y">修改密码</a>
						</li>
						<li><a href="./managers/info-man/fileUp.jsp" target="y">上传文件</a>
						</li>
						<li><a href="listfileload" target="y">下载文件</a>
						</li>
						<li><a href="./managers/info-man/Excel-in-out.jsp" target="y">数据的导入导出</a>
						</li>
					</ul></li>
				<li><a class="sub" tabindex="1">学生管理</a><img
					src="./photo/up.gif" alt="" />
					<ul>
						<li><a href="./managers/into-stu/stu-select.jsp" target="y">学生信息查询</a>
						</li>
						<li><a href="stuinfoall?id=update" target="y">学生信息修改</a>
						</li>
						<li><a href="stuinfoall?id=delete" target="y">学生信息删除</a>
						</li>
						<li><a href="./managers/into-stu/stu-add.jsp" target="y">添加学生信息</a>
						</li>
						<li><a href="./managers/into-stu/stu-select.jsp" target="y">学生课程安排</a>
						</li>
					</ul></li>


				<li><a class="sub" tabindex="1">老师管理</a><img
					src="./photo/up.gif" alt="" />
					<ul>
						<li><a href="./managers/into-tea/tea-select.jsp" target="y">教师信息查询</a>
						</li>
						<li><a href="teainfoall?id=update" target="y">教师信息修改</a>
						</li>
						<li><a href="teainfoall?id=delete" target="y">教师信息删除</a>
						</li>
						<li><a href="./managers/into-tea/tea-add.jsp" target="y">添加教师信息</a>
						</li>
						<li><a href="./BMGL/SelectBm.jsp" target="y">教师课程安排</a>
						</li>
					</ul></li>
				<li><a class="sub" tabindex="1">课程管理</a><img
					src="./photo/up.gif" alt="" />
					<ul>
						<li><a href="couall" target="y">课程信息管理</a></li>
					</ul></li>
				<li><a class="sub" tabindex="1">成绩管理</a><img
					src="./photo/up.gif" alt="" />
					<ul>
						<li><a href="./managers/manager-score/sco-select.jsp" target="y">查询成绩信息</a>
						</li>
						
						<li><a href="scoall?id=delete" target="y">删除成绩信息</a>
						</li>
						<li><a href="./managers/manager-score/sco-add.jsp" target="y">录入成绩</a>
						</li>
						<li><a href="fenye1?pageNow=1" target="y">分页查询成绩1</a>
						</li>
						<li><a href="./managers/manager-score/echarts.jsp" target="y">统计图效果</a>
						</li>
						<li><a href="scoreavg" target="y">各班各科平均分</a>
						</li>
					</ul></li>
					
			</ul>
			<script charset="utf-8" type="text/javascript"
				src="./javascript/jquery.js"></script>
			<script charset="utf-8" type="text/javascript"
				src="./javascript/theme.js"></script>
		</div>
		<div class="right">
			<iframe name="y" frameborder="0" src="./S5/index.html"></iframe>
		</div>
	</div>
	<div id="foot">
		<p class="p2">
			版权所有&nbsp;&nbsp;&nbsp;大飞<br> Copyright &copy;2017-2018&reg;All
			Right Reserved
		</p>
	</div>



</body>

</html>
