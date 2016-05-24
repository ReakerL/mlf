<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>

<link href="css/main.css" rel="stylesheet" type="text/css" />
</head>
<body>


<div class="login">
    <div class="box png">
		<div class="logo png"></div>
		<div class="input">
			<form action="loginAction.action" method="post" name="form1" id="form1">
			<div class="log">
				<div class="name">
					<label>用户名</label><input type="text" class="text" id="value_1" placeholder="用户名" name="user.userName"  tabindex="1"/>
				</div>
				<div class="pwd">
					<label>密码 </label><input type="password" class="text" id="value_2" placeholder="密码" name="user.passWord"  tabindex="2"/>
					
					<div class="check"></div>
				</div>
				<div class="name">
				<label>验证码</label><input name="yanzhengma" class="text2" id="yanzhengma" class="yanzhengma"/><img style="height:27px; margin-top: -8px;margin-bottom: -8px;margin-right: -4px;" alt="验证码看不清，换一张" src="${pageContext.request.contextPath}/safecode" id="validateCodeImg1" onclick="changeImg(this)"></div><br>
				<input type="submit" class="submit" tabindex="3" value="登录"/>
				<div class="tip"></div>
			</div>
			</form>
		</div>
	</div>
    <div class="air-balloon ab-1 png"></div>
	<div class="air-balloon ab-2 png"></div>
    <div class="footer"></div>
</div>

<script type="text/javascript" src="js/jQuery.js"></script>
<script type="text/javascript" src="js/fun.base.js"></script>
<script type="text/javascript" src="js/script.js"></script>


<!--[if IE 6]>
<script src="js/DD_belatedPNG.js" type="text/javascript"></script>
<script>DD_belatedPNG.fix('.png')</script>
<![endif]-->
<script type="text/javascript">
    //刷新验证码
	function changeImg(obj,createTypeFlag){
		document.getElementById(obj.id).src="${pageContext.request.contextPath}/safecode?createTypeFlag="+createTypeFlag+"&"+Math.random();
	}
    </script>
</body>
</html>