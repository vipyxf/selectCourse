<%@ page language="java" import="java.util.*,model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>删除学生信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
    <h1>修改学生信息</h1>
    <table border="5" style="border-style:dotted; order-color: olive;font-family: '隶书'; font-size:24px;"  cellspacing="0" title="修改学生基本信息">
       <tr>
       <th>学号</th><th>姓名</th><th>班级</th><th>籍贯</th><th>电话</th><th>邮箱</th><th>删除</th>
       </tr>
       <%
       ArrayList<Student> list=(ArrayList<Student>)request.getAttribute("s");
       for(Student stu:list){
        %>
       <tr>
       <td><%=stu.getSid() %></td>
       <td><%=stu.getSname() %></td>
       <td><%=stu.getBanji() %></td>
       <td><%=stu.getHome() %></td>
       <td><%=stu.getPhone() %></td>
       <td><%=stu.getEmail() %></td>
       <td align="center"><a href="studelete?id=<%=stu.getSid() %>" onclick="return confirm('确定要删除吗？');" style="text-decoration:none">✘</a>
       
       
       </tr>
       
       <%} %>
       
       </table>
  </body>
</html>

