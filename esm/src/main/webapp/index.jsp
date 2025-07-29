<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<form action="login" method="post">
		<table>
			<tr>
				<td>Email :</td>
				<td><input type="text" name="email"/></td>
			</tr>
			
			<tr>
				<td>Password :</td>
				<td><input type="text" name="password"/></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Login"/></td>
			</tr>
		</table>
	</form>
	
	<%
		if(request.getAttribute("result") != null) {
			out.println(request.getAttribute("result"));
		}
	%>
</body>
</html>