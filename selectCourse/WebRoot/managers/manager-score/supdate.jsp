<%@ page language="java" import="java.util.*,model.*" pageEncoding="utf-8"%>
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

<title>添加学生基本信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">

   function  AjaxId(){
     var xmlHttpRequest=null;
     if(XMLHttpRequest){
       xmlHttpRequest=new XMLHttpRequest();
     }
     else{
       xmlHttpRequest=new ActiveXObject("Microsoft.XMLHTTP");
     }
     if(xmlHttpRequest!=null){
       var id=document.getElementById("id");   //获得账号
       var zid =new RegExp("^[0-9]*$");       //判断数字的正则表达式
       if(id.value==""){
          document.getElementById("idCheck").innerHTML="学号不能为空";
       }
      
        else  if(!zid.test(id.value)){
           document.getElementById("idCheck").innerHTML="学号必须是数字！";
            } 
       
         else{
           var url="checkNewId?id="+id.value;
           xmlHttpRequest.open("get", url,true);
           xmlHttpRequest.send();
           xmlHttpRequest.onreadystatechange=function(){
           		if(xmlHttpRequest.readyState==4&& xmlHttpRequest.status==200){
           		var text=xmlHttpRequest.responseText;
           		 document.getElementById("idCheck").innerHTML=text;
           		}
           };
           
       }
     }
   }

   function namefun(){
      var name=document.getElementById("name").value;
      var rename=/^[\u4e00-\u9fa5]+$/gi;        //判断中文的正则表达式
      if(name==""){
      document.getElementById("nameCheck").innerHTML="姓名不能为空";
      }
      else if(!rename.test(name)){
       document.getElementById("nameCheck").innerHTML="姓名应输入中文！";
      }
      else if(name.length>4 ){
       document.getElementById("nameCheck").innerHTML="中文名字应少于4个字";
      }
      else{
      document.getElementById("nameCheck").innerHTML="√";
      }
   }
   
   
   function pwdfun(){
    var pwd=document.getElementById("pwd").value;  //获得密码
    if(pwd==""){
    document.getElementById("pwdCheck").innerHTML="密码不能为空";
    }
  else if(pwd.length>6){
    document.getElementById("pwdCheck").innerHTML="密码长度不能超过6";
    }
    else {
    document.getElementById("pwdCheck").innerHTML="√";
    }
   }
   
   function pwd2fun(){
     var pwd=document.getElementById("pwd").value;
      var pwd2=document.getElementById("pwd2").value;
      if(pwd!=pwd2){
       document.getElementById("pwd2Check").innerHTML="两次输入的密码不一样";
      }
      else{
       document.getElementById("pwd2Check").innerHTML="√";
      }
   
   }

  function banjifun(){
    var banji=document.getElementById("banji").value;
    if(banji==""){
     document.getElementById("banjiCheck").innerHTML="不能为空";
    }
    else{
    document.getElementById("banjiCheck").innerHTML="√";
    }
  }

   function homefun(){
   var home=document.getElementById("home").value;
   if(home==""){
     document.getElementById("homeCheck").innerHTML="不能为空";
   }
   else{
    document.getElementById("homeCheck").innerHTML="√";
   }
   }
   
   
   //判断电话
   function phonefun(){
   var phone=document.getElementById("phone").value;
   var zphone =new RegExp("^[0-9]*$");
   if(phone==""){
   document.getElementById("phoneCheck").innerHTML="不能为空";
   }
   else if(!zphone.test(phone)){
    document.getElementById("phoneCheck").innerHTML="电话必须是数字！";
   }
    else{
    document.getElementById("phoneCheck").innerHTML="√";
   }
   }
   
   
   //判断邮箱email
   function emailfun(){
   var email=document.getElementById("ma").value;
   var re = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
     if(email==""){
   document.getElementById("emailCheck").innerHTML="不能为空";
   }
   else if(!re.test(email)){
   document.getElementById("emailCheck").innerHTML="邮箱填写格式错误";
   }
   else{
   document.getElementById("emailCheck").innerHTML="√";
   }
   }
   
   

</script>




</head>

<body leftmargin="50px" topmargin="20px">
	<h2>修改学生基本信息</h2>
	<form action="sxupdate" method="post">
		<table border="5"  cellpadding="8px"
			style="border-style:dotted;margin-left:10px;order-color: olive;font-family: '隶书'; font-size:24px;"
			cellspacing="0">
			<% Student s=(Student)request.getAttribute("s"); %>
			<tr>
				<td>学号</td>
				<td><input type="text" name="id" id="id" onblur="AjaxId();" value="<%=s.getSid() %>">
				</td>
				<td><font id="idCheck" style="color:red"></font></td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input type="text" name="name" id="name" onblur="namefun();" value="<%=s.getSname() %>" >
				</td>
				<td><font id="nameCheck" style="color: #ff9bcd"></font></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="text" name="pwd" id="pwd" onblur="pwdfun();" value="<%=s.getSpwd() %>">
				</td>
				<td><font id="pwdCheck" style="color: #ff9bcd"></font></td>
			</tr>
			<tr>
				<td>确认密码</td>
				<td><input type="text" name="pwd2" id="pwd2" onblur="pwd2fun();"  >
				</td>
				<td><font id="pwd2Check" style="color: #ff9bcd"></font></td>
			</tr>
			<tr>
				<td>班级</td>
				<td><input type="text" name="banji" id="banji" onblur="banjifun();" value="<%=s.getBanji() %>">
				</td>
				<td><font id="banjiCheck" style="color: #ff9bcd"></font></td>
			</tr>
			<tr>
				<td>籍贯</td>
				<td><input type="text" name="home"  id="home"  onblur="homefun();"  value="<%=s.getHome() %>">
				</td>
				<td><font id="homeCheck" style="color: #ff9bcd"></font></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input type="text" name="email"  id="ma" onblur="emailfun();" value="<%=s.getEmail() %>">
				</td>
				<td><font id="emailCheck" style="color: #ff9bcd"></font></td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input type="text" name="phone"  id="phone" onblur="phonefun();">
				</td>
				<td><font id="phoneCheck" style="color:red"></font></td>
			</tr>
			<tr align="center">
				<td><input type="submit" value="修改" style="width:80px">
				</td>
				<td><input type="reset" value="取消" style="width:80px">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
