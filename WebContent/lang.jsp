<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'lang.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <a href="<%=basePath%>petdoglist.action">查询所有的人员</a>
  	<br>
  	<table width="800" border="1">
  	<tr>
  		<td>编号</td><td>姓名</td><td>性别</td><td>生日</td><td>价格</td><td>操作</td>
  	</tr>
  	
  	<%-- <s:iterator id="emp" value="#attr.empList">
 	<tr>
  		<td>${emp.userId }</td>
  		<td>${emp.userName }</td>
  		<td>${emp.passWord }</td>
  		<td>${emp.logintime }</td>
  		<td>${emp.userId }</td>
  		<td><a href="#">编辑</a> | <a>删除</a></td>
  	</tr> 
  	</s:iterator> --%>
  	<s:iterator id="emp" value="#attr.empList">
 	<tr>
  		<td>${emp.dogId }</td>
  		<td>${emp.dogName }</td>
  		<td>${emp.dogSex }</td>
  		<td>${emp.dogBirthday }</td>
  		<td>${emp.dogPrice }</td>
  		<td><a href="#">编辑</a> | <a>删除</a></td>
  	</tr> 
  	</s:iterator>

    </table>
    
    <s:debug></s:debug>
  </body>
</html>
