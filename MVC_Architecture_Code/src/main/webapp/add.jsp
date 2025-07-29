<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Addition Page</title>
</head>
<body>
	<h2>Addition Page</h2>
	<form action="AddController" method="post">
		FirstNum :<input type="text" name="firstnum" />
		 SecondNum :<input type="text" name="secondnum" /> 
		 <input type="Submit" value="add" />
	</form>

	<%
		if (request.getAttribute("x") != null) {
		out.println(request.getAttribute("x"));
	}
	%>
</body>
</html>