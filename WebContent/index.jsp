<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台管理系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="css/style.css" type="text/css"></link>
  <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
  
  <script type="text/javascript">
$(function(){ 		
$.ajax({
		type: "post",
		url: "shifou.action",
		dataType: "text",
		success: function(data) {
		    if(data != '1'){
		      alert("您还没有登录！请登录");
		      Window.location('/login.jsp');
		    }
		}
	});
});
</script>
  </head>
  
<frameset rows="78,*" cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="html/top.html" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame" />
  <frameset cols="250,10,*" frameborder="no" border="0" framespacing="0" id="oa_frame">
    <frame src="html/left.html" name="leftFrame" scrolling="yes" noresize="noresize" id="leftFrame" title="leftFrame" />
    <frame src="html/middle.html" name="middleFrame" scrolling="No" noresize="noresize" id="middleFrame" title="middleFrame" />
    <frame src="html/main.html" name="mainFrame" scrolling="yes" id="mainFrame" title="mainFrame" />
  </frameset>
</frameset>
<noframes><body>
</body>
</noframes>
</html>
