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
       if(id.value==""){
          document.getElementById("idCheck").innerHTML="课程号不能为空";
       }
      
         else{
           var url="checkNewCouId?cid="+id.value;
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
      if(name==""){
      document.getElementById("nameCheck").innerHTML="姓名不能为空";
      }
      else{
      document.getElementById("nameCheck").innerHTML="√";
      }
   }
   
   
  
  
   
   //课程类别
   function typefun(){
    var type=document.getElementById("type").value;
    if(type==""){
     document.getElementById("typeCheck").innerHTML="不能为空";
    }
    else{
    document.getElementById("typeCheck").innerHTML="√";
    }
  }
  
  
   //学分
   function creditfun(){
   var credit=document.getElementById("credit").value;
   var zcredit =new RegExp("^[0-9]*$");
   if(credit==""){
   document.getElementById("creditCheck").innerHTML="不能为空";
   }
   else if(!zcredit.test(credit)){
    document.getElementById("creditCheck").innerHTML="学分必须是数字！";
   }
    else{
    document.getElementById("creditCheck").innerHTML="√";
   }
   }
   
   
    //教师号
    function  AjaxTId(){
     var xmlHttpRequest=null;
     if(XMLHttpRequest){
       xmlHttpRequest=new XMLHttpRequest();
     }
     else{
       xmlHttpRequest=new ActiveXObject("Microsoft.XMLHTTP");
     }
     if(xmlHttpRequest!=null){
       var id=document.getElementById("tid");   //获得账号
       var zid =new RegExp("^[0-9]*$");       //判断数字的正则表达式
       if(id.value==""){
          document.getElementById("tidCheck").innerHTML="教师号不能为空";
       }
      
        else  if(!zid.test(id.value)){
           document.getElementById("tidCheck").innerHTML="教师号必须是数字！";
            } 
       
         else{
           var url="checkNewTId?tid="+id.value;
           xmlHttpRequest.open("get", url,true);
           xmlHttpRequest.send();
           xmlHttpRequest.onreadystatechange=function(){
           		if(xmlHttpRequest.readyState==4&& xmlHttpRequest.status==200){
           		var text=xmlHttpRequest.responseText;
           		 document.getElementById("tidCheck").innerHTML=text;
           		}
           };
           
       }
     }
   }


   
  
</script>
  </head>
  
  <body leftmargin="50px" topmargin="20px">
	<h2>添加课程信息</h2>
	<form action="couadd" method="post">
		<table border="5"  cellpadding="8px"
			style="border-style:dotted;margin-left:10px;order-color: olive;font-family: '隶书'; font-size:24px;"
			cellspacing="0">
			<tr>
				<td>课程号</td>
				<td><input type="text" name="id" id="id" onblur="AjaxId()">
				</td>
				<td><font id="idCheck" style="color:red"></font></td>
			</tr>
			<tr>
				<td>课程名</td>
				<td><input type="text" name="name" id="name" onblur="namefun();">
				</td>
				<td><font id="nameCheck" style="color: #ff9bcd"></font></td>
			</tr>
			<tr>
				<td>课程类别</td>
				<td><input type="text" name="type" id="type" onblur="typefun();">
				</td>
				<td><font id="typeCheck" style="color: #ff9bcd"></font></td>
			</tr>
			<tr>
				<td>学分</td>
				<td><input type="text" name="credit"  id="credit"  onblur="creditfun();">
				</td>
				<td><font id="creditCheck" style="color: #ff9bcd"></font></td>
			</tr>
			<tr>
				<td>教师号</td>
				<td><input type="text" name="tid"  id="tid"  onblur="AjaxTId()">
				</td>
				<td><font id="tidCheck" style="color: red"></font></td>
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
