<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加教师基本信息</title>
    
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
          document.getElementById("idCheck").innerHTML="教师号不能为空";
       }
      
        else  if(!zid.test(id.value)){
           document.getElementById("idCheck").innerHTML="教师号必须是数字！";
            } 
       
         else{
           var url="checkNewTId?tid="+id.value;
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
   
   
   //职称
   function titlefun(){
    var title=document.getElementById("title").value;
    if(title==""){
     document.getElementById("titleCheck").innerHTML="不能为空";
    }
    else{
    document.getElementById("titleCheck").innerHTML="√";
    }
  }
  
  //院系
  function departmentfun(){
    var department=document.getElementById("department").value;
    if(department==""){
     document.getElementById("departmentCheck").innerHTML="不能为空";
    }
    else{
    document.getElementById("departmentCheck").innerHTML="√";
    }
  }
</script>
  </head>
  
  <body leftmargin="50px" topmargin="20px">
	<h2>添加教师基本信息</h2>
	<form action="teaadd" method="post">
		<table border="5"  cellpadding="8px"
			style="border-style:dotted;margin-left:10px;order-color: olive;font-family: '隶书'; font-size:24px;"
			cellspacing="0">
			<tr>
				<td>账号</td>
				<td><input type="text" name="id" id="id" onblur="AjaxId()">
				</td>
				<td><font id="idCheck" style="color:red"></font></td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input type="text" name="name" id="name" onblur="namefun();">
				</td>
				<td><font id="nameCheck" style="color: #ff9bcd"></font></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="text" name="pwd" id="pwd" onblur="pwdfun();">
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
				<td>职称</td>
				<td><input type="text" name="title" id="title" onblur="titlefun();">
				</td>
				<td><font id="titleCheck" style="color: #ff9bcd"></font></td>
			</tr>
			<tr>
				<td>院系</td>
				<td><input type="text" name="department"  id="department"  onblur="departmentfun();">
				</td>
				<td><font id="departmentCheck" style="color: #ff9bcd"></font></td>
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
