<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
    
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
    <font size="5px" color="purple">欢迎来到用户列表界面</font>
		<hr>
		
		<form action="<%=request.getContextPath() %>/find.action">
			<input type="text" name="bookName"  />
			<input type="submit" value="按名字搜索" />
		</form><hr>
		
		<a href="<%=request.getContextPath() %>/save.jsp">图书添加</a>
		<hr>
		<table border="1" width="40%">
			<tr>
				<td>图书ID</td>
				<td>图书名称</td>
				<td>作者</td>
				<td>价格</td>
				<td>出版社</td>
				<td>操作</td>
			</tr>
			<s:iterator value="paging.books" var="book" >
				<tr>
					<td><s:property value="id"/></td>
					<td><s:property value="bookName"/></td>
					<td><s:property value="writer"/></td>
					<td><s:property value="price"/></td>
					<td><s:property value="publish"/></td>
					<td><a href="<%=request.getContextPath() %>/get.action?id=${book.id}">修改</a>||
					<a href="<%=request.getContextPath() %>/delete.action?id=${book.id}">删除</a>				
				</tr>
			</s:iterator>
		</table>
		
		<table>
			<tr>
				<td>
					<c:if test="${paging.pageNow > 1 }">
						<a href="${url }?bookName=${queryName }&pageNow=1&pageSize=${paging.pageSize }">首页</a>
					</c:if>
				</td>
				
				<td>
					<c:if test="${paging.pageNow > 1 }">
						<a href="${url }?bookName=${queryName }&pageNow=${paging.pageNow - 1 }&pageSize=${paging.pageSize }">上一页</a>
					</c:if>
				</td>
				
				<td>
					<c:if test="${paging.pageNow != paging.pageCount }">
						<a href="${url }?bookName=${queryName }&pageNow=${paging.pageNow +1 }&pageSize=${paging.pageSize }">下一页</a>
					</c:if>
				</td>
				
				<td>
					<c:if test="${paging.pageNow < paging.pageCount }">
						<a href="${url }?bookName=${queryName }&pageNow=${paging.pageCount }&pageSize=${paging.pageSize }">尾页</a>
					</c:if>
				</td>
			
			</tr>
		</table>  
  </body>
</html>
