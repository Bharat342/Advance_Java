<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration page</title>
</head>
<body>
	<h2>Register here</h2>
	<form action="RegistrationController" method="post">
		<table>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name"/></td>
			</tr>
			
			<tr>
				<td>Course :</td>
				<td><input type="text" name="course"/></td>
			</tr>
			
			<tr>
				<td>Email :</td>
				<td><input type="email" name="email"/></td>
			</tr>
			
			<tr>
				<td>Mobile :</td>
				<td><input type="number" name="mobile"/></td>
			</tr>
			
			<tr>
				<td><input type="submit" name="Register"/></td>
			</tr>
		</table>
	</form>
	
	<%
		if(request.getAttribute("message") != null) {
			out.println(request.getAttribute("message"));
		}
	%>
	<%
		if(request.getAttribute("errMessage") != null) {
			out.println(request.getAttribute("errMessage"));
		}
	%>
	
</body>
</html>




