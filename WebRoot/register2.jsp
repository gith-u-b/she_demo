<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <style>
      body{
        text-align: center;
      }
  </style>
  <body>
       <center>
	       <h1>注册界面</h1>
	       <a  href="<%=path%>/user_toLogin.action">已有账号，直接登录</a>
	       <div>&nbsp;</div>
	       <form action="<%= path %>/user_register.action" method="post">
	          <table border="1" style="text-align: center;">
	             <tr>
	               <td>用户名:</td>
	               <td><input type="text" name="user.userName" /></td>
	             </tr>
	             <tr>
	                <td>密码</td>
	                <td><input type="password" name="user.password" /></td>
	             </tr>
	             <tr>
	               <td colspan="2">
	                 <input type="submit" value="注册" />
	           	     <input type="reset" value="重置" />
	               </td>
	             </tr>
	          </table>
	           	
	           	     
	       </form>
       </center>
  </body>
</html>
