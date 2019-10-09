<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>登录界面</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
<link rel="stylesheet" type="text/css" href="styles.css">
-->
<link rel="stylesheet" type="text/css" href="<%=path %>/admin/css/style.css" />
<script src="<%=path %>/admin/js/jquery-1.4.4.min.js"></script>
</head>

<script>

	
	$(function(){
	var _select=$('.select');
		_select.click(function(){
			$(this).find('ul').show();
		})

		$('.select li').click(function(){
			var eid=$(this).attr('eid');
			var eid_input='<input type="hidden" value="'+eid+'" name="eid" id="eid" \/>';
			var _eidhtml=$(this).html();
			$('.eid_value').html(_eidhtml);
			if($('#eid').attr('value')){
				$('#eid').attr('value',eid);	
			}
			
		})
		$('.select ul').hover(function(){
			
		},function(){
			$(this).hide();
		})
	})
</script>

<style>
	.field{
	position: relative;
	}
	#code{
	position: absolute;
	left: 165px;
	top: 2px;
	}
</style>
</head>
<body>


	<div class="login">
		<div class="login_form">
			<form action="<%=path %>/user_login.action" name="loginform" method="post">
			
			<div class="form_info">
				<div class="field">
					<label>用户名：</label>
					<input type="text" value="${user.userName}" name="user.userName" class="text" size="20">
				</div>
				<div class="field">
					<label>密　码：</label>
					<input type="password"  name="user.password" class="text" size="20">
				</div>
				<div class="field">
					<label>验证码：</label>
					<input type="text"   name="validateCode" class="text" size="10"/>
                   	<img id="code" onclick="this.src='<%=path%>/image.jsp?d='+new Date()*1" src="image.jsp"/>
				</div>
				<div class="field">
					<label></label>
					<button class="button" style="margin-left:50px;_margin-left:48px" ></button>
				</div>
			</div>
			</form>
		</div>
	</div>


	<%
	if(request.getAttribute("msg") != null){
		%>
		<script>
			alert("${msg}");
		</script>
		<%
	}
	
%>
	
</body>
</html>