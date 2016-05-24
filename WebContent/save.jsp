<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户添加页面</title>
    
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
    <font size="5px" color="purple">欢迎来到用户添加页面</font>
	    <hr>
	    <form action="<%=request.getContextPath() %>/save.action" method="post">
	    <table>
			<tr>
				<td>书名</td>
				<td>
					<input type="text" name="book.bookName"/>
				</td>
			</tr>
			<tr>
				<td>作者</td>
				<td>
					<input type="text" name="book.writer" />
				</td>
			</tr>
			<tr>
				<td>价格</td>
				<td>
					<input type="text" name="book.price" />
				</td>
			</tr>
			<tr>
				<td>出版社</td>
				<td>
					<input type="text" name="book.publish" />
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="提交" />
				</td>
			</tr>
		</table>
		</form>
  </body>
</html>
