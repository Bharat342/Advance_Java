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
	<h2>Registration Data</h2>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Course</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		
		<%
			ResultSet result = (ResultSet)request.getAttribute("fetchedData");
		
			
			while(result.next()) { %>
			
			<tr>
				<td>
					<%=result.getInt(1) %>
				</td>
				
				<td>
					<%=result.getString(2) %>
				</td>
				
				<td>
					<%=result.getString(3) %>
				</td>
				
				<td>  
					<%=result.getString(4) %>
				</td>
				
				<td>
					<%=result.getString(5) %>
				</td>
				
				<td>
					<a href="DeleteRecordController?email=<%=result.getString(4)%>">Delete</a>
				</td>
				<td>
					<a href="UpdateRecordController?id=<%=result.getInt(1)%>">Update</a>
				</td>
			</tr>
				
			<% }  %>
	</table>
</body>
</html>