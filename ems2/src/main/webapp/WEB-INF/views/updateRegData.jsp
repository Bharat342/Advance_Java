<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="menu.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Data</title>
</head>
<body>
	<h2>Update Data.</h2>
	<form action="UpdateRecordController" method="post">
		<table border="1">
		<tr>
			<td>id: </td>
			<td><input type="text" name="id" value="<%=request.getAttribute("id")%>" readonly/></td>
		</tr>
		
		<tr>
			<td>Name: </td>
			<td><input type="text" name="name" value="<%=request.getAttribute("name")%>"/></td>
		</tr>
		
		<tr>
			<td>Course: </td>
			<td><input type="text" name="course" value="<%=request.getAttribute("course")%>"/></td>
		</tr>
		
		<tr>
			<td>Email: </td>
			<td><input type="text" name="email" value="<%=request.getAttribute("email")%>"/></td>
		</tr>
		
		<tr>
			<td>Mobile: </td>
			<td><input type="text" name="mobile" value="<%=request.getAttribute("mobile")%>"/></td>
		</tr>
		
		<tr>
			<td><input type="submit" value="Update"/></td>
		</tr>
	</table>
	</form>
</body>
</html>