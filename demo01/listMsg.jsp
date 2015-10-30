<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
    <h2>留言消息列表</h2>
    <div>
    	<table>
    		<tr>
    			<td>Id</td>
    			<td>name</td>
    			<td>email</td>
    			<td>subject</td>
    			<td>message</td>
    		</tr>
    		<c:forEach items="${msgs}" var="m">
    		<tr>
    			<td>${m.id }</td>
    			<td>${m.name }</td>
    			<td>${m.email }</td>
    			<td>${m.subject }</td>
    			<td>${m.message }</td>
    		</tr>
    		</c:forEach>
    	</table>
    	<p><input type="button" class="button" value="添加留言信息"
    	 onclick="location='addMsg.jsp'"/></p>
    </div>
	<div></div>
  </body>
</html>
